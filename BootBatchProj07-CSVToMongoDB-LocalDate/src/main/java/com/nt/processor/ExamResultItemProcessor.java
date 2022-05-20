//ItemProcessor
package com.nt.processor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.document.OExamResult;
import com.nt.model.IExamResult;

@Component
public class ExamResultItemProcessor implements ItemProcessor<IExamResult,OExamResult>{

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		
		if(item.getPercentage()>=95) {
			 OExamResult oresult=new OExamResult();
			 oresult.setId(item.getId());
			 oresult.setDob(LocalDate.parse(item.getDob().substring(0, item.getDob().indexOf(" "))));
			 oresult.setPercentage(item.getPercentage());
			 oresult.setSemester(item.getSemester());
			 return oresult;
		}
		else 
			return null;
	}

}
