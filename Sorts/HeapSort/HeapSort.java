import java.util.Random;
import java.util.Scanner;


public class HeapSort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=1000000;
		int a[]=new int[n+1];
		int a1[]=new int[n];
		Random random=new Random();
		for(int i=1;i<=n;i++)
			a[i]=random.nextInt(n);
		a=BinaryHeap.maxHeap(a, n);
		int N=n;
		while(N>=1)
		{
			a1[N-1]=a[1];
			BinaryHeap.swap(a,1,N);
			BinaryHeap.sinkDown(1, a, N-1);
			N--;
			
		}
		for(int i=0;i<n;i++)
			System.out.println(a1[i]);
		sc.close();

	}

}
