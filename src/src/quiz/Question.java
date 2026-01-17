/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

// Klasa abstrakcyjna
public abstract class Question {
    // Pola chronione dla klas dziedziczących
    protected String content;
    protected int points;
    protected Level difficulty;
    protected Category category;

    public Question(String content, int points, Level difficulty, Category category) {
        this.content = content;
        this.points = points;
        this.difficulty = difficulty;
        this.category = category;
    }

    // Metoda abstrakcyjna
    public abstract boolean checkAnswer(String input);

    public String getContent() { return content; }
    public int getPoints() { return points; }
    public Level getDifficulty() { return difficulty; }
    public Category getCategory() { return category; }
}