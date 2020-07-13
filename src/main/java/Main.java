import javax.xml.namespace.QName;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;


public class Main {
  public static void main(String[] args) {
    ArrayList<Person> people = new ArrayList<>();
    people.add(new Person("Antonio", 20, Gender.MALE));
    people.add(new Person("Alina Smith", 33, Gender.FEMALE));
    people.add(new Person("Helen White", 57, Gender.FEMALE));
    people.add(new Person("Alex Boz", 14, Gender.MALE));
    people.add(new Person("Jamie Goa", 99, Gender.MALE));
    people.add(new Person("Anna Cook", 7, Gender.FEMALE));
    people.add(new Person("Silvia Smithers", 12, Gender.FEMALE));

    // Remove a person from the ArrayList
    people.remove(2);

    // Check the (new) size of an ArrayList
    System.out.println(people.size());

    // Modify some attributes of a element of the Arraylist
    people.set(3, new Person("Noelia", 22, Gender.UNDEFINED));

    // Add a new element
    people.add(new Person("Silvia Smithers", 12, Gender.FEMALE));

    // Check the (newest) size of an ArrayList
    System.out.println(people.size());

    // Filter - By gender
    ArrayList<Person> females = people.stream()
            .filter(person -> person.getGender().equals(Gender.FEMALE))
            .collect(toCollection(ArrayList::new));

    // Sort - Older to younger
    ArrayList<Person> sorted = people.stream()
            .sorted(Comparator.comparing(Person::getAge).reversed())
            .collect(toCollection(ArrayList::new));

    // All Match - Age bigger than 5
    boolean allMatch = people.stream()
            .allMatch(person -> person.getAge() > 5);

    // Any Match - At least, a person younger than 8
    boolean AnyMatch = people.stream()
            .anyMatch(person -> person.getAge() <= 7);

    // NoneMatch - A person called Antonio
    boolean noneMatch = people.stream()
            .noneMatch(person -> person.getName().equals("Antonio"));

    // Max - Oldest person
    Optional<Person> oldest = people.stream()
            .max(Comparator.comparing(Person::getAge));

    // Min - Younger person
    Optional<Person> younger = people.stream()
            .min(Comparator.comparing(Person::getAge));

    // Group - By Gender
    Map<Gender, List<Person>> groupByGender = people.stream()
            .collect(Collectors.groupingBy(Person::getGender));

    int x = 6;
  }

}


