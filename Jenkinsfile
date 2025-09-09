pipeline {
    agent any

    environment {
        CLASS_DIR = 'classes'
        REPORT_DIR = 'test-reports'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Prepare') {
            steps {
                sh '''
                    mkdir -p ${CLASS_DIR}
                    mkdir -p ${REPORT_DIR}
                    mkdir -p lib
                '''
            }
        }

        stage('Build') {
            steps {
                sh '''
                    echo "Compiling..."
                    cd Test2
                '''
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