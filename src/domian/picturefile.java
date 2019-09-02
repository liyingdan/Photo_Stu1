package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class picturefile {
	private Integer fid;
	private String file_add;
	private String username;
	private String filename;
	@Override
	public String toString() {
		return "picturefile [fid=" + fid + ", fie_add=" + file_add + ", username=" + username + ", filename=" + filename
				+ "]";
	}
	
	
	
	

}
