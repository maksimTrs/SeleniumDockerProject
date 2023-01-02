/*
pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3.6.1-jdk-8-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("roronoazorroippo/selenium-docker")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('https://registry.hub.docker.com', '19128d91-a321-479e-80ba-1e04f6d4129a') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
} */


pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t='roronoazorroippo/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: '19128d91-a321-479e-80ba-1e04f6d4129a', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push roronoazorroippo/selenium-docker:latest"
			    }
            }
        }
    }
}