package ru.svirida.service;

import ru.svirida.domain.Question;

import java.util.List;

public interface QuestionReader {
    List<Question> readFile();
}
