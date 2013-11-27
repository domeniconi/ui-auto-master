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
        newClientBtn {
            waitFor{$("#btnCreateNewClient").isDisplayed()}
            $("#btnCreateNewClient")
        }


        createBtn (required: false) {$("#SetupModule_btnCreateClient_input")}
        /*
        sendBtn(required:false) {$("#btn-send a")}

        closeComposeEmail(required:false) {$(".compose-header .qr-card-actions a")}

        saveDraftBtn(required: false) {$('#SaveDraftModalOverlay')}

        toField(required:false) {$('.cm-to-field')}

        subject(required:false) {$('#subject-field')}

        inboxBtn(required: false) {$(".btn-inbox")}

        draftBtn(required: false) {$('.btn-drafts')}

        selectAllDraftsBtn(required: false) {$("#btn-ml-cbox input")}

        deleteBtn(required: false) {$('#btn-delete')}

        emailsList(required: false) {$("#msg-list")}   */
    }

    void newClient(){
        newClientBtn.click()
        waitFor {
             createBtn.isDisplayed()
        }
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
