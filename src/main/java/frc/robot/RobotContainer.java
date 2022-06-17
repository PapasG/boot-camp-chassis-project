package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Mechanism;

public class RobotContainer {

  private final XboxController m_controller;
  private final DriveTrain m_driveTrain;
  private final Mechanism m_mechanism;

  private final JoystickButton m_driveModeButton;
  private final JoystickButton m_mechanismButton;
  
  public RobotContainer() {

    m_driveTrain = new DriveTrain();
    m_mechanism = new Mechanism();
    m_controller = new XboxController(Constants.RobotInfo.CONTROLLER_PORT);

    m_driveModeButton = new JoystickButton(m_controller, Constants.RobotInfo.DRIVE_MODE_BUTTON_VALUE);
    m_mechanismButton = new JoystickButton(m_controller, Constants.RobotInfo.MECHANISM_BUTTON_VALUE);

    configureButtonBindings();
    setDefaultCommands();
    
  }

  private void configureButtonBindings() {

    m_driveModeButton.whenPressed(new RunCommand(()-> m_driveTrain.changeDriveMode(), m_driveTrain).withTimeout(Constants.DriveInfo.MODE_CHANGE_TIME_VALUE));

  }

  private void setDefaultCommands(){

    m_driveTrain.setDefaultCommand(new RunCommand(()->
                                       m_driveTrain.modeDrive(m_controller.getRightTriggerAxis() - m_controller.getLeftTriggerAxis(), 
                                       m_controller.getLeftX(), m_controller.getRightX(), 
                                       m_controller.getLeftY(), m_controller.getRightY()), m_driveTrain));

  }

  public Command getAutonomousCommand() {
    
    return null;
  
  }

}
