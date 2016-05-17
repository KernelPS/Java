package Collinear;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Collinear {
	static Point points[];
	static Point copy[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of points");
		int n=sc.nextInt();
		points=new Point[n];
		copy=new Point[n];
		int phead=0;
		for(int i=0 ; i<n ; i++)
			points[i]=new Point(sc.nextInt(),sc.nextInt());
		Arrays.sort(points);
		for(int i=0;i<n-3;i++){
			for(int j=i;j<n;j++)
				copy[j]=points[j];
			Arrays.sort(copy,i+1,n,copy[i].SLOPE_ORDER);
			Arrays.sort(copy,0,i,copy[i].SLOPE_ORDER);
			int head=i+1;
			int tail=i+2;
			while(tail<n)
			{
				double firstslope=copy[i].slopeTo(copy[head]);
				while(tail<n && firstslope==copy[i].slopeTo(copy[tail]))
					tail++;
				if(tail-head>=3)
				{
					double pSlope=Double.NEGATIVE_INFINITY;
					while(phead<i)
					{
						pSlope=copy[i].slopeTo(copy[phead]);
						if(pSlope<firstslope)phead++;
						else break;
					}
					if(pSlope!=firstslope)
					{
						for(int k=head-1 ;k<tail;k++)
						{
							System.out.println("("+copy[k].x+","+copy[k].y+")");
						}
					}
				}
				head=tail;
				tail=tail+1;
			}
		}


	}

	public static void createCopy()
	{
		copy=new Point[points.length];
		for(int i=0; i<points.length ; i++)
			copy[i]=points[i];

	}
	public static  void print(List<Point> collinear)
	{
		for(int i=0;i<collinear.size();i++)
			if(!(i==0 || i==collinear.size()-1))
				System.out.println("("+collinear.get(i).x+","+collinear.get(i).y+")"+"->");
			else
				System.out.println("("+collinear.get(i).x+","+collinear.get(i).y+")");
	}

}
