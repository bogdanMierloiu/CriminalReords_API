# CriminalRecords

Application for the record of criminal files

Entities:
- POLICEMAN -> that represents a police officer in a criminal records management system. It has the following properties:

- id: a Long value representing the unique identifier of the police officer.
- firstName: a String value representing the first name of the police officer.
- lastName: a String value representing the last name of the police officer.
- email: a String value representing the email address of the police officer.
- policeStation: a PoliceStation object representing the police station to which the police officer is assigned.
- department: a Department object representing the department to which the police officer belongs.
- criminalFiles: a List of CriminalFile objects representing the criminal files associated with the police officer.

- POLICE STATION -> that represents a police station in a criminal records management system. It has the following properties:

- id: a Long value representing the unique identifier of the police station.
- name: a String value representing the name of the police station.
- policemen: a List of Policeman objects representing the police officers assigned to the police station.
- departments: a List of Department objects representing the departments within the police station.

- DEPARTMENT -> that represents a department within a police station in a criminal records management system. It has the following properties:

- id: a Long value representing the unique identifier of the department.
- name: a String value representing the name of the department.
- policeStation: a PoliceStation object representing the police station to which the department belongs.
- policemen: a List of Policeman objects representing the police officers assigned to the department.
- criminalFile: a CriminalFile object representing the criminal file associated with the department.

- CRIMINAL FILE -> that represents a criminal record in a criminal records management system. It has the following properties:

- id: a Long value representing the unique identifier of the criminal record.
- number: a Long value representing the unique number associated with the criminal record.
- registrationDate: a LocalDate value representing the date on which the criminal record was registered.
- legalQualification: a LocalDate value representing the date on which the criminal record was legally qualified.
- department: a Department object representing the department to which the criminal record belongs.
- policeman: a Policeman object representing the police officer responsible for the criminal record.
- crimeType: a CrimeType object representing the type of crime associated with the criminal record.

- CRIME TYPE -> that represents the type of the crime. It has the following properties:

- id: a Long value representing the unique identifier of the type of crime record.
- type: a String value representing the name of the type of crime.
- criminalFile: a CriminalFile object representing the criminal file associated with the type of crime.
    
