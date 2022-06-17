package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RetractPiston extends CommandBase{

    DoubleSolenoid m_doubleSolenoid;

    public RetractPiston(DoubleSolenoid doubleSolenoid){

        m_doubleSolenoid = doubleSolenoid;

    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {

        m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);

    }

    @Override
    public void end(boolean interrupted) {

        m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);

    }

    @Override
    public boolean isFinished() {
        
        return false;
        
    }
    
}
