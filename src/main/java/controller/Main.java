package controller;

import gui.ChooseLogin;
import java.awt.Dimension;

/**
 *
 * @author Udinkosd
 */

public class Main {
    public static void main(String[] args) {
        ChooseLogin chooseLogin = new ChooseLogin();

        chooseLogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        chooseLogin.setPreferredSize(new Dimension(800, 600));

        chooseLogin.setVisible(true);
    }

    static class Model {

        public Model() {
        }
    }
}
