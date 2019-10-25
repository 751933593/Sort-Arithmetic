package bubble_sort;

import utils.PrintUtil;

/**
 * @program: Sort-Arithmetic
 * @description: 测试类
 * @author: liurunze
 * @create: 2019-09-25 16:47
 **/
public class Test {



    public static void main(String[] args) {

        // 测试数据
        int[] ints = {0,5,3,4, 2, 1,10};
        int[] int2 = {0,5,3,4, 2, 1,10};
        int[] ints3 = {1,2,3, 4, 5,10,0};

        // 1.传统冒泡
        System.out.println("1.传统冒泡");
        Scene1 scene1 = new Scene1();
        int[] res_ints = scene1.bubble(ints);
        PrintUtil.forEach(res_ints);

        // 2.改进后的冒泡
        System.out.println("2.改进后的冒泡");
        Scene2 scene2 = new Scene2();
        int[] res_int2 = scene2.bubble(int2);
        PrintUtil.forEach(res_int2);

        // 3.改进后的冒泡
        System.out.println("3.改进后的冒泡,交替冒泡");
        Scene3 scene3 = new Scene3();
        int[] res_ints3 = scene3.bubble(ints3);
        PrintUtil.forEach(res_ints3);


    }

}
