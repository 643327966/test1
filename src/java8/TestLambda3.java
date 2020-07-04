package java8;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8内置四大核心函数式接口
 *      Consumer<T> : 消费性接口
 *          void accept(T t);
 *      Supplier<T> : 供给型接口
 *          T get();
 *      Function<T,R> : 函数型接口
 *          R apply(T t);
 *      Predicate<T> : 断言型接口
 *          boolean test(T t);
 */
public class TestLambda3 {
    // Consumer<T> : 消费性接口
    @Test
    public void test1(){
        happy(1000,(m) -> System.out.println(m));
        happy(1000, new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }
    public  void happy(double money, Consumer con){
        con.accept(money);
    }
    // Supplier<T> : 供给型接口
    @Test
    public void test2(){
        List<Integer> aa=getNumList(10,() -> (int)(Math.random()*100));
        for(Integer a:aa){
            System.out.println(a);
        }
    }
    //产生一些整数 并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            Integer n=sup.get();
            list.add(n);
        }
        return list;
    }
    //Function<T,R> : 函数型接口
    @Test
    public void test3(){
        String newstr=strHandler("\t  嗷嗷嗷 ",(str) ->str.trim());
        System.out.println(newstr);
    }
    //需求：处理字符串
    public String strHandler(String str,Function<String,String> fun){
        return fun.apply(str);
    }
    //Predicate<T> : 断言型接口
    @Test
    public void test4(){
        List<String> list= Arrays.asList("hello","atguigu","Lambda","ww");
        List<String> strlist=filterStr(list,(t)-> t.length()>3);
        strlist.forEach(System.out::println);
    }
    //需求：满足条件的字符串添加到集合中
    public List<String> filterStr(List<String>list,Predicate<String> pre){
        List<String> strlist=new ArrayList<>();
        for (String str:list){
            if (pre.test(str)){
                strlist.add(str);
            }
        }return strlist;
    }
}
