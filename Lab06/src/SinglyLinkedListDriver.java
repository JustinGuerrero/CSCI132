public class SinglyLinkedListDriver {

    public static void main(String[] args){

        SinglyLinkedList<String> airports = new SinglyLinkedList<>();
        airports.addFirst("LAX");
        airports.addFirst("BCN");
        airports.addFirst("AMS");
        System.out.println(airports.toString());
        airports.addAfter(1,"PEK");
        airports.addAfter(2, "PVR");

        System.out.println(airports.toString());


        SinglyLinkedList<Song> playlist = new SinglyLinkedList<>();
        playlist.addFirst(new Song("Arabella", "Arctic Monkeys"));
        playlist.addLast(new Song("Lift You Up", "Zeds Dead, Delta Heavy"));
        playlist.addAfter((new Song("Diving With Whales", "Nora En Pure")));



        SinglyLinkedList<String> quote = new SinglyLinkedList<>();
        quote.addFirst("to");
        quote.addAfter(0, "heck");
        quote.addAfter(1, "with");
        quote.addAfter(2, "this");
        quote.addAfter(3,"POS");
        quote.addAfter(4,"lab");
        System.out.println(quote.toString());
    }
}
