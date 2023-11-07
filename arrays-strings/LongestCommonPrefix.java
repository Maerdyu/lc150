/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestCommonPrefix {

	// 纵向扫描
	public String longestCommonPrefix(String[] strs) {
		int index = 0;
		while (index < strs[0].length()){
			for (int i = 1; i < strs.length; i++) {
				if(strs[i].length() <= index){
					return strs[0].substring(0, index);
				}
				if(strs[i].charAt(index) != strs[0].charAt(index)){
					return strs[0].substring(0, index);
				}
			}
			index++;
		}
		return strs[0];
	}

	// 横向扫描
	// 分治
	// 二分(选择最短字符串然后二分比较)

	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		String s = longestCommonPrefix.longestCommonPrefix(strs);
		System.out.println(s);
	}
}
