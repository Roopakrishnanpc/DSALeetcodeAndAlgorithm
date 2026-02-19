package main.java;

public class ClimibingStaris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;
		if(N<=2) {
			System.out.println(N);
			return;
		}
		int prev1Step=2, prev2Step=1;
		int currentStep=prev1Step+prev2Step;
		for(int i=4; i<=N; i++) {
			prev2Step=prev1Step;
			prev1Step=currentStep;
			currentStep=prev2Step+prev1Step;
			
		}
		System.out.println(currentStep);
	}
//	fetch deptname and count of employees in that department using sql join 
//	there are 2 tables --> emp and dept
//
//	SELECT 
//	    d.deptname,
//	    COUNT(e.empid) AS employee_count
//	FROM dept d
//	LEFT JOIN emp e
//	    ON d.deptid = e.deptid
//	GROUP BY d.deptname;
//
//
//	select deptname, count(emps) from emp left join dept d on d.id= emps.id order by deptname
//
//	. filter empList where age of employees is even number 
//	3. sort emplist based on name , age and salary 
//	both q2 and 3 needs to be solved using stream only
//
//	1st way
//	empList.stream().filter(e -> e.getaget() %2==0).collect(collectors.tolist)
//	empList.stream().sorted(Comparator.comparing(Emp::getName).thenComparing(Emp::getAge).thencomparing(Emp::getSalary)).forEach(System.out::println)

}
