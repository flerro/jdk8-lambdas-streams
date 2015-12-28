package java8.playground.func.snippets;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Filter, map, reduce example
 */
public class MapReduceAndFilterStudents {

    public MapReduceAndFilterStudents() {
        List<Person> people = asList(new Person("Carlo", 27),
                                        new Person("Aldo", 15),
                                        new Person("Lucia", 19));

        List<Student> overAgeStudents = people.stream()
                .filter(p -> p.getAge() > 18)
                .map(Student::new)
                .collect(Collectors.toList());

        System.out.println("Collected students:");
        overAgeStudents.stream().forEach(System.out::print);
    }

    public static void main(String[] args) {
        new MapReduceAndFilterStudents();
    }

    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "   Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Student {
        private String name;

        Student(String name) {
            this.name = name;
        }

        Student(Person p) {
            this(p.getName());
        }

        @Override
        public String toString() {
            return "   Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
