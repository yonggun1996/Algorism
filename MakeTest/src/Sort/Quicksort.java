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
		
		//����Լ��� �̿��� �ɰ��� ������ �Ѵ�..
		if(pr > left) {//�ǹ� ������ �׷��� �����ϴ� ����Լ��� ����
			sort(arr, 0, pl - 1);
		}
		
		if(pl < right) {//�ǹ� �̻��� �׷��� �����ϴ� ����Լ��� ����
			sort(arr, pl, arr.length - 1);
		}
	}
	
	public static void Partition(int[] arr, int s) {
		//������ ���ϰ�
		//���غ��� ���� ���� ���ʿ�
		//�׷��� ���� ���� �����ʿ� ��ġ�ϴ� �޼ҵ�
		int p = (s - 1) / 2;//������
		int pl = 0;//���� ����Ʈ
		int pr = s - 1;//������ ����Ʈ
		
		//pr�� pl�� ��ġ�� �������ٸ� ��Ƽ�� ����°��� �׸��Ѵ�
		while(pl <= pr) {
			while(arr[pl] < arr[p]) pl++;//��������Ʈ�� ���غ��� ũ�� �������� ��´�
			while(arr[pr] > arr[p]) pr--;//����������Ʈ�� ���غ��� ������ �������� ��´�
			
			if(pl <= pr) {//�����ͳ��� �ٲٴ� if��
				int swap = arr[pl];
				arr[pl] = arr[pr];
				arr[pr] = swap;
				pl++;
				pr--;
			}
		}
		
		if(pr > 0) {//�ǹ� ������ �׷��� �����ϴ� �޼ҵ�� �̵�
			sort(arr, 0, pl - 1);
		}
		
		if(pl < arr.length - 1) {//�ǹ� �̻��� �׷��� �����ϴ� �޼ҵ�� �̵�
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
		System.out.println("�ð����� : " + time);
	}

}
