package com.nt.processor;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.IExamResult;
import com.nt.model.OExamResult;

@Component
public class ExamResultItemProcessor implements ItemProcessor<IExamResult, OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		   if(item.getPercentage()>=98.0f) {
			    OExamResult oresult=new OExamResult();
			    oresult.setId(item.getId());
			    oresult.setDob(LocalDate.parse(item.getDob().substring(0, item.getDob().indexOf(" "))));
			    oresult.setPercentage(item.getPercentage());
			    oresult.setSemester(item.getSemester());
			    return oresult;
		   }
		return null;
	}

}
