package ru.svirida.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.svirida.service.Estimate;

import static org.hamcrest.core.Is.is;


public class EstimateImplTest {

    private Estimate estimate;

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        estimate = context.getBean(Estimate.class);
    }

    @Test
    public void whenStudentHasRateFourth() {
        Assert.assertThat(estimate.giveEstimate(4), is("Хорошо! Вы ответили на 4 вопроса!"));
    }

}