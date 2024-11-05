package testpkg;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepkg.CuraHealthBaseClass;
import pagepkg.CuraHealthPageClass;

public class CuraHealthTestClass extends CuraHealthBaseClass {
    private CuraHealthPageClass curaHealthPage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup(); // Initialize WebDriver and navigate to the page
        curaHealthPage = new CuraHealthPageClass(driver); // Initialize the page class
    }

    @Test
    public void testLogin() throws InterruptedException {
        curaHealthPage.login(); // Perform the login action
        // Add assertions here to verify successful navigation to the telemedicine page
    }

    @Test
    public void testSubmitValues() throws Exception {
        curaHealthPage.values(); // Fill in the form and upload the file
        
        // Add assertions to verify that the values were submitted correctly
        // This may involve checking for confirmation messages or the presence of expected elements
        // For example:
        // Assert.assertTrue(driver.findElement(By.id("confirmationMessageId")).isDisplayed(), "Confirmation message not displayed.");
    }
    @Test
    public void testconfirm()
    {
    	curaHealthPage.confirm();
    }
    @Test
    public void testwindowhandle() throws Exception
    {
    	curaHealthPage.windowhandle();
    }

   
}
