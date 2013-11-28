import org.openqa.selenium.Platform

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.internal.ProfilesIni
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.Alert


domUser = 'itt.internaluser01';
domPass = 'Password1234'
baseUrl = 'http://itt.internaluser01:Password1234@masterfiles-tstua.insidemedia.net/Home/Index#'
autoClearCookies = false
cacheDriverPerThread = true
quitCacheDriverOnShutdown = true

ProfilesIni allProfiles = new ProfilesIni()

FirefoxProfile profile = allProfiles.getProfile('default')//new FirefoxProfile();
profile.setPreference("network.http.phishy-userpass-length", 255);
profile.setPreference("network.automatic-ntlm-auth.trusteduris","masterfiles-tstua.insidemedia.net");


// default is to use firefox
driver = {
    def d = new FirefoxDriver(profile)
    d.manage().window().maximize()
    return d
}


waiting {
	timeout = 20

    presets {
        slow {
            timeout = 360
            retryInterval = 15
        }
        fast {
            timeout = 15
            retryInterval = 2
        }
        quick {
            timeout = 5
        }
    }
}
reportOnTestFailureOnly = true
reportsDir = "src/test/reports"

username = 'USERNAME'
password = 'PASSWORD'

String ChromeLocalRemoteDriverURL = "http://localhost:9515"

environments {
   'remote-ie' {
	   driver = {
		   DesiredCapabilities capabillities =	DesiredCapabilities.internetExplorer()
		   capabillities.setCapability("platform", Platform.XP)
		   capabillities.setCapability("selenium-version", "2.23.0")
           capabillities.setCapability("name", "ui-automation")
		   capabillities.setCapability("version", "8");
           capabillities.setCapability("name", "ch-ui-automation")
           capabillities.setCapability("command-timeout", 300)
           capabillities.setCapability("idle-timeout", 300)
           capabillities.setCapability("screen-resolution", "1280x1024")
           capabillities.setCapability("record-screenshots", false)
           capabillities.setCapability("build", getBuildNumber())
		   new RemoteWebDriver(new URL(remoteURL), capabillities)
	   }
   }

    'remote-ie-9' {
        driver = {
            DesiredCapabilities capabillities =	DesiredCapabilities.internetExplorer()
            capabillities.setCapability("platform", Platform.VISTA)
            capabillities.setCapability("selenium-version", "2.23.0")
            capabillities.setCapability("name", "ui-automation")
            capabillities.setCapability("version", "9");
            capabillities.setCapability("name", "ch-ui-automation")
            capabillities.setCapability("command-timeout", 300)
            capabillities.setCapability("idle-timeout", 300)
            capabillities.setCapability("screen-resolution", "1280x1024")
            capabillities.setCapability("record-screenshots", false)
            capabillities.setCapability("build", getBuildNumber())
            new RemoteWebDriver(new URL(remoteURL), capabillities)
        }
    }
   
   'local-chrome'{
	   driver = {
           DesiredCapabilities capabillities = DesiredCapabilities.chrome()
           capabillities.setCapability("build", getBuildNumber())
		   new RemoteWebDriver(new URL(ChromeLocalRemoteDriverURL), capabillities)
	   }
   }
   
   'remote-chrome'{
	   driver = {
		   DesiredCapabilities capabillities = DesiredCapabilities.chrome()
		   capabillities.setCapability("platform", Platform.XP)
		   capabillities.setCapability("selenium-version", "2.23.0")
		   capabillities.setCapability("name", "ch-ui-automation")
           capabillities.setCapability("command-timeout", 300)
           capabillities.setCapability("idle-timeout", 300)
           capabillities.setCapability("screen-resolution", "1280x1024")
           capabillities.setCapability("record-screenshots", false)
           capabillities.setCapability("build", getBuildNumber())

		   def drvr = new RemoteWebDriver(new URL(remoteURL), capabillities)
		   drvr.setFileDetector(new LocalFileDetector())
		   drvr
	   }
   }

   'remote-ff'{
	   driver = {
		   DesiredCapabilities capabillities = DesiredCapabilities.firefox()
		   capabillities.setCapability("version", "11")
		   capabillities.setCapability("platform", Platform.XP)
		   capabillities.setCapability("selenium-version", "2.23.0")
           capabillities.setCapability("name", "ch-ui-automation")
           capabillities.setCapability("command-timeout", 300)
           capabillities.setCapability("idle-timeout", 300)
           capabillities.setCapability("screen-resolution", "1280x1024")
           capabillities.setCapability("record-screenshots", false)
           capabillities.setCapability("build", getBuildNumber())
		   
		   def drvr = new RemoteWebDriver(new URL(remoteURL), capabillities)
		   drvr.setFileDetector(new LocalFileDetector())
		   drvr
	   }
   }
}


def getBuildNumber(){
    def buildNumber = (System.properties.getProperty('geb.build.baseUrl') + '_version_/').toURL().getText()
    buildNumber.substring(buildNumber.indexOf('<h1') + 13 , buildNumber.indexOf('</h1'))
}


