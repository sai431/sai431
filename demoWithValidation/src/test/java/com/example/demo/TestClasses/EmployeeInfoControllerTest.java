/*
 * package com.example.demo.TestClasses;
 * 
 * import static org.mockito.Mockito.doNothing; import static
 * org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.Assert; import org.junit.Before; import org.junit.Test;
 * import org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.Mockito; import org.mockito.MockitoAnnotations; import
 * org.slf4j.Logger; import org.slf4j.LoggerFactory;
 * 
 * import com.poc.springboot.Controller.EmployeeInfoController; import
 * com.poc.springboot.Repo.EmployeeInfoRepo; import
 * com.poc.springboot.Repo.SalBreakUpRepo; import
 * com.poc.springboot.entity.EmpLoyeeInfoEntity; import
 * com.poc.springboot.entity.SalaryBreakupEntity; import
 * com.poc.springboot.model.Employee; import
 * com.poc.springboot.model.EmployeeConversionModel; import
 * com.poc.springboot.model.EmployeeRespDto; import
 * com.poc.springboot.model.SalaryBreakUpModel;
 * 
 * public class EmployeeInfoControllerTest {
 * 
 * private static final Logger LOGGER =
 * LoggerFactory.getLogger(EmployeeInfoController.class);
 * 
 * @InjectMocks private EmployeeInfoController emp;
 * 
 * @Mock private EmployeeInfoRepo empInfoRepo;
 * 
 * @Mock private SalBreakUpRepo breakUpRepo;
 * 
 * @Before public void init() { MockitoAnnotations.initMocks(this); }
 * 
 * @Test public void createEmployeeInfoSuccessTest() {
 * 
 * Employee employeeEntity = getEmployeeDto();
 * 
 * EmpLoyeeInfoEntity empConv = getEmpInfoEntity(); SalaryBreakupEntity
 * salaryEntity = getSalaryBreakupEntity();
 * 
 * when(empInfoRepo.save(Mockito.any())).thenReturn(empConv);
 * when(breakUpRepo.save(Mockito.any())).thenReturn(salaryEntity);
 * 
 * EmployeeRespDto empResponse = emp.createEmployeeInfo(employeeEntity);
 * 
 * Assert.assertNotNull(empResponse);
 * Assert.assertEquals(empResponse.getEmployee().getEmpName(), "Rajesh");
 * Assert.assertEquals(empResponse.getEmployee().getRole(), "Dev");
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getBasic(), 2000,
 * 0);
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getCityCompAllow(
 * ), 2000, 0);
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getEducation(),
 * 2000, 0); }
 * 
 * @Test public void updateEmpRespTestFailureCoverage() { Employee
 * employeeEntity = new Employee(); employeeEntity.setEmpId(1234L);
 * employeeEntity.setEmpName("Rajesh"); employeeEntity.setRole("Dev");
 * employeeEntity.setSalaryCtc(25000L);
 * when(breakUpRepo.existsById(1234l)).thenReturn(false); }
 * 
 * @Test public void updateEmpRespTestSuccessPath() { Employee employeeEntity =
 * getEmployeeDto(); EmpLoyeeInfoEntity empConv = getEmpInfoEntity();
 * SalaryBreakupEntity salaryEntity = getSalaryBreakupEntity();
 * when(breakUpRepo.existsById(1234l)).thenReturn(true);
 * when(empInfoRepo.save(Mockito.any())).thenReturn(empConv);
 * when(breakUpRepo.save(Mockito.any())).thenReturn(salaryEntity);
 * EmployeeRespDto empResponse = emp.updateEmpResp(1234L, 45823L,
 * employeeEntity); Assert.assertNotNull(empResponse);
 * Assert.assertEquals(empResponse.getEmployee().getEmpName(), "Rajesh");
 * Assert.assertEquals(empResponse.getEmployee().getRole(), "Dev");
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getBasic(), 2000,
 * 0);
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getCityCompAllow(
 * ), 2000, 0);
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getEducation(),
 * 2000, 0);
 * 
 * }
 * 
 * @Test public void getEmployeeByNameTest() {
 * 
 * when(empInfoRepo.findByEmpName(Mockito.anyString())).thenReturn(
 * getListOfEmployee()); EmployeeRespDto empResponse =
 * emp.getAllDetails("Rajesh"); Assert.assertNotNull(empResponse);
 * Assert.assertEquals(empResponse.getEmployee().getEmpName(), "Rajesh");
 * Assert.assertEquals(empResponse.getEmployee().getRole(), "Dev");
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getBasic(), 2000,
 * 0);
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getCityCompAllow(
 * ), 2000, 0);
 * Assert.assertEquals(empResponse.getEmployee().getSalbrkup().getEducation(),
 * 2000, 0);
 * 
 * }
 * 
 * @Test public void delEmpTest() { //
 * doNothing().when(empInfoRepo).deleteById((Mockito.any()));
 * emp.deleteEmpWithsal(456852L);
 * 
 * }
 * 
 * @Test public void getallEmpSuccessCheck() {
 * when(empInfoRepo.findAll()).thenReturn(getListOfEmployee());
 * List<EmployeeRespDto> empResponse = emp.getallEmp(); List<EmployeeRespDto>
 * expectedsEmpResp = getListOfEmployeeRespDto();
 * 
 * Assert.assertNotNull(empResponse); LOGGER.info(empResponse.toString());
 * LOGGER.info(expectedsEmpResp.toString());
 * Assert.assertEquals(empResponse.get(0).getEmployee().getEmpName(),
 * expectedsEmpResp.get(0).getEmployee().getEmpName());
 * Assert.assertEquals(empResponse.get(0).getEmployee().getRole(),
 * expectedsEmpResp.get(0).getEmployee().getRole());
 * Assert.assertEquals(empResponse.get(0).getEmployee().getSalbrkup().getBasic()
 * , expectedsEmpResp.get(0).getEmployee().getSalbrkup().getBasic(), 1);
 * Assert.assertEquals(empResponse.get(0).getEmployee().getSalbrkup().
 * getEducation(),
 * expectedsEmpResp.get(0).getEmployee().getSalbrkup().getEducation(), 1);
 * Assert.assertEquals(empResponse.get(1).getEmployee().getEmpName(),
 * expectedsEmpResp.get(1).getEmployee().getEmpName());
 * 
 * }
 * 
 * private EmpLoyeeInfoEntity getEmpInfoEntity() { EmpLoyeeInfoEntity empConv =
 * new EmpLoyeeInfoEntity(); empConv.setEmpId(1234L);
 * empConv.setEmpName("Rajesh"); empConv.setRole("Dev");
 * empConv.setSalaryCtc(25000L); return empConv; }
 * 
 * private SalaryBreakupEntity getSalaryBreakupEntity() { SalaryBreakupEntity
 * salaryEntity = new SalaryBreakupEntity(); double dble = 2000;
 * salaryEntity.setBasic(dble); salaryEntity.setCityCompAllow(dble);
 * salaryEntity.setEducation(dble); return salaryEntity; }
 * 
 * private Employee getEmployeeDto() { Employee employeeEntity = new Employee();
 * employeeEntity.setEmpId(1234L); employeeEntity.setEmpName("Rajesh");
 * employeeEntity.setRole("Dev"); employeeEntity.setSalaryCtc(25000L); return
 * employeeEntity; }
 * 
 * private List<EmployeeRespDto> getListOfEmployeeRespDto() {
 * List<EmployeeRespDto> listOfEmpl = new ArrayList<EmployeeRespDto>();
 * EmployeeRespDto empConv = new EmployeeRespDto(); EmployeeRespDto empConv1 =
 * new EmployeeRespDto(); double dble = 2000; SalaryBreakUpModel salModel = new
 * SalaryBreakUpModel(); salModel.setBasic(dble); salModel.setEducation(dble);
 * EmployeeConversionModel empconv = new EmployeeConversionModel();
 * empconv.setEmpName("Rajesh"); empconv.setRole("Dev");
 * empconv.setSalbrkup(salModel); EmployeeConversionModel empconv1 = new
 * EmployeeConversionModel(); empconv1.setEmpName("Rajesh");
 * empconv1.setRole("Dev");
 * 
 * empconv1.setSalbrkup(salModel);
 * 
 * empConv.setEmployee(empconv); empConv1.setEmployee(empconv1);
 * 
 * listOfEmpl.add(empConv); listOfEmpl.add(empConv1);
 * 
 * return listOfEmpl;
 * 
 * }
 * 
 * private List<EmpLoyeeInfoEntity> getListOfEmployee() {
 * List<EmpLoyeeInfoEntity> listOfEmpl = new ArrayList<EmpLoyeeInfoEntity>();
 * EmpLoyeeInfoEntity empConv = new EmpLoyeeInfoEntity();
 * empConv.setEmpId(1234L); empConv.setEmpName("Rajesh");
 * empConv.setRole("Dev"); empConv.setSalaryCtc(25000L); SalaryBreakupEntity
 * salbrkUpEntity = getSalaryBreakupEntity();
 * 
 * empConv.setSalaryBreakupEntity(salbrkUpEntity); EmpLoyeeInfoEntity empConv1 =
 * new EmpLoyeeInfoEntity(); empConv1.setEmpId(1234L);
 * empConv1.setEmpName("Rajesh"); empConv1.setRole("Dev");
 * empConv1.setSalaryCtc(25000L); listOfEmpl.add(empConv);
 * listOfEmpl.add(empConv); return listOfEmpl;
 * 
 * } }
 */