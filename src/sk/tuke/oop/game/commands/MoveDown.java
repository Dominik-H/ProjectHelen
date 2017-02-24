/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.Movable;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class MoveDown implements Command {
    
    private Movable actor;
    private int step;
    private String nAME;
    private boolean diagonal;

    public MoveDown(Movable actor, int step) {
        this.actor = actor;
        this.step = step;
        nAME = "DOWN";
        diagonal = false;
    }
    
    public MoveDown(Movable actor, int step, boolean diag) {
        this.actor = actor;
        this.step = step;
        nAME = "DOWN";
        diagonal = diag;
    }
    
    @Override
    public void execute() {
        actor.setPosition(actor.getX(), actor.getY() + step);
        
        if(!diagonal && (actor.getRotation() != Movable.Rotation.DOWN))
        {
            actor.setRotation(Movable.Rotation.DOWN);
            actor.getAnimation().setRotation(180);
        }
    }
    
}
