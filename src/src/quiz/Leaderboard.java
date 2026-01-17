/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard {
    private List<ScoreEntry> entries;
    private String filePath;

    public Leaderboard(String filePath) {
        this.filePath = filePath;
        this.entries = new ArrayList<>();
        loadFromFile(); // Próbujemy wczytać ranking przy starcie
    }

    public void addScore(ScoreEntry entry) {
        entries.add(entry);
        sortRanking();
        saveToFile(); // Zapisujemy od razu po dodaniu nowego wyniku
    }

    public void sortRanking() {
        Collections.sort(entries);
    }

    public List<ScoreEntry> getTop10() {
        sortRanking();
        int limit = Math.min(entries.size(), 10);
        return new ArrayList<>(entries.subList(0, limit));
    }

    // Zapis do pliku (Format: Nick,Punkty)
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ScoreEntry entry : entries) {
                // Zapisujemy: Nick,Punkty
                writer.write(entry.getPlayer().getNickname() + "," + entry.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Błąd zapisu rankingu: " + e.getMessage());
        }
    }

    // Odczyt z pliku
    public void loadFromFile() {
        entries.clear();
        File file = new File(filePath);
        if (!file.exists()) return; // Jeśli plik nie istnieje to koniec

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nick = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    // Tworzymy wpis (data ustawi się na teraz)
                    entries.add(new ScoreEntry(new Player(nick), score));
                }
            }
            sortRanking();
        } catch (IOException | NumberFormatException e) {
            System.err.println("Błąd odczytu rankingu: " + e.getMessage());
        }
    }
}