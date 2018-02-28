call mvn clean

call mvn compile
call mvn package

del "C:\software\jboss-eap-6.3.0\jboss-eap-6.3\standalone\deployments\JSFFamigliaProdotti-0.1WAR-1.0-SNAPSHOT*"

move "C:\software\progetti-KEPLERx86_64\JSFFamigliaProdotti-0.1\JSFFamigliaProdotti-0.1WAR\target\JSFFamigliaProdotti-0.1WAR-1.0-SNAPSHOT.war" "C:\software\jboss-eap-6.3.0\jboss-eap-6.3\standalone\deployments\"
