node {
   git url: 'https://github.com/HappyDump/Medicenter'
   sh 'git clean -fdx; sleep 4;'
   
   def mvnHome = tool 'mvn'

   stage 'build'
   
   sh "${mvnHome}/bin/mvn versions:set -DnewVersion=${env.BUILD_NUMBER}"
   sh "${mvnHome}/bin/mvn package"

   stage 'test'
   parallel 'test': {
     sh "${mvnHome}/bin/mvn test; sleep 2;"
   }, 'verify': {
     sh "${mvnHome}/bin/mvn verify; sleep 3"
   }

   stage 'archive'
   archive 'target/*.jar'
}