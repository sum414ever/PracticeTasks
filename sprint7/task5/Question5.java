import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder {
  ASC, DESC;
}

class AddressBook implements Iterable<String> {

  private NameAddressPair[] addressBook;
  private int counter = 0;

  public AddressBook(int capacity) {
    addressBook = new NameAddressPair[capacity];
  }

  public AddressBookIterator iterator() {

    return new AddressBookIterator();
  }

  public boolean create(String firstName, String lastName, String address) {
    if (addressBook.length - 1 == size()) {
      NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length * 2];
      System.arraycopy(addressBook, 0, newAddressBook, 0, size());
      addressBook = newAddressBook;
    } else if (read(firstName, lastName) != null) {
      return false;
    }
    addressBook[counter] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName),
        address);
    counter++;
    return true;
  }

  public String read(String firstName, String lastName) {

    for (int i = 0; i < size(); i++) {
      if (addressBook[i].person.firstName.equals(firstName)) {
        if (addressBook[i].person.lastName.equals(lastName)) {
          return addressBook[i].address;
        }
      }
    }
    return null;
  }

  public boolean update(String firstName, String lastName, String address) {

    if (read(firstName, lastName) == null) {
      return false;
    }

    for (int i = 0; i < size(); i++) {
      if (addressBook[i].person.firstName.equals(firstName)) {
        if (addressBook[i].person.lastName.equals(lastName)) {
          addressBook[i] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName),
              address);
        }
      }
    }
    return true;
  }


  public boolean delete(String firstName, String lastName) {
    if (read(firstName, lastName) == null) {
      return false;
    }
    int shift = 0;
    for (int i = 0; i < size(); i++) {
      if (addressBook[i].person.firstName.equals(firstName)) {
        if (addressBook[i].person.lastName.equals(lastName)) {
          shift = i;
        }
      }
    }
    System.arraycopy(addressBook, shift + 1, addressBook, shift, size() - shift);
    counter--;
    return true;
  }


  public int size() {
    return counter;
  }

  public void sortedBy(SortOrder order) {

    if (SortOrder.ASC.equals(order)) {
      Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
        @Override
        public int compare(NameAddressPair o1, NameAddressPair o2) {
          if (o1 == null | o2 == null) {
            return 0;
          }
          return o1.person.firstName.compareTo(o2.person.firstName) == 0
              ? o1.person.lastName.compareTo(o2.person.lastName)
              : o1.person.firstName.compareTo(o2.person.firstName);
        }
      });
    } else if (SortOrder.DESC.equals(order)) {
      Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
        @Override
        public int compare(NameAddressPair o1, NameAddressPair o2) {
          if (o1 == null | o2 == null) {
            return 0;
          }
          return o2.person.firstName.compareTo(o1.person.firstName) == 0
              ? o2.person.lastName.compareTo(o1.person.lastName)
              : o2.person.firstName.compareTo(o1.person.firstName);
        }
      });
    }
  }

  private static class NameAddressPair {

    private final Person person;
    private String address;

    private NameAddressPair(Person person, String address) {
      this.person = person;
      this.address = address;
    }

    public String toString() {
      return "First name: " + person.firstName + ", Last name: "
          + person.lastName + ", Address: " + address + '\n';
    }

    private static class Person {

      private String firstName;
      private String lastName;

      private Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof Person)) {
          return false;
        }
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
            Objects.equals(lastName, person.lastName);
      }

      @Override
      public int hashCode() {
        return Objects.hash(firstName, lastName);
      }
    }
  }

  private class AddressBookIterator implements Iterator<String> {

    private int counter = 0;

    public boolean hasNext() {

      return counter < size();
    }

    public String next() {
      String next = "";
      if (hasNext()) {
        next = "First name: " + addressBook[counter].person.firstName + ", Last name: "
            + addressBook[counter].person.lastName + ", Address: " + addressBook[counter].address;
        counter++;
      }
      return next;
    }
  }
}
