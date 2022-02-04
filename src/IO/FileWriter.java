package IO;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import database.Output;

import java.io.File;
import java.io.IOException;

public class FileWriter {
    private String path;
    private Output output;

    public FileWriter(final String path, final Output output) {
        this.path = path;
        this.output = output;
    }

    /**
     * Getter pentru path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Getter pentru output.
     */
    public Output getOutput() {
        return output;
    }

    /**
     * Setter pentru path.
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Setter pentru output.
     */
    public void setOutput(final Output output) {
        this.output = output;
    }

    /**
     * Metoda ce ne ajuta sa scriem in fisiere.
     */
    public void writeFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer();
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
            objectWriter.writeValue(new File(this.path), this.output);
        } catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
