### 桶排序

#### 基本思想

>  假设待排序的数组a中共有N个整数，并且已知数组a中数据的范围[0, MAX)。在桶排序时，创建容量为MAX的桶数组r，并将桶数组元素都初始化为0；将容量为MAX的桶数组中的每一个单元都看作一个"桶"。
>  在排序时，逐个遍历数组a，将数组a的值，作为"桶数组r"的下标。当a中数据被读取时，就将桶的值加1。例如，读取到数组a[3]=5，则将r[5]的值+1。

- 代码实现

  ```java
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
  ```

#### 总结

- 桶排序的空间复杂度为O(N)，N为桶的长度
- 时间复杂度为O(N)
