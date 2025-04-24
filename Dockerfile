#FROM openjdk:17-jdk-slim
#
#WORKDIR /app
#
#COPY target/OrderManagementSystem4-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 9060
#
#ENTRYPOINT ["java", "-jar", "app.jar"]
#
# Используем базовый образ с Java 17

FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл приложения
COPY target/OrderManagementSystem4-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт приложения (9060) и порт для отладки (5005)
EXPOSE 9060
EXPOSE 5005

# Запускаем приложение с параметрами отладки
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]