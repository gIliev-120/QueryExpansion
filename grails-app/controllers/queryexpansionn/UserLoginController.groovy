package queryexpansionn

import org.jasypt.util.password.BasicPasswordEncryptor

class UserLoginController {

    def register() {
        render(view:'regisger')
        /*BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encPassword = passwordEncryptor.encryptPassword("1996iliev");
        println encPassword;

        if(passwordEncryptor.checkPassword("1996iliev",encPassword)){
            println("yayaaay");
        }*/

    }

    def registerUser(){
        println params;
        User user = new User();


        redirect(controller: "Search", action: "index");
    }

    def login(){
        render(view:'login')

    }

    def logUser(){

    }
}
