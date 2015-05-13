// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc319.AerielAssistProto11.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc319.AerielAssistProto11.Robot;
/**
 *
 */

public class  armHome extends Command {
    private long startTime= 0;
    
    
    
    public armHome() {
       
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.mechanism);
        requires(Robot.collector);
        //requires(Robot.flytrap);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        startTime= System.currentTimeMillis();
        //Robot.flytrap.setSetpoint(Robot.flytrap.openTrapSetpoint);
        //Robot.flytrap.enable();
        
        
        
        
        //Robot.mechanism.armSpinForward();
        
       // Robot.collector.collectorWheelsBack();
        //Timer.delay(.5);
        //maybe add a drive forward timer delay to get off the limit switch
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.mechanism.armSpinForward();
       // Robot.collector.collectorWheels();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        return Robot.mechanism.GetLimitSwitch();// && System.currentTimeMillis() - startTime > 500;
        

    }
    // Called once after isFinished returns true
    protected void end() {
        //System.out.println("Finished Arm Home");
        Robot.mechanism.armSpinStop();
       // Robot.collector.collectorWheelsStop();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}