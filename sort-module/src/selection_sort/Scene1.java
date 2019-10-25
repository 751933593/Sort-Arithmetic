package selection_sort;

/**
 * @program: Sort-Arithmetic
 * @description: 情景一：选择排序
 * @author: liurunze
 * @create: 2019-09-25 15:52
 **/
public class Scene1 {

    /**
     * @param ints 待排序的数组
     * @return
     */
    public int[] selection(int[] ints){
        int len = ints.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (ints[j]<ints[i]){
                    int temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }

        return ints;
    }



}
