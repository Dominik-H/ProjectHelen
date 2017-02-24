/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.ActionZone;
import sk.tuke.oop.game.actors.Lava;
import sk.tuke.oop.game.actors.ripley.Hero;
import sk.tuke.oop.game.actors.ripley.RipleyState;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class End implements RipleyState {
    private Hero her;
    private Game lev;
    private boolean done;

    public End (Hero h, Game level) {
        her = h;
        lev = level;
        done = false;
    }
    
    @Override
    public void act() {
        Lava lav = null;
        for(Actor act : her.getWorld())
        {
            if(act instanceof Lava) {
                if(act.getName().equals("block2")) {
                    lav = (Lava)act;
                }
            }
        }
        
        if(!done) {
            for(Actor act : her.getWorld()) {
                if(act instanceof ActionZone && her.intersects(act)) {
                    Move mov = new Move(her, 2, 1, 0);
                    mov.execute();
                            break;
                }
            }
        }
        
    }
}
