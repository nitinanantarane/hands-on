package com.nitin.quickstart.core.java.basic;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {6, 9, 1, 5, 2, 7, 4, 10, 3, 0, 8};
		int low = 0;
		int high = nums.length - 1;
		
		quickSort(nums, low, high);
		
		System.out.println(Arrays.toString(nums));
	}

	private static void quickSort(int[] nums, int low, int high) {
		int i = low;
		int j = high;
		int m = low + (high - low) / 2;
		
		int p = nums[m];
		
		while (i <= j) {
			while (nums[i] < p) {
				i++;
			}
			
			while (nums[j] > p) {
				j--;
			}
		
			if (i <= j) {
				swap(nums, i, j);
				i++;
				j--;
			}
			System.out.println(p + " " + nums[i] + " " + nums[j]);
		}
		
		
		if (i < high) {
			quickSort(nums, i, high);
		}
		
		if (low < j) {
			quickSort(nums, low, j);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int k = nums[j];
		nums[j] = nums[i];
		nums[i] = k;
	}

}
