package queryexpansionn

class User {
    String firstName;
    String lastName;
    String email;
    String password;
    Role role;

    static constraints = {
        firstName blank: false
        lastName blank: false
        email blank: false,email: true
        password blank: false
    }

    static mapping = {
        version false
    }
}
