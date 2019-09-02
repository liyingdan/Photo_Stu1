package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ComboOrder {
	private Integer cid;
	private String cname;
	private String cphone;
	private String ctime;
	@Override
	public String toString() {
		return "ComboOrder [cid=" + cid + ", cname=" + cname + ", cphone=" + cphone + ", ctime=" + ctime + "]";
	}
	
	
	

}
