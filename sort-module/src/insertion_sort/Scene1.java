package insertion_sort;

/**
 * @program: Sort-Arithmetic
 * @description: 直接插入排序
 * 把n个待排序的元素看成为一个有序表和一个无序表。
 * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，
 * 将它插入到有序表中的适当位置，使之成为新的有序表，
 * 重复n-1次可完成排序过程
 * @author: liurunze
 * @create: 2019-09-26 11:32
 **/
public class Scene1 {

    public int[] insertion(int[] ints){

        int len = ints.length;

        int[] res = new int[len];

        for (int i=0; i<len; i++){
            if (i==0){
                res[0] = ints[i];
                continue;
            }
            int curr = ints[i];
            for (int j=0; j<i; j++){
                Integer temp = null;
                if (curr<res[j]){
                    temp = res[j];
                    res[j] = curr;
                    curr = temp;
                }
                if (j==i-1){
                    res[i] = curr;
                }
            }
        }

        return res;
    }
}
