package java8;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * 一、方法引用：若Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 *          （可以理解为方法引用是Lambda表达式的另一种表现形式）
 * 主要有三种语法格式
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * 注意：
 *     1.Lambda体中调用方法的参数列表雨返回值类型相同，要与函数式接口中抽象方法的函数列表和返回值保持一致！
 *     2.若Lambda 参数列表中的第一参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 * 二、构造器引用：
 * 格式：
 * ClassName::new
 * 注意：需要需要调用的函数构造器要与函数式接口中的抽象方法的参数列表保持一致！
 * 三、数组引用
 * Type::new
 *
 */
public class TestMethodRef {
    @Test
    public void test1(){
        Consumer<String> con = (x)-> System.out.println(x);
        PrintStream ps = System.out;
        Consumer<String> con1=ps::println;
        Consumer<String> con2=System.out::println;
        List<String> stringList= Arrays.asList("1","2");
        stringList.forEach((s -> {
            System.out.println(s);
        }));

    }
    //对象::实例方法名
    @Test
    public void test2(){
        Employee emp=new Employee();
        Supplier<String>p=() ->emp.getName();

        Supplier<Integer> p2 =emp::getAge;
        System.out.println(p2.get());
    }
    //类::静态方法名
    @Test
    public void test3(){

        Comparator<Integer> com =(x,y) -> Integer.compare(x,y);
        Comparator<Integer> com2=Integer::compare;
    }
    //类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> bp=(x,y) ->x.equals(y);
        BiPredicate<String,String> bp2=String::equals;
    }
    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup=() -> new Employee();
        Supplier<Employee> sup2=Employee::new;
        System.out.println(sup2.get());
    }
    @Test
    public void test6(){
        Function<Integer,Employee> fun=(x) -> new Employee(x);
        Function<Integer,Employee> fun2=Employee::new;
        System.out.println(fun2.apply(10));
        BiFunction<String,Integer,Employee> bf=Employee::new;
    }
    @Test
    public void test7(){
        Function<Integer,String[]> fun=(x) -> new String[x];
        String[] strs=fun.apply(10);
        System.out.println(strs.length);
        Function<Integer,String[]> fun2=String[]::new;
        String[] strs2=fun.apply(20);
        System.out.println(strs2.length);
    }
}
