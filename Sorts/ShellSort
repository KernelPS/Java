import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ShellSort {
	static int a[];
	static List<Integer> a1=new ArrayList<Integer>();
	public static void main(String[] args) {
		Random random=new Random();
		int START=0;
		int END=100000;
		for(int i=START;i<END;i++)
			a1.add(random.nextInt(END));
		int h=1;
		int N=a1.size();
		while(h<N/3)
			h=3*h+1; //Knuth Sequence.
		while(h>=1)
		{
			for(int i=h;i<N;i++)
			{
				int j=i;
				int key=a1.get(i);
				while(j>=h && a1.get(j-h)>key)
				{
					a1.set(j, a1.get(j-h));
					j=j-h;
				}
				a1.set(j,key);
			}
			h=h/3;
		}
		for(int i=0;i<a1.size();i++)
			System.out.println(a1.get(i));
	}

}
