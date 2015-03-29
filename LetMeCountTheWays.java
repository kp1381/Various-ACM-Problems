import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
/*
 * Problem Description: http://uva.onlinejudge.org/external/3/357.pdf
 * Author: Konstantin Petrov
 */
public class LetMeCountTheWays {
	static BigInteger arr[] = new BigInteger[30002];
	static int coins[] = {1,5,10,25,50};
	
	static void Func(int m, int n) {
		Arrays.fill(arr, 0, arr.length, BigInteger.ZERO);
		arr[0]=BigInteger.ONE;
		for(int i=0; i<m;i++) {
			for(int j=coins[i];j<=n;j++) {
				arr[j] = arr[j].add(arr[j-coins[i]]);
			}
		}
	}
	public static void main(String[]args) throws IOException {
		Func(5, 30001);
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
   	 	String line;
   	 	
   	 	while( (line = b.readLine()) != null && line.length() != 0) {
   	 		int number = Integer.parseInt(line.trim());
   	 		BigInteger result = arr[number];
   	 		if(result==BigInteger.ONE) System.out.println("There is only 1 way to produce "+number+" cents change.");
   	 		else System.out.println("There are "+result+" ways to produce "+number+" cents change.");
   	 	}
	}
}