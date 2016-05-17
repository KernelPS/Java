
public class BinaryHeap {

	static int[] maxHeap(int a[],int n)
	{
		int k=n/2;
		while(k>=1)
		{
			sinkDown(k, a, n);
			k--;
		}
		return a;
	}
	static int[] minHeap(int a[],int n)
	{
		int k=n;
		while(k>=1)
		{
			
		}
		return null;
	}
	static void sinkDown(int k,int a[],int n)
	{
		int j=k;
		while(2*j<=n)
		{	
			j=2*k;
			if(j<n && a[j]<a[j+1])j++;
			if(a[j]>a[k])
			{
				swap(a,j,k);
				
			}
			k=j;
				
		}
	}
	static void swimUp(int k,int a[],int n)
	{
		int j=k;
		while(j>=1)
		{
			j=k/2;
			if(a[j]>a[k])
				swap(a,j,k);
			
		}
	}
	static void swap(int a[],int i,int j)
	{
		if(j==0)
			return;
		int temp= a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
}
