/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Hammer;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Locker extends AbstractActor implements Usable {
    
    private boolean used;

    public Locker() {
        super("Locker");
        setAnimation(new Animation("resources/sprites/locker.png", 16, 16));
        used = false;
    }

    @Override
    public void use(Actor actor) {
        if(!used) {
            Hammer ham = new Hammer();
            ham.setPosition(getX() + getWidth() + 4, getY());
            getWorld().addActor(ham);
            used = true;
        }
    }

    @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
