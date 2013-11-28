package com.projectodenico.tests

import com.globant.projectodenico.ui.model.HomePage
import geb.Browser
import org.apache.log4j.Logger
import org.openqa.selenium.Alert
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
    static private CLIENT_NAME = 'NicoTest1'

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

            goToClientsPage()
            LOG.info('EXACTO (?)')

            goToCreateNewClient()

            clientName << CLIENT_NAME

            submitNewClientInformation()

            assert clientName.value() == CLIENT_NAME, 'Client Name does not match input value'



        }
    }
}
