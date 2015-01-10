package org.team1515.pastabot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickHandler {
	
	private Joystick stick1;
	private Joystick stick2;
	private ArrayList<JoystickAction> actions;
	
	public JoystickHandler(Joystick stick1, Joystick stick2) {
		this.stick1 = stick1;
		this.stick2 = stick2;
		actions = new ArrayList<JoystickAction>();
	}
	
	public void onButton(int stick, int id, Runnable action) {
		actions.add(new JoystickAction(stick, id, action));
	}
	
	public void update() {
		for(JoystickAction action : actions) {
			if((action.getStick() == 1 && stick1.getRawButton(action.getID())) || (action.getStick() == 2 && stick2.getRawButton(action.getID()))) {
				action.getAction().run();
			}
		}
	}
	
	class JoystickAction {
		int stick;
		int id;
		Runnable action;
		
		public JoystickAction(int stick, int id, Runnable action) {
			this.stick = stick;
			this.id = id;
			this.action = action;
		}
		
		public int getStick() {
			return stick;
		}
		
		public int getID() {
			return id;
		}
		
		public Runnable getAction() {
			return action;
		}
	}
}
