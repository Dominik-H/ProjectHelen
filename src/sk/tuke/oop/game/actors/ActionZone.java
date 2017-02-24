/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class ActionZone extends AbstractActor {

    public ActionZone(String name) {
        super(name);
        
        setAnimation(new Animation("resources/sprites/actionZone.png", 48, 112));
    }

    @Override
    public void act() {
    }
    
}
