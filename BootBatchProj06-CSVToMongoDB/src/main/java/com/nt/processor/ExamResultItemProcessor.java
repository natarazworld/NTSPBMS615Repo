//ItemProcessor
package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.document.ExamResult;

@Component
public class ExamResultItemProcessor implements ItemProcessor<ExamResult,ExamResult>{

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		
		if(item.getPercentage()>=95)
		     return item;
		else 
			return null;
	}

}
