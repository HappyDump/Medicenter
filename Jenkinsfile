pipeline {
  agent none
  stages {
    stage('Initialize') {
      steps {
        sh '''echo PATH = ${PATH}
echor M2_HOME = ${M2_HOME}
mvn clean'''
        echo 'Test'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
  }
}