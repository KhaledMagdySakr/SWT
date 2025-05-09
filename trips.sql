CREATE TABLE Train (
  train_id INT PRIMARY KEY,
  class_ VARCHAR(10)
);

CREATE TABLE Cars (
  car_num INT PRIMARY KEY,
  train_id INT,
  FOREIGN KEY (train_id) REFERENCES Train(train_id)
);

CREATE TABLE Seats (
  seat_num INT,
  car_num INT,
  status VARCHAR(10),
  PRIMARY KEY(seat_num, car_num),
  FOREIGN KEY (car_num) REFERENCES Cars(car_num)
);

CREATE TABLE Passenger (
  email VARCHAR(30) PRIMARY KEY,
  balance DECIMAL(10,2),
  password_ VARCHAR(20)
);

CREATE TABLE Trip (
  trip_id INT PRIMARY KEY,
  dest_station VARCHAR(20),
  source_station VARCHAR(20),
  departure_time DATETIME,
  arrival_time DATETIME,
  cost_ DECIMAL(10,2),
  Date_ DATETIME DEFAULT CURRENT_TIMESTAMP,
  train_id INT,
  FOREIGN KEY (train_id) REFERENCES Train(train_id)
);


CREATE TABLE Booking (
  email VARCHAR(30),
  trip_id INT,
  payment_status VARCHAR(10),
  num_of_tickets INT,
  PRIMARY KEY(email, trip_id),
  FOREIGN KEY (email) REFERENCES Passenger(email),
  FOREIGN KEY (trip_id) REFERENCES Trip(trip_id)
);




INSERT INTO Train (train_id, class_) VALUES (1, 'First');
INSERT INTO Train (train_id, class_) VALUES (2, 'Second');


INSERT INTO Cars (car_num, train_id) VALUES (101, 1);
INSERT INTO Cars (car_num, train_id) VALUES (102, 2);


INSERT INTO Seats (seat_num, car_num, status) VALUES (1, 101, 'available');
INSERT INTO Seats (seat_num, car_num, status) VALUES (2, 101, 'booked');


INSERT INTO Passenger (email, balance, password_) VALUES ('test1@example.com', 200.00, 'pass123');
INSERT INTO Passenger (email, balance, password_) VALUES ('test2@example.com', 500.00, 'pass456');


INSERT INTO Trip (
  trip_id, dest_station, source_station, departure_time, arrival_time, cost_, train_id
) VALUES (
  1001, 'Cairo', 'Alex', '2025-06-01 08:00:00', '2025-06-01 11:00:00', 100.00, 1
);



SELECT * FROM Trip WHERE train_id = 1;


SELECT * FROM Seats WHERE car_num = 101;


SELECT * FROM Booking WHERE email = 'test1@example.com';


