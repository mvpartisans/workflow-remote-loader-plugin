/**
 * Dumps environment varibles to the log.
 */

import com.cloudbees.groovy.cps.NonCPS

def version = '1.0'

@NonCPS
def setEnvVars() {
  env.repo = "artifactory"
  echo env.repo
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
