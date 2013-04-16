package approval;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: mzagar
 * Date: 4/15/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataGenerator {

	private static final AtomicInteger id = new AtomicInteger(0);

	public Data generate() {
		return generate(1);
	}

	public Data generate(int factor) {
		int id = DataGenerator.id.incrementAndGet();
		String str = "random" + id;
		double dbl = (id*factor+1.234) / 3.14;
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(id*100, "string: " + str);
		map.put(id*99, "double: " + dbl);
		map.put(id*98, "id: " + id);
		return new Data(id, str, dbl, map);
	}
}
