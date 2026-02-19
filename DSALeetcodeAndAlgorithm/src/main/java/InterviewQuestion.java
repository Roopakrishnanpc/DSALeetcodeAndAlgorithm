package main.java;
import java.util.stream.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
class Student {

    private int id;
    private String name;
    private List<Integer> marks;
 
    public Student(int i, String string, List<Integer> asList) {
		// TODO Auto-generated constructor stub
    	this.id=i;
    	this.name=string;
    	this.marks=asList;
	}

	public int getId() {
        return id;
    }
 
    public List<Integer> getMarks() {
        return marks;
    }
}

public class InterviewQuestion {
	public static void main(String[] args) {
		List<Student> listEmp = Arrays.asList(
			    new Student(1, "a", Arrays.asList(10, 20, 30)),
			    new Student(2, "b", Arrays.asList(40, 50, 20))
			);

		Map<Integer, Integer> sumById =
			    listEmp.stream()
			           .collect(Collectors.groupingBy(
			               Student::getId,
			               Collectors.summingInt(
			                   s -> s.getMarks()
			                         .stream()
			                         .mapToInt(Integer::intValue)
			                         .sum()
			               )
			           ));
		
		Map<Integer, Integer> sumById2 =
			    listEmp.stream()
			           .collect(Collectors.toMap(
			               Student::getId,//e1->e1.getId()
			               s -> s.getMarks()
			                     .stream()
			                     .mapToInt(Integer::intValue)
			                     .sum()
			           ));
		List<Integer> allMarks =
			    listEmp.stream()
			           .flatMap(s -> s.getMarks().stream())
			           .collect(Collectors.toList());
		
//		MythreadException extend ExceptionHandler
//
//		{
//
//		InvalidFormatException(Exception )
//
//
//		empId    empName  manager_id
//		  1	    Alice    NULL
//		  2	    Bob        1
//		  3	    Charlie    1
//		  4	    Ivan       2
//		 
//		1>emp and their manager name
//
//		select e1.empName,e2.empName from employee e1 left join e2 on e1.empID=e2.manager_id where manager_id>=1 group by empId;
//		SELECT e.empName AS employee,
//		       m.empName AS manager
//		FROM employee e
//		LEFT JOIN employee m
//		     ON e.manager_id = m.empId;

		Integer[] arr = {5,2,8};
		Integer[] arr2 = {4,9,1};
		 Stream
.concat(Arrays.stream(arr), Arrays.stream(arr2)).sorted().toArray(Integer[]::new);
		Integer[] arr3= {4,1,7,3,9,7,5,2};
		
		Arrays.stream(arr3)
	      .sorted((a,b)-> b.compareTo(a))//Comparator.reverseOrder()
	      .distinct()
	      .skip(2)
	      .forEach(System.out::println);

		
		
	}
}
