# API FOR WORKING WITH THE VSTU SCHEDULE

Приложение API для расписания мероприятий Университета сделанное на Spring Boot, Mysql, JPA and Hibernate with docker.

## Requirements

1. Java - 17

2. Maven - 3.x.x

3. Mysql

## Шаги по настройке

**1. Клонируйте приложение**

```bash
git clone git@github.com:pavelgulyev/microservices-events.git
```

**2. Создайте и запустите приложение с помощью Maven**

```bash
mvn clean install
```

**3. Создайте и запустите приложение с помощью Docker**

```bash
docker compose up
```

Приложение начнет работать в <http://localhost:8080>.

## Приложение определяет следующие API.


[//]: # (CRUD APIs для Факультетов)
API для Факультетов

    GET    /webshedule/faculties  - возвращает  список Факультетов

[//]: # (    POST   /webshedule/faculty)

[//]: # (    GET    /webshedule/faculty/{id})

[//]: # (    PUT    /webshedule/faculty/{id})

[//]: # (    DELETE /webshedule/faculty/{id})

[//]: # (CRUD APIs для Категорий Событий)
API для Категорий Событий

    GET    /webshedule/categoryies

[//]: # (    POST   /webshedule/category)

[//]: # (    GET    /webshedule/category/{id})

[//]: # (    PUT    /webshedule/category/{id})

[//]: # (    DELETE /webshedule/category/{id})

[//]: # (CRUD APIs для Тип События)
API для Тип События

    GET    /webshedule/typeevents

[//]: # (    POST   /webshedule/typeevent)

[//]: # (    GET    /webshedule/typeevent/{id})

[//]: # (    PUT    /webshedule/typeevent/{id})

[//]: # (    DELETE /webshedule/typeevent/{id})

[//]: # (CRUD APIs для Роль Пользователя)

[//]: # ()
[//]: # (    GET    /webshedule/roles)

[//]: # (    POST   /webshedule/role)

[//]: # (    GET    /webshedule/role/{id})

[//]: # (    PUT    /webshedule/role/{id})

[//]: # (    DELETE /webshedule/role/{id})

[//]: # (CRUD APIs для Групп университета)
API для Групп университета

    GET    /webshedule/groups  - возвращает  список Групп университета
    GET    /webshedule/groups/faculty/{id} - возвращает  список Групп университета

[//]: # (    POST   /webshedule/group)

[//]: # (    GET    /webshedule/group/{id})

[//]: # (    PUT    /webshedule/group/{id})

[//]: # (    DELETE /webshedule/group/{id})

[//]: # (CRUD APIs для Классов События)
API для Классов События

    GET    /webshedule/classesevent - возвращает список

[//]: # (    POST   /webshedule/classevent)

[//]: # (    GET    /webshedule/classevent/{id})

[//]: # (    PUT    /webshedule/classevent/{id})

[//]: # (    DELETE /webshedule/classevent/{id})

API для Пользователей

    GET    /webshedule/users - возвращает  список Пользователей

[//]: # (    GET    /webshedule/users/role/{id})

[//]: # (    POST   /webshedule/user)

[//]: # (    GET    /webshedule/user/{id})

[//]: # (    PUT    /webshedule/user/{id})

[//]: # (    DELETE /webshedule/user/{id})
CRUD API для Мероприятий

    GET    /webshedule/events - возвращает список Мероприятий
    POST   /webshedule/event
    GET    /webshedule/event/{id}
    PUT    /webshedule/event/{id}
    DELETE /webshedule/event/{id}
    GET    /webshedule/events/organizer - возвращает список Мероприятий определенного организатора