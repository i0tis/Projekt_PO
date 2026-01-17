/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;

public class StandardScoreCalculator implements IsScoreCalculable {
    private double multiplier = 1.0;

    public StandardScoreCalculator(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public int calculate(int base, int bonus) {
        return (int) ((base + bonus) * multiplier);
    }
}