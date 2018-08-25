package others;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @Title: new-feature-test
 * @Package others
 * @Description:
 * @author: 80002748
 * @date 2018/8/18 11:29
 */
public class TestOthers {

    public static void main(String[]args){

        // String join静态方法 相当于String 实例方法的 split()方法的逆操作
        String url = String.join(".","www","baidu","com");
        System.out.println(url); // www.baidu.com

        String emailAddr = String.join(".",String.join("@","zhangsan","SF-Express"),"com");
        System.out.println(emailAddr); // zhangsan@SF-Express.com

        // 考虑使用 Stream.reduce 方法将list中的字符串添加换行符并拼装成一个 String
        List<String> strList  = Arrays.asList(new String[] {"小明来自内蒙古","他不会骑马","也不会喝酒"});
        String threeLines = strList.stream().reduce((a,b)->String.join("\n",a,b)).get();
        System.out.println(threeLines);     // 打印字符串 "小明来自内蒙古\n他不会骑马\n也不会喝酒"


        // Base64
        Base64.Encoder encoder = Base64.getEncoder();
        String text = "zhangsan@SF-Express.com";
        byte[] textBytes = text.getBytes();
        byte[] encodedBytes = encoder.encode(textBytes);
        System.out.println(encoder.encodeToString(encodedBytes));


    }



}
