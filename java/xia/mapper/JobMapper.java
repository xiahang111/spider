package java.xia.mapper;

import java.util.List;

import xia.pojo.JUrl;

public interface JobMapper {

	public void insertJobUrl(List<String> jobUrlList);
	
	public List<String> selectAllUrl();
}
