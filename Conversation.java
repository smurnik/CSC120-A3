import java.util.Scanner;
import java.util.Random;

class Conversation {

  /**
   * @param arguments
   */
  public static void main(String[] arguments) {

// creates canned responses 
    String[] cannedPhrases = {"mmm-hm",
                                   "Hmm tell me more",
                                   "of course",
                                   "i see...",
                                   "what?",
                                   "interesting...",
                                   "i dont get it",
                                   "ohhh ok",
                                   "huh?"
                                   };
        int phrase = cannedPhrases.length;

//Asks User for name and outputs welcome 
    try (Scanner start = new Scanner(System.in)) {
      System.out.println("Enter your name: ");
      String name = start.next();

      System.out.println("Welcome " + name + "! How many rounds would you like: ");

//Takes in how many rounds
    try (Scanner userInput = new Scanner(System.in)) {
      int rounds = userInput.nextInt();

// creates set up for transcript
      start.nextLine();
      String[] transcriptArray = new String[2 * rounds];

      transcriptArray[0] = "Awsome, whats on your mind today?";

 //Creates a loop for chat
      Random rand = new Random();
      int index = -1;

      System.out.println(transcriptArray[0]);
      for(int i = 0; i < rounds; i++) {
        String input = start.nextLine();
            String[] words = input.split(" ");
            StringBuilder end = new StringBuilder();
            boolean first = true;
            String mirrored;
 //Determins wether it should output random phrase or mirror phrase
      for (String word : words) {
                if (first) {
                    first = false;
                }
                else {
                    end.append(' ');
                }
                switch (word) {
                    case "im":
                        word = "youre";
                        break;
                    case "me":
                        word = "you";
                        break;
                    case "i":
                        word = "you";
                        break;
                    case "am":
                        word = "are";
                        break;
                    case "my":
                        word = "your";
                        break;
                    case "your":
                        word = "my";
                        break;
                    case "you":
                        word = "I";
                }
                end.append(word);
            }

            String newPhrase = end.toString();
            if (!newPhrase.equals(input)) {
                mirrored = newPhrase;
            }
            else {
                mirrored = cannedPhrases[rand.nextInt(phrase)];
            }
            System.out.println(mirrored + "?");
            transcriptArray[++index] = input;
            transcriptArray[++index] = mirrored;
        }
// prints transcript        
        System.out.println(" ");
        System.out.println("Transcript:");
        for (int i = 0; i < transcriptArray.length; i++) {
            System.out.println(transcriptArray[i]);
        }
        System.exit(0);
      }
    }
  }
}
