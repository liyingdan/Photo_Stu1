package domian;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class user {
	public String username;
	private String password;;
	private String phone;
	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + ", phone=" + phone + "]";
	}
	
	
	
}
