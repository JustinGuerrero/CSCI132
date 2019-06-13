public class Checkit {

    public static void main(String[] args){

        int a = 10;
        int b = 5;
        int c = a;

        System.out.println(a == c);
        c += 10;
        System.out.println(a == c);
    }
}
