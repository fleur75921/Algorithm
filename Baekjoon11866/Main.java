import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		while(!queue.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				queue.offer(queue.poll());
			}
			if(queue.size() == 1) {
				sb.append(queue.poll());
			} else {
				sb.append(queue.poll()+", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
		br.close();
	}
}
