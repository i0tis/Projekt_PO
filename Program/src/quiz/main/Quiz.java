/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz;

import java.util.Arrays;

public class Quiz {

    public static void main(String[] args) {
        System.out.println("=== ROZPOCZYNAM TESTOWANIE MODELU ===");

        // 1. Tworzenie przykładowych odpowiedzi
        Answer a1 = new Answer("Warszawa", true);
        Answer a2 = new Answer("Kraków", false);
        Answer a3 = new Answer("Gdańsk", false);
        
        Answer b1 = new Answer("Wisła", true);
        Answer b2 = new Answer("Odra", false);

        // 2. Tworzenie pytań i przypisanie do nich odpowiedzi
        Question q1 = new Question(
            "Co jest stolicą Polski?",
            Arrays.asList(a1, a2, a3),
            Level.EASY,
            Category.HISTORIA // Kategoria z Enuma
        );

        Question q2 = new Question(
            "Najdłuższa rzeka w Polsce?",
            Arrays.asList(b1, b2),
            Level.EASY,
            Category.HISTORIA
        );

        // 3. Inicjalizacja puli pytań i dodanie pytań
        QuestionsPool pool = new QuestionsPool();
        pool.addQuestion(q1);
        pool.addQuestion(q2);
        System.out.println("Pula pytań załadowana.");

        // 4. Tworzenie Gracza
        Player player = new Player("Student123", 0);
        System.out.println("Gracz gotowy: " + player.getNick());

        // 5. Start Sesji Gry
        GameSession session = new GameSession(player, pool);
        
        // Startujemy grę w kategorii HISTORIA
        session.start(Category.HISTORIA);
        
        // --- SYMULACJA RUNDY 1 ---
        Question currentQ = session.getCurrentQuestion();
        if (currentQ != null) {
            System.out.println("\n[Pytanie 1]: " + currentQ.getContent());
            System.out.println("Wybieram odpowiedź: " + a1.getContent()); // Wybieramy "Warszawa"
            
            session.submitAnswer(a1); // Przesyłamy odpowiedź do sesji
            System.out.println("Aktualny wynik: " + session.getCurrentScore());
        }

        // --- SYMULACJA RUNDY 2 ---
        currentQ = session.getCurrentQuestion(); // Pobieramy kolejne pytanie
        if (currentQ != null) {
            System.out.println("\n[Pytanie 2]: " + currentQ.getContent());
            System.out.println("Wybieram odpowiedź: " + b2.getContent()); // Wybieramy "Odra" (błędna)
            
            session.submitAnswer(b2);
            System.out.println("Aktualny wynik: " + session.getCurrentScore());
        }

        // 6. Test Rankingu (Leaderboard)
        System.out.println("\n--- TEST RANKINGU ---");
        Leaderboard lb = new Leaderboard("ranking.txt");
        
        // Dodajemy wynik gracza do rankingu
        // Tworzymy obiekt z końcowym wynikiem (w uproszczeniu)
        Player finalScore = new Player(player.getNick(), session.getCurrentScore());
        lb.addScore(finalScore);
        
        System.out.println("Wynik zapisany. Top 10 graczy:");
        for (Player p : lb.getTop10()) {
            System.out.println("- " + p.getNick() + ": " + p.getScore() + " pkt");
        }
        
        System.out.println("=== KONIEC TESTU ===");
    }
}