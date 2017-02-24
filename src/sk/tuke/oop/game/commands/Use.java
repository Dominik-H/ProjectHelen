/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.openables.Openable;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Use implements Command {
    
    private Actor actor, actuator;
    
    public Use(Actor actor, Actor actuator) {
        this.actor = actor;
        this.actuator = actuator;
    }

    @Override
    public void execute() {
        if(actor instanceof Usable)
            ((Usable)actor).use(actuator);
        
        if(actor instanceof Openable) {
            if(((Openable)actor).isOpen())
                ((Openable)actor).close();
            else
                ((Openable)actor).open();
        }
    }
}
