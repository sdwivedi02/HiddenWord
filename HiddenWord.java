import java.util.Scanner;

public class HiddenWord {

    private int length;
    private String string;
    private String[] array;

    String resultingString = "";
    boolean checker = false;
    int hiddenWordLength;

    private static Scanner in = new Scanner(System.in);

    public HiddenWord(String word){
        this.length = word.length();
        this.string = word;
        this.array = word.split("");
    }

    public int getLength(){
        return length;
    }

    public String getString(){
        return string;
    }

    public String[] getArray(){
        return array;
    }

    public String getHint(String guess){
        resultingString = "";

        String[] guessArray = new String[getLength()];

        guessArray = guess.split("");

        String[] hiddenArray = getArray();

        for(int i = 0; i < getLength(); i ++){
            checker = false;

            for(int j = 0; j < getLength(); j++){

                if(guessArray[i].equals(hiddenArray[j])){
                    if(i == j){
                        resultingString += guessArray[i];
                    }else if(i != j){
                        resultingString += "+";
                    }
                    checker = true;
                    break;
                }
            }
            if(checker == false){
                resultingString += "*";
            }
        }

        return resultingString;

    }

    public static void main(String args[]){
        System.out.print("\nEnter hidden word: ");
        String hiddenInput = in.next();

        hiddenInput = hiddenInput.toUpperCase();

        HiddenWord puzzle = new HiddenWord(hiddenInput);

        System.out.print("\nEnter guess: ");
        String inputGuess = in.next();
        inputGuess = inputGuess.toUpperCase();

        System.out.println("\n" + puzzle.getHint(inputGuess) + "\n");

    }

}
