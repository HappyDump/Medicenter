pipeline {
  agent {
    docker {
      args '-v $HOME/.m2:/root/.m2'
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