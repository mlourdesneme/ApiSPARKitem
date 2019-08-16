import clases.*;
import com.google.gson.Gson;

import java.util.Collection;

import static spark.Spark.*;

public class SparkRestFulApi {

    public static void main(String[] args) {

        final IItemService service = new ItemsServiceMapImpl();

        port(9000);

        //GET que devuelve Items cargados

        get("/items", (req, res) -> {
            res.type("application/json");
            Collection<Item> items = service.getItems();
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(items)));
        });

        //GET que devuelve items por usuario

        get("/items/:id",(req, res) -> {
            res.type("application/json");
            Collection<Item> items = service.getItemsByUser(req.params(":id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(items)));
        });

        //POST para AGREGAR un Item

        post("/items/", (req, res) -> {
            res.type("application/json");
            Item item = new Gson().fromJson(req.body(), Item.class);
            String id = service.addItem(item.getId(), item);
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(item)));
        });


        //post que devuelve Token

        post("/token", (req,res)->{
            res.type("application/json");
            Respuesta respuesta = new Gson().fromJson(Conexion.post("http://localhost:8084/token",
                                                req.headers("username"),
                                                req.headers("password")),
                                                Respuesta.class);

            System.out.println(respuesta.getData().getToken());

            return new Gson().toJsonTree(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(respuesta.getData())));

        });

        //GET SITES

        get("/sites" ,(req, res) -> {
            res.type("application/json");
            System.out.println("Pase por /sites");
            Site[] sites= new Gson().fromJson(Conexion.get("http://localhost:8084/sites",
                    req.headers("username"), req.headers("token")), Site[].class);
            System.out.println(sites);
            System.out.println("Pase por /sites");
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(sites)));
        });

        //GET CATEGORIES

        get("/sites/:idSite/categories" , (req, res) -> {
            res.type("application/json");
            String id_site = req.params(":id_site");
            Category[] categories= new Gson().fromJson(Conexion.get("http://localhost:8084/sites/"+id_site+"/categories",
                    req.headers("username"), req.headers("token")), Category[].class);
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(categories)));
        });

    }
}
