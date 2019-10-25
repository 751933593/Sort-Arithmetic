package bucket_sort;

/**
 * @program: Sort-Arithmetic
 * @description: 情景一：桶排序
 * @author: liurunze
 * @create: 2019-09-25 15:52
 **/
public class Scene1 {

    /**
     * @param ints 待排序的数组
     * @return
     */
    public int[] bucketSort(int[] ints){

        int len = ints.length;

        //创建一个桶
        int[] bucket = new int[100];

        //根据待排序的数组向桶中放值
        for (int i=0;i<len;i++){
            bucket[ints[i]] = bucket[ints[i]]+1;
        }

        //从桶中按顺序取值
        int index = 0;
        for (int i=0;i<bucket.length;i++){
            for (int j=0;j<bucket[i];j++){
                ints[index] = i;
                index++;
            }
        }

        return ints;
    }



}
