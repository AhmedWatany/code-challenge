package TajawalTest;

import java.io.File;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONDataProvider {

    protected JsonObject jsonObject;

    public JSONDataProvider(String name) {
        jsonObject = readFromJsonFile(name);
    }

    public JsonObject readFromJsonFile(String dataFileName) {
        try {

            JsonParser parser = new JsonParser();
            this.jsonObject = (JsonObject) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                    + File.separator + "resources" + File.separator + dataFileName + ".json"));
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getJsonValue(String key) {
        if (jsonObject.isJsonNull())
            return null;
        String value = jsonObject.get(key).getAsString();
        return value;
    }

}
