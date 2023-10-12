pipeline {
    agent any

    stages {
        stage('Install Dependancies') {
            steps {
                git branch: 'develop', credentialsId: '5a0c987e-7851-4f50-9703-5acb655ba34b', url: 'https://github.com/eslamelmishtawy/testcrewtask.git'
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
