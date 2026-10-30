package iimpi.laba4;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc 
class CalcControllerTest {

	@Autowired private MockMvc mockmvc;

	@Test
	void testAdd() throws Exception {
		mockmvc.perform(get("/calc/add?x={x}&y={y}", 4, 5))
			.andExpect(status().isOk())
			.andExpect(content().string(String.valueOf(9)));
	}

	@Test
	void testSub() throws Exception {
		mockmvc.perform(get("/calc/sub?x={x}&y={y}", 54, 5))
			.andExpect(status().isOk())
			.andExpect(content().string(String.valueOf(49)));
	}

	@Test
	void testMultiply() throws Exception {
		mockmvc.perform(get("/calc/multiply?x={x}&y={y}", 21, 7))
			.andExpect(status().isOk())
			.andExpect(content().string(String.valueOf(147)));
	}

	@Test
	void testDivide() throws Exception {
		mockmvc.perform(get("/calc/divide?x={x}&y={y}", 21, 7))
			.andExpect(status().isOk())
			.andExpect(content().string(String.valueOf(3)));
	}

	@Test
	void testDivideByZero() throws Exception {
		mockmvc.perform(get("/calc/divide?x={x}&y={y}", 1, 0))
			.andExpect(status().isBadRequest());
	}

}
