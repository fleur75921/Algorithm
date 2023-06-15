import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] heap;
	static int idx;

	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	static void add(int x) {
		heap[idx] = x;
		int cur = idx;
		while(cur > 1) {
			if(heap[cur] < heap[cur / 2]) {
				swap(cur, cur / 2);
			} else {
				break;
			}
			cur /= 2;
		}
	}
	
	static int remove() {
		int result = heap[1];
		heap[1] = heap[idx + 1];
		heap[idx + 1] = 0;
		int cur = 1;
		int next = 2;
		while(next <= idx) {
			if(next == idx) {
				if(heap[next] < heap[cur]) {
					swap(cur, next);
					cur = next;
				} else {
					break;
				}
			} else {
				if(heap[next] <= heap[next + 1]) {
					if(heap[next] < heap[cur]) {
						swap(cur, next);
						cur = next;
					} else {
						break;
					}
				} else {
					if(heap[next + 1] < heap[cur]) {
						swap(cur, next + 1);
						cur = next + 1;
					} else {
						break;
					}
				}
			}
			next = 2 * cur;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input;
		idx = 0;
		heap = new int[100001];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(idx == 0) {
					sb.append("0\n");
				} else {
					idx--;
					sb.append(remove()+"\n");
				}
			} else {
				idx++;
				add(input);
			}
		}
		System.out.print(sb);
		br.close();
	}
}
