package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
import pojo.Item;
import service.UrlService;
import thread.JDUrlThread;

@Controller
public class ItemUrlController {
	
	@Autowired
	private UrlService urlService;
	
	@RequestMapping("/urlItem")
	public String UrlItem(){
		
		urlService.runUrl(); 
		
		List<String> itemUrlList = JDUrlThread.getUrlList();
		
		urlService.changeItem(itemUrlList);
		
		
		return "home";
	}
}
