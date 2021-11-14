1. Чтобы получить токен для Rest запросов нужно запросить keycloak

POST

http://localhost:8090/auth/realms/demo-roma/protocol/openid-connect/token

c body  типа x-www-form-urlencoded

со следующими параметрами

client_id : demo-app
grant_type: password
username: test
password: test


локальный старт проекта messages-crud

1. docker-compose up (Стартует базу)
2. Можно запускать приложение gradle bootRun