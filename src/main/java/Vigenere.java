import java.util.Scanner;



public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        int l = key.length();
        int count=0;
        String result = "";
        int k=0;
        String n = "";
        for (int i=0;i<message.length();i++){
            char x = message.charAt(i);
            if (x<65 || (x>90 && x<97) || x>122){
                count+=1;

                result+=x;
            }
            else{
                char y = key.charAt((i-count)%l);

                if (x >= 65 && x <= 90){
                    k=y-65;
                    if (x + k >= 91) {
                        result += (char) (x - 26+k);
                    }
                    else {
                        result += (char) (x + k);
                    }
                }
                else {
                    k= y - 65;
                    if (x + k >= 123) {
                        result += (char) (x - 26+k);
                    }
                    else {
                        result += (char) (x + k);
                    }
                }
            }
        }
        return result;
    }

    public static String decryptVigenere (String message, String key){


        int l = key.length();
        int count=0;
        String result = "";
        int k=0;
        String n = "";
        for (int i=0;i<message.length();i++){
            char x = message.charAt(i);
            if (x<65 || (x>90 && x<97) || x>122){
                count+=1;

                result+=x;
            }
            else{
                char y = key.charAt((i-count)%l);

                if (x >= 65 && x <= 90){
                    k=y-65;
                    if ((x<=64+k)||(x>=97 && x<=96+k)) {
                        result += (char) (x + 26-k);
                    }
                    else {
                        result += (char) (x - k);
                    }
                }
                else {
                    k= y - 65;
                    if ((x<=64+k)||(x>=97 && x<=96+k)) {
                        result += (char) (x + 26-k);
                    }
                    else {
                        result += (char) (x - k);
                    }
                }
            }
        }
        return result;
    }


        public static void main (String[]args){
            Scanner scan = new Scanner(System.in);

            System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
            String command = scan.nextLine().trim().toLowerCase();

            if (command.equals("encrypt")) {
                System.out.println("Please enter your message to be encrypted: ");
                String message = scan.nextLine();
                System.out.println("Please enter the key for your message: ");
                String key = scan.nextLine().trim().toUpperCase();
                System.out.println("Here is your encrypted message: ");
                System.out.println(encryptVigenere(message, key));
            } else if (command.equals("decrypt")) {
                System.out.println("Please enter your message to be decrypted: ");
                String message = scan.nextLine();
                System.out.println("Please enter the key for your message: ");
                String key = scan.nextLine().trim().toUpperCase();
                System.out.println("Here is your decrypted message: ");
                System.out.println(decryptVigenere(message, key));
            } else {
                System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
            }

            scan.close();
        }
    }

