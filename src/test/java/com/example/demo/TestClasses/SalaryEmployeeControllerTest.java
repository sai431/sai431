/*
 * package com.example.demo.TestClasses;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.mockito.Mockito.when;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.test.context.ActiveProfiles; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import com.poc.springboot.DemoApplication; import
 * com.poc.springboot.Controller.EmployeeInfoController; import
 * com.poc.springboot.model.Employee; import
 * com.poc.springboot.model.EmployeeRespDto;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @WebMvcTest(value = EmployeeInfoController.class)
 * 
 * @ActiveProfiles("prod")
 * 
 * @SpringBootTest(classes= {DemoApplication.class})
 * 
 * @ComponentScan(basePackages = {("com.example.demo")}) public class
 * SalaryEmployeeControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private EmployeeInfoController employeeInfoController;
 * 
 * @Test public void testAddEmployee() { Employee employee = new Employee();
 * employee.setEmpName("Sai"); employee.setRole("Role");
 * employee.setSalaryCtc(1589632L); EmployeeRespDto dto = new EmployeeRespDto();
 * when(employeeInfoController.createEmployeeInfo(employee)).thenReturn(dto);
 * 
 * assertThat(dto.getEmployee().getRole()).isEqualTo("Role"); //
 * assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo(
 * "/1"); }
 * 
 * }
 */