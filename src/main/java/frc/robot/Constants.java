
package frc.robot;


public final class Constants {

    public final static class DriveInfo{

        public final static int MODE_INDICATOR_INITIAL_VALUE = 0;

        public final static int TANK_DRIVE_MODE_VALUE = 0;
        public final static int LEBRON_JAMES_DRIVE_MODE_VALUE = 1;

        public final static double MODE_CHANGE_TIME_VALUE = .15;

        public final static boolean LEFT_MOTOR_CONTROLLER_GROUP_IS_INVERTED = true;
        public final static boolean RIGHT_MOTOR_CONTROLLER_GROUP_IS_INVERTED = false;

        public final static int RIGHT_FRONT_DRIVE_MOTOR_ID = 0;
        public final static int RIGHT_BACK_DRIVE_MOTOR_ID = 1;
        public final static int LEFT_BACK_DRIVE_MOTOR_ID = 2;
        public final static int LEFT_FRONT_DRIVE_MOTOR_ID = 3;

        public final static boolean MOTOR_SAFETY_IS_ENABLED = false;

        public final static boolean SQUARE_INPUTS = false;

        public final static double TRIGGER_DEAD_ZONE_VALUE = 0.01;
        public final static double JOYSTICK_DEAD_ZONE_VALUE = 0.04;

    }

    public final static class RobotInfo{

        public final static int CONTROLLER_PORT = 1;
    }

}
