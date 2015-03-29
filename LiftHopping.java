import java.io.*;
import java.util.*;
/*
 * Problem Description: http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1742
 * Author: Konstantin Petrov
 */
public class LiftHopping {

	static class Elev implements Comparable<Elev>{
		int Number;
		Flr f;
		Elev(int Number, Flr f){
			this.Number = Number;
			this.f = f;
		}
		public int compareTo(Elev o) {
			if(Number > o.Number) return 1;
			else return -1;
		}
	}

	static class Flr {
		int one;
		int two;
		public Flr(int one, int two){
			this.one = one;
			this.two = two;
		}
	}

	static int n, k, T[],time[][],arr[];
	static PriorityQueue<Elev> queue;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Flr>[]a = new LinkedList[100];
		String temp,temp1[];
		for (int i = 0; i < 100; i++) a[i] = new LinkedList<Flr>();

		queue = new PriorityQueue<Elev>();

		while((temp = b.readLine()) != null && temp.length() != 0){
			queue.clear();
			temp1 = temp.split(" ");
			n = Integer.parseInt(temp1[0]);
			k = Integer.parseInt(temp1[1]);

			T = new int[n];
			time = new int [100][n];

			for (int i = 0; i < time.length; i++) {
				for (int j = 0; j < time[0].length; j++) {
					time[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < 100; i++) a[i].clear();
			temp1 = b.readLine().split(" ");
			for (int i = 0; i < n; i++) T[i] = Integer.parseInt(temp1[i]);

			for (int i = 0; i < n; i++) {
				temp1 = b.readLine().split(" ");
				arr = new int[temp1.length];
				for (int j = 0; j < temp1.length; j++) {
					arr[j] = Integer.parseInt(temp1[j]);
					a[arr[j]].add(new Flr(arr[j], i));
				}
				for (int j = 0; j < temp1.length; j++) {
					if(j > 0) a[arr[j]].add(new Flr(arr[j-1], i));
					if(j < temp1.length-1) a[arr[j]].add(new Flr(arr[j+1], i));
				}
			}

			time[0][a[0].get(0).two] = 0;
			queue.add(new Elev(0, a[0].get(0)));

			while(!queue.isEmpty()) {
				Elev e = queue.poll();
				int x = e.Number;
				int y = e.f.one;
				int elev = e.f.two;

				if(x == time[y][elev]) {
					for (int i = 0; i < a[y].size(); i++) {
						int same = 0;
						Flr z = a[y].get(i);
						if(z.two != elev) same = 60;

						int diff = Math.abs(y - z.one);
						int newT = same+time[y][elev]+T[elev]*diff;

						if(newT < time[z.one][z.two] 
								&& (z.one == y || z.two == elev)) { 
							queue.add(new Elev(newT, z));
							time[z.one][z.two] = newT;
						}
					}
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < time[k].length; i++) {
				min = Math.min(min, time[k][i]);
			}

			if(min != Integer.MAX_VALUE) sb.append(min + "\n");
			else sb.append("IMPOSSIBLE\n");
		}
		System.out.print(sb);
	}
}