import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice implements  Cloneable{

    public static void main(String[] args) {
       //1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        System.out.println(list.stream().filter(a -> a % 2==0).toList());

        //2.Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        System.out.println(
                myList.stream()
                        .map(a -> String.valueOf(a))
                        .filter(a ->  a.startsWith("1") )
                        .toList()
        );

        // 3.How to find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> myList1 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> setInt = new HashSet<>();
        System.out.println(myList1.stream()
                .filter(a -> !setInt.add(a))
                .toList());

        //4.Given the list of integers, find the first element of the list using Stream functions?
        List<Integer> myList2 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(myList2.stream().findFirst().get());

        //5.Given a list of integers, find the total number of elements present in the list using Stream functions?
        System.out.println(myList2.stream().count());

       //6. Given a list of integers, find the maximum value element present in it using Stream functions
        List<Integer> myList6 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(myList6.stream().max((a,b) -> Integer.compare(a,b)).get());

       //7. Given a String, find the first non-repeated character in it using Stream functions?
        String input = "Java articles are Awesome";

        //Character result = input.chars() // Stream of String

                List<Character> charList = input.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey()).toList();
            //    .findFirst()
          //      .get();
        System.out.println(charList);

        //Given a String, find the first repeated character in it using Stream functions?
        String input1 = "Java Articles are Awesome";
        Character charX = input1.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap ::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst().get();
        System.out.println(charX);

        //Given a list of integers, sort all the values present in it using Stream functions?
        List<Integer> myList9 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(myList9.stream().sorted().toList());

        //Given a list of integers, sort all the values present in it in descending order using Stream functions?
        List<Integer> myList10 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(myList10.stream().sorted(Collections.reverseOrder()).toList());

        //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        List<Integer> myList11 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(!myList11.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue() > 1).toList().isEmpty());

        //Java 8 program to perform cube on list elements and filter numbers greater than 50.
        List<Integer> myList12 = Arrays.asList(1,2,3,49,25,98,98,32,15);
        System.out.println(myList12.stream().map(a -> a*a*a).filter(a -> a > 50).toList());

       // How to use map to convert object into Uppercase in Java 8?
        List<String> stringList = Arrays.asList("hello","hi");
        System.out.println(stringList.stream().map(x -> x.toUpperCase()).toList());

        //How to count each element/word from the String ArrayList in Java8?
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> ans = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        //duplicate count
        List<String> strDuplicate = ans.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).toList();

       // How to find only duplicate elements with its count from the String ArrayList in Java8?
        List<String> nameList = Arrays.asList("AA", "BB", "AA", "CC", "CC");
        Map<String,Long> mapKeyVsCount = nameList.stream().filter(x->Collections.frequency(nameList, x)>1).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mapKeyVsCount);

        //Write a program to print the count of each character in a String
        String str21 = "hello How are you ?";
        String[] strArray  =  str21.split("");
        List<String> strListX =  Arrays.asList(strArray);

      Map<String,Long>  stringLongMap = Arrays.stream(str21.split("")).map(x -> x.toUpperCase()).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
      System.out.println(stringLongMap);

      Map<String,Long>  stringLongMap1 = Arrays.stream(str21.split("")).map(x -> x.toUpperCase()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
      System.out.println(stringLongMap1);
    }
}
