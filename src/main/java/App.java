import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("cds/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/cd-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cds", Cd.all());
      model.put("template", "templates/cds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cds", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String description = request.queryParams("description");
      Cd newCd = new Cd(description);
      model.put("cd", newCd);
      model.put("template", "templates/cd.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Cd cd = Cd.find(Integer.parseInt(request.params(":id")));
    model.put("cd", cd);
    model.put("template", "templates/cd.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
