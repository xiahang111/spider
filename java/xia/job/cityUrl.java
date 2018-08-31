package java.xia.job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class cityUrl {

	
	public List<String> getUrl() throws IOException{
		
		List city = new ArrayList<>();
		
		String url = "http://www.zhaopin.com/citymap.html";
		Document doc = Jsoup.connect(url).get();
		
		
		Elements level1 = doc.select("div.col1 dl dd a strong");
		
		int i = 1;
		String cityUrl = "";
	
		url = "http://jobs.zhaopin.com/all/";
		doc = Jsoup.connect(url).get();
		
		level1 = doc.select("div#search_dom a");
		for (Element element : level1) {
			
			cityUrl = element.attr("href");
			
			System.out.println(cityUrl+"~~~"+i);
			
			city.add(cityUrl);
			
			i++;
		}
		
		return city;
		
		
	}

}















