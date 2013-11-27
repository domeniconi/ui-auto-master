package com.globant.projectodenico.ui.model

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: n.domeniconi
 * Date: 26/11/13
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
class HomePage extends Page {

    waitFor('slow'){
        $('.selectedItem').isDisplayed()
    }
    static at = { title == "Welcome to the Master File Administration Site" }
   /* private static final String DEFAULT_USERNAME = com.globant.projectodenico.common.Properties.usuario
    private static final String DEFAULT_PASSWORD = com.globant.projectodenico.common.Properties.password   */

    /**
     * Page content elements
     */
    static content = {


        clientBtn(to: ClientsPage) {$('.selectedItem')}
            /*signinBox(required:false){ $("#yreglg") }
            username(required: false){ signinBox.find("#username")}
            password(required: false){ signinBox.find("#passwd")}
            loginBtn(to: MailsPage) {signinBox.find("#submit button")} */

        }
            void goToClients () {
                clientBtn.click()

                waitFor('slow') {
            $('#btnCreateNewClient').isDisplayed()
        }
    }
    /**
     * Types user and password data and clicks login button
     */
    /*

    void login(Map credentials)
    {
        browser.clearCookiesQuietly()
        //por si le queres pasar credenciales en los tests pero no esta bueno
        String user = credentials?.username ?: configValue('username', DEFAULT_USERNAME)
        String passwd = credentials?.password ?: configValue('password', DEFAULT_PASSWORD)

        username << user
        password << passwd

        loginBtn.click()

        waitFor('slow') {
            $('.btn-compose').isDisplayed()
        }

    }
           */
    private String configValue(String name, String defaultValue) {
        browser.config.readValue name, defaultValue
    }
}

