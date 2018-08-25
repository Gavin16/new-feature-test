package lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title: new-feature-test
 * @Package lambda
 * @Description:
 * @author: 80002748
 * @date 2018/8/20 10:45
 */
public class TestLambda {

    public static void main(String[]args){

        /**
         *
         *  一般的 lambda 表达式有两种使用形式：
         *      (1) (parameters) -> expression 形式：
         *                  其中的‘->‘ 为lambda表达式的符号， 符号前为输入参数，符号后相当于方法体(可以是表达式或者代码块)
         *      (2)  Object::methodName 形式:
         *                  这种形式的lambda表达式也称方法引用; 其中 '::'(双冒号)为方法引用的, 方法引用一般是用在 返回值只需要传入参数Object调用一个方法就能得到的情况
         *
         */
        // lambda表达式的赋给Function 然后再使用 Function instance .apply() 方法调用
        Function<Integer,String> int2str = String::valueOf;
        Function<List<Integer>,Integer> sumup = (List<Integer> iList) -> {Integer s = 0;for(Integer i:iList){ s+=i;} return s; };

        List<String> strList = Arrays.asList(new String[]{"Lambdas", "Default Method", "Stream API", "Java"});
        Predicate<List<String>> pred = (List<String> inList) -> inList.contains("Java");

        Consumer<List<String>> printLen = (List<String> inList) -> {for(String str:strList){System.out.println(str.length());}} ;
        printLen.accept(strList);

        System.out.println("字符串list中是否包含Java字样:" + pred.test(strList));

        //
        Integer num1 = 12345;
        List<Integer> nList = Arrays.asList(new Integer[] {3,2,1,9,10,6,7,8,4,5});
        //
        System.out.println("result:" + int2str.apply(num1) +" " +(int2str.apply(num1) instanceof String) );
        System.out.println(sumup.apply(nList));


        /**
         * lamdba 表达式作为一种匿名函数, 更多的是用作为方法的传参,用来简化书写和提高代码可读性，
         *      这种书写的简洁性可以表现在：
         *             (1) 要实现某个功能时不需要专门去写一个方法
         *             (2) 代码书写更简短紧凑
         *             (3) 配合流处理可以让集合的较大批量的处理一行代码就完成
         */

        // lambda 表达式做匿名函数使用
        Runnable r0 = new Runnable() {
            @Override
            public void run() {
                func();
            }
            private void func(){
                System.out.println("this is runnable-0");
            }
        };
        Thread t = new Thread(r0);
        t.start();

        Runnable r2 = ()->{
            System.out.println("this is Runnable-2 ");
        };

        new Thread(r2).start();
        new Thread(()->{System.out.println("this is Thread-3");}).start();


        // 做函数传参
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        String[] features2 =  {"Lambdas", "Default Method", "Stream API", "Date and Time API"};
//        features.forEach(System.out::println);
//        features.forEach(e -> System.out.println(e));

        Arrays.sort(features2,(str1,str2)-> str1.compareToIgnoreCase(str2));
        Arrays.asList(features2).forEach(e -> System.out.println(e));

        // 用list中的map排序,
        List<Map<String,String>> mapList1 = new ArrayList<>();

        HashMap<String,String> m1 = new HashMap<>();
        HashMap<String,String> m2 = new HashMap<>();
        HashMap<String,String> m3 = new HashMap<>();

        m1.put("code","SZ");
        m2.put("code","GZ");
        m3.put("code","GD");

        mapList1.add(m1);
        mapList1.add(m2);
        mapList1.add(m3);

        System.out.println(mapList1.toString());
        mapList1.sort(Comparator.comparing(t1 -> t1.get("code")));
        System.out.println(mapList1.toString());

        /**
         * 其他函数式接口
         */
        ToIntFunction<List<String>> countElem = (List<String> strList1) -> {return strList1.size();};
        System.out.println("total elements: "+countElem.applyAsInt(strList));
    }


}
