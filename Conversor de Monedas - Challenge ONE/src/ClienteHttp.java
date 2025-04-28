import com.google.gson.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {
    private String url = "https://v6.exchangerate-api.com/v6/1ab30a144becf841dad8bd1f";

    public Float getDolarConvert(String monedaAConvertir){
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + "/latest/USD")).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            cliente.close();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ReporteCompleto reporteMultiple = gson.fromJson(response.body(),ReporteCompleto.class);

            return retornarSiExiste(reporteMultiple.conversion_rates(),monedaAConvertir);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    private Float retornarSiExiste(JsonObject response, String moneda){
        if (response.has(moneda)) {
            return response.get(moneda).getAsFloat();
        } else {
            System.out.println("No se encontró la moneda ARG en conversion_rates.");
            return null;
        }
    }

    public Float getValorMonedaAMonedaB(String moneda, String monedaAConvertir){

        try{
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url+ "/pair/" +moneda +"/"+ monedaAConvertir)).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            cliente.close();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Reporte reporte = gson.fromJson(response.body(),Reporte.class);
            return reporte.conversion_rate();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());}
    }
}
