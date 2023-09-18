// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A subsystem representing the drivetrain of the robot.
 * 
 * The drivetrain has 6 wheels, 3 on each side, with the back 2
 * controlled with Talons.
 */
public final class Drivetrain extends SubsystemBase {

  private static final int LEFT_REAR_MOTOR_CONTROLLER_ID = 0;
  private static final int LEFT_FRONT_MOTOR_CONTROLLER_ID = 1;
  private static final int RIGHT_REAR_MOTOR_CONTROLLER_ID = 2;
  private static final int RIGHT_FRONT_MOTOR_CONTROLLER_ID = 3;

  private Talon leftRearMotor = new Talon(LEFT_REAR_MOTOR_CONTROLLER_ID);
  private Talon leftFrontMotor = new Talon(LEFT_FRONT_MOTOR_CONTROLLER_ID);
  private Talon rightRearMotor = new Talon(RIGHT_REAR_MOTOR_CONTROLLER_ID);
  private Talon rightFrontMotor = new Talon(RIGHT_FRONT_MOTOR_CONTROLLER_ID);

  private MotorControllerGroup leftMotors = new MotorControllerGroup(leftRearMotor, leftFrontMotor);
  private MotorControllerGroup rightMotors = new MotorControllerGroup(rightRearMotor, rightFrontMotor);

  private DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  public Drivetrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Drive the robot, arcade style.
   * @param forwardSpeed
   * @param turnSpeed
   */
  public void driveArcadeStyle(double forwardSpeed, double turnSpeed) {
    differentialDrive.arcadeDrive(forwardSpeed, turnSpeed);  // TODO: Check whether the API is busted
  }

  public void driveTankStyle(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

}
