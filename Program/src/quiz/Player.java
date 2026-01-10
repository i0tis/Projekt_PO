/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

import java.util.List;
import java.util.Date;

public class Player {
    private String nick;
    private int score;
    private Date date;

    public Player(String nick, int score) {
        this.nick = nick;
        this.score = score;
        this.date = new Date(); // Aktualna data
    }

    // Gettery
    public String getNick() { return nick; }
    public int getScore() { return score; }
    public Date getDate() { return date; }
}