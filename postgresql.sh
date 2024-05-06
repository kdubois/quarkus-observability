podman pod create mypod
podman run -d --pod mypod \
--name postgresql \
-e POSTGRES_DB=quarkus -e POSTGRES_USERNAME=quarkus -e POSTGRES_PASSWORD=quarkus -v pg-data:/var/lib/postgresql/data:Z \
--replace docker.io/library/postgres:14