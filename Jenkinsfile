pipeline {
  agent none
  stages {
    stage('Build') {
      steps {
        sh 'bat \'mvn -B -DskipTests clean package\''
      }
    }
  }
}