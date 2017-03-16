package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mapper.JDMapper;
import pojo.Item;
import thread.JDItemThread;
import thread.JDUrlThread;

@Service
public class UrlService{
	
	@Autowired
	private JDMapper jdMapper;
	
	
	
	public void runUrl(){
		//开启多线程
		JDUrlThread jdThread = new JDUrlThread();
		new Thread(jdThread).start();
		new Thread(jdThread).start();
		new Thread(jdThread).start();
				
	}

	public void changeItem(List<String> itemUrlList) {
		JDItemThread itemThread = new JDItemThread();
		new Thread(itemThread).start();
		new Thread(itemThread).start();
		new Thread(itemThread).start();
		
		List<Item> itemList = JDItemThread.getItemList();
		jdMapper.insertItem(itemList);
		
		
	}
	
	
}











