package llmjava.gorilla;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UserIdProvider {

    String USERID_FILE = System.getProperty("user.home") + "/.gorilla-cli-userid";

    public String get() {
        String userid = readUserIdFile();
        if(userid == null) {
            userid = UUID.randomUUID().toString();
            writeUserIdFile(userid);
        }
        return userid;
    }

    private void writeUserIdFile(String userid) {
        try {
            FileWriter writer = new FileWriter(USERID_FILE);
            writer.write(userid);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String readUserIdFile() {
        String userid = null;
        try {
            Path path = Paths.get(USERID_FILE);
            if(path.toFile().exists()) {
                byte[] bytes = Files.readAllBytes(path);
                userid = new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userid;
    }
}
