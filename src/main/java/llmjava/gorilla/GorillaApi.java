package llmjava.gorilla;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GorillaApi {

    public final static String SERVER_URL = "http://34.135.112.197:8000";

    public Command.Response send(Command.Request request) {
        Command.Response response = null;
        String urlString = SERVER_URL + "/commands";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();

            write(connection, request.toJson());

            response = Command.Response.parse(read(connection));

            int status_code = connection.getResponseCode();
            connection.disconnect();
            if(status_code != 200) {
                System.err.println("Failed to send command execution result to the server.");
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    private void write(HttpURLConnection connection, String content) throws IOException {
        OutputStream out = connection.getOutputStream();
        byte[] bodyBytes = content.getBytes(StandardCharsets.UTF_8);
        out.write(bodyBytes);
        out.flush();
        out.close();
    }

    private String read(HttpURLConnection connection) throws IOException {
        final StringBuilder response = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
