# Usar a imagem do Maven para construir o projeto Java
FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app

# Copiar o arquivo pom.xml e os fontes
COPY pom.xml .
COPY src ./src

# Empacotar a aplicação
RUN mvn clean package

# Usar a imagem do OpenJDK para executar a aplicação
FROM openjdk:11-jre-slim
WORKDIR /app

# Copiar o artefato do estágio de build
COPY --from=build /app/target/my-application.jar ./my-application.jar

# Executar a aplicação
CMD ["java", "-jar", "my-application.jar"]
