package pl.lublin.wsei.java.cwiczenia.lab2.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestFileRead {
    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("src/main/java/pl/lublin/wsei/java/cwiczenia/lab2/govRss.xml")));
            System.out.println("ZAWARTOŚĆ PLIKU: gusInfoGraphic.xml");
            System.out.println(contents);
        } catch (IOException e) {
            System.out.println("Błąd wczytywania pliku gusInfoGraphic.xml => " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
