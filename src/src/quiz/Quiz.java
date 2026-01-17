/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    public static void main(String[] args) {
        System.out.println("=== TESTOWANIE NOWEGO MODELU (KONSOLA) ===");

        // 1. Tworzenie listy opcji dla pytania ABCD
        List<String> opcje = new ArrayList<>();
        opcje.add("H"); // Indeks 0
        opcje.add("O"); // Indeks 1
        opcje.add("C"); // Indeks 2
        opcje.add("N"); // Indeks 3

        // 2. Tworzenie pytań konkretnych typów (zamiast ogólnego Question)
        Question q1 = new MultipleChoiceQuestion(
            "Jaki jest symbol tlenu?", 
            10, 
            Level.EASY, 
            Category.HISTORY, // Używamy nowego Enuma
            opcje, 
            1 // Poprawny indeks to 1 (O)
        );

        Question q2 = new TrueFalseQuestion(
            "Czy Ziemia jest płaska?", 
            5, 
            Level.EASY, 
            Category.GEOGRAPHY, 
            false // Poprawna odpowiedź to Fałsz
        );

        // 3. Tworzenie listy pytań do sesji
        List<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);

        // 4. Tworzenie Gracza i Sesji
        Player player = new Player("TesterKonsolowy");
        GameSession session = new GameSession(player, questions);
        session.start();

        // 5. Symulacja gry
        
        // --- Runda 1 (ABCD) ---
        Question current = session.getCurrentQuestion();
        if (current != null) {
            System.out.println("Pytanie 1: " + current.getContent());
            // Odpowiadamy "1" (czyli opcja B/O)
            session.submitAnswer("1"); 
            System.out.println("Aktualny wynik: " + session.getCurrentScore());
        }

        // --- Runda 2 (Prawda/Fałsz) ---
        current = session.getCurrentQuestion();
        if (current != null) {
            System.out.println("Pytanie 2: " + current.getContent());
            // Odpowiadamy "false"
            session.submitAnswer("false");
            System.out.println("Aktualny wynik: " + session.getCurrentScore());
        }

        System.out.println("Koniec testu konsolowego.");
    }
}