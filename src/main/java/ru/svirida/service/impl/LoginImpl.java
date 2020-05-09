package ru.svirida.service.impl;

import org.springframework.stereotype.Service;
import ru.svirida.domain.Person;
import ru.svirida.service.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

@Service
public class LoginImpl implements Login {
    private ResourceBundle resourceBundle;

    @Override
    public String login() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(resourceBundle.getString("input.name"));
            String firstName = reader.readLine();
            System.out.println(resourceBundle.getString("input.surename"));
            String secondName = reader.readLine();
            Person person = new Person();
            person.setFirstName(firstName);
            person.setSecondName(secondName);
            System.out.println(resourceBundle.getString("hello.user") + secondName + " " + firstName + "! " + resourceBundle.getString("output.answer"));
            return firstName + " " + secondName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
