# Projekt_PO

Projekt programowanie obiektowe 
1. Wymagania funkcjonalne
- Dla gracza (użytkownika):
Rozpoczęcie gry: podanie nazwy użytkownika przed startem.
Wybór parametrów gry:
 Wybór kategorii pytań.
 Wybór poziomu trudności (łatwy, średni i trudny).
Rozgrywka:
    • Pytanie z 4 wariantami odpowiedzi, gdzie jedna z nich jest poprawna.
    • Ograniczenie czasowe na odpowiedź.
    • Natychmiastowa informacja zwrotna (czy odpowiedź była poprawna).
Zakończenie gry:
    • Wyświetlenie podsumowania (łączna liczba zdobytych punktów).
    • Możliwość zapisania wyniku w rankingu.

- Dla systemu:
Obsługa bazy pytań:
    • Przechowywanie pytań
    • Losowanie pytań z puli, aby się nie powtarzały w jednej rozgrywce/sesji.
Mechanika punktacji:
    • Przyznawanie punktów w zależności od poziomu trudności (np. łatwe = 1pkt, trudne = 3pkt).
Ranking:
    • Sortowanie graczy według najlepszego wyniku.
    • Wyświetlanie top 10 najlepszych graczy.
2. Model obiektowy
    • Question – zawiera treść, listę odpowiedzi, poprawną odpowiedź, poziom trudności.
    • Answer – treść odpowiedzi.
    • Player – nick, aktualny wynik.
    • GameSession – zarządza stanem gry (które pytanie teraz, ile czasu zostało).
    • QuizRepository – klasa odpowiedzialna za wczytywanie pytań z pliku/bazy.
    • Leaderboard – klasa zarządzająca listą najlepszych wyników.

