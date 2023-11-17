/* 
 * Hangman game to guess a word
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Hangman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = { "hello", "world", "java", "programming" };
        Random random = new Random();
        int index = random.nextInt(words.length);
        String word = words[index];
        char[] wordArr = word.toCharArray();
        char[] hiddenWord = new char[wordArr.length];
        Arrays.fill(hiddenWord, '*');
        int attempts = 0;
        boolean isMatch = false;
        while (attempts < 5) {
            System.out.println("Hidden word: " + new String(hiddenWord));
            System.out.print("Enter your guess: ");
            char guess = sc.next().charAt(0);
            for (int i = 0; i < wordArr.length; i++) {
                if (wordArr[i] == guess) {
                    hiddenWord[i] = guess;
                    isMatch = true;
                }
            }
            if (!isMatch) {
                attempts++;
            }
            isMatch = false;
        }
        System.out.println("Attempts: " + attempts);
        System.out.println("Word: " + word);
    }
}


