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
public class Move implements Command {
    
    private int step, dx, dy;
    private Movable actor;

    public Move(Movable actor, int step, int dx, int dy) {
        this.actor = actor;
        this.step = step;
        this.dx = dx;
        this.dy = dy;
    }
    
    @Override
    public void execute() {
        
        if(dx > 0 && dy > 0) {
            Command cmd = new MoveRight(actor, step, true);
            cmd.execute();
            
            cmd = new MoveDown(actor, step, true);
            cmd.execute();
            
            if(actor.getRotation() != Movable.Rotation.RD) {
                actor.setRotation(Movable.Rotation.RD);
                actor.getAnimation().setRotation(135);
            }
            
            return;
        }
        
        if(dx > 0 && dy < 0) {
            Command cmd = new MoveRight(actor, step, true);
            cmd.execute();
            
            cmd = new MoveUp(actor, step, true);
            cmd.execute();
            
            if(actor.getRotation() != Movable.Rotation.RU) {
                actor.setRotation(Movable.Rotation.RU);
                actor.getAnimation().setRotation(45);
            }
            
            return;
        }
        
        if(dx < 0 && dy > 0) {
            Command cmd = new MoveLeft(actor, step, true);
            cmd.execute();
            
            cmd = new MoveDown(actor, step, true);
            cmd.execute();
            
            if(actor.getRotation() != Movable.Rotation.LD) {
                actor.setRotation(Movable.Rotation.LD);
                actor.getAnimation().setRotation(225);
            }
            
            return;
        }
        
        if(dx < 0 && dy < 0) {
            Command cmd = new MoveLeft(actor, step, true);
            cmd.execute();
            
            cmd = new MoveUp(actor, step, true);
            cmd.execute();
            
            if(actor.getRotation() != Movable.Rotation.LU) {
                actor.setRotation(Movable.Rotation.LU);
                actor.getAnimation().setRotation(315);
            }
            
            return;
        }
        
        if(dx > 0) {
            Command cmd = new MoveRight(actor, step);
            cmd.execute();
            return;
        }
        
        if(dx < 0) {
            Command cmd = new MoveLeft(actor, step);
            cmd.execute();
            return;
        }
        
        if(dy > 0) {
            Command cmd = new MoveDown(actor, step);
            cmd.execute();
            return;
        }
        
        if(dy < 0) {
            Command cmd = new MoveUp(actor, step);
            cmd.execute();
            return;
        }
    }
    
}
