<a href="http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#preface">Hibernate-validator</a>

Custom validation logic
the validation of null values should occur separately in the built-in @NotNull constraint
if ( value == null )
    return true;

Can also disable default constraint violation building and do it manually
context.disableDefaultConstraintViolation();

if ( !value.startsWith( "SN-" ) ) {
    the recommended way is to include "wrongprefix" into your resource bundle to allow for internationalization
    String wrongPrefix = "{com.acme.constraint.SerialNumber.wrongprefix}";
    context.buildConstraintViolationWithTemplate( wrongPrefix )
        .addConstraintViolation();
    return false;
}
if ( value.length() != length ) {
String wrongLength = "{com.acme.constraint.SerialNumber.wronglength}";
context.buildConstraintViolationWithTemplate( wrongLength )
    .addConstraintViolation();
return false;
}
return true;