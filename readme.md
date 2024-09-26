

## docker
- creer le jar dans target : 
	$ mvn clean package
- creer l'image :
	$ docker build --tag=agents-server:latest .
- demarrer le container
	$ docker run agents-server
---
## versions : 
	java 19.0.2
	maven 3.9.7

