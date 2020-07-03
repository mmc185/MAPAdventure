/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.type;

import java.io.Serializable;

/**
 *
 * @author marta
 */
public enum CommandType implements Serializable {
    MOVE_N, MOVE_S, MOVE_E, MOVE_W, MOVE_U, MOVE_D, INV, LOOK, PICK_UP, OPEN, USE, 
    PUSH, RUN, EXIT, WAKE_UP
}
