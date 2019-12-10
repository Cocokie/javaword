package com.lix.customize;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CustomizeClassLoad extends A {
    public static void main(String[] args) throws IOException {
        int[] nums = {9, 5, 26, 65, 3, 45, 83, 12, 88, 45, 88};
        insertSort(nums);
    }


    public static void insertSort(int[] nums) {
        int k = 0;
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            k = nums[i];
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (k <= nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
                s = j;
            }
            nums[s] = k;
        }
        System.out.println(Arrays.toString(nums));
    }
}
