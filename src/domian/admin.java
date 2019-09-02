package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class admin {
	private Integer id;
	private String username;
	private String password;
	@Override
	public String toString() {
		return "admin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
