/*
 * package com.poc.springboot.Controller;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import javax.validation.Valid; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.domain.Page; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.poc.springboot.Exception.ResourceNotFoundException; import
 * com.poc.springboot.Repo.EmpRepository; import
 * com.poc.springboot.Repo.SalRepository; import
 * com.poc.springboot.entity.SalaryEmployeeEntity;
 * 
 * @RestController public class SalaryEmployeeController {
 * 
 * @Autowired private EmpRepository employee;
 * 
 * @Autowired private SalRepository salaryEmprepo;
 * 
 * @PostMapping("/employee/{empId}/salaryPay") public SalaryEmployeeEntity
 * createComment(@PathVariable Long empId,
 * 
 * @Valid @RequestBody SalaryEmployeeEntity salPay) { return
 * employee.findById(empId).map(post -> { salPay.setBookCategory(post); return
 * salaryEmprepo.save(salPay); }).orElseThrow(() -> new
 * ResourceNotFoundException("empId " + empId + " not found")); }
 * 
 * @PutMapping("/employee/{empId}/salaryPay/{salId}") public
 * SalaryEmployeeEntity updateComment(@PathVariable Long empId, @PathVariable
 * Long salId,
 * 
 * @Valid @RequestBody SalaryEmployeeEntity salPay) { if
 * (!employee.existsById(empId)) { throw new ResourceNotFoundException("empId "
 * + empId + " not found"); }
 * 
 * return salaryEmprepo.findById(salId).map(sal -> {
 * sal.setBasic(salPay.getBasic());
 * sal.setCityCompAllow(salPay.getCityCompAllow()); sal.setHra(salPay.getHra());
 * return salaryEmprepo.save(sal); }).orElseThrow(() -> new
 * ResourceNotFoundException("salId " + salId + "not found")); }
 * 
 * 
 * @DeleteMapping("/employee/{empId}") public void deleteStudent(@PathVariable
 * long empId) { employee.deleteById(empId); }
 * 
 * @GetMapping("/empDetails/{employeeEntity_empId}/salarydet") public List <
 * SalaryEmployeeEntity > getCoursesByInstructor(@PathVariable(value =
 * "employeeEntity_empId") Long employeeEntity_empId) { return
 * salaryEmprepo.findByEmployeeEntityEmpId(employeeEntity_empId); }
 * 
 * 
 * @DeleteMapping("/posts/{empId}") public ResponseEntity<?>
 * deletePost(@PathVariable Long empId) { return
 * postRepository.findById(postId).map(post -> { postRepository.delete(post);
 * return ResponseEntity.ok().build(); }).orElseThrow(() -> new
 * ResourceNotFoundException("PostId " + postId + " not found")); }
 * 
 * 
 * @GetMapping("/posts/{employeeEntity_empId}/comments") public
 * Page<SalaryEmployeeEntity> getAllCommentsByPostId(@PathVariable Long
 * employeeEntity_empId, Pageable pageable) { return
 * salaryEmprepo.findByEmpId(employeeEntity_empId, pageable); }
 * 
 * 
 * 
 * @GetMapping("/posts/{empId}/comments") public Page<SalaryEmployeeEntity>
 * getAllCommentsByPostId(@PathVariable (value = "empId") Long empId, Pageable
 * pageable) { return salaryEmprepo.findByPostId(empId, pageable); }
 * 
 * 
 * 
 * @DeleteMapping("/posts/{empId}/comments/{salId}") public ResponseEntity<?>
 * deleteComment(@PathVariable (value = "empId") Long empId,
 * 
 * @PathVariable (value = "salId") Long salId) { return
 * salaryEmprepo.findByIdAndPostId(salId, empId).map(comment -> {
 * salaryEmprepo.delete(comment); return ResponseEntity.ok().build();
 * }).orElseThrow(() -> new
 * ResourceNotFoundException("Comment not found with id " + salId +
 * " and postId " + empId)); }
 * 
 * 
 * }
 */