package interfaceEnhance;

/**
 * @Title: new-feature-test
 * @Package interfaceEnhance
 * @Description:
 * @author: 80002748
 * @date 2018/8/20 14:41
 */
interface TestNewInterface {

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
