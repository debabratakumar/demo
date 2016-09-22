package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by debabk on 09/09/16.
 *
 */
public class LoadProperty {

    private  Properties loadProperties(String fileName){
        Properties prop = new Properties();
        InputStream input = null;

        try {

          input = getClass().getClassLoader().getResourceAsStream(fileName);

            prop.load(input);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }


  public String getURL(){
      Properties properties=loadProperties("config.properties");

      return properties.getProperty("url");

  }
}
