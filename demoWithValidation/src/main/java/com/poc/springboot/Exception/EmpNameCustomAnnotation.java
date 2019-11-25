/*
 * package com.poc.springboot.Exception;
 * 
 * import java.lang.annotation.Documented; import
 * java.lang.annotation.ElementType; import java.lang.annotation.Retention;
 * import java.lang.annotation.RetentionPolicy; import
 * java.lang.annotation.Target;
 * 
 * import javax.validation.Constraint; import javax.validation.Payload;
 * 
 * @Documented
 * 
 * @Constraint(validatedBy = ContactNumberValidator.class)
 * 
 * @Target({ ElementType.METHOD, ElementType.FIELD,ElementType.TYPE })
 * 
 * @Retention(RetentionPolicy.RUNTIME) public interface EmpNameCustomAnnotation
 * {
 * 
 * String message() default "Invalid Employee Name"; Class<?>[] groups() default
 * {}; Class<? extends Payload>[] payload() default {};
 * 
 * }
 */