package com.rxlogix.twitter

import com.rxlogix.twitter.User
import grails.transaction.Transactional

@Transactional
class TweetService {

    def springSecurityService

    void unfriend(String username) {
        def user = User.findByUsername(username)
        if (user) {
            def currentUser = springSecurityService.currentUser
            currentUser.removeFromFollowers(user)
        }
    }

    void makeFriend(String username) {
        def user = User.findByUsername(username)
        if (user) {
            def currentUser = springSecurityService.currentUser
            currentUser.addToFollowers(user)
        }
    }
}
