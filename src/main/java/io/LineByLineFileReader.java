package io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class LineByLineFileReader {

    private final String fileName;

    public LineByLineFileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() {
        try {
            URI uri = requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI();
            Path path = Paths.get(uri);

            try (final Stream<String> lines = Files.lines(path)) {
                return lines.collect(joining("\n"));
            }
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Resource not found");
        }
        return obj;
    }
}
