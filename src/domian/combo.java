package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class combo {
	private Integer id;
	private String name;
	private Double price;
	private String image;
	private String camerist;
	private String type;
	@Override
	public String toString() {
		return "combo [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", camerist=" + camerist
				+ ", type=" + type + "]";
	}
	
	
	
}
