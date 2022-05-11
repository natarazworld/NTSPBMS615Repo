package com.nt.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("biReader")
public class BookItemReader implements ItemReader<String> {
     private String[] books=new String[] {"TIJ","CRJ","HFJ","BBJ","SIJ","WBJ" };
     
     int count=0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookItemReader.read()");
		if(count<books.length)
			return  books[count++];
		else
			return null;
	}

}
