package com.test.newalgo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]){
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee("Suresh", "Patel");
        Employee emp2 = new Employee("Hemant", "Khatri");

        list.add(emp1);
        list.add(emp2);

        emp1 = null;
        for(Employee employee: list){
            System.out.println(employee.getFirstName()+" "+employee.getLastName());
        }

    }
}

class Employee{
    private String firstName;
    private String lastName;
    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
