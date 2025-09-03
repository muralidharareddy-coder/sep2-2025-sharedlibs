def call(){
   // Use SSH key credentials stored in Jenkins
   sshagent (credentials: ['tomcat-ssh-key']) {
                    sh """
                        scp -o StrictHostKeyChecking=no ${WAR_FILE} ${TOMCAT_USER}@${TOMCAT_HOST}:${TOMCAT_DIR}/
                        ssh -o StrictHostKeyChecking=no ${TOMCAT_USER}@${TOMCAT_HOST} 'sudo systemctl restart tomcat'
                    """
}
