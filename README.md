# java-server
REST API Server in Java to be used for Docker Testing

This application utilzies Github Actions, Docker and DigitialOcean to automatically deploy a Java Server application into a Docker container on a Digital Ocean server.

Steps:
1. When source code is pushed to master, Github Actions kicks off a Maven package command to trigger a JAR file to be created. 
2. Upon successful testing and creation of JAR, Github Actions utilizes the action appleboy/scp-action@master, to copy created JAR and Dockerfile to DigitalOcean server via SSH with private key.
3. Upon completion of copy, 
