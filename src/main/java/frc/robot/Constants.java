/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * 
 * Asher was here
 * 
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	// DriveTrain motor assignments. We used CAN and set the pairs of motor controllers to have the
	// same CAN ID, ie left motors are 1 and 1 and right motors are 3 and 3.
	public static final int MOTOR_LEFT_ID = 1;
	public static final int MOTOR_RIGHT_ID = 3;

	// You can reorder controllers in FRC Driver Station, so this just grabs which one is first in the list
	// and then the second one in the list.
	public static final int DRIVER_CONTROLLER = 0;
	public static final int SHOTGUN_CONTROLLER = 1;

	// Controller button and Axis assignments. Use FRC Driver Station to help figure these out.
	public static final int LEFT_STICKY = 1;
	public static final int RIGHT_STICKY = 3;
	public static final int FLIGHT_STICKY = 1;
	public static final int FLIGHT_TWIST = 2;
	public static final int FLIGHT_THRUST = 3;
	public static final int BUTTON_LB = 5;
	public static final int BUTTON_RB = 6;
	public static final int BUTTON_LT = 7;
	public static final int BUTTON_RT = 8;
	public static final int TRIGGER = 1;
	public static final int TRIGGER_TWO = 2;


	// Is trigger pressed? Updated by ActivateBallDrive.java & DeactivateBallDrive.java, determines whether BallDrive/BallTrain functions
	public static boolean triggerStatus = false;

	public static boolean triggerTwoStatus = false;


	// I'm not sure this one is used tbh. Dunno what it was meant for. Leaving it for kicks and giggles
	public static final double Timeout = 4.25;

	// arm motor assignments. Use software like REV Spark Max Client or Phoenix Tuner to assign/ 
	// discover the motors' CAN assignments. Also remember that there may be PWM controlled motors,
	// their number is based on what port they're plugged into on the RoboRIO. These two are CAN.
	public static final int ARM_ANGLE_MOTOR_ID = 5; //Spark Max
	public static final int WINCH_MOTOR_ID = 4;	//CTRE Talon SRX
	public static final int BALL_MOTOR_ID = 6;	//Spark Max


	//Note that this is not 'final' because we change it; this is the virtual gearbox multiplier.
	public static double tankSpeed = 0.6; //Virtual Gearbox! Starts at 60% and ranges from 20% to 100%
}
