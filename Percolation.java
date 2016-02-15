import java.util.Scanner;


public class Percolation {
	static boolean visited[][];
	static boolean opened[][];
	static int n;
	static boolean path[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the grid size");
		n=sc.nextInt();
		visited=new boolean[n][n];
		opened=new boolean[n][n];
		path=new boolean[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				opened[i][j]=true;
		System.out.println("Enter the blocked sites in grid ,once finished press '-1'");
		while(true)
		{
			int i=sc.nextInt();
			if(i==-1)
				break;
			int j=sc.nextInt();
			opened[i][j]=false;	
		}
		if(recursion(0, 0))
		{
			System.out.println("system will percolate");
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(path[i][j])
					{
						System.out.print("["+i+j+"] > ");
					}
		}
		else
			System.out.println("system will not percolate");
	}
	static boolean recursion(int i,int j)
	{
		if(i<0 | j<0 | i>=n | j>=n )
			return false;
		if(visited[i][j] | !opened[i][j])
			return false;
		visited[i][j]=true;
		if(i==n-1)
		{
			System.out.println("reached");
			return true;
			
		}
		if(recursion(i-1, j))
		{
			path[i][j]=true;
			return true;
		}
		if(recursion(i+1, j))
		{
			path[i][j]=true;
			return true;
		}
		if(recursion(i, j-1))
		{
			path[i][j]=true;
			return true;
		}
		if(recursion(i, j+1))
		{
			path[i][j]=true;
			return true;
		}
		return false;
	}

}
