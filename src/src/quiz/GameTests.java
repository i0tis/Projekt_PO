/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTests {

    // Test 1: Sprawdza czy pytanie Prawda/Fałsz działa poprawnie
    @Test
    public void testTrueFalseQuestion() {
        Question q = new TrueFalseQuestion("Test?", 10, Level.EASY, Category.IT, true);
        
        // "true" powinno być zaliczone
        assertTrue("Powinno zaakceptować 'true'", q.checkAnswer("true"));
        // "tak" też (zgodnie z logiką w klasie)
        assertTrue("Powinno zaakceptować 'tak'", q.checkAnswer("tak"));
        // "false" powinno być odrzucone
        assertFalse("Powinno odrzucić 'false'", q.checkAnswer("false"));
    }

    // Test 2: Sprawdza czy pytanie ABCD działa i czy sesja liczy punkty
    @Test
    public void testMultipleChoiceScoring() {
        // Setup
        List<String> options = Arrays.asList("A", "B", "C", "D");
        // Poprawna to indeks 2 ("C"), punkty: 10
        Question q1 = new MultipleChoiceQuestion("Q1", 10, Level.MEDIUM, Category.IT, options, 2);
        
        List<Question> questions = new ArrayList<>();
        questions.add(q1);
        
        Player p = new Player("Tester");
        GameSession session = new GameSession(p, questions);
        session.start();
        
        // Action: Odpowiadamy "2" (poprawnie)
        session.submitAnswer("2");
        
        // Assertion
        assertEquals("Wynik powinien wynosić 10", 10, session.getCurrentScore());
    }

    // Test 3: Sprawdza czy Ranking (Leaderboard) poprawnie sortuje ScoreEntry
    @Test
    public void testLeaderboardSorting() {
        Leaderboard lb = new Leaderboard("test.txt");
        
        Player p1 = new Player("Słaby");
        Player p2 = new Player("Mistrz");
        
        // Dodajemy wpisy (ScoreEntry)
        lb.addScore(new ScoreEntry(p1, 5));
        lb.addScore(new ScoreEntry(p2, 100));
        
        List<ScoreEntry> top = lb.getTop10();
        
        // Pierwszy na liście powinien być Mistrz (100 pkt)
        assertEquals("Najlepszy wynik musi być pierwszy", "Mistrz", top.get(0).getPlayer().getNickname());
    }

    // Metoda main uruchamiająca testy (dla pewności)
    public static void main(String[] args) {
        System.out.println("Uruchamianie testów...");
        org.junit.runner.JUnitCore.main("quiz.GameTests");
    }
}