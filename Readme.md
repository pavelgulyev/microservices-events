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


CRUD APIs для Факультетов

    GET    /webshedule/faculties
    POST   /webshedule/faculty
    GET    /webshedule/faculty/{id}
    PUT    /webshedule/faculty/{id}
    DELETE /webshedule/faculty/{id}

CRUD APIs для Категории События

    GET    /webshedule/categoryies
    POST   /webshedule/category
    GET    /webshedule/category/{id}
    PUT    /webshedule/category/{id}
    DELETE /webshedule/category/{id}

CRUD APIs для Тип События

    GET    /webshedule/typeevents
    POST   /webshedule/typeevent
    GET    /webshedule/typeevent/{id}
    PUT    /webshedule/typeevent/{id}
    DELETE /webshedule/typeevent/{id}

CRUD APIs для Роль Пользователя

    GET    /webshedule/roles
    POST   /webshedule/role
    GET    /webshedule/role/{id}
    PUT    /webshedule/role/{id}
    DELETE /webshedule/role/{id}

CRUD APIs для Группа университета

    GET    /webshedule/groups
    GET    /webshedule/groups/faculty/{id}
    POST   /webshedule/group
    GET    /webshedule/group/{id}
    PUT    /webshedule/group/{id}
    DELETE /webshedule/group/{id}

CRUD APIs для Класс События

    GET    /webshedule/classesevent
    POST   /webshedule/classevent
    GET    /webshedule/classevent/{id}
    PUT    /webshedule/classevent/{id}
    DELETE /webshedule/classevent/{id}

CRUD APIs для Пользователя

    GET    /webshedule/users
    GET    /webshedule/users/role/{id}
    POST   /webshedule/user
    GET    /webshedule/user/{id}
    PUT    /webshedule/user/{id}
    DELETE /webshedule/user/{id}
CRUD APIs для Мероприятий

    GET    /webshedule/faculties
    POST   /webshedule/faculty
    GET    /webshedule/faculty/{id}
    PUT    /webshedule/faculty/{id}
    DELETE /webshedule/faculty/{id}