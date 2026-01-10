/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private int currentScore;
    private int currentIndex;
    private List<Question> activeQuestions;
    private Player player;
    
    // Sesja potrzebuje puli pytań, żeby wystartować
    private QuestionsPool questionsPool; 

    public GameSession(Player player, QuestionsPool pool) {
        this.player = player;
        this.questionsPool = pool;
        this.currentScore = 0;
        this.currentIndex = 0;
        this.activeQuestions = new ArrayList<>();
    }

    // Start gry: pobiera 5 pytań z kategorii IT
    public void start(Category category) {
        // Pobieramy np. 5 pytań dla wybranej kategorii
        this.activeQuestions = questionsPool.getRandomQuestion(5, category);
        this.currentIndex = 0;
        this.currentScore = 0;
        System.out.println("Gra rozpoczęta dla gracza: " + player.getNick());
    }

    public void submitAnswer(Answer answer) {
        if (currentIndex >= activeQuestions.size()) {
            System.out.println("Koniec gry.");
            return;
        }

        Question currentQ = activeQuestions.get(currentIndex);
        
        if (currentQ.checkAnswer(answer)) {
            currentScore++; // 1 pkt za poprawną odpowiedź
            System.out.println("Dobra odpowiedź!");
        } else {
            System.out.println("Błędna odpowiedź.");
        }
        
        currentIndex++;
    }
    
    // Gettery pomocnicze
    public int getCurrentScore() { return currentScore; }
    public boolean isFinished() { return currentIndex >= activeQuestions.size(); }
    public Question getCurrentQuestion() { 
        if(isFinished()) return null;
        return activeQuestions.get(currentIndex); 
    }
}