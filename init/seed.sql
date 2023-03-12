create table if not exists intern
(
    id        bigint       not null
    primary key,
    firstname varchar(255) null,
    groupe    varchar(255) null,
    lastname  varchar(255) null
    );

create table if not exists intern_seq
(
    next_val bigint null
);

create table if not exists internship_seq
(
    next_val bigint null
);

create table if not exists tutor
(
    id        bigint       not null
    primary key,
    firstname varchar(255) null,
    lastname  varchar(255) null,
    password  varchar(255) null,
    username  varchar(255) null
    );

create table if not exists internship
(
    id                       bigint       not null
    primary key,
    address                  varchar(255) null,
    communication_grade      float        null,
    company                  varchar(255) null,
    end_date                 datetime(6)  not null,
    is_evaluation_submitted  bit          null,
    is_presentation_done     bit          null,
    is_report_submitted      bit          null,
    is_survey_submitted      bit          null,
    is_visit_done            bit          null,
    is_visit_planned         bit          null,
    is_visit_sheet_completed bit          null,
    specifications           bit          null,
    start_date               datetime(6)  not null,
    supervisor               varchar(255) null,
    technical_grade          float        null,
    intern_id                bigint       not null,
    tutor_id                 bigint       not null,
    constraint FK7inhsj1xkgqeaxwfp0ourmh9k
    foreign key (tutor_id) references tutor (id),
    constraint FKclul064wlxdxh0gg3cse8sm77
    foreign key (intern_id) references intern (id)
    );

create table if not exists tutor_seq
(
    next_val bigint null
);


-- Insert data into gift.intern
INSERT INTO intern (id, firstname, groupe, lastname)
VALUES (1, 'John', 'A', 'Doe'),
       (2, 'Jane', 'B', 'Smith'),
       (3, 'Mike', 'C', 'Johnson'),
       (4, 'Sarah', 'D', 'Williams');

-- Insert test data for table gift.tutor
INSERT INTO tutor (id, firstname, lastname, password, username)
VALUES (1, 'Emily', 'Wilson', '$2y$10$qCD3lEudKeIztC2d9oS0TuoFPAFug7XgTbsJ0ALKVPDw87/5mxCsC', 'test'),
       (2, 'John', 'Doe', '$2y$10$qCD3lEudKeIztC2d9oS0TuoFPAFug7XgTbsJ0ALKVPDw87/5mxCsC', 'johnd'),
       (3, 'Jane', 'Doe', '$2y$10$qCD3lEudKeIztC2d9oS0TuoFPAFug7XgTbsJ0ALKVPDw87/5mxCsC', 'janed');

-- Insert test data for table gift.internship
INSERT INTO internship (id, address, communication_grade, company, end_date, is_evaluation_submitted,
                             is_presentation_done, is_report_submitted, is_survey_submitted, is_visit_done,
                             is_visit_planned, is_visit_sheet_completed, specifications, start_date, supervisor,
                             technical_grade, intern_id, tutor_id)
VALUES (1, '123 Main St.', 9.2, 'Acme Corp', '2023-05-31', 1, 1, 1, 1, 1, 1, 1, 0, '2023-01-01',
        'John Smith', 8.7, 1, 1),
       (2, '456 Elm St.', 8.5, 'XYZ Inc', '2023-06-30', 1, 0, 0, 0, 0, 1, 1, 1, '2023-02-01',
        'Jane Smith', 7.9, 2, 1),
       (3, '789 Oak St.', 7.8, 'ABC Corp', '2023-07-31', 0, 0, 0, 0, 0, 0, 0, 1, '2023-03-01',
        'Bob Johnson', 6.5, 3, 3);

