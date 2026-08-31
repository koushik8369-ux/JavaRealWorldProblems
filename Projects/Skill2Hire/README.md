# Skill2Hire — Version 3

Skill2Hire is a Java console Career Intelligence application. It evaluates a student's skills and proficiency levels across several technology careers, ranks the matches, and recommends the strongest fit.

## Supported career paths

- Java Full Stack Developer
- Frontend Developer
- Backend Developer
- Data Analyst

## Version 1 features

- Student name and skill-count validation
- Case-insensitive skill comparison with matched and missing skill reporting
- Basic readiness percentage

## Version 2 features

- Beginner, Intermediate, and Advanced proficiency levels
- Weighted scoring: 40%, 70%, and 100% skill contributions
- Java Full Stack category analysis: Frontend, Backend, Database, and Tools

## Version 3 features

- Reusable career database using `Career`, `CareerRepository`, and `CareerMatch`
- Multi-career analysis from one student profile
- Weighted career ranking and best-career recommendation
- Comparison reports with matched skills, missing skills, basic score, and weighted score
- Smart guidance and the top missing skills for the recommended career
- Retained Java Full Stack detailed category and proficiency report

## Compile and run

```powershell
javac *.java
java Skill2Hire
```

## Example usage

Enter `Java` at Intermediate, `HTML` at Advanced, `SQL` at Intermediate, and `Git` at Advanced. The application ranks all four careers, recommends the best match, and provides a detailed Java Full Stack analysis.
