/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Hero;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class EnhancedSword extends Sword{

    public EnhancedSword() {
        super("EnSwordik");
        
        setDamage(15);        
        
        setAnimation(new Animation("resources/sprites/swordEn.png", 16, 16));
    }
    
    @Override
    public void use(Actor actor) {
        if(actor instanceof Hero) {
            ((Hero)actor).getEnhanced();
            getWorld().removeActor(this);
        }
    }
    
}
