/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// Plik: Leaderboard.java
public class Leaderboard {
    private List<Player> topScores;
    private String filePath;

    public Leaderboard(String filePath) {
        this.filePath = filePath;
        this.topScores = new ArrayList<>();
    }

    public void addScore(Player player) {
        topScores.add(player);
        saveToFile(); // Automatyczny zapis po dodaniu wyniku
    }

    public List<Player> getTop10() {
        return topScores.stream()
                .sorted(Comparator.comparingInt(Player::getScore).reversed()) // Sortuj malejąco
                .limit(10)
                .collect(Collectors.toList());
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Player p : topScores) {
                // Format: Nick,Punkty
                writer.println(p.getNick() + "," + p.getScore());
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String nick = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    topScores.add(new Player(nick, score));
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu: " + e.getMessage());
        }
    }
}