/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public interface Openable {
    public void open();
    public void close();
    public boolean isOpen();
}
