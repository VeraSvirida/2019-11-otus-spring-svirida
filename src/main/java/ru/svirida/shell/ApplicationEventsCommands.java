package ru.svirida.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.svirida.service.impl.TestingImpl;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private String userName;
    private final TestingImpl testing;


    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption({"username", "u"}) String name) {
        userName = name;
        return "Hello, " + userName + "! Lets start test.";

    }

    @ShellMethod(value = "Testing command", key = {"t", "test"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String testing() {
        testing.makeTesting();
        return "Тестирование завершено";
    }

    private Availability isPublishEventCommandAvailable() {
        return userName == null ? Availability.unavailable("Сначала залогиньтесь") : Availability.available();
    }
}
