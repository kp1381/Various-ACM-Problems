import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Problem Description: http://poj.org/problem?id=2299
 * Author: Konstantin Petrov
 */
public class UltraQuickSort {
	static int i, j, temp1;
	static int arr[], temp[];
	public static void main(String[]arrgs) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
   	 	String line;
		while(true) {
			line = b.readLine();
			int N = Integer.parseInt(line);
			if(N==0) break;
			arr=new int[N];
			temp = new int[N];
			for(int i=0; i<N;i++) {
				arr[i]=Integer.parseInt(b.readLine());
			}
			long res = count(0, N-1);
			System.out.println(res);
		}
	}
	static long count(int a, int b) {
		if(a==b) return 0;
		int p =((a+b)>>1);
		long aux = count(a, p) + count(p+1,b);
		
		i=a;
		j=p+1;
		temp1=0;
		
		while(i <= p && j<=b) {
			if(arr[i] < arr[j])
				temp[temp1]=arr[i++];
			else {
				temp[temp1]=arr[j++];
				aux += p-i+1;
			}
			temp1++;
		}
		if(i>p)
			for(;j<=b;++j,++temp1)
				temp[temp1]=arr[j];
		else
			for(;i<=p;++i,++temp1)
				temp[temp1]=arr[i];
		
		for(int i=a;i<=b;i++)
			arr[i]=temp[i-a];
		
		return aux;
	}
}