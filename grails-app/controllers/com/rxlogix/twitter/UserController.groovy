package com.rxlogix.twitter

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class UserController {

    def tweetService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userCount: User.count(), userList: User.list(params)]
    }

    def show(User user) {
        [user: user, messages: Tweet.findAllByUser(user, [max: 10, sort: "dateCreated", order: "desc" ] )]
    }

    def unfriend(String user) {
        tweetService.unfriend(user)
        redirect action: 'index'
    }

    def makeFriend(String user) {
        tweetService.makeFriend user
        redirect action: 'index'
    }
}
