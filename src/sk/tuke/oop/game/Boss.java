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

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Boss implements RipleyState {
    private Hero her;
    private Game lev;
    private boolean done;

    public Boss(Hero h, Game level) {
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
                if(act.getName().equals("block3")) {
                    lav = (Lava)act;
                }
            }
        }
        
        if(!done) {
            for(Actor act : her.getWorld()) {
                if(act instanceof ActionZone && her.intersects(act)) {
                    if(act.getName().equals("four")) {
                        if(her.hasSword() /*&& her.getEnergy() >= 100*/) {
                            //lav.getWorld().removeActor(lav);
                            lev.setLevel(new End(her, lev));
                            done = true;
                            break;
                        }
                    }
                }
            }
        }
        
    }
}
