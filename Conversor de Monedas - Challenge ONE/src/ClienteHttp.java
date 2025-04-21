import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ClienteHttp {
    private String url = "https://v6.exchangerate-api.com/v6/1ab30a144becf841dad8bd1f/pair/";//Ver bien la url

    public Float getValorDolarAMoneda(String moneda, String monedaAConvertir){

        try{//Ver bien los errores a catchear
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url+ moneda +"/"+ monedaAConvertir)).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            cliente.close();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Reporte reporte = gson.fromJson(response.body(),Reporte.class);
            return reporte.conversion_rate();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());}
    }
}
