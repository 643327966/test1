package java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    public void test2(){
        getNumList(10,() -> (int)Math.random()*100);
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
}
