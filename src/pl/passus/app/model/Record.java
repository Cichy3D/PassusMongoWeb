package pl.passus.app.model;

import java.util.Map;

public class Record {

	private Map<String, String> data;
	private String time;
	
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Rekord [data=" + data + ", time=" + time + "]";
	}
	

}
