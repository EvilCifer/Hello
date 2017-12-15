package se1_08;

import java.util.HashMap;
import java.util.function.BiFunction;

public class ExtensibleCalculator implements ExtensibleCalculatorIF {

	private HashMap<String, BiFunction> map = new HashMap<String, BiFunction>();
	
	@Override
	public String[] operations() {
		String[] op = new String[map.size()];
		map.forEach((key, function) -> {
			int i = 0;
			op[i++] = key;
		});
		return op;
	}

	@Override
	public void addOperation(String name, BiFunction operation) {
		map.put(name, operation);
	}

	@Override
	public int calc(String op, int x, int y) {
		return (int) map.get(op).apply(x, y);
		
	}
}
