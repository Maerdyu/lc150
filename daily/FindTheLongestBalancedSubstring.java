/**
 * 2609. 最长平衡子字符串
 * https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/description/
 */
public class FindTheLongestBalancedSubstring {
    public int findTheLongestBalancedSubstring(String s) {
        int end = 0, max = 0;
        while (end < s.length()) {
            int c0 = 0, c1=0;
            while(end < s.length() && s.charAt(end)=='0'){
                c0++;
                end++;
            }
            while (end < s.length() && s.charAt(end)=='1') {
                c1++;
                end++;
            }
            max = Math.max(2*Math.min(c0, c1), max);
        }
        return max;
    }

    public static void main(String[] args) {
        FindTheLongestBalancedSubstring flbs = new FindTheLongestBalancedSubstring();
        int ls = flbs.findTheLongestBalancedSubstring("01000111");
        System.out.println(ls);
    }
}
