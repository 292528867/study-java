package com.yk.example.dto;

import java.util.*;


/**
 * Created by yk on 16/4/29.
 */
public class Employee implements Cloneable {

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

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
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

/*    public static void main(String[] args) throws Exception {
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


//        Employee test = harry;   //改变test属性的值 harry也改变
        Employee test = harry.clone(); //改变test属性的值 harry没有改变 克隆需要实现cloneable接口 调用object类的clone方法
        test.setSalary(100);
        System.out.println("test的salary的值:" + test.getSalary() + "--------harry的值:" + harry.getSalary());

        List<String> list = new LinkedList<String>();
        list.add("1111");
        list.add("2222");
        Iterator iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        //数集
        SortedSet<String> sortedSet = new TreeSet<String>();
        sortedSet.add("bbbbbX");
        sortedSet.add("abbbX");
        sortedSet.add("babbbX");
        for (String s1 : sortedSet) {
            System.out.println(s1);
        }
        //优先级队列
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                double v = o1.getSalary() - o2.getSalary();
                if (v > 0) { //o1<o2
                    return 1;
                } else if (v == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        PriorityQueue<Employee> priorityQueue = new PriorityQueue<Employee>(comparator);
        priorityQueue.add(new Employee("1111", 1000.00));
        priorityQueue.add(new Employee("222", 200.00));
        priorityQueue.add(new Employee("333", 5000.00));
        System.out.println(priorityQueue.poll().getName());

        //映射表 hashmap treemap
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("111", "test11");
        map.put("222", "test22");
        map.put("333", "test33");
       *//* Set<String> keySet = map.keySet();
        for (String s2 : keySet) {
            System.out.println(map.get(s2));
        }*//*
        //查看所有的key value
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        //集合的交集
        Set<String> result = new HashSet<String>(list);
        List<String> list1 = new ArrayList<String>();
        list1.add("1111");
        result.retainAll(list1);
        for (String s2 : result) {
            System.out.println(s2);
        }

    }*/


    public class EmployeeTest {
        String nameTest;
        String age;

        public void test() {
            System.out.println(Employee.this.name);
        }

        public String getNameTest() {
            return nameTest;
        }

        public void setNameTest(String nameTest) {
            this.nameTest = nameTest;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
