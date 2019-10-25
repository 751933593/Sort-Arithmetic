package insertion_sort;

import utils.PrintUtil;

/**
 * @program: Sort-Arithmetic
 * @description:
 * @author: liurunze
 * @create: 2019-09-26 11:31
 **/
public class Test {

    public static void main(String[] args) {

        // 测试数据
        int[] ints = {5,3,4, 2, 1};
        int[] ints2 = {6,1,2,1,5};

        // 直接插入排序
        System.out.println("1.直接插入排序");
        Scene1 scene1 = new Scene1();
        int[] res_ints = scene1.insertion(ints);
        PrintUtil.forEach(res_ints);

        // 折半插入排序
        System.out.println("2.折半插入排序");
        Scene2 scene2 = new Scene2();
        int[] res_ints2 = scene2.insertion(ints2);
        //PrintUtil.forEach(res_ints2);
    }


}
