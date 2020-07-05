package uni.mapadventureproject.parser;

import java.util.Set;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.Inventory;
import uni.mapadventureproject.type.Item;
import uni.mapadventureproject.type.ItemContainer;
import uni.mapadventureproject.type.Room;

public class Parser {

    public ParserOutput parse(String phrase, Room currentRoom, Inventory inv, Set<Command> commands) throws InvalidStringException {

        ParserOutput pOutput = new ParserOutput();

        // Rimuove anche punteggiatura e cifre
        String[] tokens = phrase.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");

        for (String t : tokens) {

            if (this.isCommand(t, commands) && pOutput.isEmpty()) {

                pOutput.add(WordType.COMMAND, t);

            } else if (this.isCommand(t, commands) && !pOutput.isEmpty()) {

                throw new InvalidStringException();

            }

        }

        if (!pOutput.isEmpty()) {

            String s;

            // Ciclo con indice poiché serve mantenere il contatore
            for (short i = 0; i < tokens.length; i++) {

                // Controlla se il token corrispondente è un oggetto dell'inventario o  della stanza
                if (!(s = this.isItem(tokens[i], inv, tokens, i)).isEmpty()) {

                    pOutput.add(WordType.I_OBJ, s);

                }

                if (!(s = this.isItem(tokens[i], currentRoom.getItemList(), tokens, i)).isEmpty()) {

                    pOutput.add(WordType.R_OBJ, s);

                }

            }

        } else {
            throw new InvalidStringException();
        }

        return pOutput;
    }

    private boolean isCommand(String s, Set<Command> commands) {

        for (Command c : commands) {

            if (c.getName().equals(s) || c.getAlias().contains(s)) {

                return true;

            }

        }

        return false;
    }

    /**
     * Gli oggetti possono essere formati da una o due parole
     */
    private String isItem(String s, Inventory inv, String[] tokens, short counter) {

        try {

            for (Item i : inv.getInventoryList()) {

                if (i.getName().equals(s) || i.getAlias().contains(s)) {

                    return s;

                } else if (i.getName().startsWith(s) /*|| i.getAlias().contains(s)*/) {

                    if (i.getName().contains(tokens[counter + 1]) /*|| i.getAlias().contains(tokens[counter + 1])*/) {

                        return s + " " + tokens[counter + 1];

                    }

                } else if (i instanceof ItemContainer) {
                    return isItem(s, ((ItemContainer)i).getcItemList(), tokens, counter);
                }

            }

            return "";

        } catch (ArrayIndexOutOfBoundsException e) {

            return "";

        }

    }

}
