ABOUT THIS PROJECT

Built With
  1. Java 8
  2. Springboot 1.5
  3. maven 3.6
   
Prerequisites 
  1. Docker
      
Installation
  1. Clone the repo
     $ git clone https://github.com
     
  2. Run maven
     $ mvn clean install
     $ mvn spring-boot:run
   
Accessing the project
  1. url:
       http://localhost:8080
  2. swagger-ui:
       http://localhost:8080/swagger-ui/
       
Service Monitoring
  1. Prometheus
     Prometheus was integrated into the service for monitoring the service.
     To start the Prometheus server run the command below (make sure docker has been installed) in the terminal (provide the actual path to prometheus.yml ) 
     
	docker run -d \
	--name=prometheus \
	-p 9090:9090 \
	-v /path/to/prometheus.yml:/path/to/prometheus.yml \
	prom/prometheus \
	--config.file=/etc/prometheus/prometheus.yml
	
  2. Then go to http://localhost:9090 to access the monitorig user interface
	
	

  
