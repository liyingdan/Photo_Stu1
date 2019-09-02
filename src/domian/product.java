package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class product {
	private Integer pid;
	private String ptype;
	private String pimage;
	private String pdesc1;
	private String pdesc2;
	@Override
	public String toString() {
		return "product [pid=" + pid + ", ptype=" + ptype + ", pimage=" + pimage + ", pdesc1=" + pdesc1 + ", pdesc2="
				+ pdesc2 + "]";
	}
	

}
