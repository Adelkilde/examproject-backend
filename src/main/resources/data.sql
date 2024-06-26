use athletics_db;


INSERT INTO participant (id, name, gender, date_of_birth, club ) VALUES (1, 'Big Jim', 'MALE', '1983-04-12', 'Denver Dolphins');
INSERT INTO participant (id, name, gender, date_of_birth, club ) VALUES (2, 'Kassandra', 'FEMALE', '1995-03-17', 'Montana Mustangs');
INSERT INTO participant (id, name, gender, date_of_birth, club ) VALUES (3, 'Tyrael', 'MALE', '1999-12-25', 'Heavenly Hosts');

INSERT INTO discipline (id, name, result_type) VALUES (1, 'Running', 'Time');
INSERT INTO discipline (id, name,result_type) VALUES (2, 'Decathlon', 'Points');
INSERT INTO discipline (id, name,result_type) VALUES (3, 'Throwing', 'Distance');

INSERT INTO result (id,  result_value, date, participant_id, discipline_id) VALUES (1, '01:23:45', '2024-06-01', 1, 1);
INSERT INTO result (id,  result_value, date, participant_id, discipline_id) VALUES (2, '321', '2024-06-02', 2, 2);
INSERT INTO result (id,  result_value, date, participant_id, discipline_id) VALUES (3, '123', '2024-06-03', 3, 3);

INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (1, 1);
INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (2, 2);
INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (3, 3);