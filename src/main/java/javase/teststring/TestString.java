package javase.teststring;

import java.util.List;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/27 10:07
 * @update: 2022/9/27 10:07
 */
public class TestString {
    public static void main(String[] args) {
        String fileName = "审批办理意见";
        int suffixIndex = fileName.lastIndexOf(".");
        System.out.println(suffixIndex);
        System.out.println(fileName.substring(0, suffixIndex + 1) ) ;
        System.out.println(fileName.substring(0, suffixIndex + 1));

    }
}
