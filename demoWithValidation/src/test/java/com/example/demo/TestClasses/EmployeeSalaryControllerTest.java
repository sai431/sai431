/*
 * package com.example.demo.TestClasses;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.junit.runner.RunWith;
 * import org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 * 
 * 
 * 
 * @ExtendWith(MockitoExtension.class)
 * 
 * @RunWith(SpringJUnit4ClassRunner.class) public class
 * EmployeeSalaryControllerTest extends AbstractTest {
 * 
 * @Override
 * 
 * @Before public void setUp() { super.setUp(); }
 * 
 * 
 * @Test public void createProduct() throws Exception { String uri =
 * "/employee/save"; Employee employee = new Employee();
 * employee.setEmpName("Sai"); employee.setRole("Dev");
 * employee.setSalaryCtc(12365896L); String inputJson =
 * super.mapToJson(employee); MvcResult mvcResult = mvc.perform(
 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
 * ).content(inputJson)) .andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus(); assertEquals(201, status);
 * String content = mvcResult.getResponse().getContentAsString();
 * assertEquals(content, "Product is created successfully"); }
 * 
 * }
 */