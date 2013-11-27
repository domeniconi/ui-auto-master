package com.projectodenico.tests

import com.globant.projectodenico.ui.model.HomePage
import com.globant.projectodenico.ui.model.ClientsPage
import geb.Browser
import org.apache.log4j.Logger
import org.openqa.selenium.Keys
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: n.domeniconi
 * Date: 26/11/13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
class CreateNewClient {
    static Logger LOG = Logger.getLogger(CreateNewClient);


    @BeforeClass(groups = ["smoke"])
    static void setUp(){

    }

    @AfterClass(groups = ["smoke"])
    static void tearDown(){
    }

    @Test(groups = ["smoke"])
    void 'Me mando un mail'() throws Exception {

        Browser.drive {
            to HomePage
            LOG.info('Starting loging process')
            goToClients()
            LOG.info('EXACTO (?)')

            newClient()


            /*toField << "${com.globant.projectodenico.common.Properties.usuario}@yahoo.com.ar"
            toField << Keys.chord(Keys.ENTER)  //es para los botones que se habilitan cuando cambias de input
            subject << 'mi primer automation de UI'

            saveDraft()

            goToDrafts()

            assert emailsList.find(".list-view-item-container").size() > 0, "No hay drafts en la lista"

            assert emailsList.find(".list-view-item-container")[0].find('.from').find('span.name').text() == "${com.globant.projectodenico.common.Properties.usuario}@yahoo.com.ar", 'AVENGE ME!!'
            assert emailsList.find(".list-view-item-container")[0].find('.subj').find('span.subject').text() == 'mi primer automation de UI', 'algo paso'

            selectAllDrafts()

            deleteDrafts()              */

        }
    }
}
