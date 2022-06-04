package frc.robot.subsystems;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{

    private final DifferentialDrive m_differentialDrive;

    private final MotorControllerGroup m_leftMotorControllerGroup;
    private final MotorControllerGroup m_rightMotorControllerGroup;

    private int m_modeIndicator;

    public DriveTrain(){

        Spark rightFrontDriveMotor = new Spark(Constants.DriveInfo.RIGHT_FRONT_DRIVE_MOTOR_ID);
        Spark rightBackDriveMotor = new Spark(Constants.DriveInfo.RIGHT_BACK_DRIVE_MOTOR_ID);
        Spark leftBackDriveMotor = new Spark(Constants.DriveInfo.LEFT_BACK_DRIVE_MOTOR_ID);
        Spark leftFrontDriveMotor = new Spark(Constants.DriveInfo.LEFT_FRONT_DRIVE_MOTOR_ID);

        m_leftMotorControllerGroup = new MotorControllerGroup(leftBackDriveMotor, leftFrontDriveMotor);
        m_rightMotorControllerGroup = new MotorControllerGroup(rightBackDriveMotor, rightFrontDriveMotor);

        m_differentialDrive = new DifferentialDrive(m_leftMotorControllerGroup, m_rightMotorControllerGroup);

        m_leftMotorControllerGroup.setInverted(Constants.DriveInfo.LEFT_MOTOR_CONTROLLER_GROUP_IS_INVERTED);
        m_rightMotorControllerGroup.setInverted(Constants.DriveInfo.RIGHT_MOTOR_CONTROLLER_GROUP_IS_INVERTED);

        m_differentialDrive.setSafetyEnabled(Constants.DriveInfo.MOTOR_SAFETY_IS_ENABLED);

        m_modeIndicator = Constants.DriveInfo.MODE_INDICATOR_INITIAL_VALUE;

    }

    public void tankDrive(double leftSpeed, double rightSpeed){

        m_differentialDrive.tankDrive(leftSpeed, rightSpeed, Constants.DriveInfo.SQUARE_INPUTS);

    }


    public void arcadeDrive(double speed, double rotation){

        m_differentialDrive.arcadeDrive(speed, rotation, Constants.DriveInfo.SQUARE_INPUTS);

    }


    public void lebronJamesDrive(double driveSpeed, double robotRotation, double spin){

        if(robotRotation > 0.04 && (driveSpeed> 0.01 || driveSpeed < -0.01)){
            
            m_differentialDrive.tankDrive(driveSpeed, driveSpeed - Math.abs(robotRotation), Constants.DriveInfo.SQUARE_INPUTS);

        } else if(robotRotation < -0.04 && (driveSpeed> 0.01 || driveSpeed < -0.01)){
            
            m_differentialDrive.tankDrive(driveSpeed - Math.abs(robotRotation), driveSpeed, Constants.DriveInfo.SQUARE_INPUTS);

        } else if(driveSpeed> 0.01 || driveSpeed < -0.01){

            m_differentialDrive.tankDrive(driveSpeed, driveSpeed, Constants.DriveInfo.SQUARE_INPUTS);

        } else if(spin < -0.04){

            m_differentialDrive.tankDrive(spin, -spin, Constants.DriveInfo.SQUARE_INPUTS);

        } else if(spin > 0.04){

            m_differentialDrive.tankDrive(spin, -spin, Constants.DriveInfo.SQUARE_INPUTS);

        }

    }


    public void modeDrive(double driveSpeed, double robotRotation, double spin,
                          double leftSpeed, double rightSpeed){

        if (m_modeIndicator == Constants.DriveInfo.TANK_DRIVE_MODE_VALUE){

            this.tankDrive(leftSpeed, rightSpeed);

            SmartDashboard.putString("Drive Mode", "Tank Drive");

        }

        if (m_modeIndicator == Constants.DriveInfo.LEBRON_JAMES_DRIVE_MODE_VALUE){

            this.lebronJamesDrive(driveSpeed, robotRotation, spin);

            SmartDashboard.putString("Drive Mode", "Lebron James Drive");

        }

    }


    public void changeDriveMode(){

        if (m_modeIndicator == Constants.DriveInfo.TANK_DRIVE_MODE_VALUE){

            m_modeIndicator = Constants.DriveInfo.LEBRON_JAMES_DRIVE_MODE_VALUE;

        } else if (m_modeIndicator == Constants.DriveInfo.LEBRON_JAMES_DRIVE_MODE_VALUE){

            m_modeIndicator = Constants.DriveInfo.TANK_DRIVE_MODE_VALUE;
            
        }

    }

    
}
