package frc.robot.subsystems;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{

    private final DifferentialDrive m_differentialDrive;

    private final MotorControllerGroup m_leftMotorControllerGroup;
    private final MotorControllerGroup m_rightMotorControllerGroup;

    private int m_modeIndicator;

    public DriveTrain(){

        Spark rightFrontDriveMotor = new Spark(0);
        Spark rightBackDriveMotor = new Spark(1);
        Spark leftBackDriveMotor = new Spark(2);
        Spark leftFrontDriveMotor = new Spark(3);

        m_leftMotorControllerGroup = new MotorControllerGroup(leftBackDriveMotor, leftFrontDriveMotor);
        m_rightMotorControllerGroup = new MotorControllerGroup(rightBackDriveMotor, rightFrontDriveMotor);

        m_differentialDrive = new DifferentialDrive(m_leftMotorControllerGroup, m_rightMotorControllerGroup);

        m_leftMotorControllerGroup.setInverted(Constants.DriveInfo.LEFT_MOTOR_CONTROLLER_GROUP_IS_INVERTED);
        m_rightMotorControllerGroup.setInverted(Constants.DriveInfo.RIGHT_MOTOR_CONTROLLER_GROUP_IS_INVERTED);

        m_differentialDrive.setSafetyEnabled(false);

        m_modeIndicator = 0;

    }

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squareInputs){

        m_differentialDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);

    }

    public void lebronJamesDrive(double driveSpeed, double robotRotation, double spin,
                                 double leftSpeed, double rightSpeed, double squareInputs){

    }

    
}
