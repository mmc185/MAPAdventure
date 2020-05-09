/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

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
    
    private Map<CommandType,String> parsedData;

    public Parser() {
        this.parsedData=new HashMap<>();
    }

    public Map getParserData() {
        return parsedData;
    }

    public void setParserData(Map parserData) {
        this.parsedData = parserData;
    }
    
    public Map<CommandType,String> parse(String phrase,Room currentRoom,Inventory inv,Set<Command>commands){
        
       return parsedData; 
    }
    
    public boolean isCommand(){
        return false;
    }
    
    public boolean isItem(){
       return false; 
    }
}
