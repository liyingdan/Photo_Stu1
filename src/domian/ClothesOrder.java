package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ClothesOrder {
	private Integer oid;
	private String username;
	private String clothesname;
	private String price;
	@Override
	public String toString() {
		return "ClothesOrder [oid=" + oid + ", username=" + username + ", clothesname=" + clothesname + ", price="
				+ price + "]";
	}
	

}
