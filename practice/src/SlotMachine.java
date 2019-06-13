import java.util.Random;

/** The public class Slot machine will generate the random numbers for the machine to run
 * This is also where we will create private variables to connect with the random generators
 * At the bottom, you'll notice getters that will return the values so in our class
 * Gambling data you will be able to grab the random numbers created here.
 * There is also a print statement that prints in the correct format to make
 * the machine look like a machine.
 */

public class SlotMachine {

    public SlotMachine() {

    }

    private int slotOne = 0;
    private int slotTwo = 0;
    private int slotThree = 0;

    public void numberGen() {

        Random rand = new Random();  // This allows us to initialize random numbers

        slotOne = rand.nextInt(7) + 1; //this notation will make the ighest number 7
        //and the lowest number one

        slotTwo = rand.nextInt(7) + 1;

        slotThree = rand.nextInt(7) + 1;

    }
    public void printSlot() {

        System.out.println("+---+---+---+");
        System.out.println("| " + slotOne + " | " + slotTwo + " | " + slotThree + " |");
        System.out.println("+---+---+---+");

    }

    public int getSlotOne(){

        return slotOne;
    }

    public int getSlotTwo(){

        return slotTwo;
    }

    public int getSlotThree(){

        return slotThree;
    }


}

