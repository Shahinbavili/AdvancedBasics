package io;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileWriterTest {
    @Test
    void should_Write_In_A_File() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("test.txt")) {
            fileOutputStream.write("Hello World!".getBytes(UTF_8));
        } catch (FileNotFoundException e) {
            System.out.println("The file test.txt dose not exist!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
