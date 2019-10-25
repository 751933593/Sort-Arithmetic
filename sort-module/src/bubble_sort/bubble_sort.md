### 冒泡排序

#### 基本思想

>  遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；如果前者比后者大，则交换它们的位置。这样，一次遍历之后，最大的元素就在数列的末尾！
> 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！

- 代码实现

  ```java
  public int[] bubble(int[] ints){
          int len = ints.length;
          // 对于一个长度为len的数组，共需要对比len-1轮
          for (int i=len-1; i>0; i--) {
              // 第一次需要对比len-1次
              for ( int j=0; j<i; j++) {
                  if (ints[j]>ints[j+1]){
                      // swap
                      ints[j] = ints[j+1]+ints[j];
                      ints[j+1] = ints[j]-ints[j+1];
                      ints[j] = ints[j]-ints[j+1];
                  }
              }
          }
          return ints;
      }
  ```

#### 优化1

- 优化思想：如果在某次遍历时发现未发生过遍历，则该数组已排序完成

- 代码实现

  ```java
  public int[] bubble(int[] ints){
          int len = ints.length;
          // 对于一个长度为len的数组，共需要对比len-1轮
          for (int i=len-1; i>0; i--) {
  
              boolean flag = true;
  
              // 第一次需要对比len-1次
              for ( int j=0; j<i; j++) {
                  if (ints[j]>ints[j+1]){
                      // swap
                      ints[j] = ints[j+1]+ints[j];
                      ints[j+1] = ints[j]-ints[j+1];
                      ints[j] = ints[j]-ints[j+1];
                      flag = false;
                  }
              }
  
              if (flag) {
                  break;
              }
          }
          return ints;
      }
  ```

#### 优化2

- 优化思想：如果一组数据，前面都已经排好序，只是最后一个是该数组的最小值，这种情况，使用优化1和传统的并无差别。针对这种情况，我们可以正向冒泡和反向冒泡交替执行，如果提前知道这些数组的大小位置规律，还可以设置正向冒泡和反向冒泡的权重。本次代码演示的是交替执行。

  ```java
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
  ```
  

#### 总结

- 由于冒泡思想的原因，该算法的时间复杂度为O(N²)
- 由于相同元素排序后前后顺序不变，则冒泡算法是稳定算法