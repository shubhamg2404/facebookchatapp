package com.example.facebookchatapp.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String helloWorld(){
		File file = new File("output.html");
		if(file.exists()){
			return file.toString();
		}
		return "file not exists";
	}
	
	@RequestMapping(value="/callback",method=RequestMethod.GET)
	
	public String firstUpdate(@RequestParam Map<String,String> allRequestParams){
		
		if(allRequestParams.containsKey("hub.challenge"))
			return allRequestParams.get("hub.challenge");
		
		return allRequestParams.toString();
	}
	
@RequestMapping(value="/callback",method=RequestMethod.POST)
	
	public String sendResponse(@RequestParam Map<String,String> param) throws IOException{
	
		File file = new File("output.html");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(param.toString());
		fileWriter.flush();
		fileWriter.close();
		
	
		return null;
	}
	

}
