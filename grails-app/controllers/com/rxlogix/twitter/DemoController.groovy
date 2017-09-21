package com.rxlogix.twitter

import grails.plugin.springsecurity.annotation.Secured

class DemoController {

    def rxMailNotificationService

    @Secured('ROLE_USER')
    def index() {
        rxMailNotificationService.sendMail(["sargam.sachdeva@rxlogix.com"], "test", "Hello Rxlogix World!!")
        render "Success"
    }
}
