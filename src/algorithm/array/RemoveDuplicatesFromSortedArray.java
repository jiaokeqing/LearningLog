package algorithm.array;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * 我的解法
     * 思路：从头至尾每次遇到index跟index+1相同的，就前移一位
     * 为了防止前移造成判断上的遗漏，所以当前移结束还是将index放在当前坐标
     */
    public int removeDuplicates(int[] nums) {
        int i;
        int length = nums.length;
        for (i = 0; i < length; i++) {
            if (i == nums.length - 1) {
                break;
            }


            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                length--;
                i--;
            }

        }
        return length + 1;
    }


    /**
     * 答案解法
     * 时间复杂度：o(n)
     */
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 4, 4, 5, 6};
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
        test.removeDuplicates(array);
    }
}
