// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc319.AerielAssistProto11.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc319.AerielAssistProto11.Robot;
/**
 *
 */
public class  WaitForHot extends Command {
    
    private static final int MIN_POSITIVE_SAMPLES = 1;
    private long startTime = 0;
    
    public WaitForHot() {
    
            // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.hotCamera);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
        startTime = System.currentTimeMillis();
    }
    // Called repeatedly when this Command is scheduled to run
    private int hotCounter = 0;
    private int counter = 0;
//    public boolean didweseehot = false;
    protected void execute() {
        // waits .5 secs "IF not .5 go back to top (return)"
        if(System.currentTimeMillis()- startTime < 500){
            return;
        }
      //"clicks" counter once
        counter++;
        // if counter is "clicked: 11 times continue "else go back to top (return)"
        // THIS IS USED TO SLOW CAMERA TO AVOID "OUTPUT ERRORS
        if(counter > 10){
            counter = 0;
        }else {
            return;
        } 
       //once counter is at 11 click hotcounter until 2
        if(Robot.hotCamera.isHot()){
            hotCounter++;
            System.out.println("saw hot");
           Robot.hotCamera.hotLightOn();
  //         didweseehot = true; // dont need this?>
        }
       // System.out.println(System.currentTimeMillis()-startTime);
      //if 5 secs have gone by register as hot
      
         if(System.currentTimeMillis()- startTime > 5000){
            hotCounter = 2;
            System.out.println("Didn't see hot");
            //System.out.print("");
        }
        
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hotCounter > MIN_POSITIVE_SAMPLES;
        
    }
    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Done");
        
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}