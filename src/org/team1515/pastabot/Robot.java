
package org.team1515.pastabot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;


public class Robot extends IterativeRobot {
	
	JoystickHandler joystickHandler;
	
    public void robotInit() {
    	joystickHandler = new JoystickHandler(new Joystick(1), new Joystick(2));
    	assignJoystickEvents();
    }

    public void autonomousPeriodic() {
    	
    }

    public void teleopInit() {
	    joystickHandler.reset();
    }
    
    public void teleopPeriodic() {
    	joystickHandler.update();
    }
    
    public void assignJoystickEvents() {
    	joystickHandler.onButton(1, 5, () -> {
    		System.out.println("button 5 pressed on joystick 1");
    	}, () -> {
	    	System.out.println("button 5 released on joystick 1");
    	});
    }
    
}
