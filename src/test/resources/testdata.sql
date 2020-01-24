INSERT INTO Persons (FirstName, LastName, Guid)
VALUES ('Test-Firstname', 'Test-Lastname', 'testguid');

INSERT INTO Departments (Name)
VALUES ('Test-Dept');

INSERT INTO RoleTypes (Name)
VALUES ('Test-type');

INSERT INTO Role (PersonID, DepartmentID, RoleTypeID, BeginDate, EndDate)
VALUES ((SELECT PersonID from Persons WHERE LastName = 'Test-Lastname'),
        (SELECT DepartmentID FROM Departments WHERE Name = 'Test-Dept'),
        (SELECT RoleTypeID FROM RoleTypes WHERE Name = 'Test-type'),
        DATE '2000-12-17',
        DATE '2015-12-17');


