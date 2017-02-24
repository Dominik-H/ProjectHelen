/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Backpack;
import sk.tuke.oop.framework.Item;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class BackpackImpl implements Backpack {

    private final int capacity;
    private LinkedList<Item> storage;
    
    public BackpackImpl(int capacity) {
        this.capacity = capacity;
        storage = new LinkedList<>();
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public Item getItemByName(String name) {
        for(Item i : storage) {
            if(i.getName() != null && i.getName().equals(name))
                return i;
        }
        
        return null;
    }
    
    public Item getLastItem() {
        return storage.peek();
    }
    
    public LinkedList<Item> getStorage() {
        return storage;
    }
    
    @Override
    public void add(Item item) {
        if(storage.size() >= capacity)
            throw new ArrayIndexOutOfBoundsException(); 
        
        storage.push(item);
    }

    @Override
    public void remove(Item item) {
        if(!storage.contains(item))
            throw new NoSuchElementException();
        else
            storage.remove(item);
    }

    @Override
    public Iterator<Item> iterator() {        
        return storage.iterator();
    }
    
}
