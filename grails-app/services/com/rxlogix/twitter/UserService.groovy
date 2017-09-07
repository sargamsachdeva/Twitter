package com.rxlogix.twitter

import grails.transaction.Transactional

@Transactional
class UserService {

    def springSecurityService

    def makeFriend(def user){
        def currentUser = springSecurityService.currentUser
        println("user in make friend "+user)
        def follower=currentUser.followers.find(){
            it.username == user.username
        }
        if(user && !follower) {
            currentUser.addToFollowers(user)
            currentUser.save(flush:true)
        }

        else {
            currentUser.removeFromFollowers(user)
            currentUser.save(flush:true)
        }
    }
}
