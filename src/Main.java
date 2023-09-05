import com.codebehind.App;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SwingUtilities.invokeLater(() -> {
            App game = new App();
            game.setVisible(true);
        });


    }
}