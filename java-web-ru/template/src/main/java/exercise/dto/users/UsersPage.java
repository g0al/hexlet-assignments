package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

// BEGIN

@AllArgsConstructor
@Getter
public class UsersPage {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}
// END
