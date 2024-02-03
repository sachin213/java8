
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import java.util.stream.Stream;


public class StreamApiPractise {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                new Student(1,"sachin",6, Arrays.asList("9998","766765"),"fdgCEfde"),
                new Student(1,"harshita",5, Arrays.asList("129998","676765"),"sgCgfdgE"),
                new Student(1,"Nisarg",2, Arrays.asList("329998","676975"),"sdgCgfE"),
                new Student(1,"navya",1, Arrays.asList("549998","677565"),"sdCEgre"),
                new Student(1,"suresh",7, Arrays.asList("659998","678665"),"dfgCgfdE"),
                new Student(1,"nirmala",8, Arrays.asList("899998","6786865"),"dfgdfCE")
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
        System.out.println(studentList2);

        //case 3 find all the department name
    }


}
