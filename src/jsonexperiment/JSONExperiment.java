/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonexperiment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.*;

/**
 *
 * @author JWright
 */
public class JSONExperiment {

    public static void main(String... args) throws FileNotFoundException {
        navigateJsonStructure(loadJsonObject(), null);
    }

    private static void navigateJsonStructure(JsonValue jsonValue, String key) {
        if (key != null)
            printKey(key);
        switch (jsonValue.getValueType()) {
            case OBJECT:
                JsonObject jsonObject = (JsonObject)jsonValue;
                for (String name: jsonObject.keySet()){
                    navigateJsonStructure(jsonObject.get(name), name);
                }
                
                break;
            case ARRAY:
                // Implement code that deals with array types
                for (JsonValue value : (JsonArray)jsonValue){
                    navigateJsonStructure(value, null);
                }
                break;
            case STRING:
                // Implement code that deals with string types
                printValue(((JsonString)jsonValue).getString());
                break;
            case NUMBER:
                // Implement code that deals with number types
                printValue(jsonValue.toString());
                break;
            case TRUE:
                // Implement code that deals with boolean types
                break;
            case FALSE:
                // Implement code that deals with boolean types
                break;
            case NULL:
                // Implement code that deals with nulls
                break;
        }
    }

    private static void printKey(String key) {
        System.out.print(key + ": ");
    }

    private static void printValue(String x) {
        System.out.println(x);
    }

    /**
     * Load JSON data from a flat-file
     *
     * @return a JsonObject that models the JSON data in the flat-file
     * @throws FileNotFoundException
     */
    public static JsonObject loadJsonObject() throws FileNotFoundException {

            JsonObject jsonObject = Json.createObjectBuilder()
                .add("title", "JSON-Processing With Java EE")
                .add("chapters", Json.createArrayBuilder()
                        .add("Introduction")
                        .add("1. JSON and Java")
                        .add("2. JSON-Processing API features")
                        .add("3. The Java EE JSON Object model")
                        .add("4. The Java EE JSON Streaming model")
                        .add("Conclusion"))
                .add("released", true)
                .add("length", 90)
                .add("sourceCode", Json.createObjectBuilder()
                        .add("repositoryName", "JSON-Processing-with-Java-EE")
                        .add("url", "github.com/readlearncode"))
                .add("complementaryCourse", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("title", "RESTful Service with JAX-RS 2.0")
                                .add("length", 120))
                        .add(Json.createObjectBuilder()
                                .add("title", "Java Enterprise Edition Introduction")
                                .add("length", 130)))
                .addNull("notes")
                .build();

        return jsonObject;
    }

}