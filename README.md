Plovr Maven Plugin
==================

This maven plugin acts as a simple wrapper around the plovr engine to facilitate easier integration into java projects. 

Currently there's no central repo jar available for direct inclusion so you'll have to build and deploy to your artifact manager manually.

Additionally the plovr dependency itself doesn't have a copy in central, i've packed a custom version in the lib directory, which you can run 

mvn install:install-file -Dfile=plovr.jar -DgroupId=com.betgenius -DartifactId=plovr -Dversion=1.0 -Dpackaging=jar

to install to your local repo, or deploy to nexus the standard way.


## Usage
### Compilation

* Add the plugin to the build section of your pom's project :

            <plugin>
                <groupId>com.betgenius</groupId>
                <artifactId>plovr-maven-plugin</artifactId>
                <version>1.0.7-SNAPSHOT</version>
                <executions>
                    <execution>
                        <id>compilejs</id>
                        <goals>
                            <goal>build</goal>
                        </goals>
                        <phase>compile</phase>
                        <configuration>
                            <includes>
                                <include>**/prodcompile.json</include>
                            </includes>
                        </configuration>
                    </execution>
                </executions>
                <configuration>
                    <configurationDirectories>
                        <configurationDirectory>
                            src/main/resources/plovr
                        </configurationDirectory>
                    </configurationDirectories>
                </configuration>
            </plugin>

### Testing

                    <plugin>
                        <groupId>com.betgenius</groupId>
                        <artifactId>plovr-maven-plugin</artifactId>
                        <version>1.0.7-SNAPSHOT</version>
                        <executions>
                            <execution>
                                <id>testjs</id>
                                <goals>
                                    <goal>test</goal>
                                </goals>
                                <phase>test</phase>
                                <configuration>
                                    <includes>
                                        <include>**/tag.json</include>
                                    </includes>
                                    <driverType>FIREFOX</driverType>
                                    <displayPort>:10</displayPort>
                                </configuration>
                            </execution>
                        </executions>
                        <configuration>
                            <configurationDirectories>
                                <configurationDirectory>
                                    src/main/resources/plovr
                                </configurationDirectory>
                            </configurationDirectories>
                        </configuration>
                    </plugin>

### Serve mode


run mvn plovr:serve to run the plovr server from the maven console. 

