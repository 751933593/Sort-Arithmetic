### 基数排序

#### 基本思想

>  基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
>  具体做法是：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。

- 代码实现

  ```java
  /**
   * @param ints 待排序的数组
   * @return
   */
  public int[] radixSort(int[] ints){
  
      int len = ints.length;
  
      // 1.首先获取最大的数
      int max = ints[0];
      for (int i = 1; i < len; i++) {
          if (ints[i]>max){
              max = ints[i];
          }
      }
  
      // 2.根据最大的数，我们可以知道需要排序几次
      for (int exp = 1; max/exp >0 ; exp=exp*10) {
          radix(exp, ints);
      }
  
      return ints;
  
  }
  
  public void radix(int exp, int[] ints){
  
      int[] bucket = new int[10];
  
      // 1.将ints中的数据按当前位exp放入bucket中
      for (int i = 0; i < ints.length; i++) {
          bucket[(ints[i]/exp)%10]++;
      }
  
      // 2.将bucket重放值，使得修改后的bucket中的值对应ints排序后的位置
      for (int i = 1; i < 10; i++) {
          bucket[i] += bucket[i-1];
      }
  
      // 3.将ints中的数据按照bucket，映射到temp_res
      int[] temp_res = new int[ints.length];
      // 为了稳定性，我们倒序遍历ints
      for (int i = ints.length-1; i >= 0; i--) {
          temp_res[bucket[(ints[i]/exp)%10]-1] = ints[i];
          bucket[(ints[i]/exp)%10]--;
      }
  
      // 4.将temp_res中的值赋给ints
      for (int i = 0; i < ints.length; i++) {
          ints[i] = temp_res[i];
      }
  }
  ```

#### 总结

- 是一种特殊的桶排序，代码难点在于桶和原数组的映射关系