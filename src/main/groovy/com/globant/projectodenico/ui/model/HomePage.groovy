package com.globant.projectodenico.ui.model

import geb.Page
import org.openqa.selenium.Alert

/**
 * Created with IntelliJ IDEA.
 * User: n.domeniconi
 * Date: 26/11/13
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
class HomePage extends Page {


    static at = { title == "Welcome to the Master File Administration Site" }
   /* private static final String DEFAULT_USERNAME = com.globant.projectodenico.common.Properties.usuario
    private static final String DEFAULT_PASSWORD = com.globant.projectodenico.common.Properties.password   */

    /**
     * Page content elements
     */
    static content = {

        menu(required:false){$('#menu')}
        clientBtn(to: ClientsPage) {$('li', text:'Clients').find('a')}
            /*signinBox(required:false){ $("#yreglg") }
            username(required: false){ signinBox.find("#username")}
            password(required: false){ signinBox.find("#passwd")}
            loginBtn(to: MailsPage) {signinBox.find("#submit button")} */

        }


    void onLoad(Page pPage){

        Alert alert = driver.switchTo().alert()
        alert.accept()
        waitFor('fast'){
            menu.isDisplayed()
        }
    }

    void goToClientsPage() {
        clientBtn.click()
    }

    private String configValue(String name, String defaultValue) {
        browser.config.readValue name, defaultValue
    }
}

