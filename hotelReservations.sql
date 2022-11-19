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
    constraint pk_guest primary key (guest_id));

CREATE TABLE Reservation(
	reservation_id int not null,
	check_in int(11) not null,
	check_out int(11) not null,
    hotel_id int not null,
    room_id int not null,
    guest_id int not null,
    rewards_points int not null,
	constraint fk_reservation_room foreign key (room_id) references Room(room_id),
	constraint fk_reservation_hotel foreign key (hotel_id) references Hotel(hotel_id),
	constraint fk_reservation_guest foreign key (guest_id) references Guest(guest_id),
	constraint pk_reservation primary key(reservation_id));
 
 
INSERT INTO Hotel(hotel_id, hotel_name, hotel_location) VALUES (1, "The Hilton", "Los Angeles, CA");
INSERT INTO Hotel(hotel_id, hotel_name, hotel_location) VALUES (2, "The Hilton", "San Francisco, CA");
INSERT INTO Hotel(hotel_id, hotel_name, hotel_location) VALUES (3, "The Wynn", "Las Vegas, NV");
INSERT INTO Hotel(hotel_id, hotel_name, hotel_location) VALUES (4, "The Venetian", "Las Vegas, NV");

INSERT INTO Room(room_id, room_type, hotel_id) VALUES (1, "King", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (2, "Queen", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (3, "King", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (4, "King", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (5, "King", 1);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (1, "Queen", 2);
INSERT INTO Room(room_id, room_type, hotel_id) VALUES (2, "King", 2);

INSERT INTO Guest(guest_id, guest_fname, guest_lname, guest_password, guest_email) VALUES (1, "Sally", "Doe", "password", "email");
INSERT INTO Guest(guest_id, guest_fname, guest_lname, guest_password, guest_email) VALUES (2, "Joe", "Doe", "password", "email");
INSERT INTO Guest(guest_id, guest_fname, guest_lname, guest_password, guest_email) VALUES (3, "Hannah", "Doe", "password", "email");

# sally staying in Hotel 1, Room 1 (King)
# joe staying in Hotel 1, Room 1 (King)
# 9 to 11 should work for King
# 9 to 12 should not work

# Room 1
INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (1, 1667718000, 1667980800, 1, 1, 1, 100);
/* 11/6/22 - 11/9/22 */
INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (2, 1668153600, 1668326400, 1, 1, 2, 100);
/* 11/11/22 - 11/13/22 */
# Room 3
INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (3, 1668067200, 1668326400, 1, 3, 1, 100);
/* 11/10/22 - 11/13/22 */
# Room 4
INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (4, 1667718000, 1667808000, 1, 4, 1, 100);
/* 11/6/22- 11/7/22 */
INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (5, 1667980800, 1668240000, 1, 4, 1, 100);
/* 11/9/22- 11/12/22 */
# Room 5
INSERT INTO Reservation(reservation_id, check_in, check_out, hotel_id, room_id, guest_id, rewards_points) VALUES (6, 1667718000, 1668153600, 1, 5, 1, 100);
/* 11/6/22- 11/11/22 */

select room_id from room 
	where hotel_id = '1' 
		and room_type = 'king' 
		and room_id NOT IN
			(select room_id from reservation 
				where hotel_id = '1' 
				and room_id in
                (select room_id from reservation
					where
                    # Conflicting scenario 1
                    (check_out > 1667808000
                    and
                    check_out < 1668067200
                    )
                    or
                    (check_in > 1667808000
                    and
                    check_in < 1668067200
                    )
                    or
                    (check_in <1667808000
                    and
                    check_out > 1668067200
                    )
				)
			)
;

# Requested check in: 1667808000 (11.7.22)
# Requested check out: 1668067200 (11.10.22)

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
