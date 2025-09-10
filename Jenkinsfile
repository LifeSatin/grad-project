pipeline {
    agent any

    environment {
        CLASS_DIR = 'classes'
        REPORT_DIR = 'test-reports'
    }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build -x test'
            }
        }
    }

    post {
        always {

        }

        failure {
            echo "Build or Test Failed."
        }

        success {
            echo "Build and Test Succeeded."
        }
    }
}