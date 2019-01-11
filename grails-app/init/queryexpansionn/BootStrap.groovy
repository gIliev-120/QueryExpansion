package queryexpansionn

import enums.UserRoles
import org.jasypt.util.password.BasicPasswordEncryptor

class BootStrap {

    def init = { servletContext ->
        User.saveAll(
                new User(firstName: "Admin",lastName:"Admin",email :"admin@admin.com",password:new BasicPasswordEncryptor().encryptPassword("admin"),role: UserRoles.ADMINISTRATOR),
                new User(firstName: "Georgi",lastName:"Iliev",email :"g.iliev96@gmail.com",password:new BasicPasswordEncryptor().encryptPassword("1996iliev"),role: UserRoles.USER),
        )
    }
    def destroy = {
    }
}
