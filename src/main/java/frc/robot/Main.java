/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 * 
 * Asher was here
 * 
 */
public final class Main {
  private Main() {
  }

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}


// This Code was written by Justin in 2019-20 and dramatically altered by
// Andy Bennett in 2021-22
// if you need help my discord is probably still active: Andy The Goat#2634

//I've added notes to explain things where I think it's needed. To change the 
//code I think it's easiest to copy what's already been done into new commands/subsystems, and then
//build them into the constants, main, robot, robotcontainer files as necessary. I didn't learn every
//single part of the API, just built off of the work that came before me! If this code base is used again
//in the future that's what you should do too!

//-------IMPORTANT-------
//Your #1 tool is right-clicking a piece of code and exploring the context menu to see where it is 
//defined, referenced, and what a function does, what variables it accepts, etc etc
//This is the magic of extensions in VSCode and helps you quickly build an understanding of how the code works. 
//Good luck!

//https://docs.wpilib.org/en/latest/docs/zero-to-robot/introduction.html
//  ^^ excellent resource for learning how to build up a robot. See all the links on the left bar

//Programs:
//Java SDK or JDK or smthn I don't remember anymore lol
//VSCode
//WPILib VSCode Extension
//FRC Driver Tools
//CAN {CAN is the way we assign numbers to motors and control them. 
//PWM does the same thing but it's less fancy and we didn't use it this year.} tools: REV SPARK MAX Client, CTRE Phoenix Tuner
//I'm sure there are more I forgot, you'll figure it out