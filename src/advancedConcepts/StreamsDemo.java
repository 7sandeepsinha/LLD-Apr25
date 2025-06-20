package advancedConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        // streams from data structure
        // streams -> generic, stream of primitives
        IntStream intStream = Arrays.stream(arr); // stream of primitive
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        Stream<Integer> integerStream = list.stream();
        Stream<Integer> directIntStream = Stream.of(1,2,3,4,5,6,7,8);
        Stream<Boolean> directBooleanStream = Stream.of(true, false, true);
        Stream<Dog> dogStream = Stream.of(new Dog(), new Dog(), new Dog());

        // Q1. List of names, print all names starting with letter 'A'
        List<String> names = Arrays.asList("Alice", "Bob", "Alex", "Brian", "Anita");
//      for(String n : names){ // picking up items from list "names" and putting it in variable n one by one
//            System.out.println(n);
//        }
        names.stream()
                .filter(n -> n.startsWith("A"))  // intermediate operation
                .forEach(n -> System.out.println(n)); // terminal operation

        names.stream()
                .filter(n -> n.startsWith("A"))  // intermediate operation
                .forEach(System.out::println); // terminal operation
        System.out.println("-----------------");
        //print all names which have length more than 4
        names.stream()
                .filter(n -> n.length() > 4)
                .forEach(n -> System.out.println(n));

        names.stream()
                .filter(n -> n.length() > 4)
                .forEach(System.out::println); // shorter code with method refernece bcs single parameter


        System.out.println("------Q2------");
        // Q2. Convert a list of names to uppercase and store it new a new list
        List<String> lowerCaseNames =
                Arrays.asList("alice", "bob", "charlie", "darwin", "alicia", "jackie", "rockie", "wu", "xu");

        List<String> upperCaseNames = lowerCaseNames.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println(upperCaseNames);
        // make those names capital which have atleast 4 letters in sorted order
        List<String> upperCase4Names = lowerCaseNames.stream()
                .filter(n -> n.length() > 4) // intermediate 1
                .map(String::toUpperCase) // intermediate 2
                .sorted() // intermediate 3
                .collect(Collectors.toList()); // terminal
        System.out.println(upperCase4Names);

        System.out.println("-----Q3--------");
        // Given a list of numbers, find the sum of all even numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .filter(n -> n%2==0) // intermediate 1 -> chooses those numbers which are even
                .mapToInt(n -> n) // converts stream into int, as it is [ 2(Stream) -> 2(Integer) ]
                .sum(); // terminal
        System.out.println(sum);

    }
}
/*
     1. Use Stream<Generic> with generics, dont rely much on primitive streams
     2. Try using Collection data structure, rather than using primitive arrays
 */