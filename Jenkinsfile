pipeline {
  agent {
    docker {
      image 'maven:3.5.0-JDK8'
      args '-v /Users/mathieu/.m2/root:/.m2'
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
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
  }
}