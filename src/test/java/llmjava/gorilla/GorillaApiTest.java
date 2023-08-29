package llmjava.gorilla;

import java.util.UUID;

class GorillaApiTest {

    public static void main(String[] args) {
        String user_id = new UserIdProvider().get();
        String interaction_id = UUID.randomUUID().toString();
        Command.Request request = new Command.Request(user_id, "list all my GCP instances", interaction_id);
        GorillaApi ep = new GorillaApi();
        Command.Response response = ep.send(request);
        for(String command: response.commands) {
            System.out.println(command);
        }
    }
}