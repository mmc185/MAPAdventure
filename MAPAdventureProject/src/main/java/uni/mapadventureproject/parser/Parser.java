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

        // Formato da coppie di tipi di parola e stringa che lo identifica. (e.g. (OBJECT, "taralli") )
        Map<WordType, String> parsedData = new HashMap<>();

        String[] tokens = phrase.toLowerCase().split("\\s+");

        for (String t : tokens) {

            if (this.isCommand(t, commands)) {

                parsedData.put(WordType.COMMAND, t);

            }

        }

        if (parsedData.size() == 1) {

            for (String t : tokens) {

                if (this.isItem(t, inv)) {

                    parsedData.put(WordType.I_OBJ, t);

                }

                if (this.isItem(t, currentRoom.getItemList())) {

                    parsedData.put(WordType.R_OBJ, t);

                }

            }

        }

        return parsedData;
    }

    private boolean isCommand(String s, Set<Command> commands) {

        for (Command c : commands) {

            if (c.getName().equals(s) || c.getAlias().contains(s)) {

                return true;

            }

        }

        return false;
    }

    private boolean isItem(String s, Inventory inv) {

        for (Item i : inv.getInventoryList()) {

            if (i.getName().equals(s) || i.getAlias().contains(s)) {

                return true;

            }

        }

        return false;
    }

}
