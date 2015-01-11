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
		actions = new ArrayList<JoystickButton>();
	}
	
	public void onButton(int stick, int id, Runnable press) {
		onButton(stick, id, press, () -> {});
	}
	
	public void onButton(int stick, int id, Runnable press, Runnable release) {
		buttons.add(new JoystickButton(stick, id, press, release));
	}
	
	public void update() {
		for(JoystickButton button : buttons) {
			if((button.getStick() == 1 && stick1.getRawButton(button.getID())) || (button.getStick() == 2 && stick2.getRawButton(button.getID()))) {
				if(!button.isPressed()) {
					button.getPress().run();
					button.setPressed(true);
				}
			}
			else if(button.isPressed()) {
				button.getRelease().run();
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
		
		public int getStick() {
			return stick;
		}
		
		public int getID() {
			return id;
		}
		
		public Runnable getPress() {
			return press;
		}
		
		public Runnable getRelease() {
			return release;
		}
		
		public boolean isPressed() {
			return pressed;
		}
		
		public void setPressed(boolean pressed) {
			this.pressed = pressed;
		}
	}
}
