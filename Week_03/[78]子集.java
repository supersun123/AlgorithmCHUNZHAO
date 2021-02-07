//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 970 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0){
            return null;
        }
        dfs(ans, nums,new ArrayList<Integer>(),0);
        return ans;
    }
    public void dfs(List<List<Integer>> ans,int nums[],List<Integer> list,int index){
        if(index==nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }//终结条件
        dfs(ans,nums,list,index+1);//不添加元素

        list.add(nums[index]);
        dfs(ans,nums,list,index+1);//添加元素

         list.remove(list.size()-1);//因为是全局变量，每次添加新元素后变量改变，所以每次递归后需要清理新添加的元素
    }
}
//leetcode submit region end(Prohibit modification and deletion)
