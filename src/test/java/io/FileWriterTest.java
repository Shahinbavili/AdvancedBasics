package io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.out;
import static java.nio.charset.StandardCharsets.UTF_8;

public class FileWriterTest {

    private static final String FILE_NAME = "test.txt";
    private static final StringBuilder SENTENCE = new StringBuilder();

    @Test
    void should_Write_In_A_File() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
             FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
            fileOutputStream.write("Hello World!".getBytes(UTF_8));

            int read;
            while ((read = fileInputStream.read()) != -1) {
                SENTENCE.append((char) read);
            }
            out.println(SENTENCE);
            Assertions.assertThat(SENTENCE.toString()).isEqualTo("Hello World!");
        } catch (FileNotFoundException e) {
            out.println("The file test.txt dose not exist!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
