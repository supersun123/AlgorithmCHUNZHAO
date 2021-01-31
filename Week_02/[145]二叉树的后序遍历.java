//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 512 👎 0


//leetcode submit region begin(Prohibit modification and deletion)




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
     /*   List<Integer> list = new ArrayList<Integer>();
        help(root,list);
        return list;
    }
    public void help(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        help(root.left,list);
        help(root.right,list);
        list.add(root.val);
    }*/
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root!=null||stack.size()>0){
            if(root!=null){
                list.add(root.val);
                stack.push(root);
                root = root.right;
            }else{
                TreeNode node = stack.pop();
                root = node.left;
            }
        }
        Collections.reverse(list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
思路：非递归方法：由于后续遍历顺序为左右根，可以遍历跟右左，再反转数组即可。
