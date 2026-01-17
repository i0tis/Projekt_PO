/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private int currentScore;
    private long startTime;
    private Player player;
    private List<Question> questions;
    private int currentIndex;
    
    // liczenie punktów
    private IsScoreCalculable scoreCalculator;

    public GameSession(Player player, List<Question> questions) {
        this.player = player;
        this.questions = questions;
        this.currentScore = 0;
        this.currentIndex = 0;
        this.scoreCalculator = new StandardScoreCalculator(1.0); // Domyślny kalkulator
    }

    // Metoda statyczna
    public static boolean validateNick(String nick) throws QuizException {
        if (nick == null || nick.length() < 3) {
            throw new QuizException("Nick jest zbyt krótki! Minimum 3 znaki.");
        }
        return true;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        System.out.println("Sesja rozpoczęta dla: " + player.getNickname());
    }
    
    public void submitAnswer(String answer) {
        if (currentIndex < questions.size()) {
            Question q = questions.get(currentIndex);
            if (q.checkAnswer(answer)) {
                // Użycie interfejsu do obliczenia punktów
                currentScore += scoreCalculator.calculate(q.getPoints(), 0);
            }
            currentIndex++;
        }
    }

    public int getCurrentScore() { return currentScore; }
    public Question getCurrentQuestion() {
        if (currentIndex < questions.size()) return questions.get(currentIndex);
        return null;
    }
    
    public Player getPlayer() {
        return player;
    }

    public long getStartTime() {
        return startTime;
    }
}