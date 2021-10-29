package in.nt.comp1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("tb")
public class TestBean {
	@Value("${per.name}")
	private String name;

	@Override
	public String toString() {
		return "TestBean [name=" + name + "]";
	}
	
	

}
