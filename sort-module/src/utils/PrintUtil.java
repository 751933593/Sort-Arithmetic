package utils;

/**
 * @program: Sort-Arithmetic
 * @description: 控制台遍历打印int型数组工具类
 * @author: liurunze
 * @create: 2019-09-25 16:50
 **/
public class PrintUtil {

    public static void forEach(int[] ints){
        for (int anInt : ints) {
            System.out.print(anInt+"\t");
        }
        System.out.println();
    }
}
