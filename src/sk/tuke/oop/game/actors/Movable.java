/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public interface Movable extends Actor {
    public enum Rotation {LEFT, RIGHT, UP, DOWN, LU, LD, RU, RD};
    
    public Rotation getRotation();
    public void setRotation(Rotation rot);
    
}
