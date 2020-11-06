/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_system;

import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JTextField;

/**
 *
 * @author TD06
 */
public class Function {

    public static int isEmptyTextBox(JTextField... txt) {
        for (JTextField t : txt) {
            String st = t.getText().trim();
            if (st.length() == 0) {
                t.grabFocus();
                Toolkit.getDefaultToolkit().beep();
                return 0;
            }
        }
        return 1;
    }

    public static String generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        String result = new String(password);
        return result;
    }
}
