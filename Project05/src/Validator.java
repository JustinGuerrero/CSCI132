public class Validator{


    /**
     * The validation method. To make sure the stack is calling things correctly. We
     * write this for loop to check if each item from the stack is called. Also, it
     * is able to detect errors within stack alignment to make sure it can only call
     * the top element, erroring out if attempted to call the element below
     */
    ArrayStack muyCool = new ArrayStack();
        // 0) initialize array stack

    public boolean isValid(String s){
        // 1) Parse (to organize data in a useful way) s into a string array[]
        // using s.split(" ") return string array
        String[] splitter = s.split(" ");

        // 2) iterate over splitter
        for (int i = 0; i < splitter.length; i++) {
            // 2.1)
                if(splitter[i].equals("calls")){
                    if (!((String)(muyCool.top())).equals(splitter[i - 1])){
                        return false;}
                    muyCool.push(splitter[i + 1]);
                        }
                if(splitter[i].equals("halts"))
                    muyCool.pop();
                if (i == 0)
                    muyCool.push(splitter[i]);



        }
        // 3) is it empty? frick I hope so since we've gotten here

        return muyCool.isEmpty();
    }


}
