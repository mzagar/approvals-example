## Example maven project using [ApprovalTest.Java library](www.approvaltests.com).

Since ApprovalTests.jar is not available through public maven repositories,
in order to use it as 'ordinary' maven dependency I suggest to install it 
to local or remote maven repository specifying some custom groupId, artifactId and version.

Description of several approaches to mavenizing ApprovalTests.jar follows.
This project uses Approach#3 (see bellow).


### Approach 1 - adding ApprovalTests.jar to remote repository
If you have a private remote maven repository (e.g. Artifactory or Nexus), 
simplest approach is to add ApprovalTests.jar manually as maven artifact 
in repository specifying custom groupId, artifactId and version.

Then you can add dependency declaration as usual and you're done.

### Approach 2 - installing ApprovalTests.jar in local repository from command line
To manually install ApprovalTests.jar v0.13 in local repository from command line, use this maven command:

```
mvn install:install-file -Dfile=ApprovalTests.jar -DgroupId=com.github.approvals -DartifactId=ApprovalTests -Dversion=0.13 -Dpackaging=jar
```

You can then reference ApprovalTests artifact by adding following dependency declaration:
```
        <dependency>
            <groupId>com.github.approvals</groupId>
            <artifactId>ApprovalTests</artifactId>
            <version>0.13</version>
        </dependency>
```

### Approach 3 - configuring maven-install plugin in pom.xml to add ApprovalTests.jar in local repository

See this project's pom.xml as example how to configure maven-install-plugin & bind it to maven initialize phase to install ApprovalTests.jar as maven artefact in local repository.

Follow these steps:
```
$ git clone https://github.com/mzagar/approvals-example.git
$ cd approvals-example
$ mvn initialize
$ mvn clean test
...
Build should be successful and all tests should pass.
```

In initialize phase 'mvn initialize', maven-install-plugin will copy approvals-exampl/lib/ApprovalTests-0.13.jar to local repository creating artefact with 
* groupId=com.github.approvals, 
* artifactId=ApprovalTests, 
* version=0.13, 
* packaging=jar.

The effect is the same as in Approach#2. 

Project pom.xml refereces ApprovalTests.jar using following dependency declaration:
```
        <dependency>
            <groupId>com.github.approvals</groupId>
            <artifactId>ApprovalTests</artifactId>
            <version>0.13</version>
        </dependency>
```


### Note: using addjars-maven-plugin with ApprovalTests.jar does not work!
Alas, using addjars-maven-plugin to automagically add ApprovalTests.jar as maven
project dependency does not work. Call to Approvals.verify() will throw exception
saying test source file cannot be located. See [here] (https://github.com/approvals/ApprovalTests.Java/issues/1) for details.

Not sure if this is a bug in [addjars-maven-plugin] (https://code.google.com/p/addjars-maven-plugin/) or not.

