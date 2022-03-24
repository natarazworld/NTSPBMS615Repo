package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentRequestParamsController {
	
	/*@GetMapping("/data")
	public  String   process(@RequestParam(name = "sno",defaultValue ="1001") int no, 
			                               @RequestParam("sname") String name) {
		System.out.println(no+"   "+name);
		//return  LVN
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public  String   process(@RequestParam(name = "sno",required = false) Integer no, 
			                               @RequestParam("sname") String name) {
		System.out.println(no+"   "+name);
		//return  LVN
		return "show_result";
	}*/
	
	
	/*	@GetMapping("/data")
		public  String   process(@RequestParam(name = "sno",required = false) Integer no, 
				                               @RequestParam("sname") String name,
				                               @RequestParam("sadd") String addrs[],
				                               @RequestParam("sadd") List<String> saddList,
				                               @RequestParam("sadd")  Set<String> saddSet) {
			System.out.println(no+"   "+name+"  "+Arrays.toString(addrs)+"  "+saddList+"  "+saddSet);
			//return  LVN
			return "show_result";
		}*/
	
	@GetMapping("/data")
	public  String   process(@RequestParam(name = "sno",required = false) Integer no, 
			                               @RequestParam("sname") String name,
			                               @RequestParam("sadd") String addrs) {
		System.out.println(no+"   "+name+"  "+addrs);
		//return  LVN
		return "show_result";
	}
	
	
	/*@GetMapping("/data")
	public  String   process(@RequestParam int sno ) {
		System.out.println(sno);
		//return  LVN
		return "show_result";
	}
	*/

}
