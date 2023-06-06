import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> queue = new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String command;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(command.equals("push")) {
				queue.offer(Integer.parseInt(st.nextToken()));
			} else if(command.equals("front")) {
				sb.append(queue.isEmpty() ? -1+"\n" : queue.peek()+"\n");
			} else if(command.equals("back")) {
				sb.append(queue.isEmpty() ? -1+"\n" : queue.peekLast()+"\n");
			} else if (command.equals("size")) {
				sb.append(queue.size()+"\n");
			} else if (command.equals("empty")) {
				sb.append(queue.isEmpty() ? 1+"\n" : 0+"\n");
			} else {
				sb.append(queue.isEmpty() ? -1+"\n" : queue.pop()+"\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
