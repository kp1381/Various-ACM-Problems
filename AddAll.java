import java.util.*;
import java.io.*;
/*
 * Problem Description: http://uva.onlinejudge.org/external/109/10954.pdf
 * Author: Konstantin Petrov
 */
public class AddAll {
	static int arr[];
	static PriorityQueue<Integer> q= new PriorityQueue<Integer>();
	public static void main(String[] args) throws IOException{
		run();
	}
	
	private static void run() throws IOException{
		Scanner s = new Scanner(System.in);
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
	
		while(true){
			int N=s.nextInt();
			if(N==0)break;
			for(int i=0;i<N;i++){
				q.add(s.nextInt());
			}
			int res=0;
			while(true){
				int temp=q.remove()+q.remove();
				res+=temp;
				if(q.isEmpty())break;
				q.add(temp);
			}
			System.out.println(res);
		}
	}
}