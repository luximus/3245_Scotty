// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A subsystem representing the combined intake and shooter.
 */
public class IntakeShooter extends SubsystemBase {

  /** Creates a new IntakeShooter. */
  public IntakeShooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Run the intake/shooter.
   * @param speed the speed at which to run the intake/shooter. Positive values indicate drawing
   *   when the intake/shooter is down and spitting out when the intake/shooter is tilted upwards.
   */
  public void runAtSpeed(double speed) {
    // TODO: Implement intake/shooter running
  }

  /**
   * Stop the intake/shooter.
   */
  public void stop() {
    // TODO: Implement intake/shooter stopping
  }

}
