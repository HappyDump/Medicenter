pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
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
        bat 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
  }
}