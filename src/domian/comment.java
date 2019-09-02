package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class comment {
	private Integer cid;
	private String username;
	private String ccom;
	private String cdate;
	@Override
	public String toString() {
		return "comment [cid=" + cid + ", username=" + username + ", ccom=" + ccom + ", cdate=" + cdate + "]";
	}
	

}
