/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.Inventory;
import uni.mapadventureproject.type.Item;
import uni.mapadventureproject.type.Room;

/**
 *
 * @author Admin
 */
public class Parser {

    private Map<WordType, String> parsedData;

    public Parser() {
        this.parsedData = new HashMap<>();
    }

    public Map getParserData() {
        return parsedData;
    }

    public void setParserData(Map parserData) {
        this.parsedData = parserData;
    }

    public Map<WordType, String> parse(String phrase, Room currentRoom, Inventory inv, Set<Command> commands) {
        //TODO
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
