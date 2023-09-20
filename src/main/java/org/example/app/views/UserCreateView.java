package org.example.app.views;

import java.util.Scanner;

public class UserCreateView extends BaseView {

    @Override
    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter username: ";
        System.out.print(title);
        String userName = scanner.nextLine().trim();

        title = "Enter first name: ";
        System.out.print(title);
        String firstName = scanner.nextLine().trim();

        title = "Enter last name: ";
        System.out.print(title);
        String lastName = scanner.nextLine().trim();

        title = "Enter email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        return new String[]{userName, firstName, lastName, email};
    }
}
