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
public class DriveStop extends Command {
    boolean finished=false;
    
    public DriveStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        requires (Robot.hotCamera);
     
    }
    private long startTime = 0;
 
    // Called just before this Command runs the first time
    protected void initialize() {
         startTime = System.currentTimeMillis();
         //Robot.drivetrain.driveStop();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.Brake();
        /**
         if(System.currentTimeMillis()- startTime < 50){
         Robot.drivetrain.driveStop(); //           ^^^^ 1000      time between driving and shooting
         } //                                             So that we get consistent distance when shooting in auto AND tele
         else{
             finished=true;
         }
         ***/ 
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return finished;
        return startTime - System.currentTimeMillis() > 500;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.hotCamera.hotLightOff();
        System.out.println("Drive Stop Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
