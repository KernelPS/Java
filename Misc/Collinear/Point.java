package Collinear;

import java.util.Comparator;

public class Point implements Comparable<Point>{
	public final Comparator<Point> SLOPE_ORDER=new BySlope();
	final int x;
	final int y;
	
	class BySlope implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			double s1=slopeTo(p1);
			double s2=slopeTo(p2);
			if(s1<s2)
				return -1;
			else if(s1==s2)
				return 0;
			else return 1;
		}


		
	}
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	@Override
	public int compareTo(Point that) {
		
		if(this.y<that.y)return -1;
		if(this.y>that.y)return 1;
		if(this.x<that.x)return -1;
		if(this.x>that.y)return 1;
		return 0;
	}
	
	public double slopeTo(Point that)
	{
		if(this.x==that.x)
		{
			if(this.y==that.y)
				return Double.NEGATIVE_INFINITY;
			return Double.POSITIVE_INFINITY;
		}
		if(this.y==that.y)
			return 0.0;
		double temp=(double)(((double)that.y-(double)this.y)/((double)that.x-(double)this.x));
		return temp;
				
	}
	

}
