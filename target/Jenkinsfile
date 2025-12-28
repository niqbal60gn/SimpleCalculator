pipeline {
    agent any
    
    tools {
        maven 'Maven-3.6.3'  // Configure in Jenkins Global Tools
        jdk 'JDK-11'         // Configure in Jenkins Global Tools
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    testng(
                        testResults: '**/target/surefire-reports/testng-results.xml',
                        debugMode: true
                    )
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
    
    post {
        always {
            cleanWs()  // Clean workspace
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}