import java.util.Scanner;


public class SocialNetwork {
	static int count;
	static int a[];
	static int sz[];
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		count=n;
		a=new int[n];
		sz=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=i;
			sz[i]=1;
		}
		int time=0;
		while(n>=0)
		{
			if(count==1)
				break;
			int p=sc.nextInt();
			int q=sc.nextInt();
			quickUnion(p,q);
			time=sc.nextInt();
		}
		System.out.println(time);

	}
	static void quickUnion(int p,int q)
	{
		int rootp=root(p);
		int rootq=root(q);
		if(rootp==rootq)
		{
			//count--;
			//System.out.println(count);
			return;
		}
		if(sz[rootp]>=sz[rootq])
		{
			a[rootq]=rootp;
			sz[rootp]+=sz[rootq];
		}
		else
		{
			a[rootp]=rootq;
			sz[rootq]+=sz[rootp];
		}
		count--;
	}
	static int root(int p)
	{
		while(a[p]!=p)
			p=a[p];
		//System.out.println(p);
		return p;
	}

}
