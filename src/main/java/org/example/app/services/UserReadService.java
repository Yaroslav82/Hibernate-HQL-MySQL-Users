package org.example.app.services;

import lombok.AllArgsConstructor;
import org.example.app.entities.User;
import org.example.app.repositories.UserReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class UserReadService {

    private final UserReadRepository repository;

    public String readUsers() {
        List<User> list = repository.readUsers();

        if (list != null) {

            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((user) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(user.getId())
                                .append(", ")
                                .append(user.getUserName())
                                .append(", ")
                                .append(user.getFirstName())
                                .append(" ")
                                .append(user.getLastName())
                                .append(", ")
                                .append(user.getEmail())
                                .append("\n")
                );
                return "\n___________ USERS ___________\n" + stringBuilder;
            }
        }
        return Constants.DATA_ABSENT_MSG;
    }
}
