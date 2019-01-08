package queryexpansionn

import org.jasypt.util.password.BasicPasswordEncryptor

class UserLoginController {

    def register() {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encPassword = passwordEncryptor.encryptPassword("1996iliev");
        println encPassword;

        if(passwordEncryptor.checkPassword("1996iliev",encPassword)){
            println("yayaaay");
        }
        render(text: "WILL REGISTER");
    }

    def login(){
        render(text: "WILL LOGIN");
    }
}
