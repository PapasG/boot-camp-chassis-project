package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {

  private final XboxController m_controller;
  private final DriveTrain m_driveTrain;

  private final JoystickButton m_driveModeButton;
  
  public RobotContainer() {

    m_driveTrain = new DriveTrain();
    m_controller = new XboxController(Constants.RobotInfo.CONTROLLER_PORT);

    m_driveModeButton = new JoystickButton(m_controller, XboxController.Button.kA.value);

    configureButtonBindings();
    setDefaultCommands();
  }

  private void configureButtonBindings() {

    m_driveModeButton.whenPressed(new RunCommand(()-> m_driveTrain.changeDriveMode(), m_driveTrain));

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
