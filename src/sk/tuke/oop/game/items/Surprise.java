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
public class Surprise extends AbstractActor implements Item, Usable{
    
    public Surprise() {
        super("tralala");
        setAnimation(new Animation("resources/sprites/egg.png", 16, 16));
    }

    @Override
    public void act() {
        
    }

    @Override
    public void use(Actor actor) {
        ((Hero)actor).setEnergy(0);
        getWorld().removeActor(this);
    }
}
