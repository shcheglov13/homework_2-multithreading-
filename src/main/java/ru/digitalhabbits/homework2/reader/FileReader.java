package ru.digitalhabbits.homework2.reader;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Sequential file reader
 */
public interface FileReader {

    Stream<String> readLines(@Nonnull File file) throws IOException;

}
