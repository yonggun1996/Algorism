package Sort;

import java.util.Scanner;

public class MergeSort {
	
	private static int[] buff;
	
	public static void sort(int[] arr, int left, int right) {
		int center = (left + right) / 2;
		if(left < right) {
			sort(arr, left, center);
			sort(arr, center + 1, right);
			
			int j = left;
			int p = 0;
			for(; p <= center - left; p++) {
				buff[p] = arr[j];
				j++;
			}
			
			int ai = j;
			int bi = 0;
			int i = left;
			while(ai <= right && bi < p) {
				if(buff[bi] <= arr[ai]) {
					arr[i] = buff[bi];
					bi++;
					i++;
				}else {
					arr[i] = arr[ai];
					ai++;
					i++;
				}
			}
			
			while(bi < p) {
				arr[i] = buff[bi];
				i++;
				bi++;
			}
		}
	}
	
	public static void setBuff(int[] arr) {
		buff = new int[arr.length];
		sort(arr, 0, arr.length-1);
	}

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		MergeSort ms = new MergeSort();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		setBuff(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		long after = System.currentTimeMillis();
		long time = (after - before) / 1000;
		System.out.println("시간차이 : " + time);
	}

}
