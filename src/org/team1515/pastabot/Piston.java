package org.team1515.pastabot;

import edu.wpi.first.wpilibj.Solenoid;

public class Piston {
    private Solenoid bottom;
    private Solenoid top;
    
    public Piston(int bottomPort, int topPort){
        this.bottom = new Solenoid(0, bottomPort);
        this.top = new Solenoid(0, topPort);
    }
    
    public void extend(){
        top.set(false);
        bottom.set(true);
    }
    
    public void retract(){
        top.set(true);
        bottom.set(false);
    }
}
