package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN

@Getter
public class UserPage {
    private User user;

    public UserPage(User user) {
        this.user = user;
    }
}
// END
