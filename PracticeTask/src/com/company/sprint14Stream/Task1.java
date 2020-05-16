package com.company.sprint14Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

  public static void main(String[] args) {
    // smoke test
//    var in = Map.of(
//        "Desktop", Stream.of(" iVan", "PeTro ", " Ira "),
//        "Web", Stream.of("STepan", "ira ", " Andriy ", "an na"),
//        "Spring", Stream.of("Ivan", "Anna"));
//    var expectedAsArray = new String[]{"Andriy", "Anna", "Ira", "Ivan", "Petro", "Stepan"};
    var in = Map.of(
            "Desktop", Stream.of("", " ", "  "),
            "Web", Stream.of("", "", "", ""),
            "Spring", Stream.of("", ""));
    var expectedAsArray = new String[0];
    var out = new MyUtils1().nameList(in).toArray();
    System.out.println(Arrays.equals(out, expectedAsArray) ? "OK" : "FAIL");
    System.out.println(Arrays.toString(expectedAsArray));
    System.out.println(Arrays.toString(out));

  }
}

class MyUtils1 {

  public Stream<String> nameList(Map<String, Stream<String>> map) {
    if(map == null){
      throw new NullPointerException(); // це навіть зайве, бо далі NPE буде викинуте у 41 рядку в разі чого
    }

    List<String> participants = new ArrayList<>();
    map.forEach((k, v) -> {
      if(v != null){
        participants.addAll(v.collect(Collectors.toList()));
      }
    });
    
    // можна було замість participants.stream()... :
    // map.values().stream().flatMap(stream -> stream)... 

    return participants.stream()
        .filter(Objects::nonNull)  // тут вже налів не буде, бо всі відфільтрувались у 42 рядку
        .filter(x->!x.isEmpty())
        .map(x -> x.replace(" ", ""))
        .filter(x->!x.equals(""))
        .map(String::trim)         // у рядку 50 вже позбулись пробілів
        .map(String::toLowerCase)
        .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
        .sorted()
        .distinct();
  }
}

//  Let the key of Map is project name and value contains list of participants.
//    Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted stream
//    of all participants without duplication.
//    Please ignore null or empty strings, extra spaces and case sensitivity.
//    Throw NullPointerException if map is null.
//    For example, for a given map
//    {"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
//    you should get
//    ["Andriy", "Anna", "Ira", "Ivan", "Petro", "Stepan"]
