package functionalInterface;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * @Title: new-feature-test
 * @Package functionalInterface
 * @Description:
 * @author: 80002748
 * @date 2018/8/20 14:57
 */
public class TestFunctionalInterface {

    public static void main(String[]args){

        /**
         * 常见的函数式接口有：
             java.lang.Runnable
             java.util.concurrent.Callable
             java.util.Comparator
             java.util.function.* (java8 新增)

         *  函数式接口中定义的抽象方法用来接收lambda表达式,当再次调用接口的该方法时，实际执行的是lambda表达式的逻辑

            java.util.function包中引入了多个函数式接口,包括如下：
             Function<T, R>：将 T 作为输入，返回 R 作为输出，他还包含了和其他函数组合的默认方法。
             Predicate<T> ：将 T 作为输入，返回一个布尔值作为输出，该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（与、或、非）。
             Consumer<T> ：将 T 作为输入，不返回任何内容，表示在单个参数上的操作。
         *
         */

        // 找出list中所有的 张姓 同学
        List<String> demoList = Arrays.asList("张小明", "赵十八", "谢阿三", "陈小花", "王小七","张聪明","郭大路");
        checkName(demoList,(e -> {return e.startsWith("张");}),e->{
            System.out.println(e);
        });

        System.out.println("***************************");
        checkName(demoList,e->e.startsWith("张"));

    }




    // 使用自定义函数式接口
    public static void checkName(List<String> nl,CheckFamilyName cfn,PrintName p){
        for(String name:nl){
            if(cfn.checkFN(name)){
                p.print(name);
            }
        }
    }
    // 使用java.util.function.Predicate
    public static void checkName(List<String> nl, Predicate<String> p){
        for(String name:nl){
            if(p.test(name)){
                System.out.println(name);
            }
        }
    }
}
