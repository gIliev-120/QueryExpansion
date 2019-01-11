package queryexpansionn

import enums.UserRoles
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
        user.firstName=params.firstName;
        user.lastName=params.lastName;
        user.email=params.email;
        user.password= new BasicPasswordEncryptor().encryptPassword(params.password);
        user.role = UserRoles.USER;
        user.save();

        session["user"]=user;

        redirect(controller: "Search", action: "index");
    }

    def login(){
        render(view:'login')

    }

    def logUser(){

        println params;
        User currentUser = User.findByEmail(params.email)
        if(currentUser==null){
            render "NO USER FOUND";
        }else{
            if(new BasicPasswordEncryptor().checkPassword(params.password,currentUser.password)){
                if(UserRoles.ADMINISTRATOR.equals(currentUser.role)){
                    render "ADMIN AUTHENTICATED";
                }else if(UserRoles.USER.equals(currentUser.role)){
                    session["user"]=currentUser;
                    redirect(controller: "search",action:"index")
                }


            }else{
                render "USER NOT AUTHENTICATED";
            }
        }

    }
}
