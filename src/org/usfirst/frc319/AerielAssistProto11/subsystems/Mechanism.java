// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc319.AerielAssistProto11.subsystems;
import org.usfirst.frc319.AerielAssistProto11.commands.armSpinStop;
import org.usfirst.frc319.AerielAssistProto11.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc319.AerielAssistProto11.Robot;
/**
 *
 */
public class Mechanism extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController arm = RobotMap.mechanismarm;
    DigitalInput armStopSwitch = RobotMap.mechanismarmStopSwitch;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new armSpinStop());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void armSpinForward(){
        Robot.mechanism.arm.set(1);
    }
    
    public void armSpinSpeed(double speed){
        //protect the arm from driving backwards
        if(speed < 0) speed = 0;
        Robot.mechanism.arm.set(speed);
    }
    
    public void armSpinStop(){
        Robot.mechanism.arm.set(0);
    }
    

    public void JoystickDrive(Joystick joystick) {
       double armTwist = joystick.getTwist();
       if (armTwist < 0){
           Robot.mechanism.arm.set(-1 * armTwist);
       }else {
           armSpinStop();
       }
    }
       public boolean GetLimitSwitch(){
        System.out.println(armStopSwitch);
           return armStopSwitch.get(); 
        
       
     }
    
        
       
    
}
