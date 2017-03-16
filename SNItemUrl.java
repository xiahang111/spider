package suning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.HeaderUtil;

public class SNItemUrl {
	
	private static Elements getItemCat() throws IOException{
		String url = "http://as.suning.com/allsort.htm";
		Document doc = Jsoup.connect(url).get();
		Elements eles = doc.select("dl dd a");
		return eles;
		
	}
	
	public void getItemUrl() throws IOException{
		Elements eles = SNItemUrl.getItemCat();
		List<String> itemUrlList = new ArrayList<String>();
		
		for (Element ele:eles) {
			String url = "http:"+ele.attr("href");
			String urlList = HeaderUtil.getHeader(url).toString();
			
			Document docList = Jsoup.connect(urlList).get();
			Elements eleList = docList.select(".border-out .border-in div.wrap div.res-img div.img-block a");
			for (Element element : eleList) {
				itemUrlList.add(element.attr("href"));
			}
		}
	}
}
















