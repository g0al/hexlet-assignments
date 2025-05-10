package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import  org.springframework.beans.factory.annotation.Autowired;

import exercise.model.User;
import exercise.component.UserProperties;

@SpringBootApplication
@RestController
public class Application {

    private List<User> users = Data.getUsers();

    @Autowired
    private UserProperties userInfo;

    @GetMapping("/admins")
    public List<String> admins() {
        var adminEmails = userInfo.getAdmins();
        var result = new ArrayList<String>();
        for (var adminEmail : adminEmails) {
            var admin = users.stream()
                    .filter(u -> u.getEmail().equals(adminEmail))
                    .findFirst();
            admin.ifPresent(user -> result.add(user.getName()));
        }
        return result;
    }

    @GetMapping("/users")
    public List<User> index() {
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Long id) {
        var user = users.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
