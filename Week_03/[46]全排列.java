//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1140 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> res = new ArrayList<>();
        dfs(res,result,nums);
        return result;
    }
    private void dfs(List<Integer> res,List<List<Integer>> result,int[] nums){
        if(res.size() == nums.length){
            result.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(res.contains(nums[i])){
                continue;
            }
            res.add(nums[i]);
            dfs(res,result,nums);
            res.remove(res.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
