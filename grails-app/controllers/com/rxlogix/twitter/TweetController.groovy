package com.rxlogix.twitter

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class TweetController {

    def springSecurityService

    def index(){
        def messages=userTweets()
        return [messages:messages]
    }

    def updateTweets() {

        def tweet = new Tweet(message: params.message)
        tweet.user = User.get(springSecurityService.principal.id)
        tweet.likes=false
        tweet.save(flush:true,failOnError:true)
        def messages=userTweets()
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
    }

    def profile() {
        def messages = timeline
        def person = springSecurityService.currentUser
        def totalStatusCount = Tweet.where { user.username == person.username }.count()

        def following = person.followers
        def followers = User.where { followers.username == person.username }.list()
        def otherUsers = User.list() - following - followers - person

        [statusMessages: messages,
         person: person,
         totalStatusCount: totalStatusCount,
         following: following,
         followers: followers,
         otherUsers: otherUsers]
    }


    def getTimeline() {
        String username = springSecurityService.currentUser
        def person = User.findByUsername(username)
        if (person) {
            def query = Tweet.whereAny {
                user == person
                user in person.followers
            }
            query.list(max: 10, sort: 'dateCreated', order: 'desc')
        }
    }

}
