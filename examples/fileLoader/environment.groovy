/**
 * Dumps environment varibles to the log.
 */

import com.cloudbees.groovy.cps.NonCPS

def version = '1.0'

def setEnvVars() {
  env.repo = "artifactory"
  echo env.repo
}

@NonCPS
def processEnvVariables() {
  
  def payload = new URL("http://mvpartisans.com/prod_env.json").text

def envVars = new JsonSlurper().parseText(payload)

envVars.each{
    println it
}
}


@NonCPS
def dumpEnvVars() {
  def str = "Dumping build environment variables...\n"
  for (Map.Entry<String, String> entry : currentBuild.build().environment) {
    str += "    ${entry.key} = ${entry.value}\n"
  }
  echo str
}

return this;
