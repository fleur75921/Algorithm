import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String command;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(command.equals("push_front")) {
				deque.push(Integer.parseInt(st.nextToken()));
			} else if(command.equals("push_back")) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			else if(command.equals("front")) {
				sb.append(deque.isEmpty() ? -1+"\n" : deque.peek()+"\n");
			} else if(command.equals("back")) {
				sb.append(deque.isEmpty() ? -1+"\n" : deque.peekLast()+"\n");
			} else if (command.equals("size")) {
				sb.append(deque.size()+"\n");
			} else if (command.equals("empty")) {
				sb.append(deque.isEmpty() ? 1+"\n" : 0+"\n");
			} else if (command.equals("pop_front")){
				sb.append(deque.isEmpty() ? -1+"\n" : deque.poll()+"\n");
			} else {
				sb.append(deque.isEmpty() ? -1+"\n" : deque.pollLast()+"\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
