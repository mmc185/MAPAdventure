package uni.mapadventureproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import uni.mapadventureproject.parser.Parser;
import uni.mapadventureproject.parser.InvalidStringException;

public class GameInteraction {

    GameManager g;
    Parser p;

    GameInteraction(GameManager g) {
        this.g = g;
        p = new Parser();
    }

    public void inputManager() throws InvalidStringException {

        Map commandMap = new HashMap<>();

        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String command = input.nextLine();
            commandMap = p.parse(command, g.getGame().getCurrentRoom(), g.getGame().getInventory(), g.getGame().getCommands());
        }

    }

}
