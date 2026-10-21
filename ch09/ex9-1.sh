git clone https://github.com/kittylyst/fighting-animals.git .
git checkout main

mvn clean package
docker build -t mammal_demo -f src/main/docker/mammal/Dockerfile .
docker run -p 8081:8081 -t mammal_demo
curl localhost:8081/getAnimal
{"timestamp":"2024-04-29T17:18:00.170+00:00","status":500,
"error":"Internal Server Error","path":"/getAnimal"}