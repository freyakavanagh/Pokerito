import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Pokerito {
    static Scanner scanner = new Scanner(System.in);

    public static String generateCard(){


        String card;

        Random random = new Random();

        int randomNumber = random.nextInt(13) + 1;

        switch (randomNumber) {

            case 1:
                card = "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
                break;
            case 2:
                card = "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
                break;

            case 3:
                card = "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
                break;
            case 4:
                card = "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
                break;
            case 5:
                card = "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
                break;
            case 6:
                card = "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
                break;
            case 7:
                card = "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
                break;
            case 8:
                card = "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
                break;
            case 9:
                card = "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
                break;
            case 10:
                card = "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
                break;
            case 11:
                card = "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
                break;
            case 12:
                card = "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
                break;

            case 13:
                card = "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
                break;

            default:
                card = "Invalid card number";
        }


        return card;
    }

    public static String explainRules(){

        String rules = "Let's play Pokerito. Type anything when you're ready.\n" +
                "It's like Poker, but a lot simpler.\n" +
                "- There are two players, you and the computer.\n" +
                "- The dealer will give each player one card.\n" +
                "- Then, the dealer will draw five cards (the river)\n" +
                "- The player with the most river matches wins!\n" +
                "- If the matches are equal, everyone's a winner!\n" +
                "- Ready? Type 'yes' if you are.";

        return rules;
    }

    public static void generateStream(String playersCard, String computersCard){
        ArrayList<String> streamCards = new ArrayList<>();
        System.out.println("Now, the dealer will draw five cards. Press enter to continue.");
        scanner.nextLine();
        String card1 = generateCard();
        streamCards.add(card1);
        System.out.println("Card 1:\n" + card1);
        scanner.nextLine();
        String card2 = generateCard();
        streamCards.add(card2);
        System.out.println("Card 2:\n" + card2);
        scanner.nextLine();
        String card3 = generateCard();
        streamCards.add(card3);
        System.out.println("Card 3:\n" + card3);
        scanner.nextLine();
        String card4 = generateCard();
        streamCards.add(card4);
        System.out.println("Card 4:\n" + card4);
        scanner.nextLine();
        String card5 = generateCard();
        streamCards.add(card5);
        System.out.println("Card 5:\n" + card5);

        decideWinner(streamCards, playersCard, computersCard);

    }

    public static int countMatches(ArrayList<String> cardStream, String playerCard){
        int matches = 0;
        for (String card : cardStream) {
            if (playerCard.equals(card)) {
                matches++;
            }
        }
        return matches;
    }

    public static void decideWinner(ArrayList<String> cardStream, String playersCard, String computersCard){

        int playerMatches = countMatches(cardStream, playersCard);
        int computerMatches = countMatches(cardStream, computersCard);

        System.out.println("You got " +playerMatches+" matches.");
        System.out.println("I got "+computerMatches+" matches.");

        if(playerMatches == computerMatches){
            System.out.println("It's a draw!");
        }else if(playerMatches > computerMatches){
            System.out.println("You win!");
        }else if(playerMatches < computerMatches){
            System.out.println("I win!");
        }

    }


    public static void playPokerito(){

        System.out.println(explainRules());
        if(scanner.nextLine().equals("yes")) {
            String playersCard = generateCard();
            System.out.println("This is your card:\n"+ playersCard);
            String computersCard = generateCard();
            System.out.println("This is my card:\n"+ computersCard);
            generateStream(playersCard, computersCard);


        }
    }

    public static void main(String[] args) {
        do{
        System.out.println("Want to play Pokerito?");
        if (scanner.nextLine().equals("yes")) {
            System.out.println("Get ready!");
            playPokerito();
            System.out.println("\nThanks for playing!");
        } else {
            System.out.println("Next time then!");
            break;
        }
    } while (true);

    }
}
