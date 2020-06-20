package uni.mapadventureproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import uni.mapadventureproject.parser.Parser;
import uni.mapadventureproject.parser.InvalidStringException;
import uni.mapadventureproject.type.CommandType;

public class GameInteraction {

    private GameManager g;
    private Parser p;

    GameInteraction(GameManager g) {
        this.g = g;
        p = new Parser();
    }

    public void inputManager() throws InvalidStringException {

        Map commandMap = new HashMap<>();

        Scanner input = new Scanner(System.in);
        String command = "";

        System.out.println(g.getGame().getCurrentRoom().getDesc());
        
        while (!commandMap.containsKey(CommandType.EXIT)) {
            command = input.nextLine();
            try {
            commandMap = p.parse(command, g.getGame().getCurrentRoom(), g.getGame().getInventory(), g.getGame().getCommands());
            System.out.println(g.executeCommand(commandMap));
            } catch (InvalidStringException e) {
                System.out.println("Eh??");
            }
            
        }

    }

}
