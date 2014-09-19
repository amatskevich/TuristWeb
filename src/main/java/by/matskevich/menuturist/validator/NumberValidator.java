package by.matskevich.menuturist.validator;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author a_matskevich
 */
@FacesValidator("numberValidator")
public class NumberValidator implements Validator {

    private final Pattern pattern;
    
    private static final String NUMBER_PATTERN = "(?!^0*$)(?!^0*\\.0*$)^\\d{1,3}(\\.\\d{1,3})?$";

    public NumberValidator() {
        pattern = Pattern.compile(NUMBER_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }
        if(!pattern.matcher(value.toString()).matches()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error",
                        value + " is not a valid email;"));
        }
    }
}
