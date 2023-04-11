package problem2;
import java.util.Scanner;
public class Problem2 {
	public static void main(String[] args)  {

	    Scanner scanner= new Scanner(System.in);
	    binarytree Tree = new binarytree();
	    int number=0;
	    System.out.print("enter r: ");
	    float r=scanner.nextFloat();
	    System.out.println("enter numbers:");
	    float r2=1;
	    float x=0;
	    for(float i=1;i<Integer.MAX_VALUE;i++){ 
		    number=scanner.nextInt();
		    if(number==-1){
		        System.out.println("ratio= "+((int)i-1)+"/"+(int)x+" = "+r2+"\nonly few repetitions");
		        break ;
		    }
		    Tree.add(number);
		    Tree.size();
		    r2=((i)/(Tree.counter));
		    x=Tree.counter;
		    if(r2>=r){
			     System.out.println("ratio= "+(int)i+"/"+(int)Tree.counter+" = "+r2+"\nmany repetitions");
			     break ;
		    }
		   Tree.counter=0;
	    }
	}
}

	class Node {
		int value;
		Node left;
		Node right;
		
		Node( int value) {
			this.value = value;
		}   
	}
	
	class binarytree {
		 public float counter = 0;
		 public Node root;
		 
		 public  void size() { 
			for (int i=1; i<=height(root); i++) 
				size2(root, i); 
			}
		 
		 public void size2 (Node root ,int level) { 
			if (root == null) 
				return; 
			if (level == 1){ 
				counter++;
			}
			else if (level > 1) {
				size2(root.left, level-1); 
				size2(root.right, level-1); 
			} 
		}
		 
		public int height(Node root) { 
			if (root == null) 
				return 0; 
			else{ 
			int lheight = height(root.left); 
			int rheight = height(root.right); 
			if (lheight > rheight) 
			     return(lheight+1);

			else
				return(rheight+1);
			}  
		}
		
		void add(int num) {
			Node newn = new Node(num);
			if (root == null){ 
				root = newn;
			}
			else {
				Node currentnode = root;
				Node parentnode;
				while (true) {
					parentnode = currentnode;
					if(num==currentnode.value)
						break ;
					if (num < currentnode.value) {
						currentnode = currentnode.left;
						if (currentnode == null) {
							parentnode.left = newn;
							return ;
						}
					} 
					else 
						currentnode = currentnode.right;
						if (currentnode == null) {
						parentnode.right = newn;
						return; 
						}
				}
			}
		}

		    }
