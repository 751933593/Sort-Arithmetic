package shell_sort;

/**
 * @program: Sort-Arithmetic
 * @description: 情景一：希尔排序
 * @author: liurunze
 * @create: 2019-09-25 15:52
 **/
public class Scene1 {

    public void groupSort(int a[], int n, int i,int gap){

        int j;

        for (j = i + gap; j < n; j += gap){

            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (a[j] < a[j - gap]){
                int tmp = a[j];
                int k = j - gap;
                while (k >= 0 && a[k] > tmp){
                    a[k + gap] = a[k];
                    k -= gap;
                }
                a[k + gap] = tmp;
            }
        }
    }


    public void shellSort(int a[], int n){

        int i,gap;

        // gap为步长，每次减为原来的一半。
        for (gap = n / 2; gap > 0; gap /= 2){
            // 共gap个组，对每一组都执行直接插入排序
            for (i = 0 ;i < gap; i++){
                groupSort(a, n, i, gap);
            }

        }
    }




}
