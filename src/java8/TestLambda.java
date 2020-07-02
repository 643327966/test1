package java8;

import java.util.*;

public class TestLambda {
    public static void main(String[] args) {
        TestLambda testLambda=new TestLambda();
        testLambda.test5();

    }
    public void test1(){
        Comparator<Integer> com =new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }

        };
        TreeSet<Integer> ts =new TreeSet<>(com);

    }
    public void test2(){
        Comparator<Integer> com =(x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts =new TreeSet<>(com);
    }
    List<Employee> employeelist= Arrays.asList(
            new Employee("张三",10,9999),
            new Employee("张四",38,8888),
            new Employee("张五",46,7777),
            new Employee("张六",26,6666)
    );
    public List<Employee> filterEmployee(List<Employee> elist, Mypredicate<Employee> mtemployee){
        List<Employee> emp=new ArrayList<>();
        for (Employee e:elist){
            if (mtemployee.test(e)){
                emp.add(e);
            }
        }
        return emp;
    }
    public void test3(){
        List<Employee> list=filterEmployee(employeelist, new Mypredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary()<=8000;
            }
        });
        for (Employee e: list){
            System.out.println(e);
        }
    }
    //lambda
    public void test4(){
        List<Employee> list =filterEmployee(employeelist,(e) -> e.getSalary() <=8000);
        list.forEach(System.out::println);
    }
    //stream
    public void test5(){
        employeelist.stream()
                .filter((e) -> e.getSalary() >= 8000)
                .limit(1)
                .forEach(System.out::println);
        employeelist.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
