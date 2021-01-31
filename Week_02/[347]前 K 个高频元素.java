//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 622 👎 0


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for(Integer key:map.keySet()){
            if(queue.size()<k){
                queue.offer(key);
            }else if(map.get(key)>map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }
        int[] res = new int[queue.size()];
        int j = 0;
        for(int num:queue){
            res[j] = num;
            j++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
思路：利用哈希表记录元素和元素出现的次数，利用优先队列实现堆（默认最小堆即删除队中最小元素），重写比较器方法，返回元素出现的次数，将次数压入堆中，
如果次数大于堆中最小元素，则删除最小元素，将新元素压入堆中。
