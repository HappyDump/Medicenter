pipeline {
  agent {
    docker {
      image 'maven:3.5.0-jdk-8-alpine'
    }
    
  }
  stages {
    stage('Initialize') {
      steps {
        echo 'Test'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.skip=true install'
      }
    }
  }
}