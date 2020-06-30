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
import uni.mapadventureproject.type.TriggeredRoom;

public class MSGame extends GameManager {
    
    
    public MSGame(Game g) {
        super(g);
    }
    
    @Override
    public String executeCommand(Map<WordType, String> commandMap) {
        
        CommandType command = this.getCommandType(commandMap.get(WordType.COMMAND));
        Room r = null;
        Item i = null;
        String output = "";
        
        /* Se l'azione sfrutta un oggetto salva l'oggetto e 
           lo rinomina nella Map per fare riferimento al suo nome principale
           e non a potenziali alias
        */
        if (commandMap.containsKey(WordType.I_OBJ)) {
            
            i = this.getGame().getInventory().searchItem(commandMap.get(WordType.I_OBJ));
            commandMap.put(WordType.I_OBJ, i.getName());
            
        } else if (commandMap.containsKey(WordType.R_OBJ)) {
            
            i = this.getGame().getCurrentRoom().getItemList().searchItem(commandMap.get(WordType.R_OBJ));
            commandMap.put(WordType.R_OBJ, i.getName());
            
        }
        
        try {
            
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
                        output = "===========================================\n"
                                + this.getGame().getCurrentRoom().getName() + "\n\n"
                                + this.getGame().getCurrentRoom().getDesc();
                        
                    } else {
                        output = "Questa stanza è chiusa!";
                    }
                    break;
                case INV:
                    
                    output = "Oggetti presenti nell'inventario: " + this.getGame().getInventory().toString();
                    break;
                case LOOK:
                    
                    if (commandMap.size() == 2) {
                        
                        output = i.getDesc();
                        
                    } else if (commandMap.size() == 1) {
                        
                        output = this.getGame().getCurrentRoom().getLook();
                        
                    } else if (commandMap.size() > 2) {
                        
                        output = "Uno alla volta, ho una certa età."; ///???? da rimuovere? throw eccezione?

                    }
                    break;
                case PICK_UP:
                    
                    if (commandMap.containsKey(WordType.R_OBJ)) {
                        
                        if (!Objects.isNull(i) && i.isPickupable()) {
                            
                            this.getGame().getInventory().add(i);
                            this.getGame().getCurrentRoom().getItemList().remove(i);
                            
                            output = "L'oggetto è stato aggiunto al tuo inventario.";
                            
                        } else {
                            output = "Non puoi prendere questo oggetto.";
                        }
                    } else if (commandMap.containsKey(WordType.I_OBJ)) {
                        
                        output = "Non puoi prendere qualcosa che hai già con te!";
                        
                    } else {
                        
                        output = "Prendere... cosa?";
                        
                    }
                    break;
                case OPEN:
                    
                    if (commandMap.containsKey(WordType.I_OBJ)) {
                        
                        i = this.getGame().getInventory().searchItem(commandMap.get(WordType.I_OBJ));
                        
                        if (i.getConsumable() != 0 && this.unlockRoom(i.getName())) {
                            
                            output = "Hai sbloccato la stanza!";
                            
                            i.setConsumable((byte) (i.getConsumable() - 1));
                            
                            if (i.getConsumable() == 0) {
                                this.getGame().getInventory().remove(i);
                                output += "\nL'oggetto " + i.getName() + "è stato rimosso.";
                            }
                            
                        } else {
                            output = "Non puoi aprire la stanza così!";
                        }
                        
                    } else {
                        output = "Non puoi aprire la stanza così!";
                    }
                    
                    break;
                case PUSH:
                    
                    if (i.isPushable() && !i.isPush()) {

                        // Compie l'azione
                        i.setPush(true);
                        output = i.getName() + " premuto!";
                        
                        // Controlla se il bottone apriva una stanza adiacente
                        this.unlockRoom(i.getName());
                        
                    } else {
                        output = "Non puoi premerlo!";
                    }
                    
                    break;
                case RUN:
                    
                    output = "Non puoi \"foldare\" proprio adesso, ti sei impegnato tanto per questo progetto!";
                    break;
                case EXIT:
                    //System.exit(0);
                    break;
                case WAKE_UP:
                    //output = "bad ending?";

                    output = "Hai scelto la via più semplice e questo non ti fa onore"
                            + "\n \n HAI COMPLETATO IL GIOCO IN : " + 
                            this.getGame().getGameTime().getTime(this.getGame().getGameTime().getSecondPassed());
                    
                    this.getGame().getGameTime().getTimer().cancel();
                    
                    this.getGame().setCurrentRoom(new Room(0,"",""));
                    break;
            }
            
            r = this.getGame().getCurrentRoom();

            //Triggera la stanza, se necessario
            if (r instanceof TriggeredRoom) {
                
                if (((TriggeredRoom) r).isTriggerable()) { //Se la stanza è triggerabile

                    String triggerer = commandMap.get(WordType.COMMAND); //Stringa da confrontare con quella che causa il trigger

                    if (commandMap.size() == 2) {
                        
                        if (commandMap.containsKey(WordType.R_OBJ)) {
                            
                            triggerer += " " + commandMap.get(WordType.R_OBJ);
                            
                        } else if (commandMap.containsKey(WordType.I_OBJ)) {
                            
                            triggerer += " " + commandMap.get(WordType.I_OBJ);
                            
                        }
                    }

                    //se triggerer=triggerer attuale della stanza, si effettua il trigger
                    if (triggerer.equals(((TriggeredRoom) r).getCurrentTriggerer())) {
                        
                        ((TriggeredRoom) r).setTrigger(true);
                        output += "\n\n" + r.getDesc();
                        
                    }
                    
                }
            }
            
            this.advancePlot();
            
        } catch (NullPointerException e) {
            
            output = "Sembra esserci qualcosa di strano in questa richiesta..."; //boh da cambiare?

        } finally {
            
            return output;
            
        }
        
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
        
        if (!Objects.isNull(this.getGame().getCurrentRoom().getSouth())
                && this.getGame().getCurrentRoom().getSouth().getLockedBy().equals(iName)) {
            
            this.getGame().getCurrentRoom().getSouth().setLockedBy("");
            flag = true;
            
        } else if (!Objects.isNull(this.getGame().getCurrentRoom().getNorth())
                && this.getGame().getCurrentRoom().getNorth().getLockedBy().equals(iName)) {
            
            this.getGame().getCurrentRoom().getNorth().setLockedBy("");
            flag = true;
            
        } else if (!Objects.isNull(this.getGame().getCurrentRoom().getEast())
                && this.getGame().getCurrentRoom().getEast().getLockedBy().equals(iName)) {
            
            this.getGame().getCurrentRoom().getEast().setLockedBy("");
            flag = true;
            
        } else if (!Objects.isNull(this.getGame().getCurrentRoom().getWest())
                && this.getGame().getCurrentRoom().getWest().getLockedBy().equals(iName)) {
            
            this.getGame().getCurrentRoom().getWest().setLockedBy("");
            flag = true;
            
        } else if (!Objects.isNull(this.getGame().getCurrentRoom().getUp())
                && this.getGame().getCurrentRoom().getUp().getLockedBy().equals(iName)) {
            
            this.getGame().getCurrentRoom().getUp().setLockedBy("");
            flag = true;
            
        } else if (!Objects.isNull(this.getGame().getCurrentRoom().getDown())
                && this.getGame().getCurrentRoom().getDown().getLockedBy().equals(iName)) {
            
            this.getGame().getCurrentRoom().getDown().setLockedBy("");
            flag = true;
            
        }
        
        return flag;
    }
    
    private void advancePlot() {
        
        Item i;

        // Se è nella stanza principale del gioco
        if (this.getGame().getCurrentRoom().getName().equals("Atrio della Metastazione")) {

            // Se ha con sè l'oggetto pendrive ovvero se è parte iniziale dell'avventura
            if (this.getGame().getInventory().getInventoryList().contains(i = new Item(54, "", ""))) {

                /*
                    Il cattivo "ruba" la pendrive al protagonista quindi si rimuove
                    dall'inventario del giocatore e si inserisce nella stanza,
                    dove però non sarà possibile raccoglierla (pickupable = false)
                 */
                this.getGame().getCurrentRoom().addItem(i);
                this.getGame().getInventory().getInventoryList().remove(i);
                i = this.getGame().getCurrentRoom().getItemList().searchItem("bigliettino");
                this.getGame().getInventory().add(i);
                this.getGame().getCurrentRoom().getItemList().remove(i);
                
            }
            /*
            else if ( this.getGame().getInventory().getInventoryList().contains(tre oggetti chiave) {
                this.getGame().getCurrentRoom().getItemList().remove(i);
                this.getGame().getInventory().add(i);
            }
             */
            
        }
        
    }
    
}
