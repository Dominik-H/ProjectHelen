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

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Wrench extends AbstractActor implements Item, Usable {
    
    public Wrench() {
        super("Wrench");
        setAnimation(new Animation("resources/sprites/wrench.png", 16, 16));
    }

    @Override
    public void use(Actor actor) {
        
    }

    @Override
    public void act() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
