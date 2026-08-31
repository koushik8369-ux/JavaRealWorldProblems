# Skill2Hire — Version 2

A beginner-friendly Java console application that compares a student's skills with the skills required for the **Java Full Stack Developer** role.

## Run the application

From this project folder, compile and run:

```powershell
javac Student.java Skill.java CareerAnalyzer.java Skill2Hire.java
java Skill2Hire
```

## Version 1 features retained

- Student name validation
- A single supported career role: Java Full Stack Developer
- Skill entry using `ArrayList`
- Case-insensitive skill matching
- Matched and missing skills report
- Career Readiness Score

## New in Version 2

- Skill proficiency collection: Beginner, Intermediate, or Advanced
- Weighted readiness: Beginner = 40%, Intermediate = 70%, Advanced = 100%
- Frontend, Backend, Database, and Tools category analysis
- Category readiness percentages and skill proficiency details
- Personalized recommendations for weak categories and beginner-level skills
- A dedicated `Skill` class for clean, encapsulated skill data
