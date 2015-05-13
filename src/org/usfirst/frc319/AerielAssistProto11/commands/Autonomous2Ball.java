/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc319.AerielAssistProto11.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author BobDev
 */
public class Autonomous2Ball extends CommandGroup {
    
    public Autonomous2Ball() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        //addSequential(new GyroReset());
        //addSequential(new DriveStop());
        //
       
        addSequential(new armHome());
     //   addSequential(new OpenTrapSetpoint());
        
        addSequential(new WaitForHot());
        //addSequential(new CameraSleep());
        addSequential(new DriveFoward());
        //addSequential(new DriveStop());
        addSequential(new ShootCommand());
        addSequential(new armHome());
        
       // addSequential(new CloseTrapSetpoint());
    }
}
