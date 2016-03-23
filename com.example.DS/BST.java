

public class TreeExample {
	static node root;
	 static int createTree(node n,int n1)
	{
		node temp;
		int height=0;;
		if(root==null)
		{
			root=n;
			height++;
		}
		else
		{
			 height++;
			 node current=root;
			 while(current!=null)
			 {
				 if(current.data>n.data)
				 {
					 if(current.left!=null)
					 {
						 current=current.left;
						 height++;
					 }
					 else
					 {
						 current.left=n;
						 height++;
						 break;
					 }
				 }
				 else if(current.data<n.data)
				 {
					 if(current.right!=null)
					 {
						 current=current.right;
						 height++;
					 }
					 else
					 {
						 current.right=n;
						 height++;
						 break;
					 }
					
				 }
			 }
			
		}
		if(height>n1)
			 return (height);
		 else 
			 return n1;
	}
	public static void main(String[] args) {
		int height=0;;
		node n=new node(10);
		height=createTree(n,height);
		node n1=new node(4);
		height=createTree(n1,height);
		node n2=new node(3);
		height=createTree(n2,height);
		node n3=new node(8);
		height=createTree(n3,height );
		node n4=new node(9);
		height=createTree(n4,height );
		node n5=new node(7);
		height=createTree(n5,height );
		inorder(root);
		//printLevel(root, height);
		//System.out.println(calculateHeight(root));
		delete(root, 4);
		System.out.println();
		inorder(root);
	}
	static void inorder(node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	static void preorder(node root)
	{
		if(root==null)
			return;
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}
	static void printLevel(node root,int height)
	{
		for(int i=1;i<=height;i++)
		{
			levelOrder(root,i);
		}
	}
	static void levelOrder(node root,int height)
	{
		if(root==null)
			return;
		if(height==1)
			System.out.println(root.data);
		else
		{
			levelOrder(root.left, height-1);
			levelOrder(root.right, height-1);
		}
	}
	static int calculateHeight(node root)
	{
		if(root==null)
			return 0;		
		int leftheight=calculateHeight(root.left);
		int rightheight=calculateHeight(root.right);
		
		return Math.max((leftheight+1), (rightheight+1));
	}
	static node delete(node n,int data) //hibbord's deletion in BST.
	{
		if(n==null)
			return null;
		if(n.data>data)
			n.left=delete(n.left, data);
		if(n.data<data)
			n.right=delete(n.right, data);
		else
		{
			if(n.left==null) return n.right;
			if(n.right==null)return n.left;
		
			node temp=minValue(n.right);
			n.data=temp.data;
			delete(n.right, temp.data);
			
		}
		return n;
	}
	static node minValue(node n)
	{
		while(n.left!=null)
			n=n.left;
		return n;
	}
}
class node{
	int data;
	node left;
	node right;
	node(int n)
	{
		data=n;
		left=right=null;
	}
}
