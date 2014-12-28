package com.betgenius.maven.plovr;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.plovr.cli.BuildCommand;

@Mojo(name ="build", defaultPhase=LifecyclePhase.COMPILE)
public class PlovrBuildMojo extends AbstractPlovrMojo {
	
	private BuildCommand serve = new BuildCommand(); 
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		 getLog().info("Starting Server");
		 	List<File> files = getConfigurationFiles();
			List<String> paths = extract(files, on(File.class).getAbsolutePath());
	        try {
				serve.runCommand(paths.toArray(new String[paths.size()]));
			} catch (IOException e1) {
		        getLog().info("Build Failure");
		        throw new MojoExecutionException("Build Failure", e1);
			}
	}



	
}
