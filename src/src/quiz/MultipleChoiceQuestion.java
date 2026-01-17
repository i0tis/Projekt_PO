/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> options;
    private int correctIndex; // 0 dla A, 1 dla B itd.

    public MultipleChoiceQuestion(String content, int points, Level difficulty, Category category, List<String> options, int correctIndex) {
        super(content, points, difficulty, category);
        this.options = options;
        this.correctIndex = correctIndex;
    }

    @Override
    public boolean checkAnswer(String input) {
        try {
            // Zakładamy, że użytkownik wpisuje numer (1, 2, 3...) lub literę (A, B, C...)
            // Uproszczenie: parsujemy liczbę (0, 1, 2)
            int answerIndex = Integer.parseInt(input);
            return answerIndex == correctIndex;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public List<String> getOptions() {
        return options;
    }
}