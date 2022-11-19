DROP DATABASE HotelReservations;
CREATE DATABASE HotelReservations;
USE HotelReservations;

CREATE TABLE Hotel(
	hotel_name varchar(100) not null,
	hotel_id int not null,
    hotel_location varchar(100) not null,
	constraint pk_hotel primary key(hotel_id));

CREATE TABLE Room(
	room_id int not null,
	room_type enum("KING", "QUEEN") not null,
    hotel_id int not null,
    constraint fk_rooms_hotel foreign key (hotel_id) references Hotel(hotel_id),
    constraint pk_room primary key (room_id, hotel_id));


CREATE TABLE Guest(
	guest_fname varchar(100) not null,
	guest_lname varchar(100) not null,
    guest_id int not null,
    guest_password varchar(100) not null,
    guest_email varchar(100) not null,
    /* constraint fk_guest_reservation foreign key (reservation_id) references Reservation(reservation_id),
    constraint fk_guest_room foreign key (room_id) references Room(room_id),
	constraint fk_guest_hotel foreign key (hotel_id) references Hotel(hotel_id),*/
    constraint pk_guest primary key (guest_id));

CREATE TABLE Reservation(
	reservation_id int not null,
	check_in date not null,
	check_out date not null,
    hotel_id int not null,
    room_id int not null,
    guest_id int not null,
    rewards_points int not null,
	constraint fk_reservation_room foreign key (room_id) references Room(room_id),
	constraint fk_reservation_hotel foreign key (hotel_id) references Hotel(hotel_id),
	constraint fk_reservation_guest foreign key (guest_id) references Guest(guest_id),
	constraint pk_reservation primary key(reservation_id));
 
 
INSERT INTO Hotel(hotel_name, hotel_id, hotel_location) VALUES ("The Hilton", 1, "dtla");
INSERT INTO Hotel(hotel_name, hotel_id, hotel_location) VALUES ("The Hilton", 2, "sf");
INSERT INTO Hotel(hotel_name, hotel_id, hotel_location) VALUES ("The Wynn", 3, "lv");
INSERT INTO Hotel(hotel_name, hotel_id, hotel_location) VALUES ("The Venetian", 4, "lv");

# SELECT hotel_name FROM Hotel WHERE hotel_id = 1;

INSERT INTO Room(room_id, room_type, hotel_id) VALUES (1, "King", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (2, "Queen", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (3, "King", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (1, "Queen", 2);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (2, "King", 2);

INSERT INTO Guest(guest_fname, guest_lname, guest_id, guest_password, guest_email) VALUES ("Sally", "Doe", 1, "password", "email");
INSERT INTO Guest(guest_fname, guest_lname, guest_id, guest_password, guest_email) VALUES ("Joe", "Doe",  2, "password", "email");
INSERT INTO Guest(guest_fname, guest_lname, guest_id, guest_password, guest_email) VALUES ("Hannah", "Doe", 3, "password", "email");

# sally staying in Hotel 1, Room 1 (King)
# joe staying in Hotel 1, Room 1 (King)
# 9 to 11 should work for King
# 9 to 12 should not work

INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (1, "2022-11-06", "2022-11-09", 1, 1, 1, 100);
INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (2, "2022-11-11", "2022-11-13", 1, 1, 2, 100);
#INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (3, "2022-11-06", "2022-11-07", 1, 1, 1, 100);


/*INNER JOIN Room on Room.hotel_id = Hotel.hotel_id
INNER JOIN Reservation on Reservation.room_id = Room.room_id
INNER JOIN Guest on Guest.guest_id = Reservation.guest_id;

SELECT * FROM Hotel, Room, Reservation, Guest
INNER JOIN Room on Room.hotel_id = Hotel.hotel_id
INNER JOIN Reservation on Reservation.room_id = Room.room_id
INNER JOIN Guest on Guest.guest_id = Reservation.guest_id;*/

/*SELECT DISTINCT * FROM Reservation
INNER JOIN Guest on Guest.guest_id = Reservation.guest_id
INNER JOIN Room on Room.room_id = Reservation.room_id
INNER JOIN Hotel on Hotel.hotel_id = Room.room_id;*/

/*INNER JOIN Room on Room.hotel_id = Hotel.hotel_id
INNER JOIN Reservation on Reservation.room_id = Room.room_id
INNER JOIN Guest on Guest.guest_id = Reservation.guest_id;*/

/*SELECT * FROM playersSample
INNER JOIN earningsSample ON earningsSample.player_id = playersSample.player_id
INNER JOIN tournamentsSample ON tournamentsSample.tournament_id = earningsSample.tournament_id;*/

/*SELECT * FROM Hotel
INNER JOIN earningsSample ON earningsSample.player_id = playersSample.player_id
INNER JOIN tournamentsSample ON tournamentsSample.tournament_id = earningsSample.tournament_id;
