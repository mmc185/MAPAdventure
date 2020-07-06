/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.parser;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Classe che imposta la struttura dell'output del Parser.
 * E' utilizzata dal parser per salvare i risultati, dal GameInteraction
 * che mette in comunicazione GameManager e Parser, e dal GameManager stesso.
 */
public class ParserOutput implements Iterable<WordType> {
    
    /* Formato da coppie di tipi di parola e stringa che lo identifica. (e.g. (I_OBJ, "quaderno") )
       può contenere al più frasi formate da: un comando, un oggetto dell'inventario e un oggetto della stanza.
        (max 3 elementi)
    */
    private Map<WordType, String> parsedData = new LinkedHashMap<>();
    
    /**
     * Indica se il ParserOutput sia vuoto.
     * @return booleano che indica se la struttura è vuota (true) o meno (false)
     */
    public boolean isEmpty () {
        return parsedData.isEmpty();
    }
    
    /**
     * Aggiunge una coppia formata da chiave (WordType) e valore (Stringa)
     * @param w WordType
     * @param s Stringa
     */
    public void add (WordType w, String s) {
        parsedData.put(w, s);
    }
    
    /**
     * Restituisce la stringa associata alla chiave del WordType, 
     * se esistente nella struttura.
     * 
     * @param w WordType
     * @return stringa, se w è presente nella struttura, null altrimenti
     */
    public String getString (WordType w) {
        return parsedData.get(w);
    }
    
    /**
     * Indica se il ParserOutput contiene il WordType w
     * @param w Wordtype
     * @return booleano che indica se nella struttura è presente w
     */
    public boolean containsWordType ( WordType w ) {
        return parsedData.containsKey(w);
    }
    
    /**
     * Indica la grandezza del ParserOutput
     * @return intero
     */
    public int size () {
        return parsedData.size();
    }
    
    @Override
    /**
     * Restituisce un iteratore basato sull'insieme di chiavi della struttura
     * 
     * @return Iterator<WordType> iteratore basato sulla chiave WordType
     */
    public Iterator<WordType> iterator() {
        return parsedData.keySet().iterator();
    }
    
    /**
     * Crea una stringa formata dagli elementi che compongono la struttura del ParserOutput
     * @return stringa
     */
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        Iterator i = this.iterator();
        
        // Finchè ci sono elementi, li concatena
        while (i.hasNext()) {
            s.append(parsedData.get(i.next()) + " ");
        }
        
        return s.toString();
    }
    
}
