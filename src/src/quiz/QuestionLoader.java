/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionLoader {

    public List<Question> loadQuestions(String filePath) {
        List<Question> questions = new ArrayList<>();
        File file = new File(filePath);

        // Jeśli plik nie istnieje, zwracamy pustą listę
        if (!file.exists()) {
            System.err.println("Nie znaleziono pliku: " + filePath);
            return questions;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Pomijamy puste linie
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                // Format: TYP;POZIOM;KATEGORIA;PKT;TREŚĆ;ODP;[OPCJE...]
                
                try {
                    String type = parts[0];
                    Level level = Level.valueOf(parts[1]);
                    Category category = Category.valueOf(parts[2]);
                    int points = Integer.parseInt(parts[3]);
                    String content = parts[4];
                    String correctStr = parts[5];

                    if (type.equals("TF")) {
                        boolean correct = Boolean.parseBoolean(correctStr);
                        questions.add(new TrueFalseQuestion(content, points, level, category, correct));
                    } else if (type.equals("MC")) {
                        int correctIndex = Integer.parseInt(correctStr);
                        List<String> options = new ArrayList<>();
                        // Opcje są od indeksu 6 do 9 (4 opcje)
                        options.add(parts[6]);
                        options.add(parts[7]);
                        options.add(parts[8]);
                        options.add(parts[9]);
                        questions.add(new MultipleChoiceQuestion(content, points, level, category, options, correctIndex));
                    }
                } catch (Exception e) {
                    System.err.println("Błąd w linii pliku: " + line + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    /**
     * Metoda filtrująca pytania po poziomie i losująca określoną liczbę.
     */
    public List<Question> getRandomQuestionsByLevel(List<Question> allQuestions, Level level, int count) {
        List<Question> filtered = new ArrayList<>();
        
        // 1. Wybieramy tylko pytania z zadanego poziomu
        for (Question q : allQuestions) {
            if (q.getDifficulty() == level) {
                filtered.add(q);
            }
        }
        
        // 2. Mieszamy listę (losowość)
        Collections.shuffle(filtered);
        
        // 3. Zwracamy tyle ile chcemy (lub mniej, jeśli w pliku jest za mało)
        int limit = Math.min(count, filtered.size());
        return new ArrayList<>(filtered.subList(0, limit));
    }
}