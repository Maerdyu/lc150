/**
 * 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsPalindrome {

	// 双指针
	public boolean isPalindrome(String s) {
		int start = 0, end = s.length()-1;
		while (start < end){
			while (start < end && !Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))){
				start++;
			}
			while (start < end && !Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end))){
				end--;
			}
			if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
				start++;
				end--;
			}else {
				return false;
			}
		}
		return true;
	}

	// 反转字符串

	public static void main(String[] args) {
		IsPalindrome isPalindrome = new IsPalindrome();
		boolean palindrome = isPalindrome.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(palindrome);
	}
}
