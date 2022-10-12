# ClaireData
 ClaireBot REST API
 
# Setup a Working Copy
Currently, unlike ClaireBot this project is built with credentials baked in. Due to this, using the pre-built version is
a massive security flaw. You should absolutely change the authentication details before using this.

1) Clone the repo
2) Edit the password details in src/main/resources/application.yml
3) Run "./gradlew build" if on Linux or "gradlew build" if on Winblows.
4) Collect the biggest jar file from build/libs/.