INSERT INTO Messages (stage, active, message) values ('boss_notify', true, 'У одной из ваших команд были запланированы %s планово-профилактические работы "%s" срок которых уже истек. <br> Заведите CRQ на проведение этих работ и укажите его номер в системе VotingVoter или продлите срок исполнения'); --1
INSERT INTO Messages (stage, active, message) values ('planned', true, 'У Вас запланированы %s планово-профилактические работы "%s". <br> Заведите CRQ на проведение этих работ и укажите его номер в системе VotingVoter'); --2
INSERT INTO Messages (stage, active, message) values ('planned_out', true, 'У Вас были запланированы %s планово-профилактические работы "%s" срок которых уже истек. <br> Заведите CRQ на проведение этих работ и укажите его номер в системе VotingVoter или продлите срок исполнения'); --3
INSERT INTO Messages (stage, active, message) values ('assigned', true, 'У Вас будут %s планово-профилактические работы "%s". <br> После выполнения работы, закройте CRQ и отметьте её в системе VotingVoter что она выполнена.'); --4
INSERT INTO Messages (stage, active, message) values ('assigned_out', true, 'У Вас %s были планово-профилактические работы "%s". <br> Напоминаем о том, что необходимо закрыть CRQ и отметьте её в системе VotingVoter как выполненная.'); --5
INSERT INTO Messages (stage, active, message) values ('error', true, 'В работе %s %s обнаружена ошибка'); --6
INSERT INTO Messages (stage, active, message) values ('completed', true, 'Планово-профилактические работы %s %s были завершены.'); -- 7
INSERT INTO Messages (stage, active, message) values ('sub_info', true, 'Уведомление по работе %s'); --8
INSERT INTO Messages (stage, active, message) values ('sub_error', true, 'Ошибка по работе %s'); --9
INSERT INTO Messages (stage, active, message) values ('task', true, 'У Вас будут %s таск "%s". <br> После выполнения таска отметьте его в системе VotingVoter что он выполнен.'); --10
INSERT INTO Messages (stage, active, message) values ('task_out', true, 'У Вас %s был таск "%s". <br> Напоминаем о том, что необходимо его выполнить и отметьте его в системе VotingVoter как выполненный.'); --11
INSERT INTO Messages (stage, active, message) values ('task_error', true, 'В таске %s %s обнаружена ошибка, был установлен статус Assigned и не был установлен исполнитель. <br> Назначьте исполнителя'); --12
INSERT INTO Messages (stage, active, message) values ('test', true, '%s ||| %s'); --13
INSERT INTO Messages (stage, active, message) values ('team_lead_notify', true, 'Заведите работы на следующий год'); --14
INSERT INTO Messages (stage, active, message) values ('new_employee', true, 'Вы были успешно добавлены как новый сотрудник в систему по контролю за выполнением работ VotingVoter.'); --15
INSERT INTO Messages (stage, active, message) values ('delete_employee', true, 'Вы были удалены из системы VotingVoter и больше не имеете доступа к системе'); --16


INSERT INTO Subject (stage, active, subject) VALUES ( 'new_employee', true, 'Новый сотрудник'); --1
INSERT INTO Subject (stage, active, subject) VALUES ( 'subject_ppw', true, 'Уведомление по работе %s'); --2
INSERT INTO Subject (stage, active, subject) VALUES ( 'subject_ppw_error', true, 'Ошибка по работе %s'); --3
INSERT INTO Subject (stage, active, subject) VALUES ( 'subject_task', true, 'Уведомление по таску %s'); --4
INSERT INTO Subject (stage, active, subject) VALUES ( 'subject_task_error', true, 'Ошибка по таску %s'); --5
INSERT INTO Subject (stage, active, subject) VALUES ( 'team_lead_notify', true, 'Заведите работы на следующий год'); --6
INSERT INTO Subject (stage, active, subject) VALUES ( 'new_employee', true, 'Новый сотрудник'); --7
INSERT INTO Subject (stage, active, subject) VALUES ( 'delete_employee', true, 'Исключение из системы'); --8
INSERT INTO Subject (stage, active, subject) VALUES ( '', true, ''); --9

INSERT INTO TIMETYPE (NAME, VALUE_DAY) VALUES ( 'day', 1 ); --1
INSERT INTO TIMETYPE (NAME, VALUE_DAY) VALUES ( 'week', 7 ); --2
INSERT INTO TIMETYPE (NAME, VALUE_DAY) VALUES ( 'month', 30 ); --3

INSERT INTO revinfo (rev, revtstmp) values (1, 1687309200000);

INSERT INTO status (status_name) values ('Planned'); --1
INSERT INTO status (status_name) values ('Assigned'); --2
INSERT INTO status (status_name) values ('Completed'); --3
INSERT INTO status (status_name) values ('Canceled'); --4
INSERT INTO status_aud (id_status, rev, revtype, status_name) values (1, 1, 0, 'Planned');
INSERT INTO status_aud (id_status, rev, revtype, status_name) values (2, 1, 0, 'Assigned');
INSERT INTO status_aud (id_status, rev, revtype, status_name) values (3, 1, 0, 'Completed');
INSERT INTO status_aud (id_status, rev, revtype, status_name) values (4, 1, 0, 'Canceled');

INSERT INTO ReminderPPW (message, message_out_of_date, message_error, id_status, id_time_type, start_time, on_start_remind, stop_time, on_stop_remind)
VALUES ( 2, 3, 6, 1, 1, -5, '', 1, '');
INSERT INTO ReminderPPW (message, message_out_of_date, message_error, id_status, id_time_type, start_time, on_start_remind, stop_time, on_stop_remind)
VALUES ( 4, 5, 6, 2, 1, -1, '', 1, '');

INSERT INTO REMINDER_TASK (ON_START_REMIND, ON_STOP_REMIND, START_TIME, STOP_TIME, MESSAGE, MESSAGE_ERROR, MESSAGE_OUT_OF_DATE, ID_STATUS, ID_TIME_TYPE)
VALUES ( '', '', -1, 1, 10, 12, 11, 2, 1);

INSERT INTO NOTIFICATION (EVENT, ID_MESSAGE, ID_SUBJECT) VALUES ( 'completed', 7, 2);
INSERT INTO NOTIFICATION (EVENT, ID_MESSAGE, ID_SUBJECT) VALUES ( 'team_lead_notify', 14, 6);
INSERT INTO NOTIFICATION (EVENT, ID_MESSAGE, ID_SUBJECT) VALUES ( 'new_employee', 15, 7);
INSERT INTO NOTIFICATION (EVENT, ID_MESSAGE, ID_SUBJECT) VALUES ( 'delete_employee', 16, 8);







INSERT INTO privileges (privileges_name) values ('admin'); --1
INSERT INTO privileges (privileges_name) values ('employee'); --2
INSERT INTO privileges (privileges_name) values ('team_lead'); --3
INSERT INTO privileges (privileges_name) values ('boss'); --4
INSERT INTO privileges (privileges_name) values ('guest'); --5
INSERT INTO privileges_aud (ID_PRIVILEGES, rev, revtype, privileges_name) values (1, 1, 0, 'admin');
INSERT INTO privileges_aud (ID_PRIVILEGES, rev, revtype, privileges_name) values (2, 1, 0, 'employee');
INSERT INTO privileges_aud (ID_PRIVILEGES, rev, revtype, privileges_name) values (3, 1, 0, 'team_lead');
INSERT INTO privileges_aud (ID_PRIVILEGES, rev, revtype, privileges_name) values (4, 1, 0, 'boss');
INSERT INTO privileges_aud (ID_PRIVILEGES, rev, revtype, privileges_name) values (5, 1, 0, 'guest');

INSERT INTO city (name) values ('Almaty'); --1
INSERT INTO city (name) values ('Astana'); --2
INSERT INTO city_aud (id_city, rev, revtype, name) values (1, 1, 0, 'Almaty');
INSERT INTO city_aud (id_city, rev, revtype, name) values (2, 1, 0, 'Astana');

INSERT INTO department (name) values ('CS Core');
INSERT INTO department_aud (id_dep, rev, revtype, name) values (1, 1, 0, 'CS Core');

INSERT INTO team (name_team, city, department, NETYPE_LIST) values ('Admins', 1, 1, 'Example of NEtypes list, need to fill');
INSERT INTO team (name_team, city, department, NETYPE_LIST) values ('SDM', 1, 1, 'Example of NEtypes list, need to fill');
INSERT INTO team (name_team, city, department, NETYPE_LIST) values ('NSS', 1, 1, 'Example of NEtypes list, need to fill');
INSERT INTO team (name_team, city, department, NETYPE_LIST) values ('FIX', 1, 1, 'Example of NEtypes list, need to fill');
-- INSERT INTO team_aud (id_team, rev, revtype, name_team, city, department) values (1, 1, 0, 'Admins', 1, 1);
-- INSERT INTO team_aud (id_team, rev, revtype, name_team, city, department) values (2, 1, 0, 'SDM', 1, 1);
-- INSERT INTO team_aud (id_team, rev, revtype, name_team, city, department) values (3, 1, 0, 'NSS', 1, 1);
-- INSERT INTO team_aud (id_team, rev, revtype, name_team, city, department) values (4, 1, 0, 'FIX', 1, 1);
INSERT INTO team_aud (id_team, rev, revtype, name_team) values (1, 1, 0, 'Admins');
INSERT INTO team_aud (id_team, rev, revtype, name_team) values (2, 1, 0, 'SDM');
INSERT INTO team_aud (id_team, rev, revtype, name_team) values (3, 1, 0, 'NSS');
INSERT INTO team_aud (id_team, rev, revtype, name_team) values (4, 1, 0, 'FIX');

INSERT INTO employee (name_employee, email, id_team, id_privileges) values ('Admin Vsevolod', 'vbeklemeshev@vshcorp.kz', 1, 1);
-- INSERT INTO employee (name_employee, email, id_team, id_privileges) values ('Admin Viktor', 'vtokarskiy@vshcorp.kz', 1, 1);
INSERT INTO employee_aud (id_employee, rev, revtype, name_employee, email, id_team, id_privileges) values (1, 1, 0, 'Admin Vsevolod', 'vbeklemeshev@vshcorp.kz', 1, 1);
-- INSERT INTO employee_aud (id_employee, rev, revtype, name_employee, email, id_team, id_privileges) values (2, 1, 0, 'Admin Viktor', 'vtokarskiy@vshcorp.kz', 1, 1);

INSERT INTO netype (name, comment) values ('JavaServer', 'Spring Boot Server on Java');
INSERT INTO netype (name, comment) values ('MSC', 'Mobile Station Controller');
INSERT INTO netype_aud (id_netype, rev, revtype, name, comment) values (1, 1, 0, 'JavaServer', 'Spring Boot Server on Java');
INSERT INTO netype_aud (id_netype, rev, revtype, name, comment) values (2, 1, 0, 'MSC', 'Mobile Station Controller');

INSERT INTO ne (city, nename, id_netype) values (1, 'al-str007', 1);
INSERT INTO ne (city, nename, id_netype) values (2, 'al-str008', 1);
INSERT INTO ne (city, nename, id_netype) values (1, 'MSX07', 2);
INSERT INTO ne (city, nename, id_netype) values (2, 'MSX08', 2);
-- INSERT INTO ne_aud (id_ne, rev, revtype, city, nename, id_netype) values (1, 1, 0, 1, 'al-str007', 1);
-- INSERT INTO ne_aud (id_ne, rev, revtype, city, nename, id_netype) values (2, 1, 0, 2, 'al-str008', 1);
-- INSERT INTO ne_aud (id_ne, rev, revtype, city, nename, id_netype) values (3, 1, 0, 1, 'MSX07', 2);
-- INSERT INTO ne_aud (id_ne, rev, revtype, city, nename, id_netype) values (4, 1, 0, 2, 'MSX08', 2);
INSERT INTO ne_aud (id_ne, rev, revtype,  nename) values (1, 1, 0,  'al-str007');
INSERT INTO ne_aud (id_ne, rev, revtype,  nename) values (2, 1, 0,  'al-str008');
INSERT INTO ne_aud (id_ne, rev, revtype,  nename) values (3, 1, 0,  'MSX07');
INSERT INTO ne_aud (id_ne, rev, revtype,  nename) values (4, 1, 0,  'MSX08');

INSERT INTO teamnetypes (id_team, id_netype, comm)values ( 1, 1, 'All' );
INSERT INTO teamnetypes_aud (ID_TEAMNETYPE, rev, revtype, id_team, id_netype, comm)values (1, 1, 0, 1, 1, 'All' );

INSERT INTO ppw (name_ppw, planeddate, workdate, crq, id_team, id_status, EXECUTORS_LIST, NE_LIST)
values ('Deploying Java server', '2023-07-07', '2023-07-07', 'LEAN-14385', 1, 1, 'Example of executors list', 'Example of NE list');
-- INSERT INTO ppw_aud (ppw_id, rev, revtype, name_ppw, planeddate, workdate, crq, id_team, id_status) values (1, 1, 0, 'Deploying Java server', '2023-06-02', '2023-06-02', 'LEAN-14385', 1, 1);
INSERT INTO ppw_aud (ppw_id, rev, revtype, name_ppw, planeddate, workdate, crq, id_team, id_status, created_by, created_date, 	OPERATION  ) values (1, 1, 0, 'Deploying Java server', '2023-06-02', '2023-06-02', 'LEAN-14385', 1, 1, 'Vsevolod', '2023-06-20', 'CREATE');

INSERT INTO neppw (ppw_id, id_ne, comm)values ( 1, 1, '' );
-- INSERT INTO neppw_aud (id, rev, revtype, id_ppw, id_ne, comm)values (1, 1, 0,  1, 1, '' );
INSERT INTO neppw_aud (id, rev, revtype, id_ne, comm)values (1, 1, 0, 1, '' );


Insert into EXECUTORPPW (id_ppw, id_employee, comm) values ( 1, 1, 'Admin' );
-- Insert into EXCUTORPPW (id_ppw, id_employee, comm) values ( 1, 2, 'Admin' );
Insert into EXECUTORPPW_aud (id, rev, revtype, id_employee, comm) values (1, 1, 0, 1, 'Admin' );
-- Insert into EXCUTORPPW_aud (id, rev, revtype, id_employee, comm) values (2, 1, 0, 2, 'Admin' );








