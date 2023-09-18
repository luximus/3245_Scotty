// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTankStyleWithMultiplier;
import frc.robot.subsystems.Drivetrain;

public final class RobotContainer {

  private static final int DRIVER_CONTROLLER_PORT = 0;
  private static final XboxController.Axis DRIVER_LEFT_AXIS = XboxController.Axis.kLeftTrigger;
  private static final XboxController.Axis DRIVER_RIGHT_AXIS = XboxController.Axis.kRightTrigger;
  private static final XboxController.Button DRIVER_SLOW_SPEED_BUTTON = XboxController.Button.kLeftBumper;
  private static final XboxController.Button DRIVER_FAST_SPEED_BUTTON = XboxController.Button.kRightBumper;

  private static final double NORMAL_DRIVE_SPEED = 0.6;
  private static final double SLOW_DRIVE_SPEED = 0.4;
  private static final double FAST_DRIVE_SPEED = 0.8;

  private Drivetrain drivetrain = new Drivetrain();
  private XboxController driverController = new XboxController(DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    configureBindings();

    drivetrain.setDefaultCommand(getDriveCommand(NORMAL_DRIVE_SPEED));
  }

  private void configureBindings() {
   var slowButton = new JoystickButton(driverController, DRIVER_SLOW_SPEED_BUTTON.value);
   var fastButton = new JoystickButton(driverController, DRIVER_FAST_SPEED_BUTTON.value);

   fastButton.whileTrue(getDriveCommand(FAST_DRIVE_SPEED));
   slowButton.whileTrue(getDriveCommand(SLOW_DRIVE_SPEED));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  private DriveTankStyleWithMultiplier getDriveCommand(double speedMultiplier) {
    return new DriveTankStyleWithMultiplier(drivetrain,
                                            this::getLeftDriveInput,
                                            this::getRightDriveInput,
                                            speedMultiplier);
  }

  private double getLeftDriveInput() {
    return driverController.getRawAxis(DRIVER_LEFT_AXIS.value);
  }

  private double getRightDriveInput() {
    return driverController.getRawAxis(DRIVER_RIGHT_AXIS.value);
  }
}
