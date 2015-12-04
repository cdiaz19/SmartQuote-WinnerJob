package test.java.com.pernix.smartquote.resources;

import main.java.com.pernix.smartquote.resources.ResourceManager;
import org.junit.Assert;
import org.junit.Test;

public class ResourceManagerTest {

    public static final 
    String EXPECTED_URL = "file:/home/cristiandiaz/Desktop/SmartQuote-WinnerProvider/out/production/SmartQuote-WinnerProviderNotifier/XMLDataUser";
    private ResourceManager resourceManager;

    @Test
    public void testCreateResourceManager(){
        resourceManager = new ResourceManager();
        Assert.assertNotNull(resourceManager);
    }

    @Test
    public void testGetResourceURL(){
        resourceManager = new ResourceManager();
        String url = resourceManager.getResourceUrl("XMLDataUser").toString();
        Assert.assertEquals(EXPECTED_URL, url);
    }

    @Test
    public void testGetFileAsString(){

        String fileExpected =   "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" +
                                "<?xml-stylesheet type=\"text/xsl\" href=\"style.xsl\"?>\r\n" +
                                "<paymentInfo>\r\n" +
                                "    <authorization>123456</authorization>\r\n" +
                                "    <card_account_name>ClientePrueba</card_account_name>\r\n" +
                                "    <card_number>************1234</card_number>\r\n" +
                                "    <amount>30000.0</amount>\r\n" +
                                "</paymentInfo>\r\n";

        resourceManager = new ResourceManager();
        String fileAsString = resourceManager.getFileAsString("XMLDataUser");
        Assert.assertEquals(fileExpected, fileAsString );
    }
}
