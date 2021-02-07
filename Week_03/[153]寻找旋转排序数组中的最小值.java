//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            if(nums[left] <= nums[right]){
                return nums[left];
            }
            int mid = left + ((right - left)>>1);
            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else if(nums[mid] < nums[left]){
                right = mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
思路：采用二分查找，直到在left，mid，right之间为单调时返回left，注意right = mid，否则可能会丢失目标值
