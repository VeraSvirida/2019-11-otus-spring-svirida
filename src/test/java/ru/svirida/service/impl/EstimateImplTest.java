package ru.svirida.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.svirida.service.Estimate;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstimateImplTest {
    @Autowired
    private Estimate estimate;

    @Test
    public void whenStudentHasRateFourth() {
        Assert.assertThat(estimate.giveEstimate(4), is("Хорошо! Вы ответили на 4 вопроса!"));
    }

}