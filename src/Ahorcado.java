import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);
        // random instance
        Random random = new Random();
        // word array
        String[] words = {"potatoe", "cheese", "intelligence", "nourishment", "serendipity"}; 
        // word to guess
        String secretWord = words[random.nextInt(words.length)];
        // max attemps
        byte maxAttemps = 5;
        // current attempt
        byte attemptNum = 0;
        // check if the word has been guessed 
        boolean guessedWord = false;
        // character array to create the word
        char[] guessedLetters = new char[secretWord.length()];
        // Fill the guessedLetters array with '_'
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        System.out.println("Try to guess the secret word, it has " + secretWord.length() + " letters!");

        // check user's input and attemps
        while (!guessedWord && attemptNum < maxAttemps) {
            // set to false in each new iteration
            boolean correctLetter = false;
            //'value of' returns a string from a character array
            System.out.println("Discovered letters until now: " + String.valueOf(guessedLetters));
            System.out.println("Insert one letter:     (left attemps: )" + (maxAttemps - attemptNum));
            // receive a character from the user's input// charAt(0)
            char letter = Character.toLowerCase(scanner.next().charAt(0));
            // iterate over the secretWord 
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    correctLetter = true;
                }   
            }
            // check if the user guessed the letter
            if (!correctLetter) {
                attemptNum++;
                System.out.println("Wrong attempt with: " + letter + " Left attemps: " + (maxAttemps - attemptNum));

            }
            // To compare String the equals method must be used
            if(String.valueOf(guessedLetters).equals(secretWord)){
                guessedWord = true;
            }
        }
        // close scanner
        scanner.close();
        // check result
        if (guessedWord) {
            System.out.println("Great! You guessed the word: " + secretWord);
        }else{
            System.out.println("Better luck next time!");
        }

    }
}
