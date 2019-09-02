package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class clothes {
	private Integer id;
	private String name;
	private String price;
	private String image;
	@Override
	public String toString() {
		return "clothes [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
