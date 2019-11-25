
package com.poc.springboot.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.springbbot.constants.DemoConstants;
import com.poc.springboot.Exception.EmployeeNotFoundException;
import com.poc.springboot.Exception.RoleNotFoundException;
import com.poc.springboot.Repo.EmployeeInfoRepo;
import com.poc.springboot.Repo.SalBreakUpRepo;
import com.poc.springboot.entity.EmpLoyeeInfoEntity;
import com.poc.springboot.entity.SalaryBreakupEntity;
import com.poc.springboot.model.Employee;
import com.poc.springboot.model.EmployeeConversionModel;
import com.poc.springboot.model.EmployeeRespDto;
import com.poc.springboot.model.SalaryBreakUpModel;


@RestController
public class EmployeeInfoController {

	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	private SalBreakUpRepo breakUpRepo;

	@Autowired
	private EmployeeInfoRepo empInfoRepo;

	@PostMapping("/employee/save")
	@ResponseBody
	public ResponseEntity<?> createEmployeeInfo(@Valid @RequestBody Employee employeeEntity ) {
		EmployeeRespDto empresp = null;
		boolean roleFlag=true;// if
		/*
		 * if(result.hasErrors()) { List<ObjectError> listofError=
		 * result.getAllErrors(); for (ObjectError objectError : listofError) {
		 * objectError.getDefaultMessage();
		 * 
		 * }
		 * 
		 * }
		 */
		List<String> rolesList = new ArrayList<String>();
		rolesList.add("Developer");
		rolesList.add("Tester");
		rolesList.add("Tech Lead");
		
		roleFlag=containsString(employeeEntity.getRole(),rolesList);
		if(roleFlag == false) {
			
			throw new RoleNotFoundException("please enter a valid designation");
		}
		else {
		EmpLoyeeInfoEntity empInfoo = new EmpLoyeeInfoEntity();
		empInfoo.setEmpId(employeeEntity.getEmpId());
		empInfoo.setEmpName(employeeEntity.getEmpName());
		
		empInfoo.setRole(employeeEntity.getRole());

		EmpLoyeeInfoEntity empConv = empInfoRepo.save(empInfoo);
		SalaryBreakupEntity salbrkup = salaryEmployee(employeeEntity.getSalaryCtc(), empInfoo);
		SalaryBreakupEntity salBrkDet = breakUpRepo.save(salbrkup);
	//	log.debug("employee Info "+empConv);
		EmployeeConversionModel empmodel = new EmployeeConversionModel();

		empmodel.setEmpName(empConv.getEmpName());
		empmodel.setRole(empConv.getRole());

		SalaryBreakUpModel salaryBreakUpModel = new SalaryBreakUpModel();
		salaryBreakUpModel.setBasic(salBrkDet.getBasic());
		salaryBreakUpModel.setCityCompAllow(salBrkDet.getCityCompAllow());
		salaryBreakUpModel.setHra(salBrkDet.getHra());

		salaryBreakUpModel.setConveyance(salBrkDet.getConveyance());
		salaryBreakUpModel.setGrossSalary(salBrkDet.getGrossSalary());
		salaryBreakUpModel.setEducation(salBrkDet.getEducation());
		salaryBreakUpModel.setLta(salBrkDet.getLta());
		salaryBreakUpModel.setMedical(salBrkDet.getMedical());
		empmodel.setSalbrkup(salaryBreakUpModel);
	//	log.debug("salary breakup model"+salaryBreakUpModel);
		empresp = new EmployeeRespDto();

		empresp.setEmployee(empmodel);
		return new ResponseEntity<>(empresp, HttpStatus.CREATED);
		}
//		return empresp;

	}

	@GetMapping("/employee/all")

	public ResponseEntity<List<?>> getallEmp() {

		List<EmpLoyeeInfoEntity> emp = empInfoRepo.findAll();

		List<EmployeeRespDto> empresplist = new ArrayList<EmployeeRespDto>();
		for (EmpLoyeeInfoEntity empLoyeeInfoEntity : emp) {
			EmployeeRespDto empresp = new EmployeeRespDto();
			EmployeeConversionModel empconv = new EmployeeConversionModel();
			SalaryBreakUpModel salemp = new SalaryBreakUpModel();

			salemp.setGrossSalary(empLoyeeInfoEntity.getSalaryBreakupEntity().getGrossSalary());
			salemp.setHra(empLoyeeInfoEntity.getSalaryBreakupEntity().getHra());
			salemp.setConveyance(empLoyeeInfoEntity.getSalaryBreakupEntity().getConveyance());
			salemp.setBasic(empLoyeeInfoEntity.getSalaryBreakupEntity().getBasic());
			salemp.setMedical(empLoyeeInfoEntity.getSalaryBreakupEntity().getMedical());
			salemp.setEducation(empLoyeeInfoEntity.getSalaryBreakupEntity().getEducation());
			salemp.setLta(empLoyeeInfoEntity.getSalaryBreakupEntity().getLta());

			empconv.setEmpName(empLoyeeInfoEntity.getEmpName());
			empconv.setRole(empLoyeeInfoEntity.getRole());
			empconv.setRole(empLoyeeInfoEntity.getRole());
			empconv.setSalbrkup(salemp);
			empresp.setEmployee(empconv);

			empresplist.add(empresp);

		}
		return new ResponseEntity<List<?>>(empresplist, HttpStatus.OK);
		//return empresplist;

	}

	@RequestMapping(value = "/getEmpByName")
	public ResponseEntity<?> getAllDetails(@RequestParam String empName) {
		List<EmpLoyeeInfoEntity> brkInfo = empInfoRepo.findByEmpName(empName);

		EmployeeRespDto empRes = new EmployeeRespDto();
		EmployeeConversionModel ecm = new EmployeeConversionModel();
		SalaryBreakUpModel breakUpModel = new SalaryBreakUpModel();
		for (EmpLoyeeInfoEntity empLoyeeInfoEntity : brkInfo) {
			ecm.setEmpName(empLoyeeInfoEntity.getEmpName());
			ecm.setRole(empLoyeeInfoEntity.getRole());
			breakUpModel.setBasic(empLoyeeInfoEntity.getSalaryBreakupEntity().getBasic());
			breakUpModel.setCityCompAllow(empLoyeeInfoEntity.getSalaryBreakupEntity().getCityCompAllow());
			breakUpModel.setConveyance(empLoyeeInfoEntity.getSalaryBreakupEntity().getConveyance());
			breakUpModel.setGrossSalary(empLoyeeInfoEntity.getSalaryBreakupEntity().getGrossSalary());
			breakUpModel.setHra(empLoyeeInfoEntity.getSalaryBreakupEntity().getHra());
			breakUpModel.setMedical(empLoyeeInfoEntity.getSalaryBreakupEntity().getMedical());
			breakUpModel.setEducation(empLoyeeInfoEntity.getSalaryBreakupEntity().getEducation());
			breakUpModel.setLta(empLoyeeInfoEntity.getSalaryBreakupEntity().getLta());
			ecm.setSalbrkup(breakUpModel);
			empRes.setEmployee(ecm);

		}

		//return empRes;
		return new ResponseEntity<>(empRes, HttpStatus.OK);
	}

	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmpWithsal(@PathVariable(value = "empId") Long empId) {
		empInfoRepo.deleteById(empId);
		return new ResponseEntity<String>("Following Employee Record Deleted Successfully ", HttpStatus.NO_CONTENT);
	}

	public static SalaryBreakupEntity salaryEmployee(Long ctc, @RequestBody EmpLoyeeInfoEntity empInfoo) {
		double basic = DemoConstants.Basic * ctc;

		double hra = DemoConstants.hra * ctc;
		double cityCompall = DemoConstants.genericValue * ctc;
		double conveyance = DemoConstants.genericValue * ctc;
		double medical = DemoConstants.genericValue * ctc;
		double education = DemoConstants.genericValue * ctc;
		double ltc = DemoConstants.genericValue * ctc;

		double grosssalary = basic + hra + cityCompall + conveyance + medical + education + ltc;

		SalaryBreakupEntity breakupEntity = new SalaryBreakupEntity();
		breakupEntity.setBasic(basic);
		breakupEntity.setHra(hra);
		breakupEntity.setCityCompAllow(cityCompall);

		breakupEntity.setConveyance(conveyance);

		breakupEntity.setMedical(medical);

		breakupEntity.setEducation(education);

		breakupEntity.setEmpLoyeeInfoEntity(empInfoo);

		breakupEntity.setGrossSalary(grosssalary);
		breakupEntity.setLta(ltc);

		return breakupEntity;

	}

	@PutMapping("/employee/{empId}/sal/{salId}")
	public EmployeeRespDto updateEmpResp(@PathVariable(value = "empId") Long empId,

			@PathVariable(value = "salId") Long salId, @Valid @RequestBody Employee commentRequest) {
		if (!breakUpRepo.existsById(empId)) {
			throw new EmployeeNotFoundException("empId " + empId + " not found", "validate request properly");
		} else {
			EmpLoyeeInfoEntity empInfoo = new EmpLoyeeInfoEntity();
			empInfoo.setEmpId(commentRequest.getEmpId());
			empInfoo.setEmpName(commentRequest.getEmpName());
			empInfoo.setRole(commentRequest.getRole());
			empInfoo.setSalaryCtc(commentRequest.getSalaryCtc());

			SalaryBreakupEntity salbrkupEnt = EmployeeInfoController.salaryEmployee(commentRequest.getSalaryCtc(),
					empInfoo);
			EmpLoyeeInfoEntity ErespMod = empInfoRepo.save(empInfoo);
			SalaryBreakupEntity salBrkModel = breakUpRepo.save(salbrkupEnt);
			EmployeeRespDto empRes = new EmployeeRespDto();
			EmployeeConversionModel ecm = new EmployeeConversionModel();
			ecm.setEmpName(ErespMod.getEmpName());
			ecm.setRole(ErespMod.getRole());
			empRes.setEmployee(ecm);
			SalaryBreakUpModel salaryBreakUpModel = new SalaryBreakUpModel();
			salaryBreakUpModel.setBasic(salBrkModel.getBasic());
			salaryBreakUpModel.setCityCompAllow(salBrkModel.getCityCompAllow());
			salaryBreakUpModel.setHra(salBrkModel.getHra());
			salaryBreakUpModel.setMedical(salBrkModel.getMedical());
			salaryBreakUpModel.setEducation(salBrkModel.getEducation());
			salaryBreakUpModel.setLta(salBrkModel.getLta());
			salaryBreakUpModel.setConveyance(salBrkModel.getConveyance());

			salaryBreakUpModel.setConveyance(salBrkModel.getConveyance());
			salaryBreakUpModel.setGrossSalary(salBrkModel.getGrossSalary());
			ecm.setSalbrkup(salaryBreakUpModel);
			empRes.setEmployee(ecm);

			return empRes;

		}
		
		

	}
	
	 private static boolean containsString(String testString, List<String> list) 
	   {
	        return list.contains(testString);
	   }

}
