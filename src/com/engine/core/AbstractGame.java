package com.engine.core;

import java.util.Stack;

import com.engine.core.components.State;

public abstract class AbstractGame {

	private Stack<State> states = new Stack<State>();

	public abstract void update(GameContainer gc, float dt);

	public abstract void render(GameContainer gc, Renderer r);

	public State peek() {
		return states.peek();
	}

	public void push(State s) {
		states.push(s);
	}

	public void pop() {
		states.peek().dispose();
		states.pop();
	}

	public void setState(State s) {
		states.pop();
		states.push(s);
	}
}
