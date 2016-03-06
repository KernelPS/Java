import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class InsertionSort {
	static List<Integer> a1=new ArrayList<Integer>();;
	public static void main(String[] args) {
		int LOW=0;
		int END=100000;
		Random random=new Random();
		for(int i=LOW;i<END;i++)
			a1.add(random.nextInt(END));
		insertionSort(a1);
		for(int i=0;i<a1.size();i++)
			System.out.println(a1.get(i));
	}
	public static void insertionSort(List<Integer>  a1) {
		int n = a1.size();
		for (int j = 1; j < n; j++) {
			int key = (int) a1.get(j);
			int i = j-1;
			while ( (i > -1) && ( (int)(a1.get(i)) > key ) ) {
				a1.set(i+1,a1.get(i));
				i--;
			}
			a1.set(i+1,key);
		}
	}
}
