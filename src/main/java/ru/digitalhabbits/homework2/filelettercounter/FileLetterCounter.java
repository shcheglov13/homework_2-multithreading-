package ru.digitalhabbits.homework2.filelettercounter;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Map;

/**
 * Counter characters in given file
 */
public interface FileLetterCounter {

    Map<Character, Long> count(@Nonnull File input);

}
