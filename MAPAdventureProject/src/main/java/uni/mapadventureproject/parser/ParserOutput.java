/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.parser;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

//public class ParserOutput implements Iterable<Entry<WordType, String>> {
public class ParserOutput implements Iterable<WordType> {
    
    /* Formato da coppie di tipi di parola e stringa che lo identifica. (e.g. (OBJECT, "taralli") )
       può contenere al più frasi formate da un comando, un oggetto dell'inventario e un oggetto della stanza.
    */
    private Map<WordType, String> parsedData = new LinkedHashMap<>();
    
    public boolean isEmpty () {
        return parsedData.isEmpty();
    }
    
    public void add (WordType w, String s) {
        parsedData.put(w, s);
    }
    
    public String getString (WordType w) {
        return parsedData.get(w);
    }
    
    public boolean containsWordType ( WordType w ) {
        return parsedData.containsKey(w);
    }
    
    public int size () {
        return parsedData.size();
    }
    
    /*public class ParserOutputIterator implements Iterator<WordType> {
        
        public ParserOutputIterator (ParserOutput p) {
            p.
        }
        
        public boolean hasNext() {
            
        }
        
        public WordType next() {
            
        }
        
        public void remove () {
            
        }
    }*/
    
    @Override
    public Iterator<WordType> iterator() {
        return parsedData.keySet().iterator();
    }
    /*public Iterator<Entry<WordType, String>> iterator() {
        return parsedData.entrySet().iterator();
    }*/
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator i = this.iterator();
        while (i.hasNext()) {
            s.append(parsedData.get(i.next()) + " ");
        }
        return s.toString();
    }
    
}
