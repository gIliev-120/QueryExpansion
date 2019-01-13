package queryexpansionn

import enums.UserRoles
import org.jasypt.util.password.BasicPasswordEncryptor

class UserLoginController {


    def register() {
        render(view:'regisger')
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
        //TODO FIX MAIL ENCODING
        sendMail {
            to user.email
            subject g.message(code :'mail.subject')
            text g.message(code:'mail.body',args:[user.firstName,user.email,params.password]);
        }

        redirect(controller: "Search", action: "index");
    }

    def login(){
        render(view:'login')
    }
    def logOut(){
        session.invalidate();
        redirect(controller: "home",action: "index")
    }

    def logUser(){

        println params;
        User currentUser = User.findByEmail(params.email)
        if(currentUser==null){
                flash.error = "USER NOT FOUND!"
                redirect(action: 'login');
        }else{
            if(new BasicPasswordEncryptor().checkPassword(params.password,currentUser.password)){
                session["user"]=currentUser;
                if(UserRoles.ADMINISTRATOR.equals(currentUser.role)){
                    redirect(controller: 'admin',action: 'index');
                }else if(UserRoles.USER.equals(currentUser.role)){

                    redirect(controller: "search",action:"index")
                }


            }else{
                flash.error = "Wrong Email/Password!"
                redirect(action: 'login');
            }
        }

    }
}
