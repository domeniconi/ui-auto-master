package com.globant.projectodenico.ui.model

import geb.Page
import org.apache.log4j.Logger

/**
 * Created with IntelliJ IDEA.
 * User: n.domeniconi
 * Date: 26/11/13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
class ClientsPage extends Page {

    private static final Logger LOG = Logger.getLogger(MailsPage)

//    static url = "console.html"
//    static at = { title == "CloudHub" }

    /**
     * Page content elements
     */
    static content = {

        newClientBtn(required: false) { $("a#btnCreateNewClient")}

        submitBtn(required: false) {$("#SetupModule_btnCreateClient_input")}

        clientName(required:false){$("input#SetupModule_txtClientName")}

        clientInformationHeader(required:false) {$('h2', text:'Client Information')}

    }

    void goToCreateNewClient(){
        newClientBtn.click()
        sleep(10000)
        driver.switchTo().frame(0)
        waitFor('slow'){
            submitBtn.isDisplayed()
        }
    }

    void submitNewClientInformation(){
        submitBtn.click()
        sleep(5000)
        driver.switchTo().defaultContent()
        driver.switchTo().frame(0)
        driver.switchTo().frame(0)

        waitFor('fast'){
            clientInformationHeader.isDisplayed()
        }
    }

    void onLoad(Page pPage){
        waitFor('fast'){
          $('iframe')[0].isDisplayed()
        }
        driver.switchTo().frame(0)
        waitFor('slow'){
            newClientBtn.isDisplayed()
        }
    }

    void onUnload(Page pPage){
        driver.switchTo().defaultContent()
    }
  /*
        void sendMail(){

            sendBtn.click()

            sleep(2000)
        }

        void saveDraft(){
            closeComposeEmail.click()
            waitFor{
                saveDraftBtn.isDisplayed()
            }

            saveDraftBtn.click()
            sleep(2000)
        }

        void selectAllDrafts(){
        selectAllDraftsBtn.click()
        sleep(2000)
    }

    void deleteDrafts(){
        $(".icon-delete").click()
        if(emailsList.find(".list-view-item-container").size() > 0){
            waitFor{
                $("#okModalOverlay").isDisplayed()
            }
            $("#okModalOverlay").click()
            sleep(2000)
        }
    }

    void goToDrafts(){
        draftBtn.click()
        sleep(3000)
    }

    Boolean refreshInbox(tries, interval){

        def flag = false
        def i=0
        while(i < tries){

            if($('#empty-folder-msg').size() > 0){
                LOG.info("refreshing inbox... try n ${i} of ${tries}")
                inboxBtn.click()
            }else{
                flag = true
                break
            }

            sleep(interval)
            i++
        }

        return flag

    }  */

}
