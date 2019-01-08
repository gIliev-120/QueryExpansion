package queryexpansionn

class HomeController {

    def index() {
        render(view:'index');
    }


    def login(){
        redirect(controller:'userLogin',action:'login')
    }

    def register(){
        redirect(controller:'userLogin',action:'register')
    }
}
