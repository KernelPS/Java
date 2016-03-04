
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SelectionSort {
	static int a[];
	static List<Integer> a1=new ArrayList<Integer>();
	public static void main(String[] args) {
		Random random=new Random();
		int START=0;
		int END=100000;
		for(int i=START;i<END;i++)
			a1.add(random.nextInt(END));
		int min=0;
		for(int i=0;i<a1.size();i++){
			min=i;
			for(int j=i+1;j<a1.size();j++)
			{
				if(a1.get(min).intValue()>a1.get(j).intValue())
					min=j;
			}
			swap(i,min);
		}
		for(int i=0;i<a1.size();i++)
			System.out.println(a1.get(i));
	}
	
	static void swap(int i,int j)
	{
		if(i!=j)
		{
		a1.set(i,a1.get(i).intValue()^a1.get(j).intValue());
		a1.set(j,a1.get(i).intValue()^a1.get(j).intValue());
		a1.set(i,a1.get(i).intValue()^a1.get(j).intValue());
		}
	}
}
