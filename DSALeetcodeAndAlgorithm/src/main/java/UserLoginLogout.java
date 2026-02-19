package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class UserLoginLogout {
	public static void main(String[] args) {
		List<String>  list=Arrays.asList("John D LOGIN","Jane S LOGIN", //"John D LOGOUT",
				"Exernal Admin LOGOUT", "Jane S LOGIN", "Admin User A LOGIN",
				"RS LOGOUT","John D LOGIN", "John D LOGOUT","KITTU LOGIN");
		
		List<String> invalidlogins=new ArrayList<>();
		Stack<String> stack = new Stack<>();
		for(String s: list) {
			String[] parts = s.split(" ");
			String user = String.join(" ",
                    Arrays.copyOf(parts, parts.length - 1));    

			String action = parts[parts.length-1];

			if(action.equalsIgnoreCase("LOGIN")) {
				if(stack.contains(s)) {
					invalidlogins.add(s);
					//stack.remove(s);
				} else {
					stack.add(user);
				}
			} else if(action.equalsIgnoreCase("LOGOUT")){
				if(!stack.contains(user)) {
					invalidlogins.add(s);
				} else {
					stack.remove(user);
				}
			}	
		}
		
		
		while(!stack.isEmpty()) {
			String s=stack.pop();
        	if(!invalidlogins.contains(s + " LOGIN")) {
        		invalidlogins.add(s + " LOGIN");
        	}
				//invalidlogins.add(s);
			}
			
		
		System.out.println(invalidlogins);
		System.out.println(stack);
		List<String> invalidlogin=new ArrayList<>();
		 Set<String> loggedInUsers = new HashSet<>();

	        for (String s : list) {
	            String[] parts = s.split(" ");
	            String user = String.join(" ",
	                    Arrays.copyOf(parts, parts.length - 1));
	            String action = parts[parts.length - 1];

	            if (action.equalsIgnoreCase("LOGIN")) {
	                if (!loggedInUsers.add(user)) {
	                    
	                	invalidlogin.add(s);
	                }
	            } 
	            else if (action.equalsIgnoreCase("LOGOUT")) {
	                if (!loggedInUsers.remove(user)) {
	                   
	                	invalidlogin.add(s);
	                }
	            }
	        }

	        // users who never logged out
	        for (String user : loggedInUsers) {
	        	
	        	if(!invalidlogin.contains(user + " LOGIN")) {
	        		invalidlogin.add(user + " LOGIN");
	        	}
	        }

	        System.out.println(invalidlogin);

	        Map<String, String> map = new HashMap<>();
	        List<String> invalid = new ArrayList<>();

	        for (String s : list) {
	            String[] parts = s.split(" ");
	            String user = String.join(" ",
	                    Arrays.copyOf(parts, parts.length - 1));
	            String action = parts[parts.length - 1];

	            if (action.equalsIgnoreCase("LOGIN")) {
	                if (map.containsKey(user)) {
	                   
	                    invalid.add(s);
	                } else {
	                    map.put(user, "LOGIN");
	                }
	            }
	            else if (action.equalsIgnoreCase("LOGOUT")) {
	                if (!map.containsKey(user)) {
	                    // logout without login
	                    invalid.add(s);
	                } else {
	                    map.remove(user);
	                }
	            }
	        }

	        // users who never logged out
	        for (String user : map.keySet()) {
	        	if(!invalid.contains(user + " LOGIN")) {
	        		invalid.add(user + " LOGIN");
	        	}
	        }

	        System.out.println(invalid);
	        userlogin();
		/*
		 * Map<Boolean, List<String>>map2
		 * =list.stream().collect(Collectors.partitioningBy(e -> e.contains("LOGIN")));
		 * 
		 * List<String> l1=map2.get(true); List<String> l2=map2.get(false);
		 * System.out.print(l1); System.out.print(l2);
		 * 
		 * List<String[]> list1=l1.stream().map(m->
		 * m.split(" ")).collect(Collectors.toList()); List<String[]>
		 * list2=l1.stream().map(m-> m.split(" ")).collect(Collectors.toList());
		 * System.out.println(); for(String[] s:list1) {
		 * System.out.println(Arrays.toString(s)); }
		 */
		/*
		 * Map<Object, Long> map1=l2.stream().map(m->
		 * m.split(" LOGOUT")).collect(Collectors.groupingBy(e -> e,
		 * Collectors.counting()));
		 * 
		 * for(Map.Entry m: map.entrySet()) {
		 * 
		 * if(m.getValue().equals(2)) { System.out.println(m.getKey()); } }
		 */
		
	}
	private static void userlogin() {

		List<String>  list=Arrays.asList("John D LOGIN","Jane S LOGIN", //"John D LOGOUT",
				"Exernal Admin LOGOUT", "Jane S LOGIN", "Admin User A LOGIN",
				"RS LOGOUT","John D LOGIN", "John D LOGOUT","KITTU LOGIN");
		
		List<String> invalidlogins=new ArrayList<>();
		Stack<String> stack = new Stack<>();
		for(String s: list) {
			String[] parts = s.split(" ");
			String user = String.join(" ",
                    Arrays.copyOf(parts, parts.length - 1));    

			String action = parts[parts.length-1];

			if(action.equalsIgnoreCase("LOGIN")) {
				if(stack.contains(s)) {
					invalidlogins.add(s);
					stack.remove(s);
				} else {
					stack.add(s);
				}
			} else if(action.equalsIgnoreCase("LOGOUT")){
				if(!stack.contains(user)) {
					invalidlogins.add(s);
				} else {
					stack.remove(s);
				}
			}	
		}
		
		
		while(!stack.isEmpty()) {
			String s=stack.pop();
				invalidlogins.add(s);
			}
			
		
		System.out.println(invalidlogins);
		System.out.println(stack);
		List<String> invalidlogin=new ArrayList<>();
		 Set<String> loggedInUsers = new HashSet<>();

	        for (String s : list) {
	            String[] parts = s.split(" ");
	            String user = String.join(" ",
	                    Arrays.copyOf(parts, parts.length - 1));
	            String action = parts[parts.length - 1];

	            if (action.equalsIgnoreCase("LOGIN")) {
	                if (!loggedInUsers.add(user)) {
	                    
	                	invalidlogin.add(s);
	                }
	            } 
	            else if (action.equalsIgnoreCase("LOGOUT")) {
	                if (!loggedInUsers.remove(user)) {
	                   
	                	invalidlogin.add(s);
	                }
	            }
	        }

	        // users who never logged out
	        for (String user : loggedInUsers) {
	        	invalidlogin.add(user + " LOGIN");
	        }

	        System.out.println(invalidlogin);

	        Map<String, String> map=new HashMap<>();
	        List<String> invalid=new ArrayList<>();
			for(String s: list) {
				String[] parts = s.split(" ");
				String user = String.join(" ",
	                    Arrays.copyOf(parts, parts.length - 1));    

				String action = parts[parts.length-1];
				
				if(action.equalsIgnoreCase("LOGIN")) {
					if(map.get(s) != null) {
						invalid.add(s);
					} else {
						map.put(user, action);
					}
				} else if(action.equalsIgnoreCase("LOGOUT")){
					if(!(map.get(s) != null)) {
						invalid.add(s);
					} else {
						map.remove(user);
					}
				}	
			}
			if(!map.isEmpty()) {
				for(String m:map.keySet()) {
						invalid.add(m + " LOGIN");
				}
			}
			System.out.print(invalid);
	}

}