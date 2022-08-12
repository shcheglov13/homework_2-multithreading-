package ru.digitalhabbits.homework2.util;

import java.io.File;

import static com.google.common.io.Resources.getResource;

public final class Util {

    private static final String FILE_NAME = "test.txt";

    private Util() {}

    public static File getPreparedFile() {
        return new File(getResource(FILE_NAME).getPath());
    }

}
