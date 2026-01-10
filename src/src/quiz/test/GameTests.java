/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class GameTests {

    // Test 1: Sprawdzenie czy odpowiedź jest poprawnie weryfikowana
    @Test
    public void testAnswerVerification() {
        Answer good = new Answer("Dobra", true);
        Answer bad = new Answer("Zła", false);
        
        Question q = new Question("Test?", Arrays.asList(good, bad), Level.EASY, Category.IT);
        
        assertTrue("Metoda powinna uznać poprawną odpowiedź", q.checkAnswer(good));
        assertFalse("Metoda powinna odrzucić błędną odpowiedź", q.checkAnswer(bad));
    }

    // Test 2: Sprawdzenie czy sesja poprawnie nalicza punkty
    @Test
    public void testScoring() {
        // Setup
        Player p = new Player("Tester", 0);
        QuestionsPool pool = new QuestionsPool();
        
        Answer a1 = new Answer("A", true);
        Question q1 = new Question("Q1", Arrays.asList(a1), Level.EASY, Category.IT);
        pool.addQuestion(q1);
        
        GameSession session = new GameSession(p, pool);
        session.start(Category.IT);
        
        // Action: Odpowiadamy poprawnie
        session.submitAnswer(a1);
        
        // Assertion: Wynik powinien wynosić 1
        assertEquals("Po poprawnej odpowiedzi wynik powinien być 1", 1, session.getCurrentScore());
    }

    // Test 3: Sprawdzenie czy Leaderboard sortuje wyniki (Top 10)
    @Test
    public void testLeaderboardSorting() {
        Leaderboard lb = new Leaderboard("test_ranking.txt");
        
        Player p1 = new Player("Słaby", 5);
        Player p2 = new Player("Mistrz", 100);
        Player p3 = new Player("Średni", 50);
        
        lb.addScore(p1);
        lb.addScore(p2);
        lb.addScore(p3);
        
        List<Player> top = lb.getTop10();
        
        // Pierwszy na liście powinien być ten co ma 100 pkt
        assertEquals("Najlepszy wynik musi być pierwszy", "Mistrz", top.get(0).getNick());
        // Drugi powinien być ten co ma 50
        assertEquals("Średni wynik musi być drugi", "Średni", top.get(1).getNick());
    }
    // To pozwoli uruchomić testy przyciskiem "Run File"
    public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("quiz.GameTests");
    }
}