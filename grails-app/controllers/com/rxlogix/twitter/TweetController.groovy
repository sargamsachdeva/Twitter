package com.rxlogix.twitter

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class TweetController {

    def springSecurityService

    /*def index(){
    }

    def listTweets() {

        def messages = userTweets()
        render template: 'messages', collection: messages, var: 'message'
    }

    def updateTweets() {

        def tweet = new Tweet(message: params.message)
        tweet.user = User.get(springSecurityService.principal.id)
        tweet.likes=0
        tweet.save(flush:true)
        render model: [id:tweet.id], action:'listTweets'
        render(template:'messages', model: [id:tweet.id])
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

    def likeTweet(Long id){

       // def messages = userTweets()
        println("params.id: "+messages.message.id)
        def tweet = Tweet.get(id)
        println("tweet id: "+tweet)
        tweet.likes = tweet.likes + 1
        tweet.save(flush:true)
        println("likes: "+tweet.likes)
        render model: [likes:tweet.likes]
    }*/

    def index(){
        def messages=userTweets()
        return [messages:messages]
    }

    def updateTweets() {

        def tweet = new Tweet(message: params.message)
        tweet.user = User.get(springSecurityService.principal.id)
        tweet.likes=0
        tweet.save(flush:true)
        def messages=userTweets()
        //render model: [id:tweet.id], action:'listTweets'
        render(template:'messages', collection: messages,var:'message')
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


    def likeTweet(Long id){
        def tweet = Tweet.get(id)
        println("tweet id: "+tweet)
        tweet.likes = true
        tweet.save(flush:true)
        println("likes: "+tweet.likes)
        flash.message="You have liked the post.."
        render model: [likes:tweet.likes]
        //return tweet
    }
}
