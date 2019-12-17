package ru.svirida.service.impl;


import org.springframework.stereotype.Service;
import ru.svirida.service.Estimate;

@Service
public class EstimateImpl implements Estimate {

    @Override
    public String giveEstimate(Integer mark) {
        String estimate = "";
        switch (mark) {
            case (1):
                estimate = "Очень плохо! Вы ответили на 1 вопрос!";
                break;
            case (2):
                estimate = "Плохо! Вы ответили на 2 вопроса!";
                break;
            case (3):
                estimate = "Удовлетворительно! Вы ответили на 3 вопроса!";
                break;
            case (4):
                estimate = "Хорошо! Вы ответили на 4 вопроса!";
                break;
            case (5):
                estimate = "Отлично! Вы ответили на 5 вопросов!";
                break;
            default:
                estimate = "Вы не прошли тестирование. Попробуйте в другой раз";
                break;
        }
        System.out.println(estimate);
        return estimate;
    }
}
