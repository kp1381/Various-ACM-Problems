import java.io.*;
import java.util.*;
/*
 * Problem Description: http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2117
 * Author: Konstantin Petrov
 */
public class WinningStreak{

     public static void main(String []args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 String line;
    	 
    	 do{
    		 line = br.readLine();
    		 StringTokenizer st = new StringTokenizer(line);
    		 int numGames = Integer.parseInt(st.nextToken());
    		 double probability = Double.parseDouble(st.nextToken());
    		 if(numGames==0) break;
    		 
    		 double dp[][]=new double[505][505];
    		 double prob[]=new double[505];
    		 prob[0]=1;
    		 for(int i=1; i<=numGames; i++) {
    			 prob[i]=prob[i-1]*probability;
    		 }
    		 
    		 for(int j=0; j<=numGames; j++) {
    			 dp[0][j]=1;
    		 }
    		 
    		 for(int i=1; i<= numGames; i++) {
    			 for(int j=0; j<= numGames; j++) {
    				 dp[i][j] = dp[i-1][j];
    				 if(j == i-1)
    					 dp[i][j] -= prob[i];
    				 else if (j < i-1)
    					 dp[i][j] -= dp[i-j-2][j]*(1-probability)*prob[j+1];
    			 }
    		 }
    		 double res = 0;
    		 for(int i=1; i<=numGames; i++) {
    			 res += i*(dp[numGames][i]-dp[numGames][i-1]);
    		 }
    		 System.out.printf("%.6f\n",res);
    	 }while(true);
     }
}