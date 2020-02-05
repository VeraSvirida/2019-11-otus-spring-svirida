package ru.svirida.service.impl;

import org.springframework.stereotype.Service;
import ru.svirida.domain.Person;
import ru.svirida.domain.Question;
import ru.svirida.service.Estimate;
import ru.svirida.service.QuestionReader;
import ru.svirida.service.Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class TestingImpl implements Testing {

    private final QuestionReader questionReader;
    private final Estimate estimate;
    private ResourceBundle resourceBundle;

    public TestingImpl(QuestionReader questionReader, Estimate estimate, ResourceBundle resourceBundle) {
        this.questionReader = questionReader;
        this.estimate = estimate;
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void makeTesting() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String answer;
            Integer mark = 0;
            System.out.println(resourceBundle.getString("input.name"));
            String secondName = reader.readLine();
            System.out.println(resourceBundle.getString("input.surename"));
            String firstName = reader.readLine();
            Person person = new Person();
            person.setFirstName(firstName);
            person.setSecondName(secondName);
            System.out.println(resourceBundle.getString("hello.user") + secondName + " " + firstName + "! " + resourceBundle.getString("output.answer"));
            List<Question> questionList = questionReader.readFile();
            for (Question question : questionList) {
                System.out.println(question.getQuestion());
                answer = reader.readLine().trim().toLowerCase();
                if (answer.equals(question.getAnswer().trim().toLowerCase())) {
                    mark++;
                }
            }
            estimate.giveEstimate(mark);
        }
    }
}
