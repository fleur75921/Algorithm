import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			boolean isYes = true;
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				if(c == '(') {
					stack.push(str.charAt(j));
				}
				if(c == ')') {
					if(stack.isEmpty()) {
						isYes = false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) {
				isYes = false;
			}
			System.out.println(isYes ? "YES" : "NO");
		}
		br.close();
	}
}
