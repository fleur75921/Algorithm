import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] pi;
	static int lens;
	static int lenp;
	static int cnt;
	
	static void lps(String pat) {
		int i = 1, len = 0;
		pi[0] = 0;
		while(i < lenp) {
			if(pat.charAt(i) == pat.charAt(len)) {
				pi[i++] = ++len;
			} else if(len != 0) {
				len = pi[i-1];
			} else {
				pi[i] = 0;
				i++;
			}
		}
	}
	
	static void pmatch(String str, String pat) {
		int i=0, j=0;
		while((lens - i) >= (lenp - j)){
			if(str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
				if(j == lenp) {
					cnt++;
					j = pi[j-1];
				}
			} else if(j != 0) {
				j = pi[j-1];
			} else {
				i++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringBuilder pat = new StringBuilder("IOI");
		for(int i=1;i<N;i++) {
			pat.append("OI");
		}
		lens = M;
		lenp = 2*N + 1;
		pi = new int[lenp];
		cnt = 0;
		lps(pat.toString());
		pmatch(str, pat.toString());
		System.out.println(cnt);
		br.close();
	}
}
