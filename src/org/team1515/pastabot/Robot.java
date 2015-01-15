
package org.team1515.pastabot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;


public class Robot extends IterativeRobot {
	
	JoystickHandler joystickHandler;
	Joystick stick1;
	Joystick stick2;
	
	Piston piston;
	CANTalon testMotor;
	
    public void robotInit() {
    	stick1 = new Joystick(0);
    	stick2 = new Joystick(1);
    	joystickHandler = new JoystickHandler(stick1, stick2);
    	assignJoystickEvents(joystickHandler);
    	
    	piston = new Piston(0, 7);
    	
    	testMotor = new CANTalon(0);
    }

    public void autonomousPeriodic() {
    	
    }

    public void teleopInit() {
	    joystickHandler.reset();
    }
    
    public void teleopPeriodic() {
    	joystickHandler.update();
    	testMotor.set(-stick1.getRawAxis(1));
    }
    
    public void assignJoystickEvents(JoystickHandler handler) {
    	handler.onButton(1, 1, () -> {
    		piston.extend();
    		System.out.println("button 1 pressed on joystick 1");
    	}, () -> {
    		piston.retract();
	    	System.out.println("button 1 released on joystick 1");
    	});
    	
    	handler.onButton(1, 2, () -> {
    		System.out.println("piston retracted");
    	});
    }
    
}
