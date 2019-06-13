import java.util.Scanner;


public class GamblingMoney {

    /** Here we will use a public class gamblingMoney to define the money
     * and the scanner for input from the user. The user may enter a numerical
     * value in order to place a bet, or alternatively enter =1 to exit the game and
     * cash out
     *
     * @return
     */
    public int gamblingMoney() {
        int dinero = 100;
        int quit = 0;


        while (quit != -1) {
            System.out.println("Enter in your bet or enter -1 to cash out");
            Scanner src = new Scanner(System.in);
            int bet = src.nextInt();
            SlotMachine machine = new SlotMachine();
            int repeat = 0;

            if (bet == -1) {
                    System.out.println("Thanks for playing!");
                    System.out.println("your balance is " + dinero);

                    break;

            }

            else if (bet == -2){
                for(int i = 0; i <= 1000000; i++){
                bet = 1;
                dinero -= java.lang.Math.abs(bet);
                machine.numberGen();

                }

            }

            machine.numberGen();
            machine.printSlot();

            /** The if statements located below will utilize boolean methods to check and see the
             * equality of the reels of the slow machine. if the reels produce a match the
             * user will be awarded the values listed within the function, and will be
             * added to the "dinero" variable from above and printed below the slot.
             *
             *
             */

            if (machine.getSlotOne() == machine.getSlotTwo() && machine.getSlotTwo() == machine.getSlotThree()){
                dinero += machine.getSlotOne() * bet * 5;
                dinero -= bet;
                System.out.println("You won " + (machine.getSlotOne()*bet*5) + " credits");
                System.out.println("Your new balance is : " + dinero);

            }
            else if (machine.getSlotOne() == machine.getSlotTwo()) {
                dinero += machine.getSlotOne() * bet;
                dinero -= bet;
                System.out.println("You won " + (machine.getSlotOne()*bet) + " credits");
                System.out.println("Your new balance is : " + dinero);


            }
            else {
                dinero -= bet;
                System.out.println("your new balance is : " + dinero);
              // System.out.println(machine.numberGen());

            }
       }

        return 0;
    }
}
