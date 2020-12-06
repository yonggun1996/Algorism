package Sort;

import java.util.Scanner;

public class Quicksort {
	public static void sort(int[] arr, int left, int right) {
		int p = (right + left) / 2;
		int pl = left;
		int pr = right;
		
		while(pl <= pr) {
			while(arr[pl] < arr[p]) pl++;
			while(arr[pr] > arr[p]) pr--;
			
			if(pl <= pr) {
				int swap = arr[pl];
				arr[pl] = arr[pr];
				arr[pr] = swap;
				pl++;
				pr--;
			}
		}
		
		//재귀함수를 이용해 쪼개서 정렬을 한다..
		if(pr > left) {//피벗 이하의 그룹을 정렬하는 재귀함수를 적용
			sort(arr, 0, pl - 1);
		}
		
		if(pl < right) {//피벗 이상의 그룹을 정렬하는 재귀함수를 적용
			sort(arr, pl, arr.length - 1);
		}
	}
	
	public static void Partition(int[] arr, int s) {
		//기준을 정하고
		//기준보다 작은 수는 왼쪽에
		//그렇지 않은 수는 오른쪽에 배치하는 메소드
		int p = (s - 1) / 2;//기준점
		int pl = 0;//왼쪽 포인트
		int pr = s - 1;//오른쪽 포인트
		
		//pr이 pl의 위치를 앞질렀다면 파티션 만드는것을 그만한다
		while(pl <= pr) {
			while(arr[pl] < arr[p]) pl++;//왼쪽포인트가 기준보다 크면 기준점을 잡는다
			while(arr[pr] > arr[p]) pr--;//오른쪽포인트가 기준보다 작으면 기준점을 잡는다
			
			if(pl <= pr) {//포인터끼리 바꾸는 if문
				int swap = arr[pl];
				arr[pl] = arr[pr];
				arr[pr] = swap;
				pl++;
				pr--;
			}
		}
		
		if(pr > 0) {//피벗 이하의 그룹을 정렬하는 메소드로 이동
			sort(arr, 0, pl - 1);
		}
		
		if(pl < arr.length - 1) {//피벗 이상의 그룹을 정렬하는 메소드로 이동
			sort(arr, pl, arr.length - 1);
		}
	}

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Partition(arr , arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		long after = System.currentTimeMillis();
		long time = (after - before) / 1000;
		System.out.println("시간차이 : " + time);
	}

}
