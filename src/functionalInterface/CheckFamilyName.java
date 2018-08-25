package functionalInterface;

/**
 * @Title: new-feature-test
 * @Package functionalInterface
 * @Description:
 * @author: 80002748
 * @date 2018/8/20 16:17
 */
@FunctionalInterface
interface CheckFamilyName<T extends  String> {
    boolean checkFN(T t);
}
