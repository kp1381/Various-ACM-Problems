import java.io.*;
import java.util.*;
/*
 * Problem Description: http://uva.onlinejudge.org/external/1/125.pdf
 * Author: Konstantin Petrov
 */
public class NumberingPaths {
	public static int[][] map;
    public static StringBuilder sb;
    static int N;
    public static void main(String args[]) throws Exception {
    	sb = new StringBuilder();
        Scanner sc=new Scanner(System.in);
        int cityNum=0;
        while(sc.hasNext()){
        	map = new int[30][30];
        	N=-1;
        	int num=sc.nextInt();
        	for(int i=0;i<num;i++){
        		int from=sc.nextInt();
        		int to=sc.nextInt();
        		map[from][to]=1;
        		if(from>N)N=from;
        		if(to>N)N=to;
        	}
        	for(int k=0;k<=N;k++)
        		for(int i=0;i<=N;i++)
        			for(int j=0;j<=N;j++)
        				if(map[i][k]>0&&map[k][j]>0)map[i][j] +=map[i][k]*map[k][j];
        	for(int k=0;k<=N;k++)
        		if(map[k][k]!=0)
        			for(int i=0;i<=N;i++)
        				for(int j=0;j<=N;j++)
        					if(map[i][k]*map[k][j]!=0)map[i][j]=-1;
        	 sb.append("matrix for city ");
             sb.append(cityNum++);
             sb.append("\n");
             for(int i=0;i<=N;i++)
     			for(int j=0;j<=N;j++){
     				sb.append(map[i][j]);
     				if(j==N)sb.append("\n");
     				else sb.append(" ");
     			}
        }
        System.out.print(sb);
    }
}