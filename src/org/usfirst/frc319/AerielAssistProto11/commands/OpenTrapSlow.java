/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc319.AerielAssistProto11.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc319.AerielAssistProto11.Robot;

/**
 *
 * @author BobDev
 */
public class OpenTrapSlow extends Command {
    boolean finished=false;
    
    public OpenTrapSlow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.flytrap);
     
    }
    private long startTime = 0;
 
    // Called just before this Command runs the first time
    protected void initialize() {
         startTime = System.currentTimeMillis();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         if(System.currentTimeMillis()- startTime < 1000){// worked at week 0
         Robot.flytrap.openTrapSlow(); //^^^      ^^^^ drives for 1 sec in auto // 2nd qualifying match changedto 750
         }
         else{finished=true;
         }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
