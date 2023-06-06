import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int tmp;
	static int b;
	static int num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>();
		int input;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				input = Integer.parseInt(st.nextToken());
				if(input > max) {
					max = input;
				}
				if(map.containsKey(input)) {
					map.put(input, map.get(input)+1);
				} else {
					map.put(input, 1);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int top = 0;
		for(int i=0;i<=max;i++) {
			tmp = 0;
			b = B;
			num = i;
			map.forEach((key, value)-> {
				if(num > key) {
					tmp += value * (num - key);
					b -= value * (num - key);
				}
				if(num < key) {
					tmp += 2 * value * (key - num);
					b += value * (key - num);
				}
			});
			if(tmp <= min && b >= 0) {
				min = tmp;
				if(top < num) {
					top = num;
				}
			}
		}
		System.out.println(min+" "+top);
		br.close();
	}
}
