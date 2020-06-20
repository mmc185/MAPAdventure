package uni.mapadventureproject;

import java.util.HashMap;
import java.util.Map;
import uni.mapadventureproject.parser.Parser;
import uni.mapadventureproject.parser.InvalidStringException;

public class GameInteraction {

    private GameManager g;
    private Parser p;

    GameInteraction(GameManager g) {
        this.g = g;
        p = new Parser();
    }

    public GameManager getGameManager() {
        return g;
    }

    public String inputManager(String sInput) {

        Map commandMap = new HashMap<>();
        String sOutput = "";
        /*Scanner input = new Scanner(System.in);
        String command = "";

        System.out.println(g.getGame().getCurrentRoom().getDesc());
        
        command = input.nextLine();*/
        try {
            commandMap = p.parse(sInput, g.getGame().getCurrentRoom(), g.getGame().getInventory(), g.getGame().getCommands());
            sOutput = g.executeCommand(commandMap);
        } catch (InvalidStringException e) {
            sOutput = "Idea interessante... ma no.";
        }
        
        return sOutput;
    }

}
