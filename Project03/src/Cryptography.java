public class Cryptography {

    /** here I declared a variable 58 to change all the char arrays with, it just makes the code easier to change if you
     * want to refactor something later on.
     * also here you will want to create 3 decoder and encoder arrays in order to use on the message.
     * think of how a for loop you can change every third letter in the char array, and you'll want to add that into
     * the transformation section of the code.
     */
    protected int num = 58;
        protected char[] encoder = new char[num];
        protected char[] encoder2 = new char[num];
        protected char[] encoder3 = new char[num]; //Encryption array
        protected char[] decoder = new char[num];
        protected char[] decoder2 = new char[num];
        protected char[] decoder3 = new char[num];// Decryption array


        public Cryptography (String rotation) {
            int[] dials = new int[rotation.length()];
            int ctr = 0;
            for (char c : rotation.toCharArray()) {
                try {
                    dials[ctr] = Integer.parseInt(c + "");
                } catch (Exception e) {
                    dials[ctr] = 0;
                }
                ctr++;
            }

            /** here I will leave the above codethe above code and give you something a bit more simplistic. This will use modular and
             * integer division to create your method to spin the encoder and decoder to the desired number.
             * it is shown below. you should not need to change the constructor from int to string, this will simply
             * over complicate things and make it harder to work with.
             * public CaesarCipher(int rotation) {
             int lefty = rotation / 100;
             int middle = (rotation % 100) / 10;
             int righty = (rotation % 100) % 10;
             */

            for(int k = 0; k<26; k++) {
                encoder[k] = (char)('A' + (dials[k % dials.length]) % num);
                decoder[k] = (char)('A' + (dials[k % dials.length]) % num);
            }
        }
        public String encrypt(String message) {
            return transform(message, encoder);
        }
        public String decrypt(String secret) {
            return transform(secret, decoder);
        }

    /** inside of this transform message you'll also have to take into account for lowercase letters
     * this is a very easy and simple fix. basically you can reuse the code you'll need for in, and the method call is
     *  Character.isLowerCase
     */
    private String transform(String original, char[] code) {
            char[] msg = original.toCharArray();
            for (int k=0; k < msg.length; k++)
                if(Character.isUpperCase(msg[k])) {
                    int j = msg[k] - 'A';
                    msg[k] = code[j];
                }

            return new String(msg);
        }

    }




