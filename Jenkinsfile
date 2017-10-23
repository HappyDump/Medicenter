pipeline {
  agent {
    docker {
      image 'maven'
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