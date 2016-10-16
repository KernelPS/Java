
import java.util.Random;



public class QuickSort1 {
	static int a1[];
	public static void main(String[] args) {
		int END=1000000;
		a1=new int[END];
		Random random=new Random();
		for(int i=0;i<END;i++)
			a1[i]=random.nextInt(END);
		int i=0;
		int j=a1.length-1;
		sort(i,j);
		for(int k=0;k<a1.length;k++)
			System.out.println(a1[k]);
	}
	static void sort(int i,int j)
	{
		if(i>=j)
			return;
		int k=partition(i, j);
		sort(i, k-1);
		sort(k+1, j);
	}
	static int partition(int i,int j)
	{
		int pivot=i;
		i=i+1;
		int high=j;
		while(true)
		{
			while(a1[i]<=a1[pivot])
			{
				i++;
				if(i>=high)
					break;
			}
			while( a1[j]>=a1[pivot])
			{
				j--;
				if(pivot>=j)
					break;
			}
			if(i>=j)
				break;
			int temp1=a1[i];
			a1[i]= a1[j];
			a1[j]= temp1;

		}

		int temp=a1[j];
		a1[j]=a1[pivot];
		a1[pivot]= temp;

		return j;
	}


}
