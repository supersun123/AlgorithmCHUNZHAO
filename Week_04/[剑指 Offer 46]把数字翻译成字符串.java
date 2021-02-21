//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 185 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int dp[] = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=len;i++){
            String tem = s.substring(i-2,i);
            if(tem.compareTo("10") >= 0 && tem.compareTo("25") <= 0){
                dp[i] = dp[i-2] + dp[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
思路：设动态规划列表 dp ，dp[i]代表以 xi 为结尾的数字的翻译方案数量。
若 x_i 和 xi−1组成的两位数字可以被翻译，则 dp[i] = dp[i - 1] + dp[i - 2]
否则 dp[i] = dp[i - 1]dp[i]=dp[i−1] 。可被翻译的两位数区间：当 x_i-1 = 0 时，组成的两位数是无法被
翻译的（例如 00, 01, 02, ⋯ ），因此区间为 [10, 25]。

