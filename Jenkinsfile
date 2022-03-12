@Library('ceiba-jenkins-library') _
pipeline{

    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
        gitLabConnection('GitCeiba')
    }

    environment {
        PROJECT_PATH_BACK = 'microservicio'
    }

    triggers {
        // @yearly, @annually, @monthly, @weekly, @daily, @midnight, and @hourly o definir un intervalo. Ej: H */4 * * 1-5
        pollSCM('@daily') //define un intervalo regular en el que Jenkins debería verificar los cambios de fuente nuevos
    }

    tools {
        jdk 'JDK8_Centos'
    }


	stages
	{
        stage('Checkout') 
		{
            steps 
			{
                echo '------------>Checkout desde Git Microservicio<------------'
                //Esta opcion se usa para el checkout sencillo de un microservicio
                checkout scm

                dir("${PROJECT_PATH_BACK}"){
                    sh 'chmod +x ./gradlew'
                    sh './gradlew clean'
                }
            }
        }


        stage('Compilacion y Test Unitarios'){
            // El "parallel" es si vamos a correr los test del frontend en paralelo con los test de backend, se configura en otro stage dentro de parallel
            parallel {
                stage('Test- Backend'){
                    steps {
                        echo '------------>Test Backend<------------'
						dir("${PROJECT_PATH_BACK}"){
							sh 'chmod +x gradlew'
							sh './gradlew --b ./build.gradle test'
                        }
                    }
                    post{
                        always {
                            junit '**/build/test-results/test/*.xml' //Configuración de los reportes de JUnit
                        }
                    }
                }
            }
        }

		
		stage('Static Code Analysis')
		{
			steps{
        sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:tienda.adn.melvin.martinez', 
        sonarName:'ADN-Tienda-api(melvin.martinez)', 
        sonarPathProperties:'./sonar-project.properties')
				}
		}

        stage('Build') 
		{
			steps {
				echo "------------>Build<------------"
				sh 'chmod +x ./microservicio/gradlew'
				sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
				sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
			}
		}  
	}

    post {
        failure {
            mail(
                to: 'melvin.martinez@ceiba.com.co',
                body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
                subject: "ERROR CI: ${env.JOB_NAME}"
            )
            updateGitlabCommitStatus name: 'IC Jenkins', state: 'failed'
        }
        success {
            updateGitlabCommitStatus name: 'IC Jenkins', state: 'success'
        }
    }
}