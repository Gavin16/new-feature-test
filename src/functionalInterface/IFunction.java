package functionalInterface;

/**
 * @Title: new-feature-test
 * @Package functionalInterface
 * @Description:
 * @author: 80002748
 * @date 2018/8/20 15:02
 */
@FunctionalInterface
public interface IFunction {
    /**
     * 注解要求接口有且仅有一个抽象方法,可以有default方法
     * 可以有Object 中的public的抽象方法
     *
     * "@FunctionalInterface"这个注解是非必须的
     * 如果接口定义前并没有使用 FunctionalInterface 注解, 虚拟机会自动判断接口是否是函数式接口
     *
     */
    void run();


//    void hello();

    /**
     * 默认方法返回接口名
     */
    default String getInterfaceName(){
        return "IFunction";
    }

    static void saySomeThing(){
        System.out.println("less is more");
    }
}
