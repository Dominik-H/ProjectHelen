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
import sk.tuke.oop.game.actors.ripley.Hero;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Potion extends AbstractActor implements Item, Usable{

    public Potion() {
        super("pot");
        setAnimation(new Animation("resources/sprites/pot.png", 16, 16));
    }

    @Override
    public void act() {
        
    }

    @Override
    public void use(Actor actor) {
        if(((Hero)actor).getEnergy() < 100) {
            ((Hero)actor).setEnergy(100);
            getWorld().removeActor(this);
        }
    }
    
}
