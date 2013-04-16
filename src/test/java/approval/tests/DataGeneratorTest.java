package approval.tests;

import approval.Data;
import approval.DataGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;
import util.ObjectMapperFactory;


import java.util.Date;

@UseReporter(JunitReporter.class)
public class DataGeneratorTest {

	private static ObjectMapper mapper = new ObjectMapperFactory().build();

	@Test
	public void test_string() throws Exception {
		String actual = new Date(1000L).toString();
		Approvals.verify(actual);
	}

	@Test
	public void returns_data() throws Exception {
		Data data = new DataGenerator().generate(1);
		Approvals.verify(json(data));
	}

	private static String json(Object o) {
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}
