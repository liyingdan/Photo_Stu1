package domian;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter@Getter
public class comment {
	private Integer cid;
	private String username;
	private String ccom;
	private Date cdate;

	@Override
	public String toString() {
		return "comment [cid=" + cid + ", username=" + username + ", ccom=" + ccom + ", cdate=" + cdate + "]";
	}
	

}
