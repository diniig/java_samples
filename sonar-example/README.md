# run sonar
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
# get token
1. open http://localhost:9000/account   (admin/admin)
2. Security tab
3. select token type and generate
4. remember it
# add plugin
```
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.sonarsource.scanner.maven</groupId>
                <artifactId>sonar-maven-plugin</artifactId>
                <version>3.4.0.905</version>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```
# run verify
```
mvn clean verify sonar:sonar -Dsonar.projectKey=com.diniig.samples.sonar-example \
                             -Dsonar.projectName='sonar-example-project' \
                             -Dsonar.host.url=http://localhost:9000 \
                             -Dsonar.token=sqa_703e6511e30b5a5e6855246f08f2127c0b949c0e
```
> [INFO] ------------------------------------------------------------------------ \
> [INFO] BUILD SUCCESS \
> [INFO] ------------------------------------------------------------------------
# check result in sonar
http://localhost:9000