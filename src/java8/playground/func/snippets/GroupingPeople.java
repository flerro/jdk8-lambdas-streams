package java8.playground.func.snippets;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * Grouping examples, following imports are used for the sake of readability:
 *
 *      import static java.util.stream.Collectors.groupingBy;
 *      import static java.util.stream.Collectors.counting;
 */

public class GroupingPeople {

    static Function<Person, Integer> ageDecade = (x) -> (int)(x.getAge() / 10) * 10;

    public GroupingPeople() {

        Map<String, List<Person>> peopleByGender = Person.people().stream()
                                                    .collect(groupingBy(Person::getGender));

        System.out.println("Group By gender >> " + peopleByGender);


        Map<Integer, List<Person>> peopleByDecade = Person.people().stream()
                                                        .collect(groupingBy(ageDecade));

        System.out.println("Group By decade >> " + peopleByDecade);


        Map<Integer, Long> totByDecade = Person.people().stream()
                                                .collect(groupingBy(ageDecade, counting()));

        System.out.println("Count By decade >> " + totByDecade);


        Map<Integer, List<String>> namesByDecade = Person.people().stream()
                                                    .collect(groupingBy(ageDecade, mapping(Person::getName, toList())));

        System.out.println("Names By decade >> " + namesByDecade);


        Collector<Person, ?, List<String>> listOfNames = mapping(Person::getName, toList());
        Collector<Person, ?, Map<Integer, List<String>>> perDecade = groupingBy(ageDecade, listOfNames);
        Collector<Person, ?, Map<String, Map<Integer, List<String>>>> perGender = groupingBy(Person::getGender, perDecade);
        Map<String, Map<Integer, List<String>>> namesByGenderAndDecade =
                                                    Person.people().stream()
                                                            .sorted(Comparator.comparingInt(Person::getAge))
                                                            .collect(perGender);

        System.out.println("Names By gender and decade >> " + namesByGenderAndDecade);


        IntSummaryStatistics ageStats = Person.people().stream()
                                        .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println("Age Stats >> " + ageStats);
    }

    public static void main(String args[]) {
        new GroupingPeople();
    }

    static class Person {
        private String name;
        private String gender;
        private int age;

        Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getGender() { return gender; }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                //    ", gender=" + gender +
                    '}';
        }

        static List<Person> people() {
            return asList(new Person("Carlo", 27, "M"),
                            new Person("Aldo", 15, "M"),
                            new Person("Giovanna", 35, "F"),
                            new Person("Rolando", 3, "M"),
                            new Person("Alfredo", 32, "M"),
                            new Person("Sara", 7, "F"),
                            new Person("Sofia", 5, "F"),
                            new Person("Giorgio", 17, "M"),
                            new Person("Lucia", 19, "F"));
        }
    }
}
