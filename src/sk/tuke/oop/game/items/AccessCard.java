/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.openables.Door;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class AccessCard extends AbstractActor implements Item, Usable {

    public AccessCard() {
        super("key");
        setAnimation(new Animation("resources/sprites/key.png", 16, 16));
    }

    @Override
    public void use(Actor actor) {
        if(actor instanceof Door) {
            ((Door)actor).unlock(this);
        }
    }

    @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
