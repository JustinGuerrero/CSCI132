import java.util.Scanner;// import scanner

public class CipherDriver {


    /**
     * Simple main method for testing the Caesar Cipher
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your key code #:");
        CaesarCipher cipher = new CaesarCipher(input.nextInt());
        input.nextLine();

//        System.out.println("Encryption code = " + new String(cipher.encoder0));
//        System.out.println("Decryption code = " + new String(cipher.decoder0));
//        System.out.println("Decryption code = " + new String(cipher.decoder1));
//        System.out.println("Decryption code = " + new String(cipher.decoder2));
//

        System.out.println("enter E for Encrypt, or D for Decrypt: ");
        String whatToDo = input.nextLine(); // driver to check what the user wants to do.
        do {
            // System.out.println("Please enter a valid selection: E - Encode, D- Decode, Q - Quit.");
            // encodes and calls different methods to do that.
            if (whatToDo.equalsIgnoreCase("E")) {
                System.out.println("Please enter the message you want to encode:");
                String message = input.nextLine();
                String coded = cipher.doCrypticSchiznit(message);
                System.out.println("Secret: " + coded);
                whatToDo = " ";
            }
            else if (whatToDo.equalsIgnoreCase("D")) {
                System.out.println("Please enter the message you want to decode:");
                String message = input.nextLine();
                String answer = cipher.doDecrypticSchiznit(message);
                System.out.println("Message: " + answer);
                whatToDo = " ";

            }
            else{
                System.out.println("Please enter a valid selection: E - Encode, D- Decode, Q - Quit.");
                whatToDo = input.nextLine();

            }
        }while (!whatToDo.equalsIgnoreCase("Q")) ;




        /*String message = input.next(); // WTF? stops working at lowercase u??
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " +coded);
        String answer = cipher.decrypt(coded);
        System.out.println("message: " +answer);*/

    }
}


