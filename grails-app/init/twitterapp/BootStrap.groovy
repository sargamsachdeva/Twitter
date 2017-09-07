package twitterapp

import com.rxlogix.twitter.Role
import com.rxlogix.twitter.User
import com.rxlogix.twitter.UserRole

class BootStrap {

    def init = { servletContext ->

        def userRole = new Role(authority: 'ROLE_USER').save()

        def testUser1 = new User(username: 'sargam', password: 'password').save()
        def testUser2 = new User(username: 'priya', password: '123456').save()
        def testUser3 = new User(username: 'ankit', password: 'password').save()
        def testUser4 = new User(username: 'shiva', password: '123456').save()



        UserRole.create testUser1, userRole
        UserRole.create testUser2, userRole
        UserRole.create testUser3, userRole
        UserRole.create testUser4, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
    def destroy = {
    }
}
