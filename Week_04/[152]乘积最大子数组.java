//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 951 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i = 0 ;i< nums.length;i++){
            if(nums[i] < 0){
                int tem = imax;
                imax = imin;
                imin = tem;
            }
            imax = Math.max(nums[i] * imax,nums[i]);
            imin = Math.min(nums[i] * imin,nums[i]);
            max = Math.max(imax,max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
思路：由于乘积设计负负得正，因此需要将负数的结果保存.再遇到负数时，得到的结果要和上一次正数乘积的结果
进行交换