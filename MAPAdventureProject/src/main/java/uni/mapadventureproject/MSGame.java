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
import uni.mapadventureproject.type.Room;

public class MSGame extends GameManager {

    public MSGame() {
        super();
    }

    @Override
    public String executeCommand(Map<WordType, String> commandMap) {

        CommandType command = this.getCommandType(commandMap.get(WordType.COMMAND));
        Room r;
        String output = "";

        switch (command) {
            case MOVE_S:
            case MOVE_N:
            case MOVE_E:
            case MOVE_W:
            case MOVE_U:
            case MOVE_D:
                if ((r = this.move(command)).isVisible()) {
                    this.getGame().setCurrentRoom(r);
                    output = this.getGame().getCurrentRoom().getDesc();
                } else {
                    output = "Questa stanza è chiusa!";
                }
                break;
            case INV:
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
    
   

}
