package queryexpansionn

class Role {
    String roleName;

    static constraints = {
        roleName blank: false
    }
    static mapping = {
        version false
    }
}
