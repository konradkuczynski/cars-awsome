pipeline {
  agent any
  stages {
    stage('test') {
      steps {
        sh 'echo "Hello World"'
      }
    }
    stage('built') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
}