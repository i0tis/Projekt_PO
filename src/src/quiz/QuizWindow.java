/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Collections;
public class QuizWindow extends javax.swing.JFrame {

    // Pola
    private GameSession session;
    private Leaderboard leaderboard;

    public QuizWindow() {
        initComponents();
        // Inicjalizujemy ranking
        leaderboard = new Leaderboard("ranking.txt");
        initGame(); 
    }


    // Pyta o nick i POZIOM, a potem ładuje z pliku.
    private void initGame() {
        // 1. Pytanie o Nick
        String nickname = JOptionPane.showInputDialog(this, "Podaj swój nick:", "Nowa Gra", JOptionPane.QUESTION_MESSAGE);
        if (nickname == null || nickname.trim().isEmpty()) {
            nickname = "Anonim";
        }

        // 2. Wybór Poziomu Trudności
        Object[] options = {"Łatwy (EASY)", "Średni (MEDIUM)", "Trudny (HARD)"};
        int choice = JOptionPane.showOptionDialog(this,
                "Wybierz poziom trudności:",
                "Poziom",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        Level selectedLevel = Level.EASY; // Domyślny
        if (choice == 1) selectedLevel = Level.MEDIUM;
        if (choice == 2) selectedLevel = Level.HARD;

        // 3. Ładowanie pytań z pliku
        QuestionLoader loader = new QuestionLoader();
        List<Question> allQuestions = loader.loadQuestions("pytania.txt");
        
        // Losujemy 10 pytań z wybranego poziomu
        List<Question> gameQuestions = loader.getRandomQuestionsByLevel(allQuestions, selectedLevel, 10);

        // Zabezpieczenie: jeśli plik jest pusty lub nie ma pytań dla tego poziomu
        if (gameQuestions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Brak pytań dla poziomu " + selectedLevel + " w pliku pytania.txt!");
            // Dodajemy jedno awaryjne pytanie, żeby gra się nie wysypała
            gameQuestions.add(new TrueFalseQuestion("Awaryjne pytanie: Czy plik istnieje?", 0, Level.EASY, Category.IT, true));
        }

        // 4. Start sesji
        Player player = new Player(nickname);
        session = new GameSession(player, gameQuestions);
        session.start();

        updateView();
    }

    private void updateView() {
        Question currentQ = session.getCurrentQuestion();

        if (currentQ == null) {
            endGame();
            return;
        }

        lblQuestion.setText(currentQ.getContent());
        lblScore.setText("Punkty: " + session.getCurrentScore());

        if (currentQ instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) currentQ;
            List<String> opts = mcq.getOptions();
            
            btnOptionA.setVisible(true);
            btnOptionB.setVisible(true);
            btnOptionC.setVisible(true);
            btnOptionD.setVisible(true);

            btnOptionA.setText(opts.get(0));
            btnOptionB.setText(opts.get(1));
            btnOptionC.setText(opts.get(2));
            btnOptionD.setText(opts.get(3));

        } else if (currentQ instanceof TrueFalseQuestion) {
            btnOptionA.setVisible(true);
            btnOptionA.setText("PRAWDA");
            
            btnOptionB.setVisible(true);
            btnOptionB.setText("FAŁSZ");

            btnOptionC.setVisible(false);
            btnOptionD.setVisible(false);
        }
    }

    private void handleAnswer(String answer) {
        session.submitAnswer(answer);
        updateView();
    }

    /**
     * Koniec gry - zapisuje wynik i wyświetla ranking
     */
    private void endGame() {
        // 1. Zapisujemy wynik gracza do rankingu
        ScoreEntry newEntry = new ScoreEntry(session.getPlayer(), session.getCurrentScore());
        leaderboard.addScore(newEntry);

        // 2. Budujemy ładny tekst z TOP 10
        StringBuilder sb = new StringBuilder();
        sb.append("Koniec gry!\n");
        sb.append("Twój wynik: ").append(session.getCurrentScore()).append("\n\n");
        sb.append("--- TABELA WYNIKÓW ---\n");
        
        int place = 1;
        for (ScoreEntry entry : leaderboard.getTop10()) {
            sb.append(place).append(". ")
              .append(entry.getPlayer().getNickname())
              .append(" - ").append(entry.getScore()).append(" pkt\n");
            place++;
        }

        // 3. Wyświetlamy okienko z rankingiem
        JOptionPane.showMessageDialog(this, sb.toString(), "Ranking", JOptionPane.INFORMATION_MESSAGE);
        
        this.dispose(); // Zamyka okno
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuestion = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        btnOptionA = new javax.swing.JButton();
        btnOptionB = new javax.swing.JButton();
        btnOptionC = new javax.swing.JButton();
        btnOptionD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQuestion.setText("Tu będzie pytanie");

        lblScore.setText("Punkty: 0");

        btnOptionA.setText("jButton1");
        btnOptionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionAActionPerformed(evt);
            }
        });

        btnOptionB.setText("jButton2");
        btnOptionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionBActionPerformed(evt);
            }
        });

        btnOptionC.setText("jButton3");
        btnOptionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionCActionPerformed(evt);
            }
        });

        btnOptionD.setText("jButton4");
        btnOptionD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lblQuestion))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOptionA))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOptionB))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOptionC))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOptionD))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblScore)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblQuestion)
                .addGap(35, 35, 35)
                .addComponent(btnOptionA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(lblScore)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOptionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionAActionPerformed
        Question q = session.getCurrentQuestion();
        if (q instanceof MultipleChoiceQuestion) {
            handleAnswer("0"); // Indeks 0 (A)
        } else {
            handleAnswer("true"); // Przycisk A to PRAWDA
}
    }//GEN-LAST:event_btnOptionAActionPerformed

    private void btnOptionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionBActionPerformed
        Question q = session.getCurrentQuestion();
        if (q instanceof MultipleChoiceQuestion) {
            handleAnswer("1"); // Indeks 1 (B)
        } else {
            handleAnswer("false"); // Przycisk B to FAŁSZ
}
    }//GEN-LAST:event_btnOptionBActionPerformed

    private void btnOptionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionCActionPerformed
        handleAnswer("2");
    }//GEN-LAST:event_btnOptionCActionPerformed

    private void btnOptionDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionDActionPerformed
        handleAnswer("3");
    }//GEN-LAST:event_btnOptionDActionPerformed
    public static void main(String args[]) {
            /* Ustawienie wyglądu okna na systemowy */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(QuizWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            /* Tworzenie i wyświetlanie okna */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new QuizWindow().setVisible(true);
                }
            });
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOptionA;
    private javax.swing.JButton btnOptionB;
    private javax.swing.JButton btnOptionC;
    private javax.swing.JButton btnOptionD;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblScore;
    // End of variables declaration//GEN-END:variables
}