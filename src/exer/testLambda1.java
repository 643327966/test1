package exer;

import java8.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class testLambda1 {
    int aa=0;
    List<Employee> employeelist= Arrays.asList(
            new Employee("张三",10,9999),
            new Employee("张四",38,8888),
            new Employee("张五",17,7777),
            new Employee("张六",26,6666),
            new Employee("张五",30,6666)
    );
    @Test
    public void test1(){

        Collections.sort(employeelist,(e1,e2) -> {
            System.out.println(++aa);
            if(e1.getAge() ==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        employeelist.forEach(System.out::println);
    }
    @Test
    public void test2(){
        String aa=strHandler("\t\t\t hello  ",(str) ->str.trim());
        System.out.println(aa);
        String bb=strHandler("abcd",(str) ->str.toUpperCase());
        System.out.println(bb);
    }
    //需求用于处理字符串
    public String strHandler(String str, MyFunction myFunction){
        return myFunction.getValue(str);
    }
}
