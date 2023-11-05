import java.util.Arrays;

/**
 * 274. H 指数
 * https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HIndex {

    /**
     * 贪心，类似分糖果,先排序然后从高到低查
     * 
     * @param citations 论文被引用的次数
     * @return h指数
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length - 1, i = 1;
        while (n >= 0 && citations[n] >= i) {
            n--;
            i++;
        }
        return i - 1;
    }

    /**
     * 计数排序
     * 
     * @param citations 论文被引用的次数
     * @return h指数
     */
    public int hIndex2(int[] citations) {
        int n = citations.length, tot = 0;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += count[n];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = { 1 };
        HIndex hIndex = new HIndex();
        int h = hIndex.hIndex2(citations);
        System.out.println(h);
    }
}