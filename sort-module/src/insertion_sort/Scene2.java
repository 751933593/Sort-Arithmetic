package insertion_sort;

import utils.PrintUtil;

/**
 * @program: Sort-Arithmetic
 * @description: 折半插入排序
 * 鉴于有序区已经有序这一特性，我们可以通过使用折半（二分）查找，
 * 快速找到要插入的位置，然后移动该位置以后的所有记录，
 * 将当前记录插入到目标位置
 * @author: liurunze
 * @create: 2019-09-26 11:32
 **/
public class Scene2 {

    public int[] insertion(int[] ints){

        int len = ints.length;

        int[] res = new int[len];

        for (int i=0; i<len; i++){
            if (i==0){
                res[0] = ints[i];
                continue;
            }

            int low = 0;
            int height = i - 1;

            while (low <= height){

                int mid = (low + height)/2;
                if (res[mid]>=ints[i]){
                    height = mid - 1;
                }
                if (res[mid]<ints[i]){
                    low = mid + 1;
                }
            }
            for (int j=i; j>height+1; j--){

                res[j] = res[j-1];
            }
            res[height+1] = ints[i];
            PrintUtil.forEach(res);
        }

        return res;
    }
}
