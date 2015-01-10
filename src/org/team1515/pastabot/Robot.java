
package org.team1515.pastabot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	JoystickHandler joystickHandler;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	joystickHandler = new JoystickHandler(new Joystick(1), new Joystick(2));
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    public void teleopInit() {
    	joystickHandler.onButton(1, 5, () -> {
    		System.out.println("button 5 pressed on joystick 1");
    	});
    }
    
    public void teleopPeriodic() {
    	joystickHandler.update();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
