#!groovy
/**
 * JenkinsFile pour le build d'une SNAPSHOT de Event_Manager
 *
 */
 
 pipeline {

    agent { label 'maven && java8' }

    environment {
        team_email= 'malembedidier24@gmail.com'
        BRANCH_MASTER= 'master'
    }
    
    /**
     * STAGES FOR DEV CONTINUOUS INTEGRATION PHASE
     */
    stages {
	
	    stage('Tools informations') {
        steps {
			  //On commence par clean le workspace 
				deleteDir()
                sh 'mvn --version'
                sh 'java -version'
                sh 'env | sort'
            }
        }

        stage('Checkout Repository') {
            steps {
                checkout scm
            }
        }


        stage('Clean') {
            steps {
                withMaven(globalMavenSettingsConfig: 'global_maven_settings') {
                    echo 'Clean with Maven'
                    sh "mvn clean"
                }
            }
        }

        stage('Unit tests') {
            steps {
                withMaven(globalMavenSettingsConfig: 'global_maven_settings') {
                    echo 'Unit testing with Maven'
                    sh "mvn test -Dmaven.test.failure.ignore=true"
                }
            }
        }
        


    /**
     * POST RESULT OPERATIONS
     */
    post {
        failure {
            mail bcc: '',
                    cc: '',
                    replyTo: '',
                    mimeType: "text/html",
                    from: env.GIT_AUTHOR_EMAIL,
                    to: env.team_email,
                    subject: 'Batch Event Manager Snapshot: FAIL',
                    body: "Batch Event Manager pipeline SNAPSHOT fail please see: <a href=\"${env.BUILD_URL}\">${env.BUILD_URL}</a> <br /> <br /> <img src=\"http://oi67.tinypic.com/affpg8.jpg\" />"
        }
        fixed {
            mail bcc: '',
                    cc: '',
                    replyTo: '',
                    mimeType: "text/html",
                    from: env.GIT_AUTHOR_EMAIL,
                    to: env.team_email,
                    subject: 'Batch Event Manager Snapshot: Fixed',
                    body: "Batch Event Manager pipeline SNAPSHOT is back to normal! <br /> <br />"
        }
    }
}
}
