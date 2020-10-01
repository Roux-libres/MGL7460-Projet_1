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
            junit testResults: '**/target/surefire-reports/TEST-*.xml'
            recordIssues enabledForFailure: true, tool: checkStyle(pattern: './build/logs/checkstyle.xml')
            recordIssues enabledForFailure: true, tool: spotBugs(pattern: './build/logs/spotbugs.xml')
            recordIssues enabledForFailure: true, tool: pmdParser(pattern: './build/logs/pmd.xml')
        }
    }
}