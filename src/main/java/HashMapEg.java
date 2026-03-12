package main.java;

import java.util.HashMap;
import java.util.Map;

public class HashMapEg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "Roopa");
		map.put(2, "Ashwin");
		map.put(3, "Sam");
		for(Map.Entry<Integer, String> m:map.entrySet()) {
			System.out.println(m.getKey() + " "+ m.getValue());
		}
		for(Integer key: map.keySet()) {
			System.out.println(key + " "+map.get(key));
		}
		map.forEach((key, val)-> System.out.println(key + " "+ val));
		
		int n = 10;
		 
        for (int i = 0; i < n; i++) {//10

            for (int j = 0; j < n; j++) {//each i time j will be call 10times 

                System.out.println("Hello");

            }

        }
 
	}

}
