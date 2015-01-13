package org.team1515.pastabot.drivetrain;

import edu.wpi.first.wpilibj.Joystick;

public class ArnoldDrive extends DriveTrain {

	public ArnoldDrive(int motorPortOne, int motorPortTwo, int motorPortThree,
			int motorPortFour, int encoderSlotOne, int encoderSlotTwo,
			int encoderSlotThree, int encoderSlotFour, Joystick joystick) {
		super(motorPortOne, motorPortTwo, motorPortThree, motorPortFour,
				encoderSlotOne, encoderSlotTwo, encoderSlotThree, encoderSlotFour,
				joystick);
		// TODO Auto-generated constructor stub
	}

	public void drive() {
		y = joystick.getRawAxis(2) * getThrottle();
		x = joystick.getRawAxis(6) * getThrottle();
		if (Math.abs(joystick.getRawAxis(2)) <= DEAD_BAND) {
			y = 0.0;
		}
		if (Math.abs(joystick.getRawAxis(6)) <= DEAD_BAND) {
			x = 0.0;
		}
	}
}
