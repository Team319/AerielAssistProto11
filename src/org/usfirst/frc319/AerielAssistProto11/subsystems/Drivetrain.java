// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc319.AerielAssistProto11.subsystems;
import org.usfirst.frc319.AerielAssistProto11.commands.joystickDrive;
import org.usfirst.frc319.AerielAssistProto11.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc319.AerielAssistProto11.Robot;
/**
 *
 */
public class Drivetrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController rightFrontMotor = RobotMap.drivetrainrightFrontMotor;
    SpeedController rightBackMotor = RobotMap.drivetrainrightBackMotor;
    SpeedController leftFrontMotor = RobotMap.drivetrainleftFrontMotor;
    SpeedController leftBackMotor = RobotMap.drivetrainleftBackMotor;
    RobotDrive mecanumDrive = RobotMap.drivetrainMecanumDrive;
    Gyro gyro = RobotMap.drivetrainGyro;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Gyro secondaryGyro = RobotMap.secondaryGyro;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new joystickDrive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    
    
    
    }
      public void JoystickDrive(Joystick stick){
          
          double x = stick.getRawAxis(1);
          double y = stick.getRawAxis(2);
          double z = stick.getRawAxis(4) * -1;
          
          //System.out.println("X: "+ x+"Y: "+y+"Z: "+ z);
          
          
          double thresh = .1;
          
          if(x > -1 * thresh && x < thresh){
              x = 0;
             
          }
          if(y > -1 * thresh && y < thresh){
              y = 0;
             
          }
          if(z > -1 * thresh && z < thresh){
              z = 0;
             
          }
          if(x >0){
              x = x * x;
          }else if(x<0){
             x= x * -x;
         }
          
         if(y>0){
             y = y * y;
         }else if(y<0){
             y= y * -y;
         }
          
          
          //System.out.println(x);
          //System.out.println(y);
          //System.out.println(y);
                  
         // Robot.drivetrain.getAngle();
         double angle =Robot.drivetrain.angle() ;
        double secondAngle = Robot.drivetrain.secondaryAngle();
        System.out.println("ORIGINAL ="+angle+"  SECOND ="+secondAngle);
        
          mecanumDrive.mecanumDrive_Cartesian(x,y,z,secondaryAngle());
        
    }
      
    public double angle(){
        return (gyro.getAngle()+180);
    }
    public double secondaryAngle(){
        return (secondaryGyro.getAngle()+180);
    }
    public void getAngle(){
        double angle = Robot.drivetrain.gyro.getAngle();
        double secondAngle = Robot.drivetrain.secondaryGyro.getAngle();
        System.out.println("ORIGINAL ="+angle+"  SECOND ="+secondAngle);
     //   System.out.println(+angle);
       // SmartDashboard.putNumber("Angle!", +angle*180);
        
    }
    public void driveFoward(){
        mecanumDrive.mecanumDrive_Cartesian(0, .7, 0, 0);  //was (0,.7,0,0)
    }
    public void driveStop(){
        mecanumDrive.stopMotor();
        //mecanumDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    public void Brake(){
        mecanumDrive.mecanumDrive_Cartesian(0,-.1,0,0);
    }
    
    public void gyroReset(){
        gyro.reset();
        secondaryGyro.reset();
        
    }

    public void slowJoystickDrive(Joystick stick) {
        double x = stick.getRawAxis(1);
          double y = stick.getRawAxis(2);
          double z = stick.getRawAxis(4) * -1;
          
          
          
          double thresh = .1;
          
          if(x > -1 * thresh && x < thresh){
              x = 0;
             
          }
          if(y > -1 * thresh && y < thresh){
              y = 0;
             
          }
          if(z > -1 * thresh && z < thresh){
              z = 0;
             
          }
          double scaler = .5;
          x = x * scaler;
          y = y * scaler;
          
          
          System.out.println(x);
          System.out.println(y);
          System.out.println(y);
                  
          Robot.drivetrain.getAngle();
          mecanumDrive.mecanumDrive_Cartesian(x,y,z,Robot.drivetrain.angle());
    }
}