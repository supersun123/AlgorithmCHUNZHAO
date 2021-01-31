//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 124 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/



class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if(root!=null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(0,node.val);//不断将得到的值放在数组的首位，即将数组反转
            for(int i=0;i<=node.children.size()-1;i++){
                stack.push(node.children.get(i));
            }
        }
        return list;





    }
}
//leetcode submit region end(Prohibit modification and deletion)
