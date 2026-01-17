/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.util.Date;

public class ScoreEntry implements Comparable<ScoreEntry> {
    private Player player;
    private int score;
    private Date date;

    public ScoreEntry(Player player, int score) {
        this.player = player;
        this.score = score;
        this.date = new Date(); // Ustawia aktualną datę
    }

    // sortowanie
    @Override
    public int compareTo(ScoreEntry other) {
        // Sortowanie malejąco (od najwyższego wyniku)
        return Integer.compare(other.score, this.score);
    }

    public Player getPlayer() { return player; }
    public int getScore() { return score; }
    public Date getDate() { return date; }
    
    @Override
    public String toString() {
        return player.getNickname() + " - " + score + " pkt (" + date + ")";
    }
}