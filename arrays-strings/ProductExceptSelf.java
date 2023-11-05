/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ProductExceptSelf {

    /**
     * 通过前缀乘积和后缀乘积两个组数求
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] res = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i]*pre[i-1];
        }
        suf[n-1] = nums[n-1];
        for (int i = n-2; i >=0; i--) {
            suf[i] = suf[i+1] * nums[i];
        }
        res[0] = suf[1];
        res[n-1] = pre[n-2];
        for (int i = 1; i < n-1; i++) {
            res[i] = pre[i-1] * suf[i+1];
        }
        return res;
    }
    
    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = {4,3,2,1,2};
        int[] productExceptSelf2 = productExceptSelf.productExceptSelf(nums);
        for (int productExceptSelf22 : productExceptSelf2) {
            System.out.println(productExceptSelf22);
        }
    }
}
