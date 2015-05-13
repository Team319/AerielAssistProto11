/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc319.AerielAssistProto11;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author BobDev
 */
public class XboxLeftTrigger extends Button{

    private final Joystick joystick;
    
    public XboxLeftTrigger(Joystick joystick){
        this.joystick = joystick;
    }
    
    
    
    
    public boolean get() {
        // get Trigger value
        double triggerValue = joystick.getRawAxis(3);
// is this the right axi???^^^^^^^^^^^^^^^^^^^^^^^^^
        boolean pressed= false;
        
        
        //left trigger values are 0 --> -1 !!!
        // if it's a quarter pressed return true
        if(triggerValue > .25){
            pressed = true;            
        }
        return pressed;
        
        
                //still gotta fix me...
       //return false     I WASN'T FIXED!!! I WAS REPLACED!!!
    }
    
}
