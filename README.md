# ok-202105-messages-rg
Личные сообщения, Гапонов Роман Владимирович

1. Direct messages
2. Target audience: stable business  need a messaging system between customers and support
3. Profit model : Connecting messaging-service as  plug-in to site that need it
   selling of different kinds of subscriptions
   
   
Модуль rg-messages-mapping-openapi
-- здесь лежат мапперы из транспортных моделей в модели сервисного слоя
Модуль rg-messages-transport-common
-- директория для объектов контекста и моделей сервисного слоя
Модуль rg-messages-transport-openapi
-- директория со скриптом, который генерит транспортные модели из файла openapi.yaml
Модуль spring-backend-app
-- модуль для сервиса messages-crud, который будет написан на спринге

-- остальные модули будут написаны на фреймворке ktor

