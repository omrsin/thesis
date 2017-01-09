In order to make this project work in your computer, there are quite a few configurations that have to be done first.

# Installing Java Pathfinder (jpf)
Here are the installation steps for **Java Pathfinder (jpf)** on Ubuntu 16.04

## Resources
 - **Java Pathfinder (JPF)** http://babelfish.arc.nasa.gov/trac/jpf
 - **JUnit** http://junit.org/


## Prerequisites
 - **Java** Installed normally using apt-get having added the repo that gets the binaries from oracle. I am using java 1.8.0_111
 - **Mercurial** Installed normally using apt-get. I am using version 3.7.3
 - **Ant** Installed normally using apt-get. I am using version 1.9.6
 - **JUnit** Download the latest jars from the official resources. In this case junit.jar hamcrest-core.jar and place them in a known directory.


## Steps
 1. Clone the project **jpf-core** from the official repository using: 
    ```sh
       hg clone http://babelfish.arc.nasa.gov/hg/jpf/jpf-core/summary
    ```
 2. Create the **site.properties** file as suggested in the official jpf site. Make sure to be pointing the jpf-core property to the directory where you cloned the project. Also be sure to remove or comment the other references to modules in the example file provided.
 3. In order to be able to build the project, JUnit libraries need to be in the classpath. The ant script requires the JUNIT_HOME directory to be specified. This could be done by creating the JUNIT_HOME environment variable and placing it in the path or what I prefer, is changing the **build.xml** file of the jpf-core project and replacing the value property **junit.home** with the value of the directory where you placed the jars. For me this is better because you avoid polluting your classpath with variables that might potentially generate conflicts with other programs.
 4. Finally, go to the jpf-core directory and execute: 
    ```sh 
       ant test 
    ```
    With this, JPF should be available.
 5. In order to test if the build was actually successful is to go to the jpf-core directory and execute:
    ```sh 
       java -jar build/RunJPF.jar src/examples/Racer.jpf
    ```
    JPF should run a basic model checking analysis on the Racer example.

# Installing the Eclipse JPF plugin
Be sure to install jpf-core and any necessary module before installing the plugin.

This is very simple and it is the most convenient way to run the analyses. In Eclipse, go to **Help -> Install New Software** and add the following update site http://babelfish.arc.nasa.gov/trac/jpf/raw-attachment/wiki/projects/eclipse-jpf/update. Finally install the corresponding plugin.


The analyses can be run by right-clicking a jpf file and choosing the option **Verify**.
