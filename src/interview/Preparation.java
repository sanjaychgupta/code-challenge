package interview;

import java.util.*;

public class Preparation {
    public static void main(String[] args) {
        Vector <Integer> vector = new Vector <>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);
        for (Integer i : vector
                ) {
            System.out.print(i);
        }
        System.out.println();
        vector.forEach(System.out::print);
        System.out.println();
        Employee emp1 = new Employee(10);
        Employee emp2 = emp1;
        System.out.println("emp1==emp2" + (emp1 == emp2));
        System.out.println("emp1.equals(emp2)" + emp1.equals(emp2));

        List<Integer> list =  new LinkedList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list.hashCode());
        List<Integer> list2 = list;
        System.out.println(list2.hashCode());

        List list3 = Collections.unmodifiableList(list);
        System.out.println(list3.hashCode());
        

/*
        List<Employee> emplist = new ArrayList<>();
        emplist.add( new Employee(10));
        emplist.add( new Employee(20));
        emplist.add( new Employee(70));
        emplist.add( new Employee(30));
        emplist.add( new Employee(50));
        emplist.add( new Employee(60));
        emplist.add( new Employee(40));
        emplist.forEach(System.out::println);
        System.out.println();

        Collections.sort(emplist);
        emplist.forEach(System.out::println);
        System.out.println();

        Collections.sort(emplist, new EmployeeComparator());

        emplist.forEach(System.out::println);
        System.out.println();

        Comparator<Employee> comparator = (o1,o2) -> (o1.empId-o2.empId)*-1;
        Collections.sort(emplist, comparator);
        emplist.forEach(System.out::println);
        System.out.println();*/


    }

    public static class Task extends Thread {
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1st" + Thread.currentThread().getName());
        }
    }
    public static class Task2 extends Thread {
        public void run() {
            System.out.println("2st" + Thread.currentThread().getName());
        }
    }

    public static class Employee implements Comparable <Employee> {
        int empId;

        public Employee(int empId) {
            this.empId = empId;
        }

        @Override
        public int compareTo(Employee e) {
            return (this.empId - e.empId) * -1;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    '}';
        }
    }

    public static class EmployeeComparator implements Comparator <Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.empId - o2.empId;
        }
    }
}

