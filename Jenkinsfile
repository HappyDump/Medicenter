pipeline {
  agent {
    docker {
      image 'maven:3.3.9-jdk-8'
    }
    
  }
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
        sh 'mvn install'
      }
    }
  }
}