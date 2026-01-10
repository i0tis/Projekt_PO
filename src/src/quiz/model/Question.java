/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.util.List;
import java.util.Date;

public class Question {
    private String content;
    private List<Answer> answers; // Relacja 1..*
    private Level difficulty;
    private Category category;

    public Question(String content, List<Answer> answers, Level difficulty, Category category) {
        this.content = content;
        this.answers = answers;
        this.difficulty = difficulty;
        this.category = category;
    }

    // Metoda
    public boolean checkAnswer(Answer answer) {
        return answer.isCorrect();
    }

    // Gettery
    public String getContent() { return content; }
    public List<Answer> getAnswers() { return answers; }
    public Level getDifficulty() { return difficulty; }
    public Category getCategory() { return category; }
}
