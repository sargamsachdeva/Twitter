package com.rxlogix.twitter

import grails.plugin.springsecurity.annotation.Secured

class DemoController {

    @Secured('ROLE_USER')
    def index() {

        render "hello from demo index()"
    }
}
