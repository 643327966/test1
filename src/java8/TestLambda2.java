package java8;

import java8.MyFun;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 一、Lambda 表达式的基础语法：java8中引入的新的操作符“-？” 该操作符从未箭头操作符活Lambda操作符
 *                      箭头操作符讲lambda 表达式拆分两部分：
 * 左侧: Lambda 表达式参数列表
 * 右侧：Lambda 表达式中所需执行的功能，即Lambda体
 *
 * 语法格式1：无参数，无返回值
 *      () -> System.out.println("hello lambda");
 * 语法格式2：有一个参数，并无返回值
 *      (x) -> System.out.println(x);
 * 语法格式3：若只有一个参数，小括号可以不写
 * 语法格式4：有两个以上的参数，有返回值，并且lambda体重有多条语句
 *          Comparator<Integer> com=(x,y) -> {
 *             System.out.println("hello");
 *             return Integer.compare(x,y);
 *         };
 *  语法格式5：若lambda 体重只有一条语句，return和大括号都可以不写
 *  语法格式6：lambda 表达式的参数列表的数据类型可以省略不写，因为jvm编译器通过上下文提短处，数据类型，即“类型中断”
 *          Comparator<Integer> com=(Integer x,Integer y) -> Integer.compare(x,y);
 *  左右遇1括号省
 *  左侧推断类型省
 *  右侧只有一行 大括号和return也可省
 *  二、lambda 表达式需要“函数式接口”的支持
 *  函数式接口：接口中只有一个抽象方法的接口，被称为函数式接口。可以使用注解@FunctionalInterface 修饰
 *            可以检测是否是函数式接口
 *            @FunctionalInterface 只能有一个抽象方法
 */
public class TestLambda2 {

    @Test
    public void test1(){
        int num =0; //jdk1.7前 必须是final
        Runnable r =new Runnable() {
            @Override
            public void run() {
                System.out.println("hello"+num);
            }
        };
        r.run();
        //num++;
        System.out.println("===========");
        Runnable r1=() -> System.out.println("hello"+num);
        r1.run();
    }
    @Test
    public void test2(){
        Consumer<String> consumer= x -> System.out.println(x);
        consumer.accept("hello jdk8");
    }
    @Test
    public void test3(){
        Comparator<Integer> com=(x,y) -> {
            System.out.println("hello");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
        Comparator<Integer> com=(Integer x,Integer y) -> Integer.compare(x,y);
    }
    @Test
    public void test5(){
        List<String> list=new ArrayList<>();//类型推断
        show(new HashMap<>());
    }
    public void show(Map<String,Integer> map){

    }
    //需求：对一个数进行运算
    @Test
    public void test6(){
        Integer num=operation(100,(x) -> x*x);
        System.out.println(num);
        System.out.println(operation(200,(y) -> y+30));
    }
    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }

}
