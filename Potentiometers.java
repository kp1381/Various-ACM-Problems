import java.util.*;
import java.io.*;
/*
 * Problem Description: http://uva.onlinejudge.org/external/120/12086.pdf
 * Author: Konstantin Petrov
 */
public class Potentiometers {	
	static public class Fenwick {
		public int[] table;

		public Fenwick(int maxN) {
			this.table = new int[maxN + 1];
		}

		public int sumQuery(int a, int b) {
			return sumQuery(b) - sumQuery(a - 1);
		}

		public int sumQuery(int k) {
			int ret = 0;
			while (k > 0) {
				ret += table[k];
				k &= k - 1;
			}
			return ret;
		}

		public void adjust(int i, int adj) {
			while (i < table.length) {
				table[i] += adj;
				i += (i & (-i));
			}
		}

		public int getValue(int i) {
			return sumQuery(i, i);
		}

		public int findFirst(int k) {
			int L = 1, R = table.length - 1;
			while (R - L > 1) {
				int M = (R + L) / 2;
				int val = sumQuery(M);
				if (val < k)
					L = M + 1;
				else
					R = M;
			}
			int LVal = sumQuery(L);
			if (LVal >= k)
				return L;
			return R == L || sumQuery(R) < k ? -1 : R;
		}
	}
	static int arr[]=new int[200001];
	public static void main(String[] args) throws IOException{
		run();
	}
	
	private static void run() throws IOException{
		StringBuilder sb = new StringBuilder();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		Fenwick fen = new Fenwick(200001);
		String temp="";
		//arr[0]=0;
		int caseNum=1;
		while(true){
			temp=in.readLine();
			int N=Integer.parseInt(temp);
			if(N==0)break;
			Arrays.fill(fen.table, 0);
			if(caseNum>1)sb.append("\n");
			sb.append("Case "+caseNum+":\n");
			for(int i=1;i<=N;i++){
				temp=in.readLine();
				fen.adjust(i, Integer.parseInt(temp));	
			}
			while(true){
				temp=in.readLine();
				if(temp.equals("END"))break;
				String temp1[] =temp.split(" ");
				int x=Integer.parseInt(temp1[1]);
				int y=Integer.parseInt(temp1[2]);
				if(temp1[0].equals("S")){
					
					fen.adjust(x, y-fen.getValue(x));
				}else{
					sb.append(fen.sumQuery(x, y)+"\n");
				}
			}
			caseNum++;
		}
		System.out.print(sb);
	}
}