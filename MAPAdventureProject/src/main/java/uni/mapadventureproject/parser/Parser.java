package uni.mapadventureproject.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.Inventory;
import uni.mapadventureproject.type.Item;
import uni.mapadventureproject.type.Room;

public class Parser {

    public Map<WordType, String> parse(String phrase, Room currentRoom, Inventory inv, Set<Command> commands) {
        Map<WordType, String> parsedData = new HashMap<>();
        return parsedData;
    }

    public boolean isCommand() {
        //TODO
        return false;
    }

    public boolean isItem() {
        //TODO
        return false;
    }
}
