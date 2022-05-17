package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.ExamResult;
import com.nt.processor.ExamResusltItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jbFactory;
	@Autowired
	private StepBuilderFactory  sbFactory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private  ExamResusltItemProcessor  processor;
	@Autowired
	private  DataSource ds;
	
	//reader (version1)
	/*@Bean
	public  JdbcCursorItemReader<ExamResult> createReader(){
		 //create  Reader class obj
		JdbcCursorItemReader<ExamResult> reader=new JdbcCursorItemReader<ExamResult>();
		 //set  DataSource
		reader.setDataSource(ds);
		//  specify SQL Query to get the records
		reader.setSql("SELECT ID,DOB,SEMESTER,PERCENTAGE  FROM EXAM_RESULT");
		//  specify RowMapper  to convert each record of RS to Model class obj
		reader.setRowMapper((rs,rowNum)->{
			 return  new ExamResult(rs.getInt(1),
					                                 rs.getDate(2),
					                                 rs.getInt(3),
					                                 rs.getDouble(4));
			   });
		   return reader;
	 }//method
	*/
	
	//reader (version2)
	@Bean
	public  JdbcCursorItemReader<ExamResult> createReader(){
		return  new JdbcCursorItemReaderBuilder<ExamResult>()
				                                                             .name("jdbc-reader")
				                                                            .dataSource(ds)
				                                                            .sql("SELECT ID,DOB,SEMESTER,PERCENTAGE  FROM EXAM_RESULT")
				                                                            .beanRowMapper(ExamResult.class)
				                                                            .build();
	}
	
	/*//writer (version1)
	 @Bean
	public  FlatFileItemWriter<ExamResult> createWriter(){
		 //create Writer class obj
		 FlatFileItemWriter<ExamResult> writer=new FlatFileItemWriter<ExamResult>();
		 //specify the location of destination file
		 writer.setResource(new FileSystemResource("e:\\csvs\\TopBrains.csv"));
		 //  create FiledExractor object
		 BeanWrapperFieldExtractor<ExamResult> extractor=new BeanWrapperFieldExtractor<ExamResult>();
		 extractor.setNames(new String[]{"id","dob","semester","percentage"});
		 // create LineAggregator  that builds the having Model class obj data 
		 DelimitedLineAggregator<ExamResult>  lineAggregator=new DelimitedLineAggregator<ExamResult>();
		 lineAggregator.setDelimiter(",");
		 lineAggregator.setFieldExtractor(extractor);
		 //set LineAggregator to Writer obj
		 writer.setLineAggregator(lineAggregator);
		 return writer;
	}*/
	
	/*	//writer Version2
		@Bean
		public  FlatFileItemWriter<ExamResult> createWriter(){
			 //create Writer class obj
			 FlatFileItemWriter<ExamResult> writer=new FlatFileItemWriter<ExamResult>();
			 //specify the location of destination file
			 writer.setResource(new FileSystemResource("e:\\csvs\\TopBrains.csv"));
			 //set LineAggregator having delimeter,  Field Extractor
			 writer.setLineAggregator(new DelimitedLineAggregator<ExamResult>() {{
				setDelimiter(",");
				setFieldExtractor(new BeanWrapperFieldExtractor<ExamResult>() {{
					setNames(new String[] {"id","dob","semester","percentage"});
				}});
			 }});
		return writer;
	   } //method
	*/		
	
	//writer Version2
		@Bean
		public  FlatFileItemWriter<ExamResult> createWriter(){
			return   new FlatFileItemWriterBuilder<ExamResult>()
				                   .name("writer-csv")
					               .resource(new FileSystemResource("e:\\csvs\\TopBrains.csv"))
					               .delimited().delimiter(",")
					               .names("id","dob","semester","percentage")
					               .build();
		   } //method
			
		@Bean(name="step1")
		public Step createStep1() {
			return  sbFactory.get("step1")
					       .<ExamResult,ExamResult>chunk(10)
					       .reader(createReader())
					       .writer(createWriter())
					       .processor(processor)
					       .build();
		}
		
		@Bean(name="job1")
		public Job createJob1() {
			return  jbFactory.get("job1")
					     .incrementer(new RunIdIncrementer())
					     .listener(listener)
					     .start(createStep1())
					     .build();
					      
		}
	
}//class
