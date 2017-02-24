/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Ventilator extends AbstractActor implements Usable {
    
    private boolean isOn;

    public Ventilator() {
        super("Ventilator");
        setAnimation(new Animation("resources/sprites/ventilator.png", 32, 32, 100));
        isOn = false;
        getAnimation().stop();
    }
    
    @Override
    public void act() {
        
    }

    @Override
    public void use(Actor actor) {
        if(isOn) {
            isOn = false;
            getAnimation().stop();
        } else {
            isOn = true;
            getAnimation().start();
        }
    }
    
}
