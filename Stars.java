import java.util.*;
import java.io.*;
/*
 * Problem Description: http://poj.org/problem?id=2352
 * Author: Konstantin Petrov
 */
public class Stars {
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
	public static void main(String[] args) throws IOException{
		run();
	}
	
	private static void run() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		Fenwick fen = new Fenwick(200001);
		String temp="";
		temp=in.readLine();
		String[] temp1;
		int N=Integer.parseInt(temp);
		int res[]= new int[N];
		for(int i=0;i<N;i++){
			temp=in.readLine();
			temp1=temp.split(" ");
			fen.adjust(Integer.parseInt(temp1[0])+1, 1);
			res[fen.sumQuery(Integer.parseInt(temp1[0])+1)-1]++;
		}
		for(int i=0;i<N;i++)System.out.println(res[i]);
	}
}
