package stream;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title: new-feature-test
 * @Package stream
 * @Description:
 * @author: 80002748
 * @date 2018/8/18 15:04
 */
public class TestStream {

    public static void main(String[] args) {
        /**
         *  使用Stream对集合进行遍历
         *  事实上只要 实现了 Collection接口 都可以获取流进行操作
         *
         *  Stream 的生成：
         *  Stream没有限定数据源
         *  因此Stream 可以有以下多种生成方式
         *      Collection.stream()
         *      Stream.of("a","b","c")
         *      Arrays.stream(T array)
         *      Random.ints()
         *
         *
         *  Stream 的操作：
         *      Stream 的操作分中间操作和终结操作
         *          中间操作： map/filter
         *
         *          终结操作：reduce,collect,sum等
         *
         *
         *  注意：
         *  使用Stream 的注意事项 Stream只能用一次，像如下使用方式不能正常工作
         *
         *  Stream stream = Stream.of(new String[] {1, 2, 3});
         *  stream.reduce((a,b)->a+b).get();
         *
         */
        String[] strArr = {"Java8", "new", "feature", "Stream", "API"};
        List<String> strList = Arrays.asList(strArr);


        /**
         *  对List的处理
         *  stream.
         *         filter
         *         map
         *         reduce
         *         collect
         */

        // filter: 筛选出长度大于3的字符串
        strList = strList.stream().filter(e -> (e.length() > 3)).collect(Collectors.toList());
        System.out.println(strList.toString()); //[Java8, feature, Stream]

        // map: 对元素做一一映射处理
        strList = strList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(strList);            // [JAVA8, FEATURE, STREAM]

        List<String> strWithStar = strList.stream().map(e -> ("*" + e)).collect(Collectors.toList());
        System.out.println(strWithStar);        // [*JAVA8, *FEATURE, *STREAM]

        List<Double> doubleListT = genRandomNums(10);
        List<Double> doubleListF = doubleListT.stream().map(t -> (9/5)*t + 32).collect(Collectors.toList());
        DecimalFormat df = new DecimalFormat("#.00");//控制精度
        System.out.println(doubleListF.stream().map(e -> df.format(e)).collect(Collectors.toList()));

        // reduce: 对集合所有元素做 reduce操作, 最终得到一个元素
        // 常见的 sum, min, max 函数都可以使用reduce 来实现
        Integer[] intArray = new Integer[]{1,2,3,4,5,6,7,8,9};
        int sum = Stream.of(intArray).reduce(Integer::min).get();
        int sum2 = Stream.of(intArray).reduce((a,b) -> a+b).get();
        int sum3 = Stream.of(intArray).filter(n -> n < 5).mapToInt(e -> e*e).sum();
        
        System.out.println("sum:"+sum+" sum2:"+sum2+" sum3:"+sum3);

    }

    // 产生一组随机数
    public  static List<Double> genRandomNums(int len) {
        List<Double> intList = new ArrayList<>();
        for (int i = 0; i < len;i++ ) {
            intList.add(Math.abs((new Random().nextDouble()) * 40));
        }
        return intList;
    }
}
