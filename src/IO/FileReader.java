package IO;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.Input;
import java.io.IOException;

public class FileReader {
    private String path;

    public FileReader(final String path) {
        this.path = path;
    }

    /**
     * Getter pentru path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Setter pentru path.
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Metoda ce ne ajuta sa citim imputul din fisiere.
     */
    public Input readData() {

        Input databaseFinal = new Input();

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            Input database = objectMapper.readValue(new java.io.FileReader(path), Input.class);

            databaseFinal = database;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return databaseFinal;
    }
}
