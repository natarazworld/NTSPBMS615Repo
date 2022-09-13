package com.nt.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("msgStore")
public class MessageStore {
	private  List<String>  msgStore=new ArrayList();
	
	public  void addMessage(String message) {
		msgStore.add(message);
	}
	
	public  List<String>   getAllMessages(){
		 return msgStore;
	}

}
