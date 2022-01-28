package utils;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConfigReader {

    static String userConfigFilePath = "src/main/resources/configuration/configuration.json";
    static String locatorsFilePath = "src/main/resources/configuration/locators.json";

    public static JSONObject getConfig(String configFilePath) {
        JSONParser parser = new JSONParser();

        try{
            return (JSONObject) parser.parse(new FileReader(configFilePath));
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getUserConfig(){
        return getConfig(userConfigFilePath);
    }

    public static JSONObject getLocators(){
        return getConfig(locatorsFilePath);
    }

}

