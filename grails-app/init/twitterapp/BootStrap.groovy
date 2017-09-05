package twitterapp

import com.rxlogix.twitter.Role
import com.rxlogix.twitter.User
import com.rxlogix.twitter.UserRole

class BootStrap {

    def init = { servletContext ->

        def userRole = new Role(authority: 'ROLE_USER').save()

        def testUser = new User(username: 'sargam', password: 'password').save()

        UserRole.create testUser, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
    def destroy = {
    }
}
