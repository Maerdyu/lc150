import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. 简化路径
 * https://leetcode.cn/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SimplifyPath {

	public String simplifyPath(String path) {
		String[] split = path.split("/");
		Deque<String> deque = new ArrayDeque<>();
		for (String s : split) {
			if("..".equals(s)){
				deque.pollFirst();
			}else if(!".".equals(s) && !"".equals(s)){
				deque.push(s);
			}
		}
		StringBuilder res = new StringBuilder();
		while (!deque.isEmpty()){
			res.insert(0, "/" + deque.pop());
		}
		return res.toString().equals("")  ? "/" : res.toString();
	}

	public static void main(String[] args) {
		SimplifyPath simplifyPath = new SimplifyPath();
		String s = simplifyPath.simplifyPath("/../");
		System.out.println(s);
	}
}
