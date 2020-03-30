### 堆排序

#### 基本思想

>  将数据以堆的形式，以最大堆的方式找到数据中的最大值，然后将其他数据继续重复刚才步骤。
>
>  性质一：索引为i的左孩子的索引是 (2 * i + 1);
>
>  性质二：索引为i的左孩子的索引是 (2 * i + 2);
>
>  性质三：索引为i的父结点的索引是 ( i - 1 ) / 2;

- 代码实现

  ```java
  public int[] heap(int[] ints){
      int len = ints.length;
      // 对于一个长度为len的数组，共需要对比len-1轮
      for (int i = 0; i < len-1; i++) {
          // 最大堆：每一趟找出最大的值
          for (int j=len-1-i; j>0; j=j-2){
              int subMax;
              if (j==(len-1-i)&&(len-i)%2==0){
                  subMax = j;
              } else {
                  subMax = ints[j] > ints[j-1] ? j : j-1;
              }
              if (ints[subMax] > ints[(j-1)/2]){
                  int temp = ints[subMax];
                  ints[subMax] = ints[(j-1)/2];
                  ints[(j-1)/2] = temp;
              }
          }
          // 将放在堆顶最大值换到后面
          int temp = ints[len-1-i];
          ints[len-1-i] = ints[0];
          ints[0] = temp;
          PrintUtil.forEach(ints);
      }
      return ints;
  }
  ```

#### 总结

- 堆排序的时间复杂度是O(N * lgN)。
  假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？
  堆排序是采用的二叉堆进行排序的，二叉堆就是一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的定义，它的深度至少是lg(N+1)。最多是多少呢？由于二叉堆是完全二叉树，因此，它的深度最多也不会超过lg(2N)。因此，遍历一趟的时间复杂度是O(N)，而遍历次数介于lg(N+1)和lg(2N)之间；因此得出它的时间复杂度是O(N * lgN)。
