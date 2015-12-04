package catalog.angularjs.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgen on 08.09.15.
 */
public class ValidationErrorDTO {

    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public void addFieldError(String path, String message){
        fieldErrors.add(new FieldErrorDTO(path,message));
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
}
