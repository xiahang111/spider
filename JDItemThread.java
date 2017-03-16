package thread;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Item;

public class JDItemThread implements Runnable{

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	//List<Item> 封装Item
	static List<Item> itemList = new ArrayList<Item>();
	List<String> jdUrlList = JDUrlThread.getUrlList();
	
	public static List<Item> getItemList(){
		return itemList;
	}
	
	//得到京东的列表
		public void run(){
			try{
			for(int i = 0;i<jdUrlList.size();i++){
				Item item = new Item();
				String url = jdUrlList.get(i);
				Document doc = Jsoup.connect(url).get();
				//获取商品的title
				Elements ele = doc.select("div#itemInfo div#name h1");
				String title = ele.text();
				item.setTitle(title);
				
				//获取商品的价格
					//获取商品编号
					ele = doc.select("div#summary-price div.dd a");
					String itemNum = ele.attr("data-sku");
					
					
					item.setId(Long.parseLong(itemNum));
					//拼接json串 http://p.3.cn/prices/mgets?skuIds=J_1411013
					String pUrl = "http://p.3.cn/prices/mgets?skuIds=J_"+itemNum;
					//获取返回的json串
 
					JsonNode jsonNode = MAPPER.readTree(priceJson);
					
					Long price = jsonNode.get(0).get("p").asLong() * 100;
					item.setPrice(price);
					System.out.println(item.getTitle());
					
				itemList.add(item);	
				
				
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			 
			
		}

}













