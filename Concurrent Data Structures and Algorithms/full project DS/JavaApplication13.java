package javaapplication13;
import java.io.IOException;
import java.util.*;
import java.io.*;
public class JavaApplication13 
     {
    public static void main(String[] args) throws Exception {
        Reader s = new Reader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = s.nextInt();
        int m = s.nextInt();
        int startVertex = s.nextInt();
        ArrayList<?> list[] = new ArrayList[n+1];
        for(int i=0;i<list.length;i++)
            list[i]=new ArrayList<Integer>();
        int indegree[] = new int[n+1];
        int outdegree[]=new int[n+1];
        double ways[] = new double[n+1];
        while(m-- >0)
        {
            int x = s.nextInt();
            int y = s.nextInt();
            ((ArrayList<Integer>)list[x]).add(y);
            outdegree[x]++;
            indegree[y]++;
        }
 
        ways[startVertex]=1;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<indegree.length;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        double compareNum = Math.pow(10,-9);
        while(!q.isEmpty())
        {
            int v = q.remove();
            for(Integer i : ((ArrayList<Integer>)list[v]))
            {
                ways[i]+=((ways[v]*1.0)/outdegree[v]);
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
        }
 
        double max = Double.MIN_VALUE;
        for(int i=1;i<ways.length;i++)
        {
            if(ways[i]>max&&outdegree[i]==0)  
                max=ways[i];
        }
        for(int i=1;i<=n;i++)
        {
            if(outdegree[i]==0&&Math.abs(ways[i]-max)<=compareNum) {
                out.write(Integer.toString(i));
                out.write(" ");
            }
        }
        out.flush();
    }
}
class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; 
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }
 
    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');
 
        if (neg)
            return -ret;
        return ret;
    }
 
    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }
 
    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
 
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
 
        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }
 
        if (neg)
            return -ret;
        return ret;
    }
 
    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }
 
    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
 
    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}
     
    

