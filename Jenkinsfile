pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                script {
                    withAnt(installation: 'ant') {
                        if (isUnix()) {
                        sh "ant all-ci"
                        } else {
                        bat "ant all-ci"
                        }
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
    post {
        always {
            recordIssues(
                enabledForFailure: true, aggregatingResults: true, 
                tools: [checkStyle(pattern: './build/logs/checkstyle_report.xml'), spotBugs(pattern: './build/logs/spotbugs_report.xml'), pmdParser(pattern: './build/logs/pmd_report.xml')]
            )
        }
    }
}