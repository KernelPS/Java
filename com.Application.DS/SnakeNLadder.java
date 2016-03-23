import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class SnakeNLadder {
	static  List<cell> grid;
	static boolean visited[]=new boolean[30];
	static LinkedList<cell> queue;
	public static void main(String[] args) {
		grid=new ArrayList<cell>();
		queue=new LinkedList<cell>();
		Scanner sc=new Scanner(System.in);
		cell temp;
		for(int i=0;i<30;i++)
		{
			temp=new cell(i);
			grid.add(i,temp);
		}
		System.out.println("Enter the ladder bases,enter '-1' once done.");
		while(true)
		{
			int temp1=sc.nextInt();
			if(temp1==-1)
				break;
			int temp2=sc.nextInt();
			grid.get(temp1).setLadderBase(temp2);
		}
		System.out.println("Enter snake mouths,enter '-1' once done");
	
		int temp5;
		while(( temp5=sc.nextInt())!=-1)
		{
			grid.get(temp5).snakeMouth(true);
		}
		
		queue.addLast(grid.get(0));
		cell e=null;
		while(!queue.isEmpty())
		{
			 e=queue.removeFirst();
			if(e.pos==29)
				break;
			enqueueNeighbours(e.pos);
		}
		System.out.println(e.dieThrows);
			
			
	}
	static void  enqueueNeighbours(int current)
	{
		for(int i=current+1;i<=current+6 && i<=29;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				if(!grid.get(i).isSnankeMouth())
				{
				if(grid.get(i).ladderBase!=-1 && !grid.get(grid.get(i).ladderBase).isSnankeMouth() )
				{
					queue.addLast(grid.get(grid.get(i).ladderBase));
					grid.get(grid.get(i).ladderBase).dieThrows=grid.get(current).dieThrows+1;
				}
				else
				{
					grid.get(i).dieThrows=grid.get(current).dieThrows+1;
					queue.addLast(grid.get(i));
				}
				}
			}
		}

	}

	
}

class cell{
	int pos;
	int dieThrows;
	boolean snakeMouth;
	int ladderBase=-1;
	cell(int pos)
	{
		this.pos=pos;
	}
	public void  setLadderBase(int n)
	{
		this.ladderBase=n;
	}
	public void snakeMouth(boolean snakeMouth)
	{
		this.snakeMouth=snakeMouth;
	}
	public boolean isSnankeMouth()
	{
		return snakeMouth;
	}
}
