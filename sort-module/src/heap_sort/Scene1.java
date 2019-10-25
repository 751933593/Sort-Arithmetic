package heap_sort;

import utils.PrintUtil;

/**
 * @program: Sort-Arithmetic
 * @description: 情景一：堆排序
 * @author: liurunze
 * @create: 2019-09-25 15:52
 **/
public class Scene1 {

    /**
     * @param ints 待排序的数组
     * @return
     */
    public int[] heap(int[] ints){
        int len = ints.length;
        // 对于一个长度为len的数组，共需要对比len-1轮
        for (int i = 0; i < len-1; i++) {
            // 最大堆：每一趟找出最大的值
            for (int j=len-1-i; j>0; j=j-2){
                int subMax;
                if (j==(len-1-i)&&(len-i)%2==0){
                    subMax = j;
                } else {
                    subMax = ints[j] > ints[j-1] ? j : j-1;
                }

                if (ints[subMax] > ints[(j-1)/2]){
                    int temp = ints[subMax];
                    ints[subMax] = ints[(j-1)/2];
                    ints[(j-1)/2] = temp;
                }

            }
            // 将放在堆顶最大值换到后面
            int temp = ints[len-1-i];
            ints[len-1-i] = ints[0];
            ints[0] = temp;
            PrintUtil.forEach(ints);
        }

        return ints;
    }



}
