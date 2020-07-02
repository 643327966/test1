package java8;

@FunctionalInterface
public interface Mypredicate<T> {

    public boolean test(T t);
}
