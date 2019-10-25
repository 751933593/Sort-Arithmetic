### 选择排序

#### 基本思想

>  首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

- 代码实现

  ```java
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
  ```

#### 总结

- 由于选择排序思想的原因，该算法的时间复杂度为O(N²)