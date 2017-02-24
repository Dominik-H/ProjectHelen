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
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Ammo extends AbstractActor implements Item, Usable {
    
    public Ammo() {
        super("Ammo");
        setAnimation(new Animation("resources/sprites/ammo.png", 16, 16, 100));
    }

    @Override
    public void use(Actor actor) {
        if(((Ripley)actor).getAmmo() < 500) {
            ((Ripley)actor).takeAmmo(50 - (((Ripley)actor).getAmmo() >= 450 ? ((Ripley)actor).getAmmo() - 450 : 0));
            getWorld().removeActor(this);
        }
    }    

    @Override
    public void act() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
