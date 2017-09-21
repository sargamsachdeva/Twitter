package co

import grails.validation.Validateable

class UserCO implements Validateable{

    String name
    String emailId
    String password
    def userService
    static constraints = {
    }
}
