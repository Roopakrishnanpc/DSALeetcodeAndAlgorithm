package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> flatMap=Arrays.asList(Arrays.asList(1,2,3,4),
				Arrays.asList(1,2), Arrays.asList(4,5));
		flatMap.stream().flatMap(List::stream).map(String::valueOf)
		.filter(e ->e.startsWith("1")).forEach(System.out::println);
		List<Integer> list=flatMap.stream().map(e-> e.stream().mapToInt(Integer::intValue).sum()).collect(Collectors.toList());//
		list.forEach(System.out::println);
		List<Integer> nums = Arrays.asList(1, 2, 3);
		/*List<String> for collect(Collectors.toList()); */String strings = nums.stream()
		                           .map(String::valueOf)
		                           //.collect(Collectors.toList());
		.collect(Collectors.joining(",","[","]"));
		//strings.forEach(System.out::println);
		System.out.println(strings);
	}

}
