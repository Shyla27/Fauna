import models.EndangeredAnimals;
import models.NonEndangered;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {


        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animalform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String rangerName = request.queryParams("rangerName");
            String sightingLocation = request.queryParams("sightingLocation");
            String animalName = request.queryParams("animalName");
            String animalAge = request.queryParams("animalAge");
            String animalHealth = request.queryParams("animalHealth");
            String animalType = request.queryParams("animalType");
            Sightings newSighting = new Sightings(rangerName,sightingLocation,1);
            newSighting.save();
            EndangeredAnimals newEndangered = new EndangeredAnimals(animalName,animalAge,animalHealth,animalType);
            newEndangered.save();
            if (animalType.equals("Nonendangered")) {
                NonEndangered regularAnimal = new NonEndangered(animalName, animalAge, animalHealth, animalType);
                regularAnimal.save();
                Sightings newSighting1 = new Sightings(rangerName, sightingLocation, regularAnimal.getId());
                newSighting1.save();
            } else if (animalType.equals("endangered")) {
                EndangeredAnimals endangeredAnimal = new EndangeredAnimals(animalName, animalAge, animalHealth, animalType);
                endangeredAnimal.save();
                Sightings newSighting2 = new Sightings(rangerName, sightingLocation, endangeredAnimal.getId());
                newSighting2.save();
            }
            List<Sightings> allSightings = Sightings.all();
            List<EndangeredAnimals> allAnimal = EndangeredAnimals.all();
            System.out.println("-------------------------------------");
            System.out.println(allAnimal.get(0).getName());
            model.put("sightings", allSightings);
            model.put("animals", allAnimal);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sightings.all());
            model.put("animals", EndangeredAnimals.all());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());


    }}