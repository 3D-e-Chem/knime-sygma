package nl.esciencecenter.e3dchem.sygma;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamCollector implements Runnable {
    private final InputStreamReader input;
    private final StringBuilder buf = new StringBuilder(1024);

    StreamCollector(InputStream input) {
        this.input = new InputStreamReader(input);
    }

    @Override
    public void run() {
        new BufferedReader(input).lines().forEach(line -> {
            buf.append(line);
            buf.append(System.lineSeparator());
        });
    }

    String getContent() {
        return buf.toString();
    }
}
