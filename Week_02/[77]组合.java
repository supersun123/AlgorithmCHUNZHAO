//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 499 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n <= 0 || n < k){
            return result;
        }
        List<Integer> res = new ArrayList<>();
        dfs(n,k,1,result,res);
        return result;
    }
    private void dfs(int n,int k,int begin,List<List<Integer>> result,List<Integer> res){
        if(res.size() == k){
            result.add(new ArrayList<>(res));
            return;
        }
        for(int i = begin;i <= n;i++){
            res.add(i);
            dfs(n,k,i+1,result,res);
            res.remove(res.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
