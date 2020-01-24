select Persons.firstName, Persons.lastName, Departments.name as DepartmentName, RoleTypes.name as RoleTypeName, Roles.BeginDate, Roles.EndDate from Persons
join Roles on Persons.PersonID = Roles.PersonID
join Departments on Roles.DepartmentID = Departments.DepartmentID
join RoleTypes on RoleTypes.RoleTypeID = Roles.RoleTypeID
where Persons.guid =?