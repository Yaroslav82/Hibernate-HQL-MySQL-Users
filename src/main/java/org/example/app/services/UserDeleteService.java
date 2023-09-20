package org.example.app.services;

import lombok.AllArgsConstructor;
import org.example.app.entities.User;
import org.example.app.exceptions.EditException;
import org.example.app.repositories.UserDeleteRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UserDeleteService {

    private final UserDeleteRepository repository;

    public String deleteUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new EditException("Check inputs", errors);
            } catch (EditException ue) {
                return ue.getErrors();
            }
        }

        return repository.deleteUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}
