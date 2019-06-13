public class mainStacker {

    public static void main(String[] args) {
        /**
         * Main method creates instances of our classes, allowing us to
         * call the methods in the main and run our program, creating stacks and
         * queues.
         */

        DLLStack stacker = new DLLStack();
        ArrayStack chimken = new ArrayStack();
        queueClass cool = new queueClass();
        Validator val = new Validator();





        stacker.push(4);
        stacker.push("the floofer likes to eat");
        System.out.println(stacker.top());
        stacker.push("Chimken");
        stacker.push(34.3);
        stacker.pop();
        System.out.println(stacker.top());

        chimken.push(3);
        chimken.push(23.4);
        chimken.push("hi ");


        cool.enqueue(3);
        System.out.println(cool.toString());
        cool.enqueue("neato burrito");
        System.out.println(cool.toString());
        cool.enqueue(29834.3232);
        System.out.println(cool.toString());
        cool.enqueue(4);
        System.out.println(cool.toString());
        cool.dequeue();
        cool.first();
        System.out.println(cool.first());





        System.out.println(chimken.top());
        chimken.pop();
        System.out.println(chimken.isEmpty());
        System.out.println(stacker.toString());
        System.out.println(chimken.toString());
        stacker.pop();
        stacker.pop();
        stacker.pop();
        System.out.println(stacker.toString());
        System.out.println(stacker.isEmpty());

        // should validate

        String callStack = "A calls B B calls C C halts B halts A halts";
        System.out.println(val.isValid(callStack));

        callStack = "A calls B B calls C C calls D D halts C calls E E halts C halts B halts A halts";
        System.out.println(val.isValid(callStack));

        callStack = "A calls A A halts A halts";
        System.out.println(val.isValid(callStack));

        callStack = "main calls functionA functionA calls testMe testMe halts functionA calls runRun runRun halts functionA halts main halts";
        System.out.println(val.isValid(callStack));

// Should fail

        callStack = "main calls A A calls B A calls C B halts C halts A halts main halts";
        System.out.println(val.isValid(callStack));

        callStack = "A calls B B halts";
        System.out.println(val.isValid(callStack));


    }
}
