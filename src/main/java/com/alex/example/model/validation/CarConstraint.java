package com.alex.example.model.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = { CarValidator.class })
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CarConstraint {

    // @NotNull(message="would be nice if we had one")
    String message() default "{com.alex.example.model.validation.carconstraint.message}";

    // public interface MyGroup
    // @CarConstraint(groups = MyGroup.class)
    // validator.validate(car, MyGroup.class)
    // no group = Default group
    // groups control the order of constraint evaluation
    Class<?>[] groups() default {};

    // Payload associates metadata info with a given constraint
    // public class Severity
    //   public static class Info implements Payload
    //   public static class Error implements Payload
    //   @NotNull(message="would be nice if we had one", payload=Severity.Info.class)
    Class<? extends Payload>[] payload() default {};

    // when the validation constraint can be applied to different targets e.g method params, type, field
//    @CarConstraint(
//        message="Please check that your passwords match and try again.",
//        expression="param[1]==param[2]",
//        validationAppliesTo=ConstraintType.PARAMETERS
//    )
//    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;
}
