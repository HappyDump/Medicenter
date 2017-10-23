pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        build(job: 'sh \'mvn -B -DskipTests clean package\'', wait: true)
      }
    }
  }
}