import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static String add(String num, String addend) {
		StringBuilder sb = new StringBuilder();
		int num_size = num.length();
		int addend_size = addend.length();
		int min = Math.min(num_size, addend_size);
		int max = Math.max(num_size, addend_size);
		boolean carry = false;
		int a, b, sum;
		for(int i=0;i<min;i++) {
			a = Integer.parseInt(num.substring(num_size-1-i, num_size-i));
			b = Integer.parseInt(addend.substring(addend_size-1-i, addend_size-i));
			sum = a + b;
			if(carry == true) {
				sum += 1;
			}
			if(sum >= 10) {
				carry = true;
				sum -= 10;
			} else {
				carry = false;
			}
			sb.insert(0, sum);
		}
		for(int i=min;i<max;i++) {
			if(num_size >= addend_size) {
				a = Integer.parseInt(num.substring(num_size-1-i, num_size-i));
				sum = a;
				if(carry == true) {
					sum += 1;
				}
				if(sum >= 10) {
					carry = true;
					sum -= 10;
				} else {
					carry = false;
				}
				sb.insert(0, sum);
			}
			else {
				a = Integer.parseInt(addend.substring(addend_size-1-i, addend_size-i));
				sum = a;
				if(carry == true) {
					sum += 1;
				}
				if(sum >= 10) {
					carry = true;
					sum -= 10;
				} else {
					carry = false;
				}
				sb.insert(0, sum);
			}
		}
		if(carry) {
			sb.insert(0, 1);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		String item;
		String answer = "0";
		for(int i=0;i<K;i++) {
			item = br.readLine();
			if(item.equals("0")) {
				stack.pop();
			}
			else {
				stack.push(item);
			}
		}
		while(!stack.isEmpty()) {
			answer = add(answer, stack.pop());
		}
		System.out.println(answer);
		br.close();
	}
}
