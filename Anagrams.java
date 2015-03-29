import java.util.*;
/*
 * Problem Description: http://uva.onlinejudge.org/external/1/156.pdf
 * Author: Konstantin Petrov
 */
import java.io.*;
public class Anagrams{
	static HashMap<String, List<String>> hash;
	public static void main(String[] args) throws IOException{
		run();
	}
	public static void convert(String word){
		int temp[]=new int[26];
		for(int i=0;i<26;i++){
			temp[i]=0;
		}
		String Lword=word.toLowerCase();
		for(int i=0;i<word.length();i++){
			int t=Lword.charAt(i)-97;
			temp[t]++;
		}
		if(hash.containsKey(Arrays.toString(temp))){
			hash.get(Arrays.toString(temp)).add(word);
		}
		else{
			List<String> l=new LinkedList<String>();
			l.add(word);
			hash.put(Arrays.toString(temp), l);
		}
	}
	
	private static void run() throws IOException{
		hash= new HashMap<String,List<String>>();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String temp=in.readLine();
		while(!temp.equals("#")){
			String temp1[] =temp.split(" ");
			for(int i=0;i<temp1.length;i++){
				convert(temp1[i]);
			}
			temp=in.readLine();
		}
	///	System.out.println(hash);
		LinkedList<String> res = new LinkedList<String>();
		for(List<String> l:hash.values()){
			if(l.size()==1){
				res.add(l.get(0));
			}
		}
		Collections.sort(res);
		for(String s:res){
			System.out.println(s);
		}
	}
}

