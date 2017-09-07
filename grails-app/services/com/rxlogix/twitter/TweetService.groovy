package com.rxlogix.twitter

import com.rxlogix.twitter.User
import grails.transaction.Transactional

@Transactional
class TweetService {

    def springSecurityService

    void makeFriend(User user) {
        /*def user1 = User.find(user)
        println("user in service: "+user)
        if (user1) {
        */
        println("user in service: "+user)
        def currentUser = springSecurityService.currentUser
            currentUser.addToFollowers(user)
        //}
    }

}
