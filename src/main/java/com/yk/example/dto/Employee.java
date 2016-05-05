package com.yk.example.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


/**
 * Created by yk on 16/4/29.
 */
public class Employee {

    private Date hireDay;

    private String name;

    private double salary;

    public Employee() {
    }

    public Employee(Date hireDay, String name, double salary) {
        this.hireDay = hireDay;
        this.name = name;
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        //优化语句,计算这个等式比 对比一个一个对象的的属性付出的代价要小的多
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return this.hireDay.equals(other.hireDay) && this.name.equals(other.name) && this.salary == other.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hireDay, this.name, this.salary);
    }

    public void update(ArrayList list) {

    }

    public ArrayList find(String query) {
        return new ArrayList();
    }

    public String testLong(final String s) {
        return s;
    }

 /*   public static void main(String[] args) {
        Employee harry = new Employee(new Date(), "", 1000.00);
        Date d = harry.getHireDay();
        double tenYearsInMilliSeconds = 10 * 365 * 24 * 60 * 60 * 1000;
        d.setTime(d.getTime() - (long) tenYearsInMilliSeconds);

        harry.update(new ArrayList<Employee>());
        @SuppressWarnings("unchecked")
        ArrayList<Employee> arrayList = (ArrayList<Employee>) harry.find("");

        String s = "111";
        s = harry.testLong(s);
        System.out.println(s);


    }*/

}
