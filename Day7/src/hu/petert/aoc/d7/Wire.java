package hu.petert.aoc.d7;

public class Wire {

    private final String input;
    private boolean hasOutput = false;
    private char output = 0;

    public Wire(String input){

        this.input = input;
    }

    public char getOutput(){
        if(hasOutput) return output;
        output = getLocalOutput();
        hasOutput = true;
        return output;
    }

    private char getLocalOutput(){

        if(isInteger(input)) return (char) Integer.parseInt(input);
        String[] values = input.split(" ");

        if(values.length == 3){
            Wire w1, w2;
            if(isInteger(values[0])) w1 = new Wire(values[0]);
            else w1 = Main.wires.get(values[0]);
            if(isInteger(values[2])) w2 = new Wire(values[2]);
            else w2 = Main.wires.get(values[2]);

            if(values[1].equals("AND")) return (char) (w1.getOutput() & w2.getOutput());
            if(values[1].equals("OR")) return (char) (w1.getOutput() | w2.getOutput());
            if(values[1].equals("LSHIFT")) return (char) (w1.getOutput() << w2.getOutput());
            if(values[1].equals("RSHIFT")) return (char) (w1.getOutput() >>> w2.getOutput());
        } else if(values.length == 2){
            Wire w1;
            if(isInteger(values[1])) w1 = new Wire(values[1]);
            else w1 = Main.wires.get(values[1]);

            if(values[0].equals("NOT")) return (char) ~ w1.getOutput();
        } else if(values.length == 1){
            return Main.wires.get(values[0]).getOutput();
        }

        return 0;
    }

    private boolean isInteger(String s){
        try {
            Integer.parseInt(s, 10);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

}
