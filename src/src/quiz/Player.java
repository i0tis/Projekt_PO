/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

public class Player {
    private String nickname;
    private static int totalPlayers = 0; // Pole statyczne

    public Player(String nickname) {
        this.nickname = nickname;
        totalPlayers++; // Zwiększamy licznik przy każdym nowym graczu
    }

    public String getNickname() {
        return nickname;
    }

    public static int getTotalPlayers() {
        return totalPlayers;
    }
}