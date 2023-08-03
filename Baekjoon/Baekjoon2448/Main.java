import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	
	static int N;
	static ArrayList<String> strs;
	
	static void make(int n) {
		if(n == N) {
			return;
		}
		
		int size = strs.size();
		StringBuilder sb = new StringBuilder();
		String cur;
		for(int i=0;i<size;i++) {
			sb.append(" ");
		}
		for(int i=0;i<size;i++) {
			cur = strs.get(i);
			strs.add(cur+" "+cur);
			strs.set(i, sb+cur+sb);
		}
		make(n+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = (int) (Math.log10(Integer.parseInt(br.readLine()) / 3) / Math.log10(2));
		strs = new ArrayList<>();
		strs.add("  *  ");
		strs.add(" * * ");
		strs.add("*****");
		make(0);
		System.out.println(String.join("\n", strs));
		br.close();
	}
}
