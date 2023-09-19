// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The wrist joint of the intake/shooter.
 */
public class WristJoint extends SubsystemBase {

  private static final int MOTOR_ID = 5;
  private static final int UPPER_LIMIT_SWITCH_ID = 0;

  Talon motor = new Talon(MOTOR_ID);
  DigitalInput upperLimitSwitch = new DigitalInput(UPPER_LIMIT_SWITCH_ID);

  /** Creates a new WristJoint. */
  public WristJoint() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Returns true if the wrist is at its maximum extension.
   */
  public boolean isOverextended() {
    return upperLimitSwitch.get();
  }

  public void moveAtSpeed(double speed) {
    if (!(speed > 0 && isOverextended())) {  // TODO: Check which direction is extension/flexion
      motor.set(speed);
    } else {  // TODO: Check if else statement actually works
      motor.set(0.0);
    }
  }

  /**
   * Stop the wrist from moving.
   */
  public void stop() {
    motor.set(0.0);
  }

}
