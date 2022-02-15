package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medal {
	@Id
	private  String mid;
	private  String mname;
	private  String event;
	private  String place;
	
	
	@Override
	public String toString() {
		return "Medal [mid=" + mid + ", mname=" + mname + ", event=" + event + ", place=" + place + "]";
	}

}
