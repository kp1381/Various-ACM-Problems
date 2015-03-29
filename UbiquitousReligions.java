import java.util.*;
import java.io.*;
/*
 * Problem Description: http://poj.org/problem?id=2524
 * Author: Konstantin Petrov
 */
public class UbiquitousReligions{
	static HashMap<String, List<String>> hash;
	public static void main(String[] args) throws IOException{
		run();
	}
	
	private static void run() throws IOException{
		hash= new HashMap<String,List<String>>();
		LinkedList<Integer> resL= new LinkedList<Integer>();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String temp=in.readLine();
		//int caseNum=1;
		while(true){
			String temp1[] =temp.split(" ");
			int n=Integer.parseInt(temp1[0]);
			int m=Integer.parseInt(temp1[1]);
			if(n==0&&m==0)break;
			int res=n;
			int arr[]=new int[n+1];
			for(int i=0;i<=n;i++){
				arr[i]=i;
			}
			for(int i=0;i<m;i++){
				temp=in.readLine();
				temp1=temp.split(" ");
				int a=Integer.parseInt(temp1[0]);
				int b=Integer.parseInt(temp1[1]);
				int a1=a;
				int b1=b;
				while(a1!=arr[a1]){
					a1=arr[a1];
				}
				arr[a]=a1;
				while(b1!=arr[b1]){
					b1=arr[b1];
				}
				arr[b]=b1;
				if(arr[a]!=arr[b]){
					res--;
					b1=b;
					while(true){
						if(b1==arr[b1]){
							arr[b1]=a1;
							break;
						}else{
							int temp3= arr[b1];
							arr[b1]=a1;
							b1=temp3;
						}
					}
					arr[b]=arr[a];
				}
				//System.out.println(Arrays.toString(arr));
			}
			temp=in.readLine();
			//System.out.println("Case "+caseNum+": "+res);
			resL.add(res);
			//caseNum++;
		}
		for(int i=0;i<resL.size();i++){
			System.out.println("Case "+(i+1)+": "+resL.get(i));
		}
	}
}
