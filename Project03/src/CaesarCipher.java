public class CaesarCipher {
    /**
     *Listen up friends here's a Caesar Cipher class. Guess what it does? it takes in a message and encodes or decodes it.
     * The protected variables @encoder and @decoder will create char arrays for upper, and lowercase letters.
     */

    //FIELDS
    private int numKeys = 26;
    protected char[] encoder0 = new char[52];
    protected char[] encoder1 = new char[52];
    protected char[] encoder2 = new char[52];

    protected char[] decoder0 = new char[52];
    protected char[] decoder1 = new char[52];
    protected char[] decoder2 = new char[52];

    /**
     *these are said arrays that hold the characters.
     */
    //CONSTRUCTOR

    public CaesarCipher(int rotation) {

        /**
         *THE CONSTRUCTOR!!!!
         * has input parameter rotation that takes in the three digit code given by the user.
         * There are also three int variables here in the constructor
         * @lefty will give the left most digit given in the key code
         * @middle gives the middle digit from the key
         * @righty gives the right hand part of the key
         * Also note the various for loops created to encode and decode the letters given by the user.
         */

        int lefty = rotation/100; //gives the 'hundred' space in '1'23.
        int middle = (rotation%100)/10;//gives the 'tens' space in 1'2'3.
        int righty = (rotation%100)%10; // gives the 'ones' space in 12'3'.

        System.out.println("Your top secret super special key code is " +lefty+ " - " +middle+ " - " +righty);

        for (int k = 0; k <numKeys; k++) {
            encoder0[k] = (char) ('A' + (k + lefty) % numKeys);
            decoder0[k] = (char) ('A' + (k - lefty + numKeys) % numKeys);
        }

        for (int k = 0; k <numKeys; k++) {
            encoder0[k+26] = (char) ('a' + (k + lefty) % numKeys);
            decoder0[k+26] = (char) ('a' + (k - lefty + numKeys) % numKeys);
        }

        for (int k = 0; k <numKeys; k++) {
            encoder1[k] = (char) ('A' + (k + middle) % numKeys);
            decoder1[k] = (char) ('A' + (k - middle + numKeys) % numKeys);
        }

        for (int k = 0; k <numKeys; k++) {
            encoder1[k+26] = (char) ('a' + (k + middle) % numKeys);
            decoder1[k+26] = (char) ('a' + (k - middle + numKeys) % numKeys);
        }
        for (int k = 0; k <numKeys; k++) {
            encoder2[k] = (char) ('A' + (k + righty) % numKeys);
            decoder2[k] = (char) ('A' + (k - righty + numKeys) % numKeys);
        }

        for (int k = 0; k <numKeys; k++) {
            encoder2[k+26] = (char) ('a' + (k + righty) % numKeys);
            decoder2[k+26] = (char) ('a' + (k - righty + numKeys) % numKeys);
        }


        /**
         * These for loops give us our six look up tables for encoding and decoding.
         */




        // The CaesarCipher takes as a parameter the int rotation. Rotation is the offset that we change the alphabet by
        // to encrypt our message. We then devide by 26 with modulous devision to get a whole number that is associated
        //with the numeric value of each character of the alphabet.
        //The for loop replaces each letter of the message with an offset letter based on our rotation. The same thing occurs
        // in reverse for our decoder array.
    }

    public String doCrypticSchiznit(String message) {

        /**
         *this method takes a message and converts it to a character array. Then based on the encoder array it replaces the letters in
         * message with a encoded message.
         */
        //hello -- 123 -- "igomp"
        char[] asChar = message.toCharArray();
        for (int i = 0; i < asChar.length; i += 3) {
            String temporaryChar = asChar[i] + "";
            String returnedString = encrypt(temporaryChar, encoder0);
            char[] returnedStringAsCharArray = returnedString.toCharArray();
            char toReplace = returnedStringAsCharArray[0];
            asChar[i] = toReplace;

        }
        for (int i = 1; i < asChar.length; i += 3) {
            String temporaryChar = asChar[i] + "";
            String returnedString = encrypt(temporaryChar, encoder1);
            char[] returnedStringAsCharArray = returnedString.toCharArray();
            char toReplace = returnedStringAsCharArray[0];
            asChar[i] = toReplace;

        }

        for (int i = 2; i < asChar.length; i += 3) {
            String temporaryChar = asChar[i] + "";
            String returnedString = encrypt(temporaryChar, encoder2);
            char[] returnedStringAsCharArray = returnedString.toCharArray();
            char toReplace = returnedStringAsCharArray[0];
            asChar[i] = toReplace;

        }
        return String.copyValueOf(asChar);
    }
    public String doDecrypticSchiznit(String message) {

        /**
         *this method takes an encrypted message and converts it to a character array. Then based on the decoder array it replaces the letters in
         * message with a decoded message.
         */
        //hello -- 123 -- "igomq"
        char[] asChar = message.toCharArray();
        for (int i = 0; i < asChar.length; i += 3) {
            String temporaryChar = asChar[i] + "";
            String returnedString = encrypt(temporaryChar, decoder0);
            char[] returnedStringAsCharArray = returnedString.toCharArray();
            char toReplace = returnedStringAsCharArray[0];
            asChar[i] = toReplace;

        }
        for (int i = 1; i < asChar.length; i += 3) {
            String temporaryChar = asChar[i] + "";
            String returnedString = encrypt(temporaryChar, decoder1);
            char[] returnedStringAsCharArray = returnedString.toCharArray();
            char toReplace = returnedStringAsCharArray[0];
            asChar[i] = toReplace;

        }

        for (int i = 2; i < asChar.length; i += 3) {
            String temporaryChar = asChar[i] + "";
            String returnedString = encrypt(temporaryChar, decoder2);
            char[] returnedStringAsCharArray = returnedString.toCharArray();
            char toReplace = returnedStringAsCharArray[0];
            asChar[i] = toReplace;

        }
        return String.copyValueOf(asChar);
    }

    public String encrypt(String secret, char[] encoder) {
        return transform(secret, encoder);



    } //this is the method encrypt it takes in  the message we write down and then calls transform on it. Transform takes as
    //parameters message and encoder. we'll talk more about what transform does when we get to it.

    public String decrypt(String secret, char[] decoder) {
        return transform(secret, decoder);

    } //
    // takes as parameters the secret message and the decoder array and returns the secret.

    /**
     * Returns transformation of original String using given code.
     */

    private String transform(String original, char[] code) {
        /**
         * ok this changes the message into a changed message based on the upper or lower case message.
         */

        char[] msg = original.toCharArray();
        for (int k = 0; k < msg.length; k++) {

            if (msg[k] == ' ') {
                msg[k] = ' ';
            } else if (Character.isUpperCase(msg[k])) {
                int j = msg[k] - 'A';
                msg[k] = code[j];
            } else if (Character.isLowerCase(msg[k])) {
                int j = msg[k] - 'G';
                msg[k] = code[j];///// ask some questions?

            }


        }
        return new String(msg);
    }
}