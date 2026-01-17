# 🧠 Quiz Wiedzy - Projekt Java (GUI)

Aplikacja typu Quiz z interfejsem graficznym (GUI) stworzona w języku Java. Pozwala użytkownikom na sprawdzenie swojej wiedzy w interaktywny sposób. Projekt obejmuje dynamiczne ładowanie pytań z pliku, wybór poziomów trudności oraz system rywalizacji poprzez ranking graczy.

## ✨ Funkcje aplikacji

| Funkcja | Opis |
| :--- | :--- |
| **Baza pytań** | Pytania wczytywane są z zewnętrznego pliku `pytania.txt` (Kategorie: IT, Historia, Sport, Geografia). |
| **Poziomy trudności** | Wybór między **Easy, Medium i Hard** (wpływa na pulę losowanych pytań). |
| **Ranking** | Automatyczny zapis najlepszych wyników do pliku `ranking.txt`. |
| **Interfejs** | Graficzny interfejs użytkownika (Swing) – obsługa myszką, okna dialogowe. |
| **Weryfikacja** | Logika biznesowa sprawdzona testami jednostkowymi (JUnit). |

## 🛠️ Technologie
* **Język:** Java 17+
* **Interfejs:** Java Swing (JFrame, JOptionPane)
* **Testy:** JUnit 4.13.2
* **Struktury danych:** Listy i Kolekcje (Collections Framework)
* **Zapis danych:** Obsługa plików tekstowych (odczyt pytań, zapis rankingu)

## 🚀 Instrukcja uruchomienia (Tutorial)

| Krok | Działanie w IDE (NetBeans / IntelliJ) | Uwagi |
| :--- | :--- | :--- |
| **1. Pobranie** | Sklonuj repozytorium lub pobierz ZIP. | Upewnij się, że plik `pytania.txt` jest w głównym folderze projektu. |
| **2. Biblioteki** | Dodaj bibliotekę **JUnit 4** do projektu. | Wymagane do uruchomienia testów. |
| **3. Uruchomienie Gry** | Kliknij Prawym Przyciskiem na plik `src/quiz/QuizWindow.java` -> **Run File**. | To jest główny plik aplikacji okienkowej. |
| **4. Uruchomienie Testów** | Kliknij Prawym Przyciskiem na `src/quiz/GameTests.java` -> **Test File**. | Weryfikacja logiki naliczania punktów. |

Szczegółowy opis projektu znajduje się w folderze [Docs](./Docs).

---

## 📋 Przebieg rozgrywki (Opis)

1.  **Start:** Aplikacja wita użytkownika i prosi o podanie **Nicku**.
2.  **Konfiguracja:** Gracz wybiera poziom trudności (Łatwy / Średni / Trudny).
3.  **Gra:** Wyświetla się okno z pytaniem i 4 wariantami odpowiedzi (lub Prawda/Fałsz).
    * *Poprawna odpowiedź:* Punkty są dodawane.
    * *Błędna odpowiedź:* Przejście do kolejnego pytania.
4.  **Koniec:** Po serii pytań wyświetla się wynik końcowy oraz **Tabela Wyników (Top 10)**.
