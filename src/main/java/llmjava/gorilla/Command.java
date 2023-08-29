package llmjava.gorilla;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class Command {
    public static class Request {
        private String user_id;
        private String user_input;
        private String interaction_id;

        public Request(String user_id, String user_input, String interaction_id) {
            this.user_id = user_id;
            this.user_input = user_input;
            this.interaction_id = interaction_id;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    public static class Response {
        List<String> commands;
        public Response(List<String> commands) {
            this.commands = commands;
        }

        @Override
        public String toString() {
            return "Response: " + commands.toString();
        }

        public static Response parse(String jsonString) {
            Type listType = new TypeToken<List<String>>(){}.getType();
            List<String> commands = new Gson().fromJson(jsonString, listType);
            return new Response(commands);
        }
    }
}
