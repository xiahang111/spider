package util;

import java.util.Random;

import org.apache.http.client.methods.HttpGet;

public class HeaderUtil {
	
	public static HttpGet getHeader(String url){
		//创建一个get请求链接
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Accept", "text/html");
		httpGet.addHeader("Accept-Charset", "utf-8");
		httpGet.addHeader("Accept-Encoding", "gzip");
		httpGet.addHeader("Accept-Language", "en-US,en");
		int n = new Random().nextInt(100);
		 
		
		if (n % 6 == 0) {
			httpGet.addHeader("User-Agent",
					"Mozilla/5.0 (X11;Linux x86_64) AppleWebKit/537.22 (KHTML,like Gecko) Chrome/25.0.1364.160 safari/537.22");
		} else if (n % 5 == 0) {
			httpGet.addHeader("User-Agent",
					"User-Agent:Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50");
		} else if (n % 4 == 0) {
			httpGet.addHeader("User-Agent",
					"User-Agent:Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;");
		} else if (n % 3 == 0) {
			httpGet.addHeader("User-Agent",
					"User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; TencentTraveler 4.0)");
		} else if (n % 2 == 0) {
			httpGet.addHeader("User-Agent",
					"User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)");
		} else {
			httpGet.addHeader("User-Agent",
					"User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/999");
		}
		
		return httpGet;
	}
}
