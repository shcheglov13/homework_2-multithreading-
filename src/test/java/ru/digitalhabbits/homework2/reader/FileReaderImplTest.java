package ru.digitalhabbits.homework2.reader;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

class FileReaderImplTest {

    private final static String TEST_FILE_NAME = "FileReaderTest.txt";

    private final FileReader fileReader;

    public FileReaderImplTest() {
        this.fileReader = new FileReaderImpl();
    }

    @Test
    public void should_read_file() {
        try {
            List<String> result = fileReader.readLines(getTestFile()).collect(Collectors.toList());
            assertThat(result).containsOnly(
                    "decfedefdfdbedef",
                    "bfadedbdebfdcaab",
                    "cbcdaddbcafebaca",
                    "ddccbfbaebfcfaec"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getTestFile() {
        return new File(getResource(TEST_FILE_NAME).getPath());
    }
}