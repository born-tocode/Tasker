create table users
(
    username   varchar_ignorecase(50)  not null primary key,
    password   varchar_ignorecase(500) not null,
    email      varchar_ignorecase(50)  not null,
    registered timestamp               not null,
    enabled    boolean                 not null
);

create table authorities
(
    username  varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities (username, authority);

create table tasks
(
    id       integer      not null unique,
    task     varchar(300) not null,
    fromDate date         not null,
    dueDate  date         not null,
    addTime  timestamp    not null,
);






