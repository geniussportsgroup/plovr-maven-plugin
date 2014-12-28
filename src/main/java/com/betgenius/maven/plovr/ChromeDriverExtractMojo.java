package com.betgenius.maven.plovr;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "extract-chromedriver",
        defaultPhase = LifecyclePhase.GENERATE_RESOURCES,
        requiresProject = true)
public class ChromeDriverExtractMojo extends AbstractPlovrMojo {

//    @Parameter(readonly = true, required = true, defaultValue = "${project}")
//    protected MavenProject project;
//
//    protected InputStream getChromeDriverExecutableResource() {
//        return getClass().getResourceAsStream(determineOS().getResource());
//    }
//
//    @Override
//    public void execute() throws MojoExecutionException, MojoFailureException {
//        AbstractPlovrMojo.OS operatingSystem = determineOS();
//        File outputFile = getChromeDriverExecutable();
//        try (InputStream inputStream = getChromeDriverExecutableResource();
//             OutputStream outputStream = new FileOutputStream(outputFile)) {
//            IOUtils.copy(inputStream, outputStream);
//        } catch (IOException e) {
//            throw new MojoExecutionException("Failure to copy resource", e);
//        }
//    }



}
