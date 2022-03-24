package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Product;

@Controller
public class DataRenderingController {
	
	
	/*@GetMapping("/report")
	public   String   showReportData(Map<String,Object> map) {
		//add simple values as the model attributes  (Generally these values  are not hardcode
		 //static values - these values will  come from DB s/w through DAO,Service class)
		map.put("favColors",new String[] {"red","green","yellow","white"});
		map.put("nickNames",List.of("raja","maharaja","king","prince"));
		map.put("phoneNumbers", Set.of(999999L,888888L,7777L,666666L));
		map.put("idDetails",Map.of("aadhar",4545353L,"voterId",45345353L,"panNo","453H545"));
		//return LVN
		return "show_report";
	}*/
	
	/*@GetMapping("/report")
	public   String   showReportData(Map<String,Object> map) {
		// create Model class obn having data (Generally this object comes from DAO, service classes 
		 //having db table record
		Product prod=new Product(1001, "sofa",56789.0 , 1.0);
		//make  model class obj as the model attribute
		map.put("prodData",prod);
		//return LVN
		return "show_report";
	}
	*/
	
	@GetMapping("/report")
	public   String   showReportData(Map<String,Object> map) {
		 //create List of Model class objs as  the model attribute
		List<Product>  list=List.of(new Product(1001, "sofa", 897688.0, 1.0),
				                                    new Product(1002, "chair",554555.0, 2.0));
		map.put("prodList",list);
		//rerturn lvn
		return "show_report";
	}
	
	
	
	/*@GetMapping("/report")
	public   String   showReportData(Map<String,Object> map) {
		//add simple values as the model attributes
		map.put("name", "raja");
		map.put("age",30);
		map.put("addrs", "hyd");
		//return LVN
		return "show_report";
	}*/

}
