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
public class MoveLeft implements Command {
    
    private Movable actor;
    private int step;
    private String nAME;
    private boolean diagonal;

    public MoveLeft(Movable actor, int step) {
        this.actor = actor;
        this.step = step;
        nAME = "LEFT";
        diagonal = false;
    }
    
    public MoveLeft(Movable actor, int step, boolean diag) {
        this.actor = actor;
        this.step = step;
        nAME = "LEFT";
        diagonal = diag;
    }
    
    @Override
    public void execute() {
        actor.setPosition(actor.getX() - step, actor.getY());
        
        if(!diagonal && (actor.getRotation() != Movable.Rotation.LEFT))
        {
            actor.setRotation(Movable.Rotation.LEFT);
            actor.getAnimation().setRotation(270);
        }
    }
    
}
