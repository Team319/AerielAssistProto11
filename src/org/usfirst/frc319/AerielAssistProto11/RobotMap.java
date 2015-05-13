// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc319.AerielAssistProto11;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
import org.usfirst.frc319.AerielAssistProto11.commands.flytrapSleep;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainrightFrontMotor;
    public static SpeedController drivetrainrightBackMotor;
    public static SpeedController drivetrainleftFrontMotor;
    public static SpeedController drivetrainleftBackMotor;
    public static RobotDrive drivetrainMecanumDrive;
    public static Gyro drivetrainGyro;
    public static Gyro secondaryGyro;
    public static SpeedController mechanismarm;
    public static DigitalInput mechanismarmStopSwitch;
    public static SpeedController collectorcollector;
    public static DigitalInput beamBreak;
    public static Relay hotRelay;
    public static Encoder encoder;
    public static SpeedController encoderMotor;
    public static Encoder flytrapFlytrapEncoder;
    public static SpeedController flytrapFlytrapMotor;
    public static DigitalInput flytrapResetSwitch;
    public static Relay catchRelay;

    
    public static void init() {
        
        //------------PWM PORTS-------------------//
        drivetrainrightFrontMotor = new Victor(1, 1);        
        drivetrainleftFrontMotor = new Victor(1, 2);
        drivetrainleftBackMotor = new Victor(1, 3);
        drivetrainrightBackMotor = new Victor(1, 4);
        mechanismarm = new Victor(1, 5);
        collectorcollector = new Victor(1, 6);
        flytrapFlytrapMotor = new Victor(1, 7);
        
        //--------DRIVE TRAIN CONSTRUCTORS-------//
        
        drivetrainMecanumDrive = new RobotDrive(drivetrainleftFrontMotor, drivetrainleftBackMotor,
        drivetrainrightFrontMotor, drivetrainrightBackMotor);
	
            drivetrainMecanumDrive.setSafetyEnabled(true);
            drivetrainMecanumDrive.setExpiration(0.1);
            drivetrainMecanumDrive.setSensitivity(0.5);
            drivetrainMecanumDrive.setMaxOutput(1.0);
        
        //-------ANALOG PORTS-------------------//
        
        drivetrainGyro = new Gyro(1, 1);
        drivetrainGyro.setSensitivity(0.0072);
        
        secondaryGyro = new Gyro(1,2);
        secondaryGyro.setSensitivity(0.0072);
        
        
        
        //---------DIGITAL I/O Ports-----------//
        
        mechanismarmStopSwitch = new DigitalInput(1, 1);
        beamBreak = new DigitalInput(2);
        flytrapFlytrapEncoder = new Encoder(1, 3, 1, 4, false, CounterBase.EncodingType.k4X);
            flytrapFlytrapEncoder.setDistancePerPulse(1.0);
            flytrapFlytrapEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);
            flytrapFlytrapEncoder.start();
        flytrapResetSwitch = new DigitalInput(1, 5);
        
        //---------RELAY PORTS-----------------//
        
        hotRelay = new Relay(1);
        catchRelay= new Relay(2);
        
        
        
        //-----
	LiveWindow.addSensor("Flytrap", "FlytrapEncoder", flytrapFlytrapEncoder);
        LiveWindow.addActuator("Flytrap", "FlytrapMotor", (Victor) flytrapFlytrapMotor);
        
               
    }
}