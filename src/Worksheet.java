import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Playing with lambdas and streams in the JDK 8
 */
public class Worksheet {

    public static void main(String args[]) {

        System.out.println(">>> Lambdas ----------------------------------------------------------------");

        // -------------------------------------------------------------------------------------------------
        // A float comparator
        Comparator<Float> cmp = (x, y) -> (x < y) ? -1 : ((x > y) ? 1 : 0);

        float ten = 10;
        float twenty = 20;
        boolean tenGreaterThanTwenty = cmp.compare(ten, twenty) == 1;

        System.out.println("Comparator: " + ten + " > " + twenty + " ? " + tenGreaterThanTwenty);

        // -------------------------------------------------------------------------------------------------
        // Lambda capturing variables defined in scope

        int lesser = -1; int greater = 1; int equal = 0;
        Comparator<Integer> integerComparator = (x, y) -> (x < y) ? lesser : ((x > y) ? greater : equal);

        int five = 5; int three = 3;
        boolean threeLessThanFive = integerComparator.compare(three, five) == lesser;

        System.out.println("Comparator (capture): " + ten + " < " + twenty + " ? " + threeLessThanFive);

        // -------------------------------------------------------------------------------------------------


        System.out.println(">>> Streams ----------------------------------------------------------------");

        // -------------------------------------------------------------------------------------------------
        // Working with a stream of random integers

        System.out.println("Print some random integers");

        new Random()
            .ints()                         // generate the stream
            .limit(5)                       // limit the stream
            .forEach(System.out::println);  // print the ints

        // -------------------------------------------------------------------------------------------------
        // Filter, map, reduce example
        List<Person> people = asList(new Person("Carlo", 27), new Person("Aldo", 15), new Person("Lucia", 19));

        Stream<Person> everyBody = people.stream();

        // filter: Person.age > 18
        Stream<Person> peopleOver18 = everyBody.filter(p -> p.getAge() > 18);

        // map: transforming Person to Student
        Stream<Student> mappedStudents = peopleOver18.map(person -> new Student(person));

        // reduce: collecting students
        List<Student> students = mappedStudents.collect(Collectors.toList());

        // Display the filter, map, reduce steps
        // since we already consumed our streams, we create new ones
        System.out.println("Filter, Map, Reduce on people:");
        people.stream().forEach(System.out::print);
        System.out.println();
        System.out.println("Filter out if Person.age < 18:");
        people.stream().filter(p -> p.getAge() > 18).forEach(System.out::print);
        System.out.println();
        System.out.println("Trasforming each filtered Person into a Student:");
        people.stream().filter(p -> p.getAge() > 18).map(Student::new).forEach(System.out::print);
        mappedStudents.forEach(System.out::print);
        System.out.println();
        System.out.println("Collected students:");
        students.stream().forEach(System.out::print);

        // -------------------------------------------------------------------------------------------------

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
