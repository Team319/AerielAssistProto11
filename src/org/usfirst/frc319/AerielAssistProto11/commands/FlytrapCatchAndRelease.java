/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc319.AerielAssistProto11.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author BobDev
 */
public class FlytrapCatchAndRelease extends CommandGroup {
    
    public FlytrapCatchAndRelease() {
        // Add Commands here:
        addSequential(new CloseTrapSetpoint()); // closes
        addSequential(new FlytrapHoldTime());  // WAITS
        addSequential(new OpenTrapSetpoint());
       
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
    }
}
