package ro.sapo.jsonpointer;

import ro.sapo.builders.JsonBuildersExercise;
import ro.sapo.builders.JsonBuildersExerciseSolution;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPointer;

/**
 * Created by sapo on 15-Jan-17.
 */
public class JsonPointerExerciseSolution {

    public static void main(String args[]) {
        JsonObject json = JsonBuildersExerciseSolution.getFinalObject();

        //read name
        JsonPointer readNamePointer = new JsonPointer("/name");
        System.out.println("Read nama attribute: "  + readNamePointer.getValue(json));

        //read type of second batter
        JsonPointer readSecondBatterTypePointer = new JsonPointer("/batter/1/type");
        System.out.println("Read type of second batter: "  + readSecondBatterTypePointer.getValue(json));

        //add price attribute
        JsonPointer addPricePointer = new JsonPointer("/price");
        json = addPricePointer.add(json, Json.createValue(0.55));
        System.out.println("Added price attribute: " + json);

        //change value of price attribute
        JsonPointer changePricePointer = new JsonPointer("/price");
        json = changePricePointer.replace(json, Json.createValue(1.55));
        System.out.println("Changed price attribute: " + json);

        //change Chocolate to Vanilla
        JsonPointer changeChocolatePointer = new JsonPointer("/batter/1/type");
        json = changeChocolatePointer.replace(json, Json.createValue("Vanilla"));
        System.out.println("Changed batter Chocolate to Vanilla: " + json);

        //add new topping
        JsonPointer addToppingPointer = new JsonPointer("/topping/-");
        json = addToppingPointer.add(json, Json.createObjectBuilder()
                                                    .add("id", "5004")
                                                    .add("type", "Vanilla").build()
        );
        System.out.println("Added new topping Vanilla: " + json);
    }
}
