import java.util.*;
import java.io.*;
/*
 * Problem Description: http://uva.onlinejudge.org/external/124/12405.pdf
 * Author: Konstantin Petrov
 */
public class Scarecrow {
	public static void main(String[] args) throws IOException{
		run();
	}
	
	private static void run() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String temp="";
		temp=in.readLine();
		String[] temp1;
		int caseN=Integer.parseInt(temp);
		int res[] = new int[caseN];
		for(int i=0;i<caseN;i++){
			temp=in.readLine();
			res[i]=0;
			int N=Integer.parseInt(temp);
			temp=in.readLine();
			for(int j=0;j<N;j++){
				if(temp.charAt(j)=='.'){
					res[i]++;
					j+=2;
				}
			}
		}
		for(int i=0;i<caseN;i++)System.out.println("Case " + (i+1)+ ": " + res[i]);
	}
}
