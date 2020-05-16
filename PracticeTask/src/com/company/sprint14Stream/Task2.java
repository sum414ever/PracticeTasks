package com.company.sprint14Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {

  public static void main(String[] args) {

    var in = List.of(
        Stream.of("093 987 65 43", "(050)1234567", "12-345"),
        Stream.of("067-21-436-57", "050-2345678", "(0501234567", "0939182736", "224-19-28"),
        Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45")
    );
    var expected = Map.of(
        "050", Stream.of("1234567", "2345678"),
        "067", Stream.of("2143657"),
        "093", Stream.of("1122334", "9182736", "9876543"),
        "044", Stream.of("4356218"),
        "loc", Stream.of("2241928", "7217345"),
        "err", Stream.of("12345")
    );
    var out = new MyUtils2().phoneNumbers(in);

    boolean res = out.entrySet().stream()
        .allMatch(mapEntry ->
            expected.containsKey(mapEntry.getKey()) &&
                Arrays.equals(
                    expected.get(mapEntry.getKey()).toArray(),
                    mapEntry.getValue().toArray()
                )
        );
    System.out.println(res ? "OK" : "FAIL");
  }

}

class MyUtils2 {

  public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {

    List<PhoneNumber> phoneNumberList = PhoneNumber.getAllNumbers(list);

    if (phoneNumberList.isEmpty()) {   // не має бути проблемою стрімити порожню колекцію
      return Collections.emptyMap();
    }
    return phoneNumberList.stream()
        .filter(Objects::nonNull) // тут нали вже відфільтровані, аде колекцію ти готуєш сам
        .distinct()               // можна було збирати не в List, а в Set, тоді дуплікатів не було б вже в колекції
        .sorted(Comparator.comparing(PhoneNumber::getPhoneNumber))
        .collect(Collectors.groupingBy(
            PhoneNumber::getAreaCode,
            Collectors.mapping(PhoneNumber::getPhoneNumber,
                Collectors.collectingAndThen(Collectors.toList(),
                    Collection::stream))));
  }

  public static class PhoneNumber {

    private String areaCode;
    private String phoneNumber;

    public PhoneNumber(String areaCode, String phoneNumber) {
      this.areaCode = areaCode;
      this.phoneNumber = phoneNumber;
    }

    public static List<PhoneNumber> getAllNumbers(List<Stream<String>> list) {

      return list.stream().flatMap(i -> i)
          .filter(Objects::nonNull)
          .map(x -> x.replace(" ", ""))
          .filter(x -> !x.isEmpty())
          .map(y -> y.replaceAll("\\D+", "")) // можна було 79 рядок прибрати, а 80 після цього поставити, адже \D прибере й пробіли
          .map(x -> {
            if (x.length() == 10) {
              return new PhoneNumber(x.substring(0, 3), x.substring(3));
            } else if (x.length() == 7) {
              return new PhoneNumber("loc", x);
            } else {
              return new PhoneNumber("err", x);
            }
          })
          .collect(Collectors.toList()); // toSet допоможе позбутись дуплікатів вже тут
    }

    public String getAreaCode() {
      return areaCode;
    }

    public String getPhoneNumber() {
      return phoneNumber;
    }

    @Override
    public String toString() {
      return
          areaCode +
              phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof PhoneNumber)) {
        return false;
      }
      PhoneNumber that = (PhoneNumber) o;
      return Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
      return Objects.hash(phoneNumber);
    }
  }
}

//  Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) method of the MyUtils class to build a Map of all phone numbers.
//    The key of Map is code of network and value contains sorted list of phones.
//    Remove all spaces, brakets and dashes from phone numbers.
//    For example, for a given
//    [["093 987 65 43", "(050)1234567", "12-345"],
//    ["067-21-436-57", "050-2345678", "0939182736", "224-19-28"],
//    ["(093)-11-22-334", "044 435-62-18", "721-73-45"]]
//    you should get
//    {"050"=["1234567", "2345678"],
//    "067"=["2143657"],
//    "093"=["9876543", "9182736", "1122334"],
//    "044"=["4356218"], "loc"=["7217345", "2241928"], "err"=["12345"]}
