import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    private static final String API_KEY = "1d5c96673f2d727b9fc1eadc";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public Monedas buscarMoneda(String monedaBase, String monedaObjetivo) {
        URI direccion = URI.create(BASE_URL + API_KEY + "/pair/" + monedaBase + "/" + monedaObjetivo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la API: " + response.body());
            }

            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return null;
        }
    }
}
