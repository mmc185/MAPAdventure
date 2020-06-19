/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.util.Map;
import java.util.Objects;
import uni.mapadventureproject.parser.WordType;
import uni.mapadventureproject.type.CommandType;
import uni.mapadventureproject.type.Item;
import uni.mapadventureproject.type.Room;

public class MSGame extends GameManager {

    public MSGame(Game g) {
        super(g);
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
                } else if (r.getLockedBy().equals("")) {

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
                        i = this.getGame().getInventory().searchItem(commandMap.get(WordType.I_OBJ));
                    } else if (commandMap.containsKey(WordType.R_OBJ)) {
                        i = this.getGame().getCurrentRoom().getItemList().searchItem(commandMap.get(WordType.R_OBJ));
                    }

                    output = i.getDesc();

                } else if (commandMap.size() == 1) {

                    output = this.getGame().getCurrentRoom().getLook();

                } else if (commandMap.size() > 2) {
                    output = "Uno alla volta, ho una certa età."; ///???? da rimuovere? throw eccezione?
                }
                break;
            case PICK_UP:

                if (commandMap.containsKey(WordType.R_OBJ)) {

                    i = this.getGame().getCurrentRoom().getItemList().searchItem(commandMap.get(WordType.R_OBJ));

                    if (!Objects.isNull(i) && i.isPickupable()) {

                        this.getGame().getInventory().add(i);
                        this.getGame().getCurrentRoom().getItemList().remove(i);

                        output = "L'oggetto è stato aggiunto al tuo inventario.";

                    } else {
                        output = "Non puoi prendere questo oggetto.";
                    }
                } else {
                    //output = "Prendere cosa?";
                }
                break;
            case OPEN:

                if (commandMap.size() == 2 && commandMap.containsKey(WordType.I_OBJ)) {

                    i = this.getGame().getInventory().searchItem(commandMap.get(WordType.I_OBJ));
                    this.unlockRoom(i.getName());

                }
                break;
            case PUSH:

                if (commandMap.containsKey(WordType.I_OBJ)) {
                    i = this.getGame().getInventory().searchItem(commandMap.get(WordType.I_OBJ));
                } else if (commandMap.containsKey(WordType.R_OBJ)) {
                    i = this.getGame().getCurrentRoom().getItemList().searchItem(commandMap.get(WordType.R_OBJ));
                }

                if (i.isPushable()) {
                    i.setPush(true);
                } //???

                break;
            case RUN:

                output = "Non puoi \"foldare\" proprio adesso, ti sei impegnato tanto per questo progetto!";
                break;
            case EXIT:
                //System.exit(0);
                break;
            case WAKE_UP:
                //output = "bad ending?";
                break;
        }

        //trigger room??
        
        return output;
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

    public boolean unlockRoom(String iName) {
        
        boolean flag = false;
        //try / catch?
        if ( this.getGame().getCurrentRoom().getSouth().getLockedBy().equals(iName)) {
            this.getGame().getCurrentRoom().getSouth().setLockedBy("");
            flag = true;
        } else if ( this.getGame().getCurrentRoom().getNorth().getLockedBy().equals(iName)) {
            this.getGame().getCurrentRoom().getNorth().setLockedBy("");
            flag = true;
        } else if (this.getGame().getCurrentRoom().getEast().getLockedBy().equals(iName)) {
            this.getGame().getCurrentRoom().getEast().setLockedBy("");
            flag = true;
        } else if (this.getGame().getCurrentRoom().getWest().getLockedBy().equals(iName)) {
            this.getGame().getCurrentRoom().getWest().setLockedBy("");
            flag = true;
        } else if (this.getGame().getCurrentRoom().getUp().getLockedBy().equals(iName)) {
            this.getGame().getCurrentRoom().getUp().setLockedBy("");
            flag = true;
        } else if (this.getGame().getCurrentRoom().getDown().getLockedBy().equals(iName)) {
            this.getGame().getCurrentRoom().getDown().setLockedBy("");
            flag = true;
        }
         
        return flag;
    }

}