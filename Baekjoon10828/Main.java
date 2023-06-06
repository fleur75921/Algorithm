import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String command;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			if(st.countTokens() > 1) {
				st.nextToken();
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else {
				command = st.nextToken();
				if(command.equals("top")) {
					sb.append(stack.isEmpty() ? -1+"\n" : stack.peek()+"\n");
				} else if (command.equals("size")) {
					sb.append(stack.size()+"\n");
				} else if (command.equals("empty")) {
					sb.append(stack.isEmpty() ? 1+"\n" : 0+"\n");
				} else {
					sb.append(stack.isEmpty() ? -1+"\n" : stack.pop()+"\n");
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}
