package main.java;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.*;

public class Java8Examples {

    public static void main(String[] args) {

        // 1️⃣ Sort Map by Value
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 20);
        map.put("B", 10);
        map.put("C", 40);
        map.put("D", 5);

        Map<String, Integer> sorted =
                map.entrySet()
                   .stream()
                   .sorted(Map.Entry.comparingByValue())
                   .collect(Collectors.toMap(
                           Map.Entry::getKey,
                           Map.Entry::getValue,
                           (a, b) -> a,
                           LinkedHashMap::new));

        System.out.println("Sorted Map: " + sorted);


        // 2️⃣ Find All Pairs With Given Sum
        int[] arr1 = {1,2,3,4,6,7,4,5};
        int sum = 8;

        Set<Integer> seen = new HashSet<>();

        Arrays.stream(arr1).forEach(num -> {
            int target = sum - num;
            if (seen.contains(target)) {
                System.out.println("Pair: " + num + " " + target);
            }
            seen.add(num);
        });


        // 3️⃣ Longest Substring Without Repeating Characters
        String s = "abcabcbb";

        Set<Character> set = new HashSet<>();
        int[] left = {0};
        int[] max = {0};

        IntStream.range(0, s.length()).forEach(right -> {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left[0]));
                left[0]++;
            }
            set.add(s.charAt(right));
            max[0] = Math.max(max[0], right - left[0] + 1);
        });

        System.out.println("Longest Substring Length: " + max[0]);
        String s2 = "i AM roopa";
       // Stream.of(s2.split(" ")).reduce("", (a,b)-> b+ " "+a);

        // 4️⃣ Find Missing Numbers in Range 1–10
        int[] arr2 = {1,3,4,6,7,10};

        Set<Integer> existing =
                Arrays.stream(arr2)
                      .boxed()
                      .collect(Collectors.toSet());

        System.out.print("Missing Numbers: ");
        IntStream.rangeClosed(1, 10)
                 .filter(i -> !existing.contains(i))
                 .forEach(i -> System.out.print(i + " "));
        System.out.println();


        // 5️⃣ Second Highest Salary (SQL)
        // SELECT MAX(salary)
        // FROM employee
        // WHERE salary < (SELECT MAX(salary) FROM employee);


        // 6️⃣ Fixed Thread Pool (Java 8)
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> System.out.println("Task 1 executed"));
        executor.submit(() -> System.out.println("Task 2 executed"));

        executor.shutdown();
    }
}
