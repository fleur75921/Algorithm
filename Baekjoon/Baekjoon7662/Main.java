import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int remove(PriorityQueue<Integer> q, HashMap<Integer, Integer> map) {
		int key, cnt;
		while(true) {
			key = q.poll();
			cnt = map.getOrDefault(key, 0);
			if(cnt == 0) {
				continue;
			}
			break;
		}
		if(cnt == 1) {
			map.remove(key);
		} else {
			map.put(key, cnt-1);
		}
		return key;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int k, num;
		char oper;
		PriorityQueue<Integer> min;
		PriorityQueue<Integer> max;
		HashMap<Integer, Integer> map;
		for(int t=0;t<T;t++) {
			k = Integer.parseInt(br.readLine());
			min = new PriorityQueue<>();
			max = new PriorityQueue<>(Collections.reverseOrder());
			map = new HashMap<>();
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				oper = st.nextToken().charAt(0);
				num = Integer.parseInt(st.nextToken());
				if(oper == 'I') {
					min.offer(num);
					max.offer(num);
					map.put(num, map.getOrDefault(num, 0)+1);
				} else {
					if(map.isEmpty()) {
						continue;
					}
					if(num == 1) {
						remove(max, map);
					} else {
						remove(min, map);
					}
				}
			}
			if(map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				num = remove(max, map);
				sb.append(num+" "+(map.size() > 0 ? remove(min, map) : num)+"\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
