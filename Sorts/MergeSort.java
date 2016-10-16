import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MergeSort {
	static List<Integer> a1=new ArrayList<Integer>();
	public static void main(String[] args) {
		Random random=new Random();
		int END=1000000;
		for(int i=0;i<END;i++)
			a1.add(random.nextInt(END));
		int i=0;
		int j=a1.size()-1;
		a1=mergeSort(i, j);
		for(int k=0;k<a1.size();k++)
			System.out.println(a1.get(k));
	}
	static List<Integer> mergeSort(int i,int j)
	{
		if(i>=j)
		{
			List<Integer> list=new ArrayList<Integer>();
			list.add(a1.get(i));
			return list;
		}
		int mid=i+(j-i)/2;
		List<Integer> l1=mergeSort(i, mid);
		List<Integer> l2=mergeSort(mid+1, j);
		return merge(l1, l2);

	}
	static List<Integer> merge(List<Integer> l1,List<Integer> l2)
	{
		List<Integer> temp=new ArrayList<Integer>();

		int i=0;
		int j=0;
		for(int k=0;k<l1.size()+l2.size();k++)
		{
			if(i==l1.size())
			{
				temp.add(k,l2.get(j));
				j++;
				continue;
			}
			else if(j==l2.size())
			{
				temp.add(k,l1.get(i));
				i++;
				continue;
			}
			if(l1.get(i)>l2.get(j))
			{
				temp.add(k,l2.get(j));
				j++;
			}
			else
			{
				temp.add(k,l1.get(i));
				i++;
			}
		}
		return temp;
	}

}
