package Sort;

import java.util.Scanner;

public class HeapSort {
	
	public void sort(int[] arr) {
		for(int i = arr.length - 1; i > 1; i--) {
			int swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;
			
			int par = 0;
			int chi1 = par * 2 + 1;
			int chi2 = par * 2 + 2;
			
			while((chi1 < i && chi2 < i) && (arr[par] > arr[chi1] || arr[par] > arr[chi2])) {
				if(arr[chi1] < arr[chi2]) {
					int swap1 = arr[par];
					arr[par] = arr[chi1];
					arr[chi1] = swap1;
					par = chi1;
					chi1 = par * 2 + 1;
					chi2 = par * 2 + 2;
				}else {
					int swap2 = arr[par];
					arr[par] = arr[chi2];
					arr[chi2] = swap2;
					par = chi2;
					chi1 = par * 2 + 1;
					chi2 = par * 2 + 2;
				}
			}
		}
		
		if(arr[0] < arr[1]) {
			int swap3 = arr[1];
			arr[1] = arr[0];
			arr[0] = swap3;
		}
	}
	
	public void makeHeap(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int chi = i;
			int par = (i - 1) / 2;
			
			while(arr[par] > arr[chi]) {
				int swap = arr[par];
				arr[par] = arr[chi];
				arr[chi] = swap;
				chi = par;
				par = (chi - 1) / 2;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("----------------");
	}

	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		hs.makeHeap(arr);
		hs.sort(arr);
		
		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}

}
