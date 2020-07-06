/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package uni.mapadventureproject.parser;

 /**
  * Classe per l'eccezione di stringa non valida incontrata nel Parser.
  */
public class InvalidStringException extends Exception {

    public InvalidStringException() {
        super("Stringa non valida."); // Messaggio dell'eccezione
    }
}
