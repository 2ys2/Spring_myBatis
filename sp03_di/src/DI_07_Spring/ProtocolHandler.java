package DI_07_Spring;

import java.util.List;

public class ProtocolHandler {
	private List<MyFilter> filters;
	
	//getter
	public List<MyFilter> getFilters(){
		return this.filters;
	}
	
	//setter 
	//filters ��ü���ּҰ� setter�� ����
	public void setFilters(List<MyFilter> filters) {
		this.filters = filters;
	}
	
	//���� �Լ�
	public int filter_length() {
		return this.filters.size();
	}
}
