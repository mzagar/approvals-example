package approval;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mzagar
 * Date: 4/15/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Data {
	private int id;
	private String text;
	private double value;
	private Map<Integer, String> map;

	public Data(int id, String text, double value, Map<Integer, String> map) {
		this.id = id;
		this.text = text;
		this.value = value;
		this.map = map;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public double getValue() {
		return value;
	}

	public Map<Integer, String> getMap() {
		return map;
	}
}
