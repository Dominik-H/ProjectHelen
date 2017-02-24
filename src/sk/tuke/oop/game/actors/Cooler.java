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
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Cooler extends AbstractActor implements Usable {

    public Cooler() {
        super("Cooler");
        setAnimation(new Animation("resources/sprites/fan.png", 32, 32, 200));
        getAnimation().stop();
    }

    @Override
    public void use(Actor actor) {
        if(actor instanceof Wrench || actor instanceof Hammer) {
            getAnimation().start();
        }
    }

    @Override
    public void act() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
