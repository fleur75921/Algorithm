import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> positive = new PriorityQueue<Integer>();
		PriorityQueue<Integer> negative = new PriorityQueue<Integer>(Collections.reverseOrder());
		int num;
		for(int i=0;i<N;i++) {
			num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				positive.offer(num);
			}
			else {
				negative.offer(num);
			}
		}
		int result = 0;
		int max = 0;
		int pos_size = positive.size(), neg_size = negative.size();
		if(pos_size > M) {
			for(int i=0;i<pos_size%M;i++) {
				max = positive.poll();
			}
			result += max*2;
			max = 0;
			pos_size = positive.size();
			for(int i=0;i<pos_size/M-1;i++) {
				for(int j=0;j<M;j++) {
					max = positive.poll();
				}
				result += max*2;
			}
		}
		max = 0;
		if(neg_size > M) {
			for(int i=0;i<neg_size%M;i++) {
				max = negative.poll();
			}
			result -= max*2;
			max = 0;
			neg_size = negative.size();
			for(int i=0;i<neg_size/M-1;i++) {
				for(int j=0;j<M;j++) {
					max = negative.poll();
				}
				result -= max*2;
			}
		}
		int left = 0, right = 0;
		pos_size = positive.size();
		if(positive.size() > 0) {
			for(int i=0;i<pos_size;i++) {
				left = positive.poll();
			}
		}
		neg_size = negative.size();
		if(negative.size() > 0) {
			for(int i=0;i<neg_size;i++) {
				right = negative.poll();
			}
		}
		right = -1 * right;
		result += Math.min(left, right)*2;
		result += Math.max(left, right);
		System.out.println(result);
		br.close();
	}
}
