package ru.digitalhabbits.homework2.reader;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

@Slf4j
public class FileReaderImpl implements FileReader {

    @Override
    public Stream<String> readLines(@Nonnull File file) throws IOException {
        log.info("Reading lines from the file {}", file.getAbsolutePath());
        return Files.lines(file.toPath());
    }

}
