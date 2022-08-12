package ru.digitalhabbits.homework2.lettercounter;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Counter characters in given string
 */
public interface LetterCounter {

    Map<Character, Long> count(@Nonnull String input);

}
