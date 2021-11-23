package extendedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExtendedList<T> extends ArrayList<T> {

    public static void main(String[] args) {

        ExtendedList<Integer> extendedList = new ExtendedList<>();
        List<Integer> integers = List.of(1, 5, 7, 9, 5);

        List<Integer> map1 = extendedList.map(integers, (Integer i) -> i * i);
        System.out.println(map1);
        extendedList.fill(100, () -> new Random().nextInt());
        for (Integer i : integers) {
            boolean all = extendedList.forAll(integers, (in) -> (i % 2 == 1));
            System.out.println(all);
        }
        Integer sum = extendedList.reduce(1, integers, (a, b) -> a + b);
        System.out.println(sum);

    }

    public <R> List<R> map(List<T> tList, Function<T, R> function) {
        List<R> list = new ArrayList<>();

        for (T currentElement : tList) {
            list.add(function.apply(currentElement));
        }
        return list;

    }

    public void fill(int size, Supplier<T> supplier) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            list.add((T) supplier);
        }

    }

    public boolean forAll(List<T> list, Predicate<T> predicate) {

        for (T current : list) {
            boolean test = predicate.test(current);
            if (test) {
                return true;
            }
        }
        return false;
    }

    public List<T>[] partition(List<T> list1, List<T> list2, Predicate<T> predicate) {
        List[] lists = null;
        for (T curr1 : list1) {
            for (T curr2 : list2) {
                boolean test1 = predicate.test(curr1);
                boolean test2 = predicate.test(curr2);
                if (test1 && !test2 || !test1 && test2) {
                    return lists = new List[]{list1, list2};

                }
            }
        }
        return lists;
    }

    public T reduce(T t, List<T> list, BinaryOperator<T> binaryOperator) {
        for (T currentElement : list) {
            t = binaryOperator.apply(t, currentElement);
        }
        return t;
    }


}
