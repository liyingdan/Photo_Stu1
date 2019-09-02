package domian;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class picture {
	private Integer pid;
	private String pdate;
	private String ppic1;
	private String ppic2;
	private String ppic3;
	private String ppic4;
	private String ppic5;
	private String ppic6;
	private String ppic7;
	private String ppic8;
	private String ppic9;
	private String ppic10;
	@Override
	public String toString() {
		return "picture [pid=" + pid + ", pdate=" + pdate + ", ppic1=" + ppic1 + ", ppic2=" + ppic2 + ", ppic3=" + ppic3
				+ ", ppic4=" + ppic4 + ", ppic5=" + ppic5 + ", ppic6=" + ppic6 + ", ppic7=" + ppic7 + ", ppic8=" + ppic8
				+ ", ppic9=" + ppic9 + ", ppic10=" + ppic10 + "]";
	}
	

}
