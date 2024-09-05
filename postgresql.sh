podman pod create mypod
podman run -d --pod mypod \
    --name postgres \
    -e POSTGRES_DB=quarkus -e POSTGRES_USER=quarkus -e POSTGRES_PASSWORD=quarkus \
    -v pg-data:/var/lib/postgresql/data:Z \
    --replace docker.io/library/postgres:14
podman run -d --pod mypod --name quarkus-app \
    -e QUARKUS_DATABASE_USERNAME=quarkus -e QUARKUS_DATABASE_PASSWORD=quarkus -e quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/quarkus?loggerLevel=OFF \
    --replace quay.io/kevindubois/quarkus-observability:latest