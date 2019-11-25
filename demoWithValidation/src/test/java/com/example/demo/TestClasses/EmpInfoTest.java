package com.example.demo.TestClasses;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.poc.springboot.DemoApplication;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
public class EmpInfoTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void verifySaveToEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/employee/save").contentType(MediaType.APPLICATION_JSON)
				.content("{\"empName\":\"Sdfgh\",\"role\":\"Tester\",\"salaryCtc\":1256568965}")
				.accept(MediaType.APPLICATION_JSON))
				/*
				 * andExpect(jsonPath("$.id").exists()) .andExpect(jsonPath("$.text").exists())
				 * .andExpect(jsonPath("$.completed").exists())
				 * .andExpect(jsonPath("$.text").value("New ToDo Sample"))
				 * .andExpect(jsonPath("$.completed").value(false))
				 */
				// .andReturn().getResponse().getContentAsString();
				.andDo(print());
	}

	@Test
	public void verifyEmpById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getEmpByName").param("empName", "Sdfgh")
				.accept(MediaType.APPLICATION_JSON))

				.andDo(print());
	}

	@Test
	public void verifyAllEmpList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}

	@Test
	public void verifyDeleteToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/employee/1").accept(MediaType.APPLICATION_JSON)).andDo(print());
	}

}
