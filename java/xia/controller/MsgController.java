package java.xia.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xia.service.JobService;
import xia.service.MsgService;

@Controller
@RequestMapping("/url")
public class MsgController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private MsgService msgService;
	
	@RequestMapping("insert")
	public void url() throws IOException{
		jobService.insertJobUrl();
	}
	
	@RequestMapping("select")
	public String select() throws IOException{
		msgService.inserMsg();
		
		return "index";
	}
}













