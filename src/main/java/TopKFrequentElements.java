package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3,4,4,5,5,5,5};
        int k = 2;
        int[] res=new int[k];
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums) {
        	map.put(num, map.getOrDefault(num, 0)+1);
        }
        //here we are collecting the index example nums.length=7 we are taking upto 8 because we start from 0
        //now we are allocating the values like
        // 0 1 2 3 4 5 6 7
        //   3 2 1 5       if u see these numbers from nums are mattched with their count
        //     4
        //list[1]=3
        //list[2]=2, 4 -> thats why we are creating array list to check if you numbers have same count
        //list[3]=1
        //list[4]=5
        List<Integer>[] list=new ArrayList[nums.length+1];
        for(int i=0; i<=nums.length; i++) list[i]=new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> num:map.entrySet()) {
        	list[num.getValue()].add(num.getKey());
        	System.out.println(num.getValue() + " " + num.getKey());
        }
        int idx=nums.length;//for top most nums.length; for min value idx=0;
        k--;//comment this and add k>=0 and add res[k-1]=num; k--; same result
        System.out.println(k);
        while(k>=0) {//>=0 because we need to assign int res[0] as well or we can do k-1 in res
        	for(int num:list[idx]) {
        		res[k--]=num;//res[k-1]=num; k--;
//        		to find min value op:3, 2
//        		if(k>=0) {
//        			res[k--]=num;//res[k-1]=num; k--;
//        		}
        	}
        	idx--;//idx++; for min value
        }
        System.out.println(list[2]);
        for(int num:res) {
        	System.out.println(num);
        }
//        PriorityQueue<Integer> heap = new PriorityQueue<>(
//                Comparator.comparingInt(map::get) // frequency ascending
//            );
//
//            for (int num : map.keySet()) {
//                heap.offer(num);
//                if (heap.size() > k) {
//                    heap.poll(); // remove smallest frequency
//                }
//            }
//
//            // Step 3: Output top K
//            while (!heap.isEmpty()) {
//                System.out.println(heap.poll());
//            }
//        int[] topK = Arrays.stream(nums)
//            .boxed() // convert int to Integer for streams
//            .collect(Collectors.groupingBy(n -> n, Collectors.counting())) // frequency map
//            .entrySet().stream() // stream of map entries
//            .sorted((a,b) -> b.getValue().compareTo(a.getValue()))//Compartors.comparing(Map.Entry::getValue).reversed())
//            .limit(k).mapToInt(Map.Entry::getKey).toArray();
        //System.out.println(topK);
//        
//        Map<String, List<Employee>> byDept = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//
//            // Sort by max salary in each department
//            List<String> topKDepartments = byDept.entrySet().stream()
//                .sorted((e1, e2) -> 
//                    Integer.compare(
//                        e2.getValue().stream().mapToInt(Employee::getSalary).max().orElse(0),
//                        e1.getValue().stream().mapToInt(Employee::getSalary).max().orElse(0)
//                    )
//                ).limit(k)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//
//            System.out.println(topKDepartments);
        
//        Map<String, List<Employee>> byDept = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//
//        List<String> topKDepartments = byDept.entrySet().stream()
//                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size())) // descending by count
//                .limit(k)
//                .map(Map.Entry::getKey) // extract department names
//                .collect(Collectors.toList());
//        .sorted((e1, e2) -> 
//        Integer.compare(
//            e2.getValue().stream().mapToInt(Employee::getSalary).sum(),
//            e1.getValue().stream().mapToInt(Employee::getSalary).sum()
//        )
//    )
//        
//        
//        Map<String, List<Employee>> byDept = employees.stream()
//        .collect(Collectors.groupingBy(Employee::getDepartment));
//
//    // Sort by max salary in each department using Comparator.comparing
//    List<String> topKDepartments = byDept.entrySet().stream()
//        .sorted(
//            Comparator.comparing(
//                (Map.Entry<String, List<Employee>> e) -> 
//                    e.getValue().stream().mapToInt(Employee::getSalary).max().orElse(0)
//            ).reversed() // descending order
//        )
//        .limit(k)
//        .map(Map.Entry::getKey)
//        .collect(Collectors.toList());

	}

}
