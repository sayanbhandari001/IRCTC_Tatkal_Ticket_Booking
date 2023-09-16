package org.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties configProp;

    //this is to read files from Config.properties Files
    public Properties init_prop()  {
        //Load properties File
        configProp = new Properties();
        FileInputStream configPropfile = null;
        try {
            configPropfile = new FileInputStream("./src/test/Resources/PleaseEnterUserInformationHere/config.properties");
            configProp.load(configPropfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProp;
    }
}
//Logging
//        logger = Logger.getLogger("nopCommerceSDET");
//        PropertyConfigurator.configure("Log4j.properties");
//        logger.setLevel(Level.DEBUG);