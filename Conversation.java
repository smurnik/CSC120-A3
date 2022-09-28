import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Conversation {

  /**
   * @param arguments
   */
  public static void main(String[] arguments) {

// creates canned responses 
    String[] responses = {"mmm-hm",
                                   "Elaborate?",
                                   "of course",
                                   "i see...",
                                   "what?",
                                   "interesting...",
                                   "i dont get it",
                                   "ohhh ok",
                                   "huh?",
                                   "yeah"
                                   };
        int phrase = responses.length;

//Asks User for name and outputs welcome 
    try (Scanner start = new Scanner(System.in)) {
      System.out.println("Enter your name: ");
      String name = start.next();

      System.out.println("Welcome " + name + "! How many rounds would you like: ");

//Takes in how many rounds
    try (Scanner userInput = new Scanner(System.in)) {
      int rounds = userInput.nextInt();
      System.out.println(start.nextLine());

// creates transcript array and adds previous conversation
      ArrayList<String> transcript = new ArrayList<String>();
      transcript.add("Enter your name: " + "\n");
      transcript.add(name + "\n");
      transcript.add("Welcome " + name + "! How many rounds would you like:" + "\n");

      System.out.println("Awsome lets start, whats on your mind today?");
      transcript.add("Awsome, whats on your mind today?" + "\n");

 //Creates a loop for chat
      Random rand = new Random();

      for(int i = 0; i < rounds; i++) {
        
        String input = start.nextLine(); //takes in user input
            String[] words = input.split(" "); // creates an array for user input
            StringBuilder end = new StringBuilder();
            boolean first = true;
            String mirrored;
            transcript.add(input + "\n");
            
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
                mirrored = responses[rand.nextInt(phrase)];
            }
            System.out.println(mirrored + "?");
        }
        System.out.println("Bye! Hope to see you again soon :)");
        transcript.add("Bye! Hope to see you again soon :)" + "\n");

// prints transcript        
        String newTranscript = transcript.toString()
        .replace(",", "")  
        .replace("[", "")  
        .replace("]", "")  
        .trim();
        System.out.println(" ");
        System.out.println("-TRANSCRIPT-");
       System.out.println(newTranscript);
        System.exit(0);
      }
    }
  }
}
