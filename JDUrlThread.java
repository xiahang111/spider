package thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

 

public class JDUrlThread implements Runnable{
	
	private static List<String> itemUrlList = new ArrayList<String>();
	
	public static List<String> getUrlList(){
		return itemUrlList;
	}
	
	public static Elements getItemCat() throws IOException{
		System.out.println("爬取开始了。。。。");
		String url = "https://www.jd.com/allSort.aspx";
		Document doc = Jsoup.connect(url).get();
		Elements eles = doc.select(".items dl dd a");
		return eles;
	}
	
	//实现多线程的方法
	public void run(){
		//PrintStream ps = FileUtil.getFile();
		try{
		//拿到所有分类的页面
		Elements eles = JDUrlThread.getItemCat();
		
		
		for (Element ele : eles) {
			String url = "http:"+ele.attr("href");
			//String urlList = HeaderUtil.getHeader(url).toString();
			
			//判定三级列表页面
			if(url.indexOf("?cat=")>0){
				Document listDoc = Jsoup.connect(url).get();
				Elements listEles = listDoc.select(".gl-item .gl-i-wrap").select(".j-sku-item div.p-img a");
				for (Element itemUrl : listEles) {
					itemUrlList.add("http:"+itemUrl.attr("href"));
					System.out.println("有效连接"+"http:"+itemUrl.attr("href"));
					//ps.println("有效连接"+"http:"+itemUrl.attr("href") );
				}
				
			}
			
		}
		
		 
		System.out.println("有效商品总数为："+itemUrlList.size());
		}catch(Exception e){
			e.printStackTrace();
		}
	 
		
		
	}
	
	
	
}
