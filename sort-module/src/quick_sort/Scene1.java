package quick_sort;

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
    public int[] quick(int[] ints){
        int len = ints.length;

        quick(0,len-1,ints);

        return ints;
    }

    public void  quick(int begin, int end, int[] ints){

        int intsBegin = begin;
        int intsEnd = end;
        // 把第一个数当做基数
        int base = ints[begin];
        int finalIndex = begin;

        // false：从后往前；true：从前往后
        boolean flag = false;

        while (begin < end) {
            if (!flag){
                if (base > ints[end]){
                    ints[begin] = ints[end];
                    finalIndex = end;
                    flag = true;
                    continue;
                }
                end--;
            } else {
                if (base < ints[begin]){
                    ints[end] = ints[begin];
                    finalIndex = begin;
                    flag = false;
                    continue;
                }
                begin++;
            }
        }

        ints[finalIndex] = base;

        if ((finalIndex-intsBegin)>1){
            quick(intsBegin,finalIndex-1,ints);
        }
        if ((intsEnd-finalIndex)>1){
            quick(finalIndex+1,intsEnd,ints);
        }
    }



}
