import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String result="";
        for (int i=0;i<message.length();i++){
            char x=message.charAt(i);
            if ((x>=65 && x<=90)||x>=97 && x<=122) {
                if (x >= 120 || x >= 88 && x <= 90) {
                    result += (char) (x - 23);
                }
                else {
                        result += (char) (x + 3);
                }
            }
            else {
                result+=message.charAt(i);
            }
        }

        return result;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String result="";
        for (int i=0;i<message.length();i++){
            char x=message.charAt(i);
            if ((x>=65 && x<=90)||x>=97 && x<=122) {
                if ((x<=67)||(x>=97 && x<=99)) {
                    result += (char) (x + 23);
                }
                else {
                    result += (char) (x - 3);
                }
            }
            else {
                result+=message.charAt(i);
            }
        }

        return result;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String result="";
        key=key%26;

        for (int i=0;i<message.length();i++){
            char x=message.charAt(i);
            if ((x>=65 && x<=90)||(x>=97 && x<=122)) {
                if (x >= 123-key || (x >= 91-key && x <= 90)) {
                    result += (char) (x - 26+key);
                }
                else {
                    result += (char) (x + key);
                }
            }
            else {
                result+=message.charAt(i);
            }
        }

        return result;
    }
    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String result="";
        key=key%26;
        for (int i=0;i<message.length();i++){
            char x=message.charAt(i);

            if ((x>=65 && x<=90)||x>=97 && x<=122) {
                if ((x<=64+key)||(x>=97 && x<=96+key)) {
                    result += (char) (x + 26-key);
                }
                else {
                    result += (char) (x - key);
                }
            }
            else {
                result+=message.charAt(i);
            }
        }

        return result;
    }

    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");

        }
        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command2 = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your key to be encrypted: ");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message,key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your key to be decrypted: ");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message,key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }
        scan.close();
    }
}
