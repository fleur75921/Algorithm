import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int sum = 0;
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
		}
		// 산술 평균
		System.out.println((int)Math.round(sum / (double)N));
		// 중앙값
		Arrays.sort(numbers);
		System.out.println(numbers[N / 2]);
		// 최빈값
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt;
		for(int i=0;i<N;i++) {
			if(map.get(numbers[i]) == null) {
				map.put(numbers[i], 1);
			}
			else {
				cnt = map.get(numbers[i]);
				map.put(numbers[i], cnt + 1);
			}
		}
		int max = Collections.max(map.values());
		TreeSet<Integer> set = new TreeSet<>();
		for(int key : map.keySet()) {
			if(map.get(key) == max) {
				set.add(key);
			}
		}
		if(set.size() == 1) {
			System.out.println(set.pollFirst());
		}
		else {
			set.pollFirst();
			System.out.println(set.pollFirst());
		}
		// 범위
		System.out.println(numbers[N-1] - numbers[0]);
		br.close();
	}
}
