import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {

 staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("allAnimals", Animal.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());




    }
}