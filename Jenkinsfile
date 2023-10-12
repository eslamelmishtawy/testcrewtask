pipeline {
    agent any

    stages {
        stage('Install Dependancies') {
            steps {
                sh "mvn compile"

            }
        }
        stage('Run Tests') {
            steps {
                sh "mvn test"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    archiveArtifacts 'test-output/**'
                }
            }
        }
    }
}
