/*
 * Office Rostering Problem Description Vishal owns a startup with a small team
 * of employees. Vishal noticed a peculiar behaviour by his employees.
 * 
 * Among the employees, they have established some friendships. Every employee
 * has one or more friends in office. Whether one is working from office next
 * day depends on their own and their friend's status today i.e., WFH or WFO.
 * 
 * The behaviour is
 * 
 * When an employee worked from office today (WFO) and exactly 3 of his friends
 * also worked from office, then he will continue to work from office the next
 * day, else he will work from home (WFH) the next day When an employee worked
 * from home today and less than 3 of his friends worked from office, then he
 * will work from office the next day, else he will continue work from home On
 * day one everyone will be working from office. Employees mark their attendance
 * when they come to the office. Rostering over R days is defined as the total
 * number of employees who attended the office during these R days.
 * 
 * Given the friendship connections of employees and an integer K, determine how
 * many days it will take to reach a rostering value of K, following the rules.
 * 
 * Constraints 3 < N, M < 30
 * 
 * 1 < K < 50
 * 
 * Input The first line contains two space-separated integers N and M,
 * representing the number of employees and the total number of friendships
 * among them.
 * 
 * The next M lines contain two space-separated integers representing IDs of two
 * employees who are friends.
 * 
 * Last line consists of a single integer K, denoting the rostering value that
 * should be achieved.
 * 
 * Output Single integer denoting the number of days it will take to achieve the
 * rostering value K.
 * 
 * Time Limit (secs) 1
 * 
 * Examples Example 1
 * 
 * Input
 * 
 * 4 5
 * 
 * 1 3
 * 
 * 3 2
 * 
 * 0 3
 * 
 * 0 1
 * 
 * 2 1
 * 
 * 8
 * 
 * Output
 * 
 * 3
 * 
 * Explanation
 * 
 * From the input it is seen that there are 4 employees and 5 connections.
 * Employee 0 is friends with 1,3; 1 is friends with 0, 2, 3; 2 is friends with
 * 1,3; 3 is friends with 0, 1, 2. Rostering value required to be achieved is 8.
 * 
 * On Day 1everyone will work from office, the rostering value achieved day one
 * is 4.
 * 
 * On Day 2 employees 1 and 3 will work from office, as they have 3 friends and
 * all 3 worked from office last day. Employees 0 and 2 will work from home as
 * they have less than 3 of their friends who worked from office last day. Since
 * two employees will work from office on day 2, rostering value achieved
 * including day two is 6.
 * 
 * On Day 3, employees 1 and 3 will work from home, since less than 3 of their
 * friends worked from office last day. Employees 0 and 2 will work from office
 * as they have less than 3 of their friends who worked from office last day.
 * Thus, rostering value achieved including day 3 is 8.
 * 
 * Rostering value has been reached on day 3, hence the output 3.
 * 
 * Example 2
 * 
 * Input
 * 
 * 5 7
 * 
 * 1 4
 * 
 * 0 4
 * 
 * 0 1
 * 
 * 3 2
 * 
 * 3 4
 * 
 * 2 0
 * 
 * 1 3
 * 
 * 15
 * 
 * Output
 * 
 * 5
 * 
 * Explanation
 * 
 * From input it is seen that are 5 employees and 7 connections, 15 is the
 * rostering value needed to be reached.
 * 
 * On Day 1: All employees will work from office; rostering value at end of the
 * day is 5.
 * 
 * On Day 2: Employees 1, 3, 4 and 0 will work from office, rostering value at
 * end of the day is 9.
 * 
 * On Day 3: Employees 1, 2 and 4 will work from office, rostering value at end
 * of the day is 12.
 * 
 * On Day 4: All employees will do work from home, rostering value at end of the
 * day is 12.
 * 
 * On Day 5: All employees will work from office, rostering value at end of the
 * day is 17.
 * 
 * On Day 5, since the rostering value target is reached (17 > 15), hence print
 * 5 as output.
 */