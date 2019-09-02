package domian;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
public class PageBean {
	private Integer currentPage;
	private Integer totalPage;
	private Integer totalCount;
	private List<combo> comboList = new ArrayList<>();
	private List<clothes> clothesList = new ArrayList<>();
	

}
