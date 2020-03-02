mvn clean install sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=8f7282f7561e4ee8fa666bad910a37c897880da0 \
  -Dsonar.sources=/src/main/java \
  -Dsonar.tests=/src/test/java \
  -Dmaven.test.failure.ignore=true