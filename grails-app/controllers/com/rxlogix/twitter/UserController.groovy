package com.rxlogix.twitter

import co.UserCO
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class UserController {

    def tweetService
    def springSecurityService
    def userService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userCount: User.count(), userList: User.list(params)]
    }

    def show(User user) {
        [user: user, messages: Tweet.findAllByUser(user, [max: 10, sort: "dateCreated", order: "desc" ] )]
    }

    def makeFriend() {

        def user = User.get(params.id)
        userService.makeFriend(user)
        flash.message = "Friend list updated!!"
        redirect action: 'index'
    }

    def register(UserCO command) {
        log.debug "params for register action :"+params
        if (!command.validate())
        {
            command.errors.allErrors.each{ log.debug "error while saving User :"+it }
            render template:"/user/userSaveError",model: [command:command]
            return
        }
        else{
            //save user data
        }
    }
}
