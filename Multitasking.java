import java.util.*;
import java.io.*;
/*
 * Problem Description: http://uva.onlinejudge.org/external/119/11926.pdf
 * Author: Konstantin Petrov
 */
public class Multitasking {
	static HashMap<String, List<String>> hash;
	public static void main(String[] args) throws IOException{
		run();
	}
	
	private static void run() throws IOException{
		hash= new HashMap<String,List<String>>();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String temp=in.readLine();
		while(true){
			boolean conflict=false;
			boolean arr[]=new boolean[1000001];
			String temp1[] =temp.split(" ");
			int n=Integer.parseInt(temp1[0]);
			int m=Integer.parseInt(temp1[1]);
			if(n==0&&m==0)break;
			for(int i=0;i<n;i++){
				temp=in.readLine();
				if(!conflict){
					temp1 =temp.split(" ");
					for(int j=Integer.parseInt(temp1[0]);j<Integer.parseInt(temp1[1]);j++){
						if(arr[j]){
							conflict=true;
							break;
						}else arr[j]=true;
					}
				}
			}
			for(int i=0;i<m;i++){
				temp=in.readLine();
				if(!conflict){
					temp1 =temp.split(" ");
					int rep=Integer.parseInt(temp1[2]),k=0,start=Integer.parseInt(temp1[0]),end=Integer.parseInt(temp1[1]);
					do{
						for(int j=k*rep+start;j<k*rep+end;j++){
							if(arr[j]){
								conflict=true;
								break;
							}else arr[j]=true;
						}
						k++;
					}while(k*rep+end<1000001);
				}
			}
			if(conflict)System.out.println("CONFLICT");
			else System.out.println("NO CONFLICT");
			temp=in.readLine();
		}
	}
}
