package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComapreProblem {


    public static void main(String[] args) {
        Employee e1 = new Employee(1, "ZYX");
        Employee e2 = new Employee(2, "ABCD");
        Employee e3 = e1;

        ArrayList<Employee> ar = new ArrayList();
        ar.add(e2);
        ar.add(e1);
        for (Employee e:
             ar) {
            System.out.println("Employee name =>> " + e.getName() + " regno =>> "+ e.getRegno());
        }

        ar.sort(Comparator.comparing(Employee::getName));
        for (Employee e:
                ar) {
            System.out.println("Employee name =>> " + e.getName() + " regno =>> "+ e.getRegno());
        }

    }



}

class Employee {
    private int regno;
    private String name;

    //constructor of Employee class
    public Employee(int regno, String name) {
        this.name = name;
        this.regno = regno;
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int Regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}