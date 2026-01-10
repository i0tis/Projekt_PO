/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionsPool {
    private List<Question> allQuestions;

    public QuestionsPool() {
        this.allQuestions = new ArrayList<>();
    }

    // Metoda ładująca pytania
    public void loadQuestions(String path) {
        // odczyt z pliku txt/json - do testów ręcznie
        System.out.println("Ładowanie pytań z: " + path);
    }
    
    // Metoda pomocnicza do dodawania pytań ręcznie
    public void addQuestion(Question q) {
        allQuestions.add(q);
    }

    // logika losowania
    public List<Question> getRandomQuestion(int amount, Category category) {
        List<Question> filtered = allQuestions.stream()
                .filter(q -> q.getCategory() == category)
                .collect(Collectors.toList());

        Collections.shuffle(filtered); // Mieszamy pytania

        // Zwracamy 'amount' pytań lub mniej, jeśli nie ma tyle w bazie
        return filtered.stream().limit(amount).collect(Collectors.toList());
    }
}