/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

public class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String content, int points, Level difficulty, Category category, boolean correctAnswer) {
        super(content, points, difficulty, category);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String input) {
        // Zamieniamy input na boolean
        boolean inputBool = Boolean.parseBoolean(input) || input.equalsIgnoreCase("tak");
        return inputBool == correctAnswer;
    }
}