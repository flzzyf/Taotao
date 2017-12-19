import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemCat {
	//转换成json数据时使用u作为key
	@JsonProperty("u")
	private String url;
	
	@JsonProperty("n")
	private String name;
	
	@JsonProperty("i")
	private ArrayList item;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList getItem() {
		return item;
	}

	public void setItem(ArrayList arrayList) {
		this.item = arrayList;
	}
	
	
	
}