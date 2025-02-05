import java.util.Optional;

interface UserService {

    default String getWelcomeMessage() {
        return "Welcome, Guest!";
    }

    Optional<String> getUser(String name);
}

class UserServiceImpl implements UserService {

    @Override
    public Optional<String> getUser(String name) {
        if (name == null || name.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(name);
    }
}

public class UserServiceEx {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        String welcomeMessage1 = userService.getUser("Viswa")
                .map(name -> "Welcome, " + name + "!")
                .orElse(userService.getWelcomeMessage());  
        System.out.println(welcomeMessage1);

        String welcomeMessage2 = userService.getUser("")
                .map(name -> "Welcome, " + name + "!")
                .orElse(userService.getWelcomeMessage());  
        System.out.println(welcomeMessage2); 
    }
}
