package ru.digitalhabbits.homework2;

import lombok.extern.slf4j.Slf4j;
import ru.digitalhabbits.homework2.filelettercounter.AsyncFileLetterCounter;
import ru.digitalhabbits.homework2.filelettercounter.FileLetterCounter;
import ru.digitalhabbits.homework2.util.Util;

@Slf4j
public class Main {

    public static void main(String... args) {
        FileLetterCounter fileLetterCounter = new AsyncFileLetterCounter();
        fileLetterCounter.count(Util.getPreparedFile());
    }

}
