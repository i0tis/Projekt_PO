# 🧠 Quiz Wiedzy - Projekt Java

Aplikacja typu Quiz stworzona w języku Java, pozwalająca użytkownikom na sprawdzenie swojej wiedzy w interaktywny sposób. Projekt obejmuje zarządzanie pytaniami, wybór poziomów trudności oraz system rywalizacji poprzez ranking graczy.

## ✨ Funkcje aplikacji

| Funkcja | Opis |
| :--- | :--- |
| **Baza pytań** | Obsługa zestawów pytań z różnych kategorii. |
| **Poziomy trudności** | Wybór między Easy, Medium i Hard (wpływa na punkty). |
| **Ranking** | System zapisu wyników i wyświetlanie tabeli liderów. |
| **Interfejs** | Czytelne menu obsługiwane z poziomu konsoli. |

## 🛠️ Technologie
* **Język:** Java 17+
* **Struktury danych:** Listy i Mapy (Collections Framework)
* **Zapis danych:** Obsługa plików tekstowych (Ranking)

## 🚀 Instrukcja uruchomienia (Tutorial)

| Krok | Działanie w IDE (IntelliJ / Eclipse) | Działanie w Terminalu |
| :--- | :--- | :--- |
| **1. Pobranie** | Sklonuj repozytorium lub pobierz ZIP. | `git clone https://github.com/TwojUser/quiz-java.git` |
| **2. Otwarcie** | Wybierz **File > Open** i wskaż folder projektu. | `cd quiz-java` |
| **3. Kompilacja** | IDE zrobi to automatycznie po otwarciu. | `javac -d out src/*.java` |
| **4. Uruchomienie** | Kliknij Prawym Przyciskiem na `Main.java` -> **Run**. | `java -cp out Main` |

Szegółowy opis projektu znajduje się w folderze  
[Docs](./Docs)  
[DIAGRAM UML](./Docs/UML.jpg)

---

## 📋 Przykład działania programu
```text
Pytanie: Który pierwiastek ma symbol 'H'?
A) Hel
B) Wodór
C) Tlen

Twoja odpowiedź: B
Wynik: Poprawna odpowiedź! Zdobywasz punkty.
