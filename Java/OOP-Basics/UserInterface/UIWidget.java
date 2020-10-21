package com.company;
//this code examples the interface segregation principle which states that interfaces should be broken down into each seperate capibility
public interface UIWidget extends Resizeable, Draggable {
    public void render();
}

