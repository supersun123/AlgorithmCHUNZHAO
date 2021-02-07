//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 572 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N>=0? ful(x,N):1.0/ful(x,-N);
    }
    public double ful(double x,long N){
        if(N==0){
            return 1.0;
        }
        double y = ful(x,N/2);
        return N%2==0? y*y:y*y*x;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
思路：将乘方问题不断分解成小问题，最后得到最终值，迭代时要判断幂数的奇偶性。时间复杂度由n将为logn
