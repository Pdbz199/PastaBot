package org.team1515.pastabot.drivetrain;

import edu.wpi.first.wpilibj.Talon;

public class MotorModule {
    private Talon one;
    private Talon two;
    
    public MotorModule(int portOne, int portTwo){
        this.one = new Talon(portOne);
        this.two = new Talon(portTwo);
    }
    
    public void setSpeed(double speed){
        if(speed > 1.0){
            speed = 1.0;
        }
        if(speed < -1.0){
            speed = -1.0;
        }
        one.set(speed);
        two.set(speed);
    }
    
    public void stop(){
        setSpeed(0.0);
    }
}
