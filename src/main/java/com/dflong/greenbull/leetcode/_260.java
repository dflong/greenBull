package com.dflong.greenbull.leetcode;

public class _260 {

   // 因为已知sum的第k位为1，说明这两个数的第k位一个为0，一个为1，
   // 因此可以将nums中的元素分成两组，一组里边的元素的第k位都为0，另一组都为1，
   // 对每一组的元素分别求异或，因为其他的元素都有两个，异或的结果都为0，
   // 所以每一组的异或结果即为答案之一
   public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num; // 结果为两个不同数的异或结果
        }

        int k = - 1;
        for (int i = 0; i < 32 && k == - 1; i ++) {
            if ((sum >> i & 1) == 1) k = i; // 取第k位为1
        }

        int[] res =  new int[2];
        for (int num : nums) {
            if ((num >> k & 1) == 0) res[0] ^= num;
            else res[1] ^= num;
        }

        return res;
   }
}
