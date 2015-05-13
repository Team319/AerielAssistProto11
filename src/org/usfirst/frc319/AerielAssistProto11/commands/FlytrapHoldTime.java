/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc319.AerielAssistProto11.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc319.AerielAssistProto11.Robot;

/**
 *
 * @author BobDev
 */
public class FlytrapHoldTime extends Command {
   private long startTime = 0;
    private boolean finished;
    
    
    public FlytrapHoldTime() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.flytrap);
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        startTime = System.currentTimeMillis();
        finished = false;
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.flytrap.flytrapHold(); // "holds" flytrap at closed setpoint... 
        
        if(System.currentTimeMillis()- startTime > 1000){ // Holds it for "#" seconds...
            finished = true; // if "#" seconds have gone by go to "isFinished"
        }else{
            finished = false; // ELSE Don't go to isFinished
        }
        
        
       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished; // it's done... The Command Group can continue...
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
