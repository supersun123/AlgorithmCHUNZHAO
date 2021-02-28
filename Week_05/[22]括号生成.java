//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1538 👎 0


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        generate(0, 0, n, "");
        return result;
    }
    public void generate(int left,int right,int n,String s){
        //终结条件
        if(left==n && right==n){
            result.add(s);
            return;
        }
        //递归条件
        if(left<n){
            generate(left+1,right,n,s+"(");
        }
        if(right<left){
            generate(left,right+1,n,s+")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
思路：定义生成函数，起始条件就是左右括号为零，终结条件为左右括号为n，然后不断递归增加左右括号，同时增加条件，即左括号不能大于n，
并且左括号数量比右括号多时才能生成右括号。
