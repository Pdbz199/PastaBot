package org.team1515.pastabot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickHandler {
	
	private Joystick stick1;
	private Joystick stick2;
	private ArrayList<JoystickButton> buttons;
	
	public JoystickHandler(Joystick stick1, Joystick stick2) {
		this.stick1 = stick1;
		this.stick2 = stick2;
		buttons = new ArrayList<JoystickButton>();
	}
	
	public void onButton(int stick, int id, Runnable press) {
		buttons.add(new JoystickButton(stick, id, press));
	}
	
	public void onButton(int stick, int id, Runnable press, Runnable release) {
		buttons.add(new JoystickButton(stick, id, press, release));
	}
	
	public void reset() {
		for(JoystickButton button : buttons) {
			button.setPressed(false);
			button.release();
		}
	}
	
	public void update() {
		for(JoystickButton button : buttons) {
			if((button.getStick() == 1 && stick1.getRawButton(button.getID())) || (button.getStick() == 2 && stick2.getRawButton(button.getID()))) {
				if(!button.isPressed()) {
					button.press();
					button.setPressed(true);
				}
			}
			else if(button.isPressed()) {
				button.release();
				button.setPressed(false);
			}
		}
	}
	
	class JoystickButton {
		
		int stick;
		int id;
		Runnable press;
		Runnable release;
		boolean pressed;
		
		public JoystickButton(int stick, int id, Runnable press, Runnable release) {
			this.stick = stick;
			this.id = id;
			this.press = press;
			this.release = release;
			pressed = false;
		}
		
		public JoystickButton(int stick, int id, Runnable press) {
			this(stick, id, press, () -> {});
		}
		
		public int getStick() {
			return stick;
		}
		
		public int getID() {
			return id;
		}
		
		public void press() {
			press.run();
		}
		
		public void release() {
			release.run();
		}
		
		public boolean isPressed() {
			return pressed;
		}
		
		public void setPressed(boolean pressed) {
			this.pressed = pressed;
		}
	}
}
