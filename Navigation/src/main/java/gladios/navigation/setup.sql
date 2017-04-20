create table if not exists Routes(
	RouteName varchar(50) not null unique,
	RouteID int not null auto_increment,
	StartLocationName varchar(50) not null,
	EndLocationName varchar(50) not null,
	primary key(RouteID)
);
	
create table if not exists RouteWayPoints(
	RouteName varchar(50) not null unique,
	StartLoc varchar(50) not null,
	WayPoint1 varchar(50),
	WayPoint2 varchar(50),
	WayPoint3 varchar(50),
	WayPoint4 varchar(50),
	WayPoint5 varchar(50),
	WayPoint6 varchar(50),
	WayPoint7 varchar(50),
	WayPoint8 varchar(50),
	WayPoint9 varchar(50),
	WayPoint10 varchar(50),
	WayPoint11 varchar(50),
	WayPoint12 varchar(50),
	WayPoint13 varchar(50),
	WayPoint14 varchar(50),
	WayPoint15 varchar(50),
	WayPoint16 varchar(50),
	WayPoint17 varchar(50),
	WayPoint18 varchar(50),
	WayPoint19 varchar(50),
	WayPoint20 varchar(50),
	WayPoint21 varchar(50),
	WayPoint22 varchar(50),
	WayPoint23 varchar(50),
	WayPoint24 varchar(50),
	WayPoint25 varchar(50),
	WayPoint26 varchar(50),
	WayPoint27 varchar(50),
	WayPoint28 varchar(50),
	WayPoint29 varchar(50),
	WayPoint30 varchar(50),
	EndLoc varchar(50) not null,
	Preference varchar(25),
	primary key(RouteName)
);

create table if not exists Locations(
	LocationName varchar(50) not null unique,
	LocationID int not null,
	Longitude decimal(30, 30) not null,
	Latitude decimal(30, 30) not null,
	primary key(LocationID)
);
