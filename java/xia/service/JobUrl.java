package java.xia.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import xia.job.cityUrl;

public class JobUrl {

	
	private cityUrl cityUrl = new cityUrl();
	
	BufferedWriter bufferedWriter ;
	
	
	//工作岗位具体链接
	List<String> jobUrl;
	
	
	/**
	 * 
	 * @throws IOException
	 */
	
	
	//获取JobUrl链接
	public void getJob() throws IOException{
		
		
		cityUrl = new cityUrl();
		
		//33条城市数据
		List<String> cityList = cityUrl.getUrl();
		
		int i = 1;
		
		//爬取开始
		for (String cityUrl : cityList) {
			
			jobUrl = new ArrayList<String>();
			//
			for(int j = 1;j<=100;j++){
				String url = cityUrl+"p"+j;
			    try{
					Document doc = Jsoup.connect(url).get();
					Elements eles = doc.select("span.post a");
					for (Element element : eles) {
						
						String jUrl = element.attr("href");
						
						System.out.println(jUrl+"~~~~"+i);
						i++;
						
						jobUrl.add(jUrl);
						
					}
					
			    }catch(Exception e){
			    	break;
			    }
				
			    reJobUrl(jobUrl);
			}
			
		}
		
	}
	
	public List<String> reJobUrl(List<String> jobUrl){
		
		return this.jobUrl;
	}

}







