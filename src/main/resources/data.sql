DROP TABLE IF EXISTS person;

CREATE TABLE Persons
(
    PersonID  INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(250) NOT NULL,
    LastName  VARCHAR(250) NOT NULL,
    Guid VARCHAR(250) NOT NULL
);

CREATE TABLE Departments
(
    DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
    Name         VARCHAR(250) NOT NULL
);

CREATE TABLE RoleTypes
(
    RoleTypeID INT AUTO_INCREMENT PRIMARY KEY,
    Name       VARCHAR(250) NOT NULL
);

CREATE TABLE Role
(
    Roleid       INT AUTO_INCREMENT PRIMARY KEY,
    PersonID     INT,
    FOREIGN KEY (PersonID) REFERENCES Persons (PersonID),
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Departments (DepartmentID),
    RoleTypeID   INT,
    FOREIGN KEY (RoleTypeID) REFERENCES RoleTypes (RoleTypeID),
    BeginDate    DATE,
    EndDate      DATE
);

INSERT INTO Persons (FirstName, LastName, Guid)
VALUES ('Leo', 'Tolstoy', 'lttestguid'),
       ('Mikhail', 'Bakunin', 'mbtestguid'),
       ('Camillo', 'Berneri', 'cbtestguid');

INSERT INTO Departments (Name)
VALUES ('State Dept'),
       ('God Dept');

INSERT INTO RoleTypes (Name)
VALUES ('Employee'),
       ('Lecturer');

INSERT INTO Role (PersonID, DepartmentID, RoleTypeID, BeginDate, EndDate)
VALUES ((SELECT PersonID from Persons WHERE LastName = 'Tolstoy'),
        (SELECT DepartmentID FROM Departments WHERE Name = 'State Dept'),
        (SELECT RoleTypeID FROM RoleTypes WHERE Name = 'Employee'),
        DATE '2000-12-17',
        DATE '2015-12-17'),
       ((SELECT PersonID from Persons WHERE LastName = 'Bakunin'),
        (SELECT DepartmentID FROM Departments WHERE Name = 'State Dept'),
        (SELECT RoleTypeID FROM RoleTypes WHERE Name = 'Lecturer'),
        DATE '2002-01-01',
        DATE '2017-02-14'),
       ((SELECT PersonID from Persons WHERE LastName = 'Berneri'),
        (SELECT DepartmentID FROM Departments WHERE Name = 'God Dept'),
        (SELECT RoleTypeID FROM RoleTypes WHERE Name = 'Employee'),
        DATE '2010-10-10',
        DATE '2015-10-17'),
       ((SELECT PersonID from Persons WHERE LastName = 'Berneri'),
        (SELECT DepartmentID FROM Departments WHERE Name = 'God Dept'),
        (SELECT RoleTypeID FROM RoleTypes WHERE Name = 'Lecturer'),
        DATE '2008-08-17',
        DATE '2020-12-01');


