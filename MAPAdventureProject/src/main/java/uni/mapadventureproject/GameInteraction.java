package uni.mapadventureproject;

import uni.mapadventureproject.parser.Parser;

public class GameInteraction {

    GameManager g;
    Parser p;

    GameInteraction(GameManager g) {
        this.g = g;
        p = new Parser();
    }

    public void inputManager() {
        /* //Parser p = new Parser();
         * Map<> commandMap = new HashMap<>();
         * 
         * Scanner input = new Scanner(System.in);
         * 
         * while ( input.hasNextLine() ) {
         *  String command = input.nextLine();
         *  commandMap = p.parse(command, g.getCroom, g.getInv, g.getComm);
         * }
         */
    }

}
