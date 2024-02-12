
import java.util.*;
import java.util.function.Predicate;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamApiPractise {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                new Student(1,"sachin",6, Arrays.asList("9998","766765"),"fdgCEfde"),
                new Student(2,"harshita",5, Arrays.asList("129998","676765"),"sgCgfdgE"),
                new Student(3,"Nisarg",2, Arrays.asList("329998","676975"),"sdgCgfE"),
                new Student(4,"navya",1, Arrays.asList("549998","677565"),"sdCEgre"),
                new Student(5,"suresh",7, Arrays.asList("659998","678665"),"dfgCgfdE"),
                new Student(6,"nirmala",8, Arrays.asList("899998","6786865"),"dfgCgfdE")
        )
                .toList();
                //.collect(Collectors.toList());

        //case 1 Rank is between 3 and 7
        Predicate<Student> studentPredicate = student -> student.getRank() >= 3 && student.getRank() <= 7;
        //Predicate<Student> studentPredicate1  = Student :: getRank >= 3;
        List<Student> studentList1 = studentList.stream().filter(s -> s.getRank() >= 3 && s.getRank() <=7).toList();
        System.out.println(studentList1);
       //ImmutableCollections
        //studentList1.add(new Student(1,"nirmala",8, Arrays.asList("899998","6786865"),"dfgdfCE"));
        //System.out.println(studentList1);

        //case 2, department contain CE and sort it by name , if name is name sort if by rank
        Stream<Student> studentStream = studentList.stream().filter(student -> student.getDepartment().contains("CE"));
        List<Student> studentList2 = studentStream.sorted(Comparator.comparing(Student::getName).thenComparing(Student :: getRank)).toList();
       // reverse order
        //List<Student> studentList3 = studentStream.sorted(Comparator.comparing(Student::getName,Comparator.reverseOrder()).thenComparing(Student :: getRank)).toList();
        System.out.println(studentList2);


        //case 3 find all the department name , unique
        List<String> departmentList = studentList.stream().map(Student::getDepartment).distinct().toList();
        System.out.println(departmentList);
        Set<String> departmentSet = studentList.stream().map(Student::getDepartment).collect(Collectors.toSet());
        departmentSet.add("xyvfb");
        System.out.println(departmentSet);

        //case 4
        //find all the contact number which is list
        List<String> contacts = studentList.stream().flatMap(student -> student.getContacts().stream()).toList();

        //case 5 , group the student by department name , return map which key is department name and value is list of student which belongs to same department
        Map<String,List<Student>> departmentMap = studentList.stream().collect(Collectors.groupingBy(Student :: getDepartment));
        System.out.println(departmentMap);

        //case 6 , map of department name and count against it
        studentList.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.counting()));

        //case 7 find the department name which has max number of student
        studentList.stream().collect(Collectors.groupingBy(Student :: getDepartment,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
    }


}

