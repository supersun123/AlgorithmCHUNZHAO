//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1111 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<>();
        }
        Map<Character,String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res = new ArrayList<>();
        dfs("",digits,0,res,map);
        return res;
    }
    public void dfs(String s,String digtis,int i,List<String> res,Map<Character,String> map){
        if(i==digtis.length()){
            res.add(s);
            return;
            
        }
        String letter = map.get(digtis.charAt(i));//digtis为数字字符串
        for(int j=0;j<letter.length();j++){
            dfs(s+letter.charAt(j),digtis,i+1,res,map);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
思路：首先创建哈希表，然后遍历输入的数字字符串，提取字符串对应的哈希值，遍历相应哈希值，然后和后面数字字符的哈希值进行排列
通过dfs方式，生成组合的状态数。
