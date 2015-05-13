package org.usfirst.frc319.AerielAssistProto11.commands;


import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc319.AerielAssistProto11.Robot;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BobDev
 */
public class ShootCommand extends Command {
    
    private long startTime = 0;
    private double speed = .1;
    
    public ShootCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.mechanism);
        //requires(Robot.flytrap);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        startTime = System.currentTimeMillis();
        //Robot.flytrap.setSetpoint(Robot.flytrap.openTrapSetpoint);
        //Robot.flytrap.enable();
        speed = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(speed < 1 ){
            speed += .05;
        }
        //Robot.mechanism.armSpinForward();
        Robot.mechanism.armSpinSpeed(speed);
        //iystem.out.println("Shot @ " + speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime > 1250;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
