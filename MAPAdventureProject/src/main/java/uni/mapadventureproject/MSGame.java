/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.util.Map;
import java.util.Objects;
import uni.mapadventureproject.parser.WordType;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.CommandType;
import uni.mapadventureproject.type.Inventory;
import uni.mapadventureproject.type.Item;
import uni.mapadventureproject.type.Room;

public class MSGame extends GameManager {

    public MSGame() {
        super();
    }

    @Override
    public String executeCommand(Map<WordType, String> commandMap) {

        CommandType command = this.getCommandType(commandMap.get(WordType.COMMAND));
        Room r;
        Item i = null;
        String output = "";

        switch (command) {
            case MOVE_S:
            case MOVE_N:
            case MOVE_E:
            case MOVE_W:
            case MOVE_U:
            case MOVE_D:
                
                if (Objects.isNull(r = this.move(command))) {
                    output = "Non puoi andare lì!";
                } else if (r.isVisible()) {
                    
                    this.getGame().setCurrentRoom(r);
                    output = this.getGame().getCurrentRoom().getDesc();
                    
                } else {
                    output = "Questa stanza è chiusa!";
                }
                break;
            case INV:
                
                output = "Oggetti presenti nell'inventario: " + this.getGame().getInventory().toString();
                break;
            case LOOK:
                
                if (commandMap.size() == 2) {
                    
                    if (commandMap.containsKey(WordType.I_OBJ)) {
                        i = searchItem( commandMap.get(WordType.I_OBJ), this.getGame().getInventory());
                    } else if (commandMap.containsKey(WordType.R_OBJ)) {
                        i = searchItem( commandMap.get(WordType.I_OBJ), this.getGame().getInventory());
                    }
                    
                    output = i.getDesc();
                    
                } else if (commandMap.size() == 1) {
                    
                    output = this.getGame().getCurrentRoom().getLook();
                    
                } else if (commandMap.size() > 2) {
                    output = "Inserire un oggetto alla volta."; ///???? da rimuovere? throw eccezione?
                }
                break;
        }

        return "";
    }

    public CommandType getCommandType(String cName) {

        for (Command c : this.getGame().getCommands()) {

            if (c.getName().equals(cName) || c.getAlias().contains(cName)) {

                return c.getcType();

            }

        }

        return null;

    }

    public Room move(CommandType c) {

        if (c.equals(CommandType.MOVE_S) && !Objects.isNull(this.getGame().getCurrentRoom().getSouth())) {
            return this.getGame().getCurrentRoom().getSouth();
        } else if (c.equals(CommandType.MOVE_N) && !Objects.isNull(this.getGame().getCurrentRoom().getNorth())) {
            return this.getGame().getCurrentRoom().getNorth();
        } else if (c.equals(CommandType.MOVE_E) && !Objects.isNull(this.getGame().getCurrentRoom().getEast())) {
            return this.getGame().getCurrentRoom().getEast();
        } else if (c.equals(CommandType.MOVE_W) && !Objects.isNull(this.getGame().getCurrentRoom().getWest())) {
            return this.getGame().getCurrentRoom().getWest();
        } else if (c.equals(CommandType.MOVE_U) && !Objects.isNull(this.getGame().getCurrentRoom().getUp())) {
            return this.getGame().getCurrentRoom().getUp();
        } else if (c.equals(CommandType.MOVE_D) && !Objects.isNull(this.getGame().getCurrentRoom().getDown())) {
            return this.getGame().getCurrentRoom().getDown();
        }

        return null;
    }
    
    public Item searchItem (String iName, Inventory inv) {
        for ( Item i : inv.getInventoryList() ) {
            if (i.getName().equals(iName) || i.getAlias().contains(iName)) {

                return i;

            }
        }
        
        return null;
    }

}
