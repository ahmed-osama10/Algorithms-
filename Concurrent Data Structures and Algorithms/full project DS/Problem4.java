import java.util.Scanner;
	public class Problem4 {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			int[][] graph=new int[n][n];
			
			prim p=new prim();
			for (int i = 0; i < m; i++) {
				int x,y;
				x=sc.nextInt();
				y=sc.nextInt();
				
				graph[x-1][y-1]=Math.abs(x-y);
				graph[y-1][x-1]=Math.abs(x-y);
			}
			sc.close();
			
			long startTime = System.nanoTime();
			
			p.Implemtation(graph , n);
			System.out.println(p.total);
			
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			
			System.out.println("\nTime Elapsed: "+timeElapsed+" nano seconds");
			
		}
	}
	
	class prim{
		int total=0;
		public int Implemtation( int graph[][], int n ) {
			int parent[]= new int[n];
			int cost[]=new int [n];
			Boolean visited[]=new Boolean[n];
			
			for(int i=0; i<n ; i++) {
				cost[i]=Integer.MAX_VALUE;
				visited[i]=false;
			}
			
			cost[0] = 0;
			parent[0]=0;
			
			for (int i=0 ; i<n-1 ; i++) {
				int u=index(cost , visited , n);
				visited[u]=true;
				
				for (int j=0 ; j<n ; j++) {
					if (graph[u][j] != 0 && visited[j] == false && graph[u][j]<cost[j]) {
						parent[j]=u;
						cost[j]=graph[u][j];
					}
				}
			}
			
			return 0;
		}
		
		public int index(int cost[], Boolean visited[], int n) {
			int max=Integer.MIN_VALUE;
			int index=-1;
			for (int i = 0; i < n; i++) {
				if (visited[i]==false && cost[i]>max) {
					total+=max;
					max=cost[i];
					index=i;
				}
			}
			return index;
		}
	}
