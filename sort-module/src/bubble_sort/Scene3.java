package bubble_sort;

/**
 * @program: Sort-Arithmetic
 * @description: 情景一：改进后的冒泡（如果一组数据，前面都已经排好序，
 *      只是最后一个是该数组的最小值，这种情况，使用优化1和传统的并无差别。
 *      针对这种情况，我们可以正向冒泡和反向冒泡交替执行，
 *      如果提前知道这些数组的大小位置规律，还可以设置正向冒泡和反向冒泡的权重。
 *      本次代码演示的是交替执行。）
 * @author: liurunze
 * @create: 2019-09-25 15:52
 **/
public class Scene3 {

    /**
     * @param ints 待排序的数组
     * @return
     */
    public int[] bubble(int[] ints){

        int len = ints.length;
        boolean turn = false;
        for ( int l=0,r=len-1; l<r; ) {

            boolean flag = true;

            for (int i=l;i<r;i++){

                // 正向反向交替
                if (turn){
                    // 反向 l++
                    if (ints[r-i]<ints[r-i-1]){
                        // swap
                        ints[r-i] = ints[r-i-1] + ints[r-i];
                        ints[r-i-1] = ints[r-i] - ints[r-i-1];
                        ints[r-i] = ints[r-i] - ints[r-i-1];
                        flag = false;
                    }
                } else {
                    // 正向 r--
                    if (ints[i]>ints[i+1]){
                        // swap
                        ints[i] = ints[i+1] + ints[i];
                        ints[i+1] = ints[i] - ints[i+1];
                        ints[i] = ints[i] - ints[i+1];
                        flag = false;
                    }
                }

            }
            if (flag) {
                break;
            }
            if (turn) {
                l++;
                turn = false;
            } else {
                r--;
                turn = true;
            }

        }

        return ints;
    }



}
