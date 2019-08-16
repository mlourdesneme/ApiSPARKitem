import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;

import static spark.Spark.*;

public class SparkRestFulApi {

    public static void main(String[] args) {

        final IItemService service = new ItemsServiceMapImpl();

        port(9000);

        //GET que recibe token, username y devuelve Sites
        get("/items", (req, res) -> {
            res.type("application/json");
            Collection<Item> items = service.getItems();
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(items)));
        });

        //GET que recibe username y devuelve Sites

        get("/items/:username",(req, res) -> {
            res.type("application/json");
            Collection<Item> items = service.getItemsByUser(req.params(":username"));
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(items)));
        });

        //POST de un Item

        post("/items/", (req, res) -> {
            res.type("application/json");
            Item item = new Gson().fromJson(req.body(), Item.class);
            int id = service.addItem(item);
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(item)));
        });


        //post

        post("/token", (req,res)->{
            res.type("application/json");
            Token tokenObt = new Gson().fromJson(Conexion.post("http://localhost:8084/token",
                                                req.headers("username"),
                                                req.headers("password")),
                                                Token.class);

            Token token =null;
            token.setToken(tokenObt.getToken());
            System.out.println(token);
            //return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, new Gson().fromJson(br.readLine(),Token.class)));
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(token.getToken())));
        });


        //GET SITES

        get("/sites" ,(req, res) -> {
            res.type("application/json");
            //System.out.println("paso");
            Site[] sites= new Gson().fromJson(Conexion.get("http://localhost:8084/sites"), Site[].class);
            /*
            BufferedReader b1= Conexion.get("https://localhost:8082");
            Site[] sites= new Gson().fromJson(b1, Site[].class);
            */
            return new Gson().toJson(new StandardResponse(StatusResponse.OK, new Gson().toJsonTree(sites)));
        });





    }
}
