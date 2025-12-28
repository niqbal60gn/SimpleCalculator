pipeline {
    agent any
    
    stages {
        stage('Test') {
            steps {
                bat 'echo "Hello from Windows Jenkins!"'
                bat 'java --version'
                bat 'mvn --version'
            }
        }
    }
}
