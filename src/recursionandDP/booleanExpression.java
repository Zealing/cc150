package recursionandDP;

import java.util.HashMap;

public class booleanExpression {

	public int fDP(String exp, boolean result, int s, int e, HashMap<String, Integer> q) {
		String key = "" + result + s + e;
		if (q.containsKey(key)) {
			return q.get(key);
		}
		
		if (s == e) {
			if (exp.charAt(e) == '1' && result) {
				return 1;
			} else if (exp.charAt(e) == '0' && !result) {
				return 1;
			}
			return 0;
		}
		
		int count = 0;
		if (result) {
			for (int i = s + 1; i <= e; i+= 2) {
				char operator = exp.charAt(i);
				if (operator == '&') {//only when all sides are true -- them can go true and add it into count
					count += countWays(exp, true, s, i - 1) * countWays(exp, true, i + 1, e);
				} else if (operator == '|') {
					count += countWays(exp, true, s, i - 1) * countWays(exp, true, i + 1, e) +
							 countWays(exp, true, s, i - 1) * countWays(exp, false, i + 1, e) +
							 countWays(exp, false, s, i - 1) * countWays(exp, true, i + 1, e);
				} else if (operator == '^') {
					count += countWays(exp, true, s, i - 1) * countWays(exp, false, i + 1, e) +
							 countWays(exp, false, s, i - 1) * countWays(exp, true, i + 1, e);
				}
			}
		} else {//when given result is false--similar to above operation
			for (int i = s + 1; i <= e; i+= 2) {
				char operator = exp.charAt(i);
				if (operator == '&') {
					count += countWays(exp, false, s, i - 1) * countWays(exp, false, i + 1, e) +
							 countWays(exp, true, s, i - 1) * countWays(exp, false, i + 1, e) +
							 countWays(exp, false, s, i - 1) * countWays(exp, true, i + 1, e);
				} else if (operator == '|') {
					count += countWays(exp, false, s, i - 1) * countWays(exp, false, i + 1, e);
				} else if (operator == '^') {
					count += countWays(exp, true, s, i - 1) * countWays(exp, true, i + 1, e) +
							 countWays(exp, false, s, i - 1) * countWays(exp, false, i + 1, e);
				}
			}
		}
		q.put(key, count);
		return count;
	}
	
	public int countWays(String exp, boolean result, int start, int end) {
		if (start == end) {
			if (exp.charAt(start) == '1' && result) {
				return 1;
			} else if (exp.charAt(start) == '0' && !result) {
				return 1;
			}
			return 0;
		}
		
		int count = 0;
		if (result) {
			for (int i = start + 1; i <= end; i+= 2) {
				char operator = exp.charAt(i);
				if (operator == '&') {//only when all sides are true -- them can go true and add it into count
					count += countWays(exp, true, start, i - 1) * countWays(exp, true, i + 1, end);
				} else if (operator == '|') {
					count += countWays(exp, true, start, i - 1) * countWays(exp, true, i + 1, end) +
							 countWays(exp, true, start, i - 1) * countWays(exp, false, i + 1, end) +
							 countWays(exp, false, start, i - 1) * countWays(exp, true, i + 1, end);
				} else if (operator == '^') {
					count += countWays(exp, true, start, i - 1) * countWays(exp, false, i + 1, end) +
							 countWays(exp, false, start, i - 1) * countWays(exp, true, i + 1, end);
				}
			}
		} else {//when given result is false--similar to above operation
			for (int i = start + 1; i <= end; i+= 2) {
				char operator = exp.charAt(i);
				if (operator == '&') {
					count += countWays(exp, false, start, i - 1) * countWays(exp, false, i + 1, end) +
							 countWays(exp, true, start, i - 1) * countWays(exp, false, i + 1, end) +
							 countWays(exp, false, start, i - 1) * countWays(exp, true, i + 1, end);
				} else if (operator == '|') {
					count += countWays(exp, false, start, i - 1) * countWays(exp, false, i + 1, end);
				} else if (operator == '^') {
					count += countWays(exp, true, start, i - 1) * countWays(exp, true, i + 1, end) +
							 countWays(exp, false, start, i - 1) * countWays(exp, false, i + 1, end);
				}
			}
		}
		return count;
	}
	
	public booleanExpression() {
		// TODO Auto-generated constructor stub
	}

}
