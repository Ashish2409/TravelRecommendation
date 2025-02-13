pipeline {
    agent {label 'linux'}

    tools {
        jdk 'JDK-17'
        maven 'Maven 3.9.8'
    }

    stages {
        // API Gateway module
        stage('Build API gateway Module') {
            steps {
                dir('api-gateway') {
                    echo 'Building API gateway Module..'
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test API gateway Module') {
            steps {
                dir('api-gateway') {
                    echo 'Testing API gateway Module..'
                    sh 'mvn test'
                }
            }
        }

        // TR module
        stage('Build TR Module') {
            steps {
                dir('recommendation-service') {
                    echo 'Building TM Module..'
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test TR Module') {
            steps {
                dir('recommendation-service') {
                    echo 'Testing TR Module..'
                    sh 'mvn test'
                }
            }
        }

        // UM module
        stage('Build User Module') {
            steps {
                dir('user-service') {
                    echo 'Building User Module..'
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test User Module') {
            steps {
                dir('user-service') {
                    echo 'Testing UM Module..'
                    sh 'mvn test'
                }
            }
        }

        // Sonar Analysis
        stage('SonarQube analysis') {
            environment {
                scannerHome = tool 'SonarQube Scanner'
            }
            steps {
                withSonarQubeEnv('SonarHyd') {
                    sh '$scannerHome/bin/sonar-scanner -Dproject.settings=sonar-project.properties'
                }
            }
        }
    }
}
