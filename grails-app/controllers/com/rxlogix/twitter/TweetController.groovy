package com.rxlogix.twitter

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class TweetController {

    def springSecurityService

    def index(){
    }

    def listTweets() {
        def messages = userTweets()
        render template: 'messages', collection: messages, var: 'message'
    }

    def updateTweets() {

        def tweet = new Tweet(message: params.message)
        tweet.user = User.get(springSecurityService.principal.id)
        tweet.save(flush:true)
        forward action:'listTweets'
    }

    def userTweets() {
        
        def userId = User.get(springSecurityService.principal.id)
        println("user: "+userId)
        def tweets = Tweet.createCriteria().list(max:10) {
            user{
                eq('username',userId.username)
            }
            order 'dateCreated', 'desc'
        }

        println("messages in timeline: "+tweets)
        return tweets
    }
}
