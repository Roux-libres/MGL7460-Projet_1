pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                withAnt(installation: 'ant') {
                    if (isUnix()) {
                      sh "ant ci"
                    } else {
                      bat "ant ci"
                    }
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}