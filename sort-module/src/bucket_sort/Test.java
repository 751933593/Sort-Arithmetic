package bucket_sort;

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
        int[] ints = {0,5,3,4,4,4, 2, 1,10};
        int[] int2 = {0,5,3,4, 2, 1,10};
        int[] ints3 = {1,2,3, 4, 5,10,0};

        // 1.桶排序
        System.out.println("1.堆排序");
        Scene1 scene1 = new Scene1();
        PrintUtil.forEach(scene1.bucketSort(ints));



    }

}
