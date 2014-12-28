package com.betgenius.maven.plovr;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "serve", defaultPhase = LifecyclePhase.NONE)
public class PlovrServeMojo extends AbstractPlovrMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Starting Server");
        startServer(getConfigurationFiles());
        try {
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    public void doExecute() throws MojoExecutionException {
    // When Ctrl-C is pressed, stop the container
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                try {
//                    if (ContainerRunMojo.this.localContainer != null
//                            && (org.codehaus.cargo.container.State.STARTED
//                            == ContainerRunMojo.this.localContainer.getState()
//                            ||
//                            org.codehaus.cargo.container.State.STARTING == ContainerRunMojo.this.localContainer.getState())) {
//                        ContainerRunMojo.this.localContainer.stop();
//
//                    }
//
//                } catch (Exception e) {
//                    ContainerRunMojo.this.getLog().warn("Failed stopping the container", e);
//
//                }
//
//            }
//        });
//
//        super.doExecute();
//
//        getLog().info("Press Ctrl-C to stop the container...");
//        ContainerUtils.waitTillContainerIsStopped(this.localContainer);
//    }
}
