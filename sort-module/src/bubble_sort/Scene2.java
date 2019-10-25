package bubble_sort;

/**
 * @program: Sort-Arithmetic
 * @description: 情景一：改进后的冒泡（如果在某次遍历时发现未发生过遍历，则该数组已排序完成）
 * @author: liurunze
 * @create: 2019-09-25 15:52
 **/
public class Scene2 {

    /**
     * @param ints 待排序的数组
     * @return
     */
    public int[] bubble(int[] ints){
        int len = ints.length;
        // 对于一个长度为len的数组，共需要对比len-1轮
        for (int i=len-1; i>0; i--) {

            boolean flag = true;

            // 第一次需要对比len-1次
            for ( int j=0; j<i; j++) {
                if (ints[j]>ints[j+1]){
                    // swap
                    ints[j] = ints[j+1] + ints[j];
                    ints[j+1] = ints[j] - ints[j+1];
                    ints[j] = ints[j] - ints[j+1];
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return ints;
    }



}
