### 插入排序

#### 基本思想

>  把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程

- 代码实现

  ```java
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
  ```

#### 优化1：折半插入

- 优化思想：鉴于有序区已经有序这一特性，我们可以通过使用折半（二分）查找，快速找到要插入的位置，然后移动该位置以后的所有记录，将当前记录插入到目标位置

- 代码实现

  ```java
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
          }
          return res;
      }
  ```

#### 总结

- 由于插入排序思想的原因，该算法的空间复杂度为O(N)
- 直接插入排序时间复杂度为O(N²)
- 折半插入排序时间复杂度为O(N*logN)