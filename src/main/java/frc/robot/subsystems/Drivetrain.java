/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;
//import frc.robot.commands.EncoderPos1;
import edu.wpi.first.wpilibj.Encoder;

public class Drivetrain extends SubsystemBase {

  private WPI_VictorSPX motorLeft = new WPI_VictorSPX(Constants.MOTOR_LEFT_ID);
  private WPI_VictorSPX motorRight = new WPI_VictorSPX(Constants.MOTOR_RIGHT_ID);

  public static Encoder enc;
  private static final double cpr = 5; //if am-3314a
  private static final double whd = 6; // for 6 inch wheel

  
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    enc = new Encoder(0,1);
    enc.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
    //setDefaultCommand(new EncoderPos1());
  }

  public static double driveDistance(){
    return enc.getDistance();
  }

  public static double driveCount(){
    
    return enc.get();
  }

  public static void driveReset(){
    enc.reset();
    enc.setDistancePerPulse(Math.PI*whd/cpr);
  }

  public void setLeftMotor(double speed){
    motorLeft.set(ControlMode.PercentOutput, -speed);
    //motorLeft.setSafetyEnabled(true);
  }

  public void setRightMotor(double speed){
    motorRight.set(ControlMode.PercentOutput, speed);
    //motorRight.setSafetyEnabled(true);
  }
}
