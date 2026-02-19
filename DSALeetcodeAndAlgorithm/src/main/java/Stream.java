package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class ObjClass {

    private int id;
    private String name;
    private double score;

    public ObjClass(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ObjClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="roopa";
		String sen="roopa is a good girl";
		String[] senArr=sen.split(" ");
		//count character occurences in a string
		System.out.println(Arrays.stream(senArr).reduce((a,b)-> b +" "+ a ).orElse(" ")); 
		String reversed = s.chars()
		        .mapToObj(c -> String.valueOf((char) c))
		        .reduce("", (a, b) -> b + a);

		System.out.println(reversed);

		s.chars().mapToObj(e->(char)e).
		collect(Collectors.groupingBy(Function.identity(), 
				LinkedHashMap::new
				,Collectors.counting())).
		entrySet().forEach(e1-> System.out.print(e1.getKey()+ " "+e1.getValue()));
		System.out.println("Find first non repeating character");
		Entry<Character, Long> c=s.chars().mapToObj(e->(char)e).
		collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
				Collectors.counting())).
		entrySet().stream().filter(e1-> e1.getValue()==1L).findFirst().get();
		System.out.println(c.getKey());
		System.out.println("Identify duplicate element in a list ----------");
		List<Integer> list=Arrays.asList(1,2,3,4,5,5,5,5);
		Set<Integer> set=new HashSet<>();
		list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);;
		list.stream()
	    .sorted((a,b) -> b.compareTo(a))
	    .skip(1);
		Integer max = list.stream().max(Integer::compareTo).orElse(null);

		Integer secondMax = list.stream()
		    .filter(e -> !e.equals(max))
		    .max(Integer::compareTo)
		    .orElse(null);

		System.out.println(secondMax);
		int x=20,y=60;
		IntStream.of(x, y)
        .map(i -> i * 2)
        .forEach(System.out::println);

		

		list.stream().filter(se->!set.add(se)).forEach(System.out::println);
		list.stream()
	    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	    .entrySet()
	    .stream()
	    .filter(e -> e.getValue() > 1)
	    //.map(Map.Entry::getKey)
	    .forEach(System.out::println);
		list.stream().mapToInt(Integer::intValue).max();
		list.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
		list.stream().min(Integer::compareTo).ifPresent(System.out::println);
		List<ObjClass> listobj = Arrays.asList(
		        new ObjClass(3, "John", 82.5),
		        new ObjClass(1, "Alex", 91.0),
		        new ObjClass(2, "David", 75.3),
		        new ObjClass(5, "Chris", 91.0)
		);
		listobj.stream().sorted(Comparator.comparing(ObjClass::getName)).forEach(System.out::println);
		listobj.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).forEach(System.out::println);
		listobj.stream()
	       .sorted(Comparator.comparingDouble(ObjClass::getScore)
	                         .reversed()
	                         .thenComparing(ObjClass::getName))
	       .forEach(System.out::println);
		int[] piles= {3,4,2,1,4,7};
		Arrays.stream(piles).max().getAsInt();
		
		
		list.stream().mapToInt(Integer::intValue).sum();
		list.stream().mapToInt(Integer::intValue).average();
		list.stream().collect(Collectors.summingInt(e->e));
		
		//If You Want Sum of Scores for Even/Odd ID
		Map<Boolean, Double> result = listobj.stream()
		    .collect(Collectors.partitioningBy(
		        obj -> obj.getId() % 2 == 0,
		        Collectors.summingDouble(ObjClass::getScore)
		    ));
		System.out.println(result);
		
		list.stream().filter(e2-> set.add(e2)).forEach(System.out::println);
		list.stream()
	    .distinct()
	    .forEach(System.out::println);

		Map<String, Optional<ObjClass>> result1 =
		        listobj.stream()
		               .collect(Collectors.groupingBy(
		                       ObjClass::getName,
		                       Collectors.maxBy(
		                               Comparator.comparingDouble(ObjClass::getScore)
		                       )
		               ));
		String s1="apoor";
		boolean isAnagram = s1.chars().sorted()
		        .boxed()
		        .collect(Collectors.toList())
		        .equals(
		            s.chars().sorted()
		               .boxed()
		               .collect(Collectors.toList())
		        );


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		List<String> lists = Arrays.asList("apple", "banana", "cherry");
		boolean b=list.stream().allMatch(s77->s77.equals("orange"));
		System.out.println(b); 
		boolean hasA = lists.stream()
		                   .anyMatch(s66 -> s66.contains("a"));

		System.out.println(hasA); // true



		boolean allContainA = lists.stream().allMatch(s44 -> s44.contains("a"));
		boolean noneContainZ = lists.stream().noneMatch(s55 -> s55.contains("z"));

		System.out.println(allContainA); // false
		System.out.println(noneContainZ); // true


		List<List<String>> nestedList = Arrays.asList(
		    Arrays.asList("a", "b"),
		    Arrays.asList("c", "d"),
		    Arrays.asList("e")
		);



		boolean containsD = nestedList.stream()
		                              .flatMap(List::stream)
		                              .anyMatch(s11 -> s11.equals("d"));

		System.out.println(containsD); // true

		if (nestedList.stream().flatMap(List::stream).anyMatch(s22 -> s22.contains("a"))) {
		    String joined = nestedList.stream()
		                              .flatMap(List::stream)
		                              .filter(s33 -> s33.contains("a"))
		                              .collect(Collectors.joining(", "));
		    System.out.println(joined);
		}
		List<List<Integer>> nestedListint = Arrays.asList(
			    Arrays.asList(1,2),
			    Arrays.asList(11,2),
			    Arrays.asList(3)
			);
		nestedListint.stream().flatMap(List::stream).map(String::valueOf).filter(h->h.startsWith("1")).forEach(System.out::println);
		nestedListint.stream().map(i-> i.stream().mapToInt(Integer::intValue).sum()).forEach(System.out::println);
		String sentence = "hi how are you?";

		String rr = Arrays.stream(sentence.split(" "))   // split into words
		                      .map(word -> new StringBuilder(word).reverse().toString()) // reverse each word
		                      .collect(Collectors.joining(" ")); // join back with space

		System.out.println(rr);
		//"\\W+"
		
		
	}

}
