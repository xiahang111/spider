package java.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemUrlController {
	
	@Autowired
	private UrlService urlService;
	
	@RequestMapping("/urlItem")
	public String UrlItem(){
		
		urlService.runUrl(); 
		
		List<String> itemUrlList = Lists.newArrayList();
		
		urlService.changeItem(itemUrlList);
		
		
		return "home";
	}
}
