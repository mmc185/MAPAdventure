/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.util.Iterator;
import java.util.Objects;
import javax.swing.ImageIcon;
import uni.mapadventureproject.parser.ParserOutput;
import uni.mapadventureproject.parser.WordType;
import uni.mapadventureproject.type.CommandType;
import uni.mapadventureproject.type.Item;
import uni.mapadventureproject.type.Room;
import uni.mapadventureproject.type.TriggeredRoom;
import uni.mapadventureproject.type.ItemContainer;

/**
 * Classe che implementa i metodi astratti di GameManager per la gestione del
 * gioco "MetaStation: the last exam"
 */
public class MSGame extends GameManager {

    // Musica di sottofondo del gioco
    private PlayMusic music = new PlayMusic();

    /**
     * ostruttore, prende lo stato del gioco e fa partire la musica
     *
     * @param g entità di gioco
     */
    public MSGame(Game g) {
        super(g);

        // Caricamento della musica
        music.playSound("resources//Musica//soundtrack.wav");

    }

    @Override
    /**
     * Metodo che implementa la logica del gioco. Gestisce il comando
     * dell'utente in base alla validità dei comandi scritti rispetto allo stato
     * attuale in cui si trova il gioco.
     *
     * @param pOutput l'output del Parser
     *
     * @return ritorna una stringa che descrive la risposta da dare all'utente.
     */
    public String executeCommand(ParserOutput pOutput) {

        // Prende il tipo di comando in modo da gestire la richiesta
        CommandType command = this.getGame().getCommandType(pOutput.getString(WordType.COMMAND));

        Room r = null;
        Item i = null;
        StringBuilder output = new StringBuilder();

        // Se un singolo item viene sfruttato nella richiesta lo salva
        i = this.retrieveItem(pOutput);

        try {

            switch (command) {

                // Comandi per il movimento
                case MOVE_S:
                case MOVE_N:
                case MOVE_E:
                case MOVE_W:
                case MOVE_U:
                case MOVE_D:

                    // Controlla se ci si può spostare in quella direzione o meno
                    if (Objects.isNull(r = this.move(command))) {

                        output.append("Non puoi andare lì!");

                    } // Controlla che non sia bloccata
                    else if (r.getLockedBy().equals("")) {

                        // Si sposta nella stanza designata
                        this.getGame().setCurrentRoom(r);

                        // Controlla se si è finito il gioco in maniera "lecita"
                        this.advancePlot();

                        output.append("===========================================\n"
                                + this.getGame().getCurrentRoom().getName() + "\n\n"
                                + this.getGame().getCurrentRoom().getDesc());

                    } else {

                        // Nel caso la stanza sia bloccata
                        output.append("Questa stanza è chiusa!");
                    }
                    break;

                // Comando per l'inventario, ne stampa il contenuto
                case INV:

                    output.append("Oggetti presenti nell'inventario: " + this.getGame().getInventory().toString());
                    break;

                // Comando per guardare
                case LOOK:

                    // Se si vuole guardare un oggetto
                    if (pOutput.size() == 2) {

                        output.append(i.getDesc());

                    } else if (pOutput.size() == 1) { // Se si vuole guardare la stanza

                        output.append(this.getGame().getCurrentRoom().getLook());

                    } else if (pOutput.size() > 2) { // Se si vogliono guardare troppi oggetti alla volta

                        output.append("Uno alla volta, ho una certa età.");

                    }
                    break;

                // Comando per raccogliere oggetti
                case PICK_UP:

                    // Controlla che l'oggetto sia della stanza e non presente nell'inventario
                    if (pOutput.containsWordType(WordType.R_OBJ)) {

                        // Controlla che l'oggetto si possa raccogliere
                        if (!Objects.isNull(i) && i.isPickupable()) {

                            // Aggiunge l'oggetto all'inventario e lo rimuove dalla stanza
                            this.getGame().getInventory().add(i);
                            this.getGame().getCurrentRoom().removeItem(i);

                            output.append("L'oggetto è stato aggiunto al tuo inventario.");

                        } else {

                            output.append("Non puoi prendere questo oggetto.");

                        }
                    } else if (pOutput.containsWordType(WordType.I_OBJ)) {

                        output.append("Non puoi prendere qualcosa che hai già con te!");

                    } else {

                        output.append("Prendere... cosa?");

                    }
                    break;

                // Comandi per sbloccare stanze o contenitori
                case USE:
                case OPEN:

                    // Se si vuole aprire una stanza con un oggetto dell'inventario
                    if (pOutput.size() == 2 && pOutput.containsWordType(WordType.I_OBJ)) {

                        //Apertura stanza
                        if (!i.isConsumed() && this.unlockRoom(i.getName())) {
                            output.append("Hai sbloccato la stanza!");

                            i.consume();

                            // Se l'oggetto è stato consumato, lo rimuove dall'inventario
                            if (i.isConsumed()) {

                                this.getGame().getInventory().remove(i);
                                output.append("\nL'oggetto " + i.getName() + " è stato rimosso.");

                            }

                        } else {
                            output.append("Non puoi aprire con questo oggetto!");
                        }

                    } else if (pOutput.containsWordType(WordType.R_OBJ)) { // Apertura di un contenitore da sbloccare

                        ItemContainer iC = null; //contenitore
                        i = null;
                        byte index = 0;

                        // Iteratore per ciclare sul ParserOutput
                        Iterator it = pOutput.iterator();
                        it.next(); // Salta il comando iniziale, già conosciuto

                        // Salva gli oggetti che devono interagire nell'ordine prestabilito (e.g. "Apri baule con chiave")
                        while (it.hasNext()) {

                            //itemContainer. obbligatoriamente un oggetto della Room
                            if (index == 1 && it.next().equals(WordType.R_OBJ)) {

                                iC = (ItemContainer) this.getGame().getCurrentRoom().getItemList().searchItem(pOutput.getString(WordType.R_OBJ));

                            } //Chiave. obbligatoriamente un oggetto dell'inv
                            else if (index == 2 && it.next().equals(WordType.I_OBJ)) {

                                i = this.getGame().getInventory().searchItem(pOutput.getString(WordType.I_OBJ));

                            }

                            index++;
                        }

                        // Se l'oggetto è effettivamente un contenitore
                        if (iC instanceof ItemContainer) {

                            // Se trova l'oggetto per aprirlo ed è corretto oppure se il contenitore non è bloccato lo apre
                            if ((i != null && !i.isConsumed() && iC.unlockContainer(i.getName()))
                                    || (iC.getLockedBy().equals(""))) {

                                if (iC.getcItemList().getInventoryList().isEmpty()) {

                                    output.append("L'oggetto è stato aperto, ma è vuoto!");

                                } else {

                                    output.append("Hai aperto l'oggetto " + iC.getName()
                                            + "! Ecco il suo contenuto:" + iC.toString());

                                }

                                if (i != null) {

                                    i.consume();

                                    // Se l'oggetto è stato consumato, lo rimuove dall'inventario
                                    if (i.isConsumed()) {
                                        this.getGame().getInventory().remove(i);
                                        output.append("\nL'oggetto " + i.getName() + " è stato rimosso.");
                                    }
                                }

                            } else {
                                output.append("Non puoi aprire quest'oggetto così!");
                            }

                        } else {
                            output.append("Non puoi aprire quest'oggetto così!");
                        }

                    } else {
                        output.append("Non puoi aprire con quest'oggetto!");
                    }

                    break;

                // Comando per spingere oggetti
                case PUSH:

                    // Se si può spingere e non è già stato spinto
                    if (i.isPushable() && !i.isPush()) {

                        // Compie l'azione
                        i.setPush(true);
                        output.append(i.getName() + " premuto!");

                        // Controlla se l'oggetto sblocca una stanza adiacente
                        this.unlockRoom(i.getName());

                    } else {

                        output.append("Non puoi premerlo!");

                    }

                    break;

                // Comando per "scappare"
                case RUN:

                    output.append("Non puoi \"foldare\" proprio adesso, ti sei impegnato tanto per questo progetto!");
                    break;

                // Comando per "svegliarsi" fa partire un finale nascosto
                case WAKE_UP:

                    output.append("Hai scelto la via più semplice e questo non ti fa onore"
                            + "\n \n HAI COMPLETATO IL GIOCO IN : "
                            + this.getGame().getGameTime().getTime());

                    // Ferma il timer che tiene traccia del tempo di completamento del gioco
                    this.getGame().getGameTime().cancel();

                    // Mostra all'utente una immagine di congratulazioni
                    r = this.getGame().getCurrentRoom();
                    r.setRoomImage(new ImageIcon("resources//img//stanze//congrats.jpg"));

                    break;

                // Comando per stampare la guida di gioco
                case HELP:
                    output.append(this.showHelp());
                    break;
            }

            // Controlla se la stanza è triggerabile dal comando dell'utente
            r = this.getGame().getCurrentRoom();
            if (r instanceof TriggeredRoom) {

                output.append(this.manageTriggers(pOutput, (TriggeredRoom) r));
            }

        } catch (NullPointerException e) {

            output.append("Sembra esserci qualcosa di strano in questa richiesta...");

        } finally {

            return output.toString();

        }

    }

    /**
     * Funzione che prende il nome dell'oggetto, se presente, dal ParserOutput e
     * ne ritorna l'Item.
     *
     * @param pOutput output del parser
     * @return Item il cui nome o alias si trova nel ParserOutput
     */
    private Item retrieveItem(ParserOutput pOutput) {

        Item i = null;

        /* Se l'azione sfrutta un oggetto salva l'oggetto e 
           lo rinomina nel ParserOutput per fare riferimento al suo nome principale
           e non a potenziali alias, così da uniformare la gestione del comando.
         */
        if (pOutput.containsWordType(WordType.I_OBJ)) { // Per gli oggetti dell'inventario

            // Cerca l'item
            i = this.getGame().getInventory().searchItem(pOutput.getString(WordType.I_OBJ));

            // Se lo trova, lo rinomina nel ParserOutput
            if (!Objects.isNull(i)) {

                pOutput.add(WordType.I_OBJ, i.getName());

            } else {// Se non ha trovato l'oggetto lo cerca in un contenitore non bloccato dell'inventario

                for (Item iC : this.getGame().getInventory().getInventoryList()) {

                    if (iC instanceof ItemContainer && ((ItemContainer) iC).getLockedBy().equals("")) {

                        i = ((ItemContainer) iC).getcItemList().searchItem(pOutput.getString(WordType.I_OBJ));
                        pOutput.add(WordType.I_OBJ, i.getName());

                    }

                }

            }

        } else if (pOutput.containsWordType(WordType.R_OBJ)) { // Per gli oggetti della stanza

            i = this.getGame().getCurrentRoom().getItemList().searchItem(pOutput.getString(WordType.R_OBJ));

            // Se lo trova, lo rinomina nel ParserOutput
            if (!Objects.isNull(i)) {

                pOutput.add(WordType.R_OBJ, i.getName());

            } else {// Se non ha trovato l'oggetto lo cerca in un contenitore non bloccato della stanza

                for (Item iC : this.getGame().getCurrentRoom().getItemList().getInventoryList()) {

                    if (iC instanceof ItemContainer && ((ItemContainer) iC).getLockedBy().equals("")) {

                        i = ((ItemContainer) iC).getcItemList().searchItem(pOutput.getString(WordType.R_OBJ));
                        pOutput.add(WordType.R_OBJ, i.getName());

                    }

                }
            }

        }

        return i;
    }

    /**
     * Funzione per spostarsi tra le stanze
     *
     * @param c tipo di comando che indica il movimento da compiere
     * @return stanza in cui spostarsi, se trovata, altrimenti null
     */
    private Room move(CommandType c) {

        // Se il comando corrisponde a quel movimento e la stanza in quella direzione esiste
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

    /**
     * Funzione per sbloccare le stanze chiuse, cerca tra tutte le stanze
     * adiacenti alla stanza attuale.
     *
     * @param iName nome dell'oggetto "chiave"
     * @return booleano, true se la stanza è stata sbloccata dall'item, false
     * altrimenti
     */
    private boolean unlockRoom(String iName) {

        boolean flag = false;

        /* Controlla se esiste una stanza in quella direzione, per ogni direzione
         * e controlla se è bloccata dall'item passato in input.
         * In caso affermativo, la sblocca e imposta il flag a true.
         */
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

    /**
     * Funzione per gestire le stanze TriggeredRoom in relazione con il comando
     * scritto dall'utente.
     *
     * @param pOutput output del Parser
     * @param r stanza attuale, TriggeredRoom
     * @return stringa che contiene il nuovo "stato" della stanza, ovvero la sua
     * descrizione
     */
    private String manageTriggers(ParserOutput pOutput, TriggeredRoom r) {

        String output = "";

        if (r.isTriggerable()) { //Se la stanza è triggerabile

            String triggerer = pOutput.getString(WordType.COMMAND); //Stringa da confrontare con quella che causa il trigger

            if (pOutput.size() == 2) {

                if (pOutput.containsWordType(WordType.R_OBJ)) {

                    triggerer += " " + pOutput.getString(WordType.R_OBJ);

                } else if (pOutput.containsWordType(WordType.I_OBJ)) {

                    triggerer += " " + pOutput.getString(WordType.I_OBJ);

                }
            }

            //se triggerer=triggerer attuale della stanza, si effettua il trigger
            if (triggerer.equals(r.getCurrentTriggerer())) {

                r.setTrigger(true);
                output = "\n\n" + r.getDesc();

            }

        }

        return output;
    }

    @Override
    /**
     * Funzione che restituisce la guida del gioco "MetaStation: the last exam"
     *
     * @return stringa con la guida
     */
    public String showHelp() {
        return "===========================================\n"
                + "GUIDA\n"
                + "\n"
                + "* Inserisci un comando nel rettangolo in basso e premi \"Invia\" o il tasto Invio.\n"
                + "\n"
                + "* Per spostarti, puoi premere le frecce o \"su\", \"giù\", oppure scriverlo nel rettangolo.\n"
                + "\n"
                + "* Per visualizzare il contenuto dell'inventario, premi l'icona dello zaino, oppure digita comandi come \"inventario\", \"inv\", \"borsa\"...\n"
                + "\n"
                + "* Quelli descritti in questa guida sono solo alcuni dei comandi disponibili, scommetto che sarai capace di scoprire gli altri senza ulteriori aiuti...\n"
                + "\n"
                + "* Sei in difficoltà? Prova a guardarti intorno con il comando \"guarda\" e fa' attenzione agli indizi che ti vengono suggeriti!\n"
                + "\n"
                + "Esempi di frasi accettate:\n"
                + "- Raccogli la bottiglia / Prendi bottiglia\n"
                + "- Guarda\n"
                + "- Osserva la bottiglia\n"
                + "- Nord\n"
                + "- Apri con chiave / Usa la chiave \n"
                + "- Apri il baule con la chiave dorata \n"
                + "- Premi il pulsante \n"
                + "\n"
                + "E' importante inserire solo un'azione alla volta!\n"
                + "Esempio di frase NON accettata:\n"
                + "- Prendi la bottiglia e prendi l'ombrello \n"
                + "===========================================";
    }

    /**
     * Procedura che fa avanzare la narrazione della storia, basandosi sulla
     * stanza pivotale per lo svolgimento degli eventi.
     */
    private void advancePlot() {

        Item i;

        // Se è nella stanza principale del gioco
        if (this.getGame().getCurrentRoom().getName().equals("Atrio della Metastazione")) {

            // Se ha con sè l'oggetto pendrive ovvero se è parte iniziale dell'avventura
            if (!Objects.isNull(i = this.getGame().getInventory().searchItem("pendrive"))) {

                /*
                    Il cattivo "ruba" la pendrive al protagonista quindi si rimuove
                    dall'inventario del giocatore e si inserisce nella stanza,
                    dove però non sarà possibile raccoglierla (pickupable = false)
                 */
                this.getGame().getCurrentRoom().addItem(i);
                this.getGame().getInventory().getInventoryList().remove(i);

                // Inserisce il bigliettino di "ricatto" nell'inventario del giocatore
                i = this.getGame().getCurrentRoom().getItemList().searchItem("bigliettino");
                this.getGame().getInventory().add(i);
                this.getGame().getCurrentRoom().getItemList().remove(i);

            } // Se il giocatore ha terminato il gioco e ha collezionato tutti gli oggetti
            else if (!Objects.isNull(this.getGame().getInventory().searchItem("lingotto"))
                    && !Objects.isNull(this.getGame().getInventory().searchItem("ixora septrifolia")) /*&& !Objects.isNull(this.getGame().getInventory().getInventoryList().contains("lingotto")*/) {

                // Gli viene restituita la chiavetta
                i = this.getGame().getCurrentRoom().getItemList().searchItem("pendrive");
                this.getGame().getCurrentRoom().getItemList().remove(i);
                this.getGame().getInventory().add(i);

                // Viene descritto il finale del gioco
                this.getGame().getCurrentRoom().setDesc("\n\n[finale] "
                        + "\n\nHAI COMPLETATO IL GIOCO IN : " + this.getGame().getGameTime().getTime() + "\n");

                // Ferma il timer che tiene traccia del tempo di completamento del gioco
                this.getGame().getGameTime().cancel();

                // Mostra all'utente una immagine di congratulazioni
                this.getGame().getCurrentRoom().setRoomImage(new ImageIcon("resources//img//stanze//congrats.jpg"));

            }

        }

    }

}
