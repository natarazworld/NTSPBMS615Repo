package com.nt.runners;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Tourist;
import com.nt.service.ITouristMgmtService;

@Component
public class MongoDBTestRunner implements CommandLineRunner {
	@Autowired
	private ITouristMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
/*		//=====  save document ===============
		try {
			 //Tourist tourist=new Tourist(null,"ramesh", "USA",45.0f,"3543543L54AS5",9999999L ,true);  //with 7 fields
			
				Tourist tourist=new Tourist();
				tourist.setTouristName("suraj");
				tourist.setNativePlace("nepal");  // with 3 fileds
			
			Tourist tourist=new Tourist(null,"ramesh", "USA",45.0f,"3543543L54AS5",9999999L ,true,100,LocalDateTime.of(2022,10,20,11,34)); 
			
			String result=service.registerTourist(tourist);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		//============ findAll Documents method================
		   //service.fetchAllToursits().forEach(System.out::println);
		  
		/*//================saveAll(-) method==========================
		try {
		Tourist tourist1=new Tourist(null,"chari", "USA",45.0f,"3543543L54AS5",9999999L ,true,100,LocalDateTime.of(2022,10,20,11,34));
		Tourist tourist2=new Tourist();
		tourist2.setTouristName("suraj");
		tourist2.setNativePlace("nepal");  // with 3 fileds
		Tourist tourist3=new Tourist(null,"ramana", "canada",45.0f,"35435435LL6S5",888888L ,true,null,null);
		List<Tourist> touristList=List.of(tourist1, tourist2, tourist3);
		String msg=service.saveTouristGroup(touristList);
		System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
	//service.fetchAllToursits(true,"touristName","contactNo").forEach(System.out::println);
		
	/* Optional<Tourist> opt=service.fetchTouristById("620284349c941c58ccc6d608");
	 if(opt.isPresent())
		  System.out.println("Document is ::"+opt.get());
	 else
		 System.out.println("Document  not found ");*/
		
		//System.out.println(service.modifyTouristById("620284349c941c58ccc6d608", 565646464776L));
		
		System.out.println(service.removeToursitById("620284349c941c58ccc6d608"));
	
	}// main(-)

}// class
