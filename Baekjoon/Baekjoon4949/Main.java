import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char tmp;
		char pop;
		boolean isNo = false;
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<str.length();i++) {
				tmp = str.charAt(i);
				if(tmp == '(' || tmp == '[') {
					stack.push(tmp);
				}
				else if(tmp == ')' || tmp == ']') {
					if(stack.isEmpty()) {
						isNo = true;
						break;
					}
					pop = stack.pop();
					if((tmp == ')' && pop == '[') || (tmp == ']' && pop == '(')) {
						isNo = true;
						break;
					}
				}
			}
			if(isNo == false && stack.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			isNo = false;
		}
		System.out.println(sb);
		br.close();
	}
}
