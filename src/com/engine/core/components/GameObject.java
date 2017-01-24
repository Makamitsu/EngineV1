package com.engine.core.components;

import java.util.ArrayList;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;

public abstract class GameObject {
	
	protected float xPos;
    protected float yPos;
    protected int width;
    protected int height;
	protected String tag = "null";
	protected boolean dead = false;
	protected ArrayList<Component> components = new ArrayList<Component>();

	public abstract void update(GameContainer gc, float dt);
	public void updateComponents(GameContainer gc, float dt){
		for(Component c : components){
			c.update(gc, this, dt);
		}
	}
	
	public abstract void render(GameContainer gc, Renderer r);
	
	public void renderComponents(GameContainer gc, Renderer r){
		for(Component c : components){
			c.render(gc, r);
		}
	}
	
	public abstract void componentEvent(String name, GameObject object);
	
	public abstract void dispose();
	
	public void addComponent(Component c){
		components.add(c);
	}
	
	public void removeComponent(String s){
		for(int i = 0;i < components.size();i++){
			if(components.get(i).getTag().equalsIgnoreCase(s)){
				components.remove(i);
			}
		}
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	public float getX() {
		return xPos;
	}
	public void setX(float x) {
		this.xPos = x;
	}
	public float getY() {
		return yPos;
	}
	public void setY(float y) {
		this.yPos = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


}
