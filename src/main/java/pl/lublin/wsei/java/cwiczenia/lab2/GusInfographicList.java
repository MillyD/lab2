package pl.lublin.wsei.java.cwiczenia.lab2;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GusInfographicList {
    List<String> items;
 //   List<Infografika> infographics;
    String fileContent;

    public GusInfographicList(String fileName) {
        readFile(fileName);
        divideContentToItems();
    }


    private void readFile(String fileName){
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
            fileContent = resultStringBuilder.toString();
        } catch (IOException e) {
            System.out.println("Błąd wczytywania pliku gusInfoGraphic.xml => " + e.getLocalizedMessage());
            e.printStackTrace();
        }

    }

    private void divideContentToItems(){
        Matcher matcher = Pattern.compile("<item>((?:\\n.*?)*)</item>").matcher(fileContent);
        this.items = matcher
                .results()
                .filter(m -> m.group(1) != null)
                .map(m -> m.group(1))
                .collect(Collectors.toList());
    }

}
