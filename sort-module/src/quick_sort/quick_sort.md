### 快速排序

#### 基本思想

>  选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；其中一部分的所有数据都比另外一部分的所有数据都要小。然后，再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

- 代码实现

  ```java
  	/**
       * @param ints 待排序的数组
       * @return
       */
      public int[] quick(int[] ints){
          int len = ints.length;
  
          quick(0,len-1,ints);
  
          return ints;
      }
  
      public void quick(int begin, int end, int[] ints){
  
          int intsBegin = begin;
          int intsEnd = end;
          // 把第一个数当做基数
          int base = ints[begin];
          int finalIndex = begin;
  
          // false：从后往前；true：从前往后
          boolean flag = false;
  
          while (begin < end) {
              if (!flag){
                  if (base > ints[end]){
                      ints[begin] = ints[end];
                      finalIndex = end;
                      flag = true;
                      continue;
                  }
                  end--;
              } else {
                  if (base < ints[begin]){
                      ints[end] = ints[begin];
                      finalIndex = begin;
                      flag = false;
                      continue;
                  }
                  begin++;
              }
          }
  
          ints[finalIndex] = base;
  
          if ((finalIndex-intsBegin)>1){
              quick(intsBegin,finalIndex-1,ints);
          }
          if ((intsEnd-finalIndex)>1){
              quick(finalIndex+1,intsEnd,ints);
          }
      }
  ```

#### 总结

- 快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。
  这句话很好理解：假设被排序的数列中有N个数。遍历一次的时间复杂度是O(N)，需要遍历多少次呢？至少lg(N+1)次，最多N次。
  (01) 为什么最少是lg(N+1)次？快速排序是采用的分治法进行遍历的，我们将它看作一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的定义，它的深度至少是lg(N+1)。因此，快速排序的遍历次数最少是lg(N+1)次。
  (02) 为什么最多是N次？这个应该非常简单，还是将快速排序看作一棵二叉树，它的深度最大是N。因此，快读排序的遍历次数最多是N次。