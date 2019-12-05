package ru.svirida.service.impl;

import ru.svirida.domain.Person;
import ru.svirida.domain.Question;
import ru.svirida.service.Estimate;
import ru.svirida.service.QuestionReader;
import ru.svirida.service.Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TestingImpl implements Testing {

    private final QuestionReader questionReader;
    private final Estimate estimate;

    public TestingImpl(QuestionReader questionReader, Estimate estimate) {
        this.questionReader = questionReader;
        this.estimate = estimate;
    }

    @Override
    public void makeTesting() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String answer;
            Integer mark = 0;
            System.out.println("Введите ваше Имя");
            String secondName = reader.readLine();
            System.out.println("Введите вашу фамилию");
            String firstName = reader.readLine();
            Person person = new Person();
            person.setFirstName(firstName);
            person.setSecondName(secondName);
            System.out.println("Добрый день, " + firstName + " " + secondName + "! Ответьте на 5 вопросов:");
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
