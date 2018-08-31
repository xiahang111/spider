package java.xia.service;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xia.mapper.JobMapper;
import xia.mapper.MsgMapper;
import xia.pojo.JobMsg;



@Service
public class MsgService {
	
	String dec = "";
	
	List<String> List = new ArrayList<String>();
	
	List<JobMsg> msgList = new CopyOnWriteArrayList<JobMsg>();
	
	Socket socket = new Socket();
	
	JobMsg msg ;
	
	int i = 1;
	

	@Autowired
	private JobMapper jobMapper;
	
	@Autowired
	private MsgMapper msgMapper;
	
	int j = 1;
	
	public void inserMsg() throws IOException{
		
	
		socket.setSoTimeout(60000);
		
		List<String> urlString = jobMapper.selectAllUrl();
		
		
		
		//获得工作url具体链接
		for (String url : urlString) {
			
			msg = new JobMsg();
			
			try {
				Document doc = Jsoup.connect(url).get();
				Elements eles = doc.select("li strong");
				for (Element ele : eles) {
					
					List.add(ele.text());
				}
				
				msg.setJobSalary(List.get(0));
				msg.setJobPlace(List.get(1));
				msg.setJobEdu(List.get(5));
				msg.setJobPost(List.get(7));
				
				List.clear();
				
				eles = doc.select("div.tab-inner-cont");
				for (Element element : eles) {
				
					dec = dec+element.text();
					dec = dec.replaceAll("\\s","");
				}
				if(dec.length()>100){
				dec = dec.substring(20,80);
				}
				msg.setJobDec(dec);
				
				System.out.println(i);
				
				i++;
				
				msgList.add(msg);
				
			if(msgList.size()/100>=1&&msgList.size()%100==0){
					
					System.out.println("百条数据已满 准备插入~~~~~~");
					
					msgMapper.insertMsg(msgList);
					
					msgList.clear();
				}else{
					continue;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		/*msg = new JobMsg();
		
		msg.setJobDec("3");
		msg.setJobEdu("3");
		msg.setJobPlace("3");
		msg.setJobPost("3");
		msg.setJobSalary("3");
		msgList.add(msg);*/
		
	}

}
	
}




