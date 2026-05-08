import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        if (n < 4) {
            return ans;
        }
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                long target2 = (long)target - nums[i] - nums[j];
                int left = j + 1, right = n - 1;

                while (left < right) {
                    long sum =(long)nums[left] + nums[right];
                    if (sum == target2){
                         ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    }
                    else if (sum > target2) right--;
                    else left++;
                }
            }
        }
        return ans;
    }
}
