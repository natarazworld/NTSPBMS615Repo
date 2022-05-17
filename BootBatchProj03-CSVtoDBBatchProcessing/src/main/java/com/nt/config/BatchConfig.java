package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jbFactory;
	@Autowired
	private  StepBuilderFactory sbFactory;
	@Autowired
	private  JobMonitoringListener  listener;
	@Autowired
	private  EmployeeItemProcessor processor;
	@Autowired
	private   DataSource ds;
	
	/*  // reader (version1)
	  public  FlatFileItemReader<Employee>  createReader(){
		//create obj for FlatFileItemReader 
		FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		//specify the source of csv file
		reader.setResource(new ClassPathResource("EmployeesInfo.csv"));
		//create  LineReader/LineMapper object
		DefaultLineMapper<Employee> lineMapper=new DefaultLineMapper<Employee>();
		// create LineTokenizer  object
		DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames("empno","empname","empaddrs","salary");
		// create FiledSetMapper to map  each line content to  Model class obj properties
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper=new BeanWrapperFieldSetMapper<Employee>();
		fieldSetMapper.setTargetType(Employee.class);
		//add  LinkTokenizer ,FieldSetMapper to LineMapper
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		//add LineMapper to  FlatFileItemReader
		reader.setLineMapper(lineMapper);
		return reader;
	} */
	
	/*  reader (version2)
	  public  FlatFileItemReader<Employee>  createReader(){
	 
		//create obj for FlatFileItemReader 
		FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		//specify the source of csv file
		reader.setResource(new ClassPathResource("EmployeesInfo.csv"));
		// set LineMapper 
		reader.setLineMapper(new DefaultLineMapper<Employee>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				 setDelimiter(",");
				 setNames("empno","empname","empaddrs","salary");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
				setTargetType(Employee.class);
			}});
		}});
		return reader;
	}//method */
	
	//reader (version3)
	@Bean(name="reader")
	public  FlatFileItemReader<Employee>  createReader(){
		return new  FlatFileItemReaderBuilder<Employee>()
				                 .name("file-reader")
				                 .resource(new ClassPathResource("EmployeesInfo.csv"))
				                 .delimited().delimiter(",")
				                 .names("empno","empname","empaddrs","salary")
				                 .targetType(Employee.class)
				                 .build();
	}
	
	/*//writer (version1)
	@Bean(name="writer")
	public  JdbcBatchItemWriter<Employee>  createWriter(){
		 //create JdbcBatchItemWriter object
		JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>();
		//set DataSource
		 writer.setDataSource(ds);
		 // set SQL Query
		 writer.setSql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:empname,:empaddrs,:salary,:grossSalary,:netSalary)");
		 // specify  the Source provider  ( The names of named params in SQL Query must match with Model class property names) 
		 writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		 return writer;
	}*/
	
	//writer (version2)
	@Bean(name="writer")
	public  JdbcBatchItemWriter<Employee> createWriter(){
		return new  JdbcBatchItemWriterBuilder<Employee>()
				              .dataSource(ds)
				              .sql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:empname,:salary,:empaddrs,:grossSalary,:netSalary)")
				              .beanMapped()
				              .build();
		
	}
	
	//step preparation
	@Bean(name="step1")
	public  Step createStep1() {
		return  sbFactory.get("step1")
				     .<Employee,Employee>chunk(3)
				     .reader(createReader())
				     .writer(createWriter())
				     .processor(processor)
				     .build();
	}//method
	
	
	@Bean(name="job1")
	public   Job createJob1() {
		return jbFactory.get("job1")
				    .listener(listener)
				    .incrementer(new RunIdIncrementer())
				    .start(createStep1())
				    .build();
	}
		
	

}
