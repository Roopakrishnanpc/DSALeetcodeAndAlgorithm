#1.Second Highest Salary
SELECT MAX(sal)
FROM Employee
WHERE sal < (SELECT MAX(sal) FROM Employee);

SELECT DISTINCT sal
FROM Employee
ORDER BY sal DESC
    LIMIT 1 OFFSET 1;

#2.Nth Highest Salary
SELECT sal
FROM (
         SELECT sal, DENSE_RANK() OVER (ORDER BY sal DESC) rnk
         FROM Employee
     ) t
WHERE rnk = N;

#Example: 3rd highest salary → rnk = 3

3. Find Duplicate Records
SELECT name, COUNT(*)
FROM Employee
GROUP BY name
HAVING COUNT(*) > 1;
4. Delete Duplicate Records
DELETE FROM Employee
WHERE id NOT IN (
    SELECT MIN(id)
    FROM Employee
    GROUP BY name, dept
);
5. Employees Earning More Than Their Manager
SELECT e.name, e.sal
FROM Employee e
         JOIN Employee m
              ON e.manager_id = m.id
WHERE e.sal > m.sal;
6. Maximum Salary Per Department
SELECT dept, MAX(sal)
FROM Employee
GROUP BY dept;
7. Department With Highest Average Salary
SELECT dept
FROM Employee
GROUP BY dept
ORDER BY AVG(sal) DESC
    LIMIT 1;
8. Employees Without Department
SELECT *
FROM Employee
WHERE dept IS NULL;
9. Departments With No Employees
SELECT d.dept_name
FROM Department d
         LEFT JOIN Employee e
                   ON d.dept = e.dept
WHERE e.dept IS NULL;
10. First Record From Table
SELECT *
FROM Employee
ORDER BY id ASC
    LIMIT 1;
11. Last Record From Table
SELECT *
FROM Employee
ORDER BY id DESC
    LIMIT 1;
12. Employees Earning Above Average Salary
SELECT *
FROM Employee
WHERE sal > (SELECT AVG(sal) FROM Employee);
13. Count Employees Per Department
SELECT dept, COUNT(*)
FROM Employee
GROUP BY dept;
14. Top 3 Highest Salaries
SELECT DISTINCT sal
FROM Employee
ORDER BY sal DESC
    LIMIT 3;
15. Employees With Same Salary
SELECT sal, COUNT(*)
FROM Employee
GROUP BY sal
HAVING COUNT(*) > 1;
16. Difference Between Max and Min Salary
SELECT MAX(sal) - MIN(sal)
FROM Employee;
17. Current Date
SELECT CURRENT_DATE;
18. Employees Joined in Last 30 Days
SELECT *
FROM Employee
WHERE joining_date >= CURRENT_DATE - INTERVAL 30 DAY;
19. Total Salary Per Department
SELECT dept, SUM(sal)
FROM Employee
GROUP BY dept;
20. Names Starting With A
SELECT *
FROM Employee
WHERE name LIKE 'A%';
21. Names Ending With N
SELECT *
FROM Employee
WHERE name LIKE '%N';
22. Salary Between 3000 and 7000
SELECT *
FROM Employee
WHERE sal BETWEEN 3000 AND 7000;
23. Second Lowest Salary
SELECT MIN(sal)
FROM Employee
WHERE sal > (SELECT MIN(sal) FROM Employee);
24. Rank Employees by Salary
SELECT name, sal,
       RANK() OVER (ORDER BY sal DESC) rnk
FROM Employee;
25. Running Total of Salary
SELECT name, sal,
       SUM(sal) OVER (ORDER BY id) AS running_total
FROM Employee;
26. Employees Joined on Same Date
SELECT joining_date, COUNT(*)
FROM Employee
GROUP BY joining_date
HAVING COUNT(*) > 1;
27. Highest Salary Employee Per Department
SELECT *
FROM (
         SELECT *,
                RANK() OVER(PARTITION BY dept ORDER BY sal DESC) rnk
         FROM Employee
     ) t
WHERE rnk = 1;
28. Inner Join
SELECT *
FROM Employee e
         INNER JOIN Department d
                    ON e.dept = d.dept;
29. Left Join
SELECT *
FROM Employee e
         LEFT JOIN Department d
                   ON e.dept = d.dept;
30. Right Join
SELECT *
FROM Employee e
         RIGHT JOIN Department d
                    ON e.dept = d.dept;