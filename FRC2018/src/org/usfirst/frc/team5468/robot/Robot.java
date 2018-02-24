/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5468.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import templates.*;
import utilities.*;


public class Robot extends IterativeRobot {
	private Hardware robot;
	private Input input;
	private Output output;
	private Thread lemonlight;
	
	private TeleopProgram teleop;
	private AutoProgram auto;
	
	@Override
	public void robotInit() {
		robot = new Hardware();
		input = new Input(robot);
		output = new Output(robot);
		//lemonlight = new Vision();
	}

	@Override
	public void autonomousInit() {
		auto = input.getAuto();
		robot.enableCompressor(true);
		auto.autonomousInit();
	}

	@Override
	public void autonomousPeriodic() {
		output.update();
		auto.autonomousPeriodic();
	}

	@Override
	public void teleopInit(){
		teleop = input.getTeleop();
		robot.variables.setDriver(input.getDriver());
		robot.enableCompressor(true);
		teleop.teleopInit();
	}
	
	@Override
	public void teleopPeriodic() {
		//lemonlight.run();
		output.update();
		teleop.teleopPeriodic();
	}
	
	
	@Override
	public void disabledInit() {
	}
	
	@Override 
	public void disabledPeriodic() {
		//lemonlight.run();
		robot.refreshConfig();
		output.update();
	}
}
