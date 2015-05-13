// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.AerielAssistProto11.subsystems;

import org.usfirst.frc319.AerielAssistProto11.commands.flytrapSleep;
import org.usfirst.frc319.AerielAssistProto11.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; 
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc319.AerielAssistProto11.Robot;
import org.usfirst.frc319.AerielAssistProto11.RobotMap;
import org.usfirst.frc319.AerielAssistProto11.commands.CloseTrapSetpoint;
import org.usfirst.frc319.AerielAssistProto11.commands.DefaultFlytrapSetpoint;
import org.usfirst.frc319.AerielAssistProto11.commands.JoystickCatch;

/**
 *
 */
public class Flytrap extends PIDSubsystem {

    Encoder flytrapEncoder = RobotMap.flytrapFlytrapEncoder;
    SpeedController flytrapMotor = RobotMap.flytrapFlytrapMotor;
    DigitalInput flytrapResetSwitch = RobotMap.flytrapResetSwitch;
    Relay catchRelay = RobotMap.catchRelay;

    // Initialize your subsystem here
    public double openTrapSetpoint = 0; 
    public double closeTrapSetpoint = 350;
    public double defaultSetpoint = 1000 ;
    public Flytrap() {
        super("Flytrap", 0.001, 0.0, 0.0);
        setAbsoluteTolerance(100); ////Lets make this bigger, was 10 3/3/14
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Flytrap", "PIDSubsystem Controller", getPIDController());
        
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here.
        setDefaultCommand(new flytrapSleep());
        //setDefaultCommand(new JoystickCatch());
      //  setDefaultCommand(new DefaultFlytrapSetpoint());
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        double value = flytrapEncoder.pidGet();
        System.out.println("The encoder value is:" + value);
        return value;
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
	System.out.println(output);
        flytrapMotor.pidWrite(output);
    }
    public void flytrapSleep(){
        //Robot.flytrap.flytrapMotor.set(0);
    }
    public boolean getFlytrapResetSwitch(){
        return flytrapResetSwitch.get();
        }
    public void flytrapReset(){
        Robot.flytrap.flytrapEncoder.reset();
    }
    public void flytrapHold(){
        Robot.flytrap.flytrapMotor.set(0);
    }
    public void catchLightOn(){
        Robot.flytrap.catchRelay.set(Relay.Value.kForward);
    }
    public void catchLightOff(){
        Robot.flytrap.catchRelay.set(Relay.Value.kOff);
    }
    public void openTrapSlow(){
        Robot.flytrap.flytrapMotor.set(.2);
    }
    public void closeTrapFast(){
        Robot.flytrap.flytrapMotor.set(-.7);
    }
}
