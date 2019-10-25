### 归并排序

#### 基本思想

>  将两个的有序数列合并成一个有序数列，我们称之为"**归并**"。
>
>  将待排序的数列分成若干个长度为1的子数列，然后将这些数列两两合并；得到若干个长度为2的有序数列，再将这些数列两两合并；得到若干个长度为4的有序数列，再将它们两两合并；直接合并成一个数列为止。这样就得到了我们想要的排序结果。(参考下面的图片)

- 代码实现

  ```java
  	public void mergeSort(int a[], int start, int end){
  
          if(a.length==0 || start >= end){
              return ;
          }
  
          int mid = (end + start)/2;
          mergeSort(a, start, mid); // 递归排序a[start...mid]
          mergeSort(a, mid+1, end); // 递归排序a[mid+1...end]
  
          // a[start...mid] 和 a[mid...end]是两个有序空间，
          // 将它们排序成一个有序空间a[start...end]
          merge(a, start, mid, end);
      }
  
      /*
       * 将一个数组中的两个相邻有序区间合并成一个
       */
      public void merge(int a[], int start, int mid, int end){
  
          int[] tmp = new int[end-start+1];    // tmp是汇总2个有序区的临时区域
          int i = start;            // 第1个有序区的索引
          int j = mid + 1;        // 第2个有序区的索引
          int k = 0;                // 临时区域的索引
  
          while(i <= mid && j <= end){
              if (a[i] <= a[j]){
                  tmp[k++] = a[i++];
              }else {
                  tmp[k++] = a[j++];
              }
          }
  
          while(i <= mid){
              tmp[k++] = a[i++];
          }
  
          while(j <= end){
              tmp[k++] = a[j++];
          }
  
          // 将排序后的元素，全部都整合到数组a中。
          for (i = 0; i < k; i++){
              a[start + i] = tmp[i];
          }
  
      }
  ```

#### 总结

- 归并排序的形式就是一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的可以得出它的时间复杂度是O(N*lgN)