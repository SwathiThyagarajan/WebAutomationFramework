package com.thetestingacademy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propertyReader {

  // post creating a data.properties file under resource now we can read the property from here

    // How to read the property
    // create a static function so u can use it directly

    public propertyReader(){

    }

    public static String readKey(String key) throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        Properties properties = null;

        try {
            fileInputStream = new FileInputStream
                (System.getProperty("user.dir")+"/src/main/resources/data.properties");
        // the above will give u exception so add exception
      // after "user.dir")+ give the path of the data.properties
     // right click and select copy the path from content root

        // now we will load the file and getting the key
        properties = new Properties();
        properties.load(fileInputStream);
        }catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}
