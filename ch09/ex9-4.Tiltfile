local_resource(
  'monorepo-java-compile',
  'mvn clean package',
  deps=['src', 'pom.xml'])

docker_build(
  'animals_demo',
  '.',
  dockerfile='./src/main/docker/animal/Dockerfile')

// ... All other docker_build tasks elided

docker_compose("deploy/docker-compose.yml)