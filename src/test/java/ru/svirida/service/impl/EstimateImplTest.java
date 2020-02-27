package ru.svirida.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.util.Assert;
import ru.svirida.Main;
import ru.svirida.service.Estimate;


@SpringBootTest(classes = Main.class, properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class EstimateImplTest {
    @Autowired
    private Estimate estimate;

    @Test
    public void whenStudentHasRateFourth() {
        Assert.hasText(estimate.giveEstimate(4), "Хорошо! Вы ответили на 4 вопроса!");
    }

}