package com.betgenius.maven.plovr;


import com.google.common.collect.ImmutableList;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.plexus.util.DirectoryScanner;
import org.plovr.CompilationServer;
import org.plovr.ConfigParser;

import java.io.File;
import java.util.List;

public abstract class AbstractPlovrMojo extends AbstractMojo {

    @Parameter
    protected File[] configurationDirectories;

    @Parameter
    protected String[] includes = {"**/*.json"};

    @Parameter
    protected String[] excludes = {};


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        throw new RuntimeException("Not implemented yet");
    }

    protected ImmutableList<File> getConfigurationFiles(File baseDirectory) {
        ImmutableList.Builder<File> listBuilder = new ImmutableList.Builder<File>();
        final DirectoryScanner directoryScanner = new DirectoryScanner();
        directoryScanner.setIncludes(includes);
        directoryScanner.setExcludes(excludes);
        directoryScanner.setBasedir(baseDirectory);
        directoryScanner.scan();

        for (String fileName : directoryScanner.getIncludedFiles()) {
            listBuilder.add(new File(baseDirectory, fileName));

        }
        return listBuilder.build();
    }

    protected ImmutableList<File> getConfigurationFiles() {
        getLog().info("Getting Configuration Files...");
        ImmutableList.Builder<File> listBuilder = new ImmutableList.Builder<File>();
        for (File configurationDirectory : configurationDirectories) {
            if (!configurationDirectory.exists()) {
                getLog().warn(String.format("Configuration directory '%s' does not exist", configurationDirectory));
            } else {
                listBuilder.addAll(getConfigurationFiles(configurationDirectory));
            }
        }
        return listBuilder.build();
    }


    protected void startServer(List<File> configurationFiles) throws MojoFailureException {

        if (configurationFiles == null || configurationFiles.isEmpty()) {
            getLog().error("No configuration files war found.");
            throw new MojoFailureException("No config files found, cannot start server");
        }

        try {
            CompilationServer server = new CompilationServer("localhost", 9810, false);
            for (File configFile : configurationFiles) {
                server.registerConfig(ConfigParser.parseFile(configFile));
            }
            server.run();
            getLog().info("Plovr server started.");
        } catch (Exception e) {
            getLog().error("Problem starting plovr server. " + e.getMessage());
            throw new MojoFailureException("Could not start plovr server",e);
        }

    }


//    @Parameter(readonly = true, required = true, defaultValue = "${project}")
//    protected MavenProject project;

//    public static enum OS {
//        WINDOWS("/driverbin/windows/chromedriver.exe"),
//        LINUX("/driverbin/linux/chromedriver"),
//        MAC("/driverbin/osx/chromedriver");
//
//        private final String resource;
//
//        private OS(String resource) {
//            this.resource = resource;
//        }
//
//        public String getResource() {
//            return resource;
//        }
//    }
//
//    @Nonnull
//    public static OS determineOS() throws RuntimeException {
//        String osName = System.getProperty("os.name").toLowerCase();
//
//        if (osName.contains("win")) {
//            return OS.WINDOWS;
//        }
//
//        if (osName.contains("mac")) {
//            return OS.MAC;
//        }
//
//        if (osName.contains("nix") || osName.contains("nux") || osName
//                .contains("aix") || osName.contains("sunos")) {
//            return OS.LINUX;
//        }
//
//        throw new RuntimeException(format("Operating system could not be " +
//                "determined from '%s'", osName));
//    }
//
//    protected File getChromeDriverExecutable() {
//        String dir = project.getBuild().getDirectory();
//        switch (determineOS()) {
//            case WINDOWS:
//                return new File(dir, "chromedriver.exe");
//            case LINUX:
//            case MAC:
//                return new File(dir, "chromedriver");
//            default:
//                return null;
//        }
//    }


}
