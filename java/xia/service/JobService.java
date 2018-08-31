	package java.xia.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xia.job.cityUrl;
import xia.mapper.JobMapper;
import xia.pojo.JUrl;

@Service
public class JobService {
	
	@Autowired
	private JobMapper jobMapper;
	
	String regex = ".*jobs.zhaopin.com/[0-9]{15}.*";
	//创建cityUrl对象爬取城市数据
	private cityUrl cityUrl = new cityUrl();
	
	BufferedWriter bufferedWriter ;
	
	
	//工作岗位具体链接
	List<String> jobUrl;
	

	
	public void insertJobUrl() throws IOException{
		
		
		
		//测试数据
		/*String url = "http://jobs.zhaopin.com/498142187250882.htm";
		
		jobUrlList.add(url);
		
		url = "www.baidu.com/123123123/123123123.htm";
		
		jobUrlList.add(url);
		
		jobMapper.insertJobUrl(jobUrlList);*/
		
		//分割线------------------------------------------------------------
		
		cityUrl = new cityUrl();
		
		//252条城市数据
		List<String> cityList = cityUrl.getUrl();
		
		int i = 1;
		
		//爬取开始
		for (String cityUrl : cityList) {
			
			System.out.println(cityUrl);
			
			jobUrl = new ArrayList<String>();
			//
			for(int j = 1;j<=100;j++){
				String url = cityUrl+"p"+j;
			    try{
					Document doc = Jsoup.connect(url).get();
					Elements eles = doc.select("div.details_container span.post a");
					for (Element element : eles) {
						
						String jUrl = element.attr("href");
						
						
						if(jUrl.length()==43&&jUrl.matches(regex)){
							jobUrl.add(jUrl);
							
							System.out.println(jUrl+"~~~~"+i);
							i++;
						}
						
					
						
					}
					
			    }catch(Exception e){
			    	break;
			    }
				
			  
			}
			if(!jobUrl.isEmpty()){
				jobMapper.insertJobUrl(jobUrl);
			}else{
				continue;
			}
		}
		
		
		//分割线--------------------------------------------------
		
		
		/*String url = "www.baidu.com";
		
		jobUrlList.add(url);
		
		url = "www.jingdong.com";
		
		jobUrlList.add(url);*/
		
		//创建txt文件
		/* File f = new File("D:\\jobUrl.txt");  
         if (f.exists()) {  
        	 
         } else {  
             f.createNewFile();// 不存在则创建  
         }  
         BufferedReader input = new BufferedReader(new FileReader(f));  
         BufferedWriter output = new BufferedWriter(new FileWriter(f));  

		//遍历List
		for (Iterator iterator = jobUrlList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
		//将内容写进本地文件
		 try {  
	            output.write(string);  
	            output.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	  
	        }  
		}*/
	
			
		
			
		
		
		
	}

}



