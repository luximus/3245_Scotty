// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A subsystem representing the combined intake and shooter.
 */
public final class IntakeShooter extends SubsystemBase {

  private static final int LEFT_MOTOR_ID = 0;
  private static final int RIGHT_MOTOR_ID = 1;

  private Talon leftMotor = new Talon(LEFT_MOTOR_ID);
  private Talon rightMotor = new Talon(RIGHT_MOTOR_ID);

  private MotorController motor = new MotorControllerGroup(leftMotor, rightMotor);

  /** Creates a new IntakeShooter. */
  public IntakeShooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Run the intake/shooter.
   * @param speed the speed at which to run the intake/shooter. Positive values indicate drawing
   *   in.
   */
  public void runAtSpeed(double speed) {
    motor.set(speed);
  }

  /**
   * Stop the intake/shooter.
   */
  public void stop() {
    motor.set(0);
  }

}
