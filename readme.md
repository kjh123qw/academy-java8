This program was created by Kim jeongho using java8.
<br />[output test result]

```
************************************************************
***************** Academy Manager Ver 1.0.0 ****************
************************************************************
[MAIN MENU]
   1.      Teacher
   2.        Class
   3.      Student
   4.         Quit
select number >> 1
************************************************************
[MAIN MENU] > [TEACHER]
   1. Registration
   2.       Modify
   3.   Regi-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 1
------------------------------------------------------------
[MAIN MENU] > [TEACHER] > [REGISTRATION]
==> MSG: Registration of a teacher
NAME (max 12) [back:!b] : John
AGE (numbers) [back:!b] : 35
OK!
Completed to register for database.
------------------------------------------------------------
************************************************************
[MAIN MENU] > [TEACHER]
   1. Registration
   2.       Modify
   3.   Regi-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 4
------------------------------------------------------------
[MAIN MENU] > [TEACHER] > [LIST]
==> MSG: Teacher list
    1. Name:         Mark | Age:  45 | Subject: [JSP]
    2. Name:       Pororo | Age:  39 | Subject: [ORACLE, CSS3]
    3. Name:        Barus | Age:  44 | Subject: [JAVASCRIPT]
    4. Name:          KJH | Age:  24 | Subject: []
    5. Name:         John | Age:  35 | Subject: []
Select target number [back:!b] : !b
************************************************************
[MAIN MENU] > [TEACHER]
   1. Registration
   2.       Modify
   3.   Regi-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 3
------------------------------------------------------------
[MAIN MENU] > [TEACHER] > [REGISTER CLASS]
==> MSG: Teacher register class
    1. Name:         Mark | Age:  45 | Subject: [JSP]
    2. Name:       Pororo | Age:  39 | Subject: [ORACLE, CSS3]
    3. Name:        Barus | Age:  44 | Subject: [JAVASCRIPT]
    4. Name:          KJH | Age:  24 | Subject: []
    5. Name:         John | Age:  35 | Subject: []
Select teacher [back:!b] : 5
    1. Sbuject:          JSP | Teacher:         Mark | Max:  1/30 | Apply: 20200510 ~ 20200520 | Period : 20200601 ~ 20200920
    2. Sbuject:       ORACLE | Teacher:       Pororo | Max:  1/20 | Apply: 20200520 ~ 20200531 | Period : 20200605 ~ 20200630
    3. Sbuject:        HTML5 | Teacher:              | Max:  0/15 | Apply: 20200522 ~ 20200620 | Period : 20200630 ~ 20200820
    4. Sbuject:   JAVASCRIPT | Teacher:        Barus | Max:  1/20 | Apply: 20200522 ~ 20200531 | Period : 20200621 ~ 20200930
    5. Sbuject:         CSS3 | Teacher:       Pororo | Max:  7/20 | Apply: 20200522 ~ 20200531 | Period : 20200621 ~ 20200930
Select class [back:!b] : 3
OK!
Completed to register for database.
------------------------------------------------------------
************************************************************
[MAIN MENU] > [TEACHER]
   1. Registration
   2.       Modify
   3.   Regi-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 4
------------------------------------------------------------
[MAIN MENU] > [TEACHER] > [LIST]
==> MSG: Teacher list
    1. Name:         Mark | Age:  45 | Subject: [JSP]
    2. Name:       Pororo | Age:  39 | Subject: [ORACLE, CSS3]
    3. Name:        Barus | Age:  44 | Subject: [JAVASCRIPT]
    4. Name:          KJH | Age:  24 | Subject: []
    5. Name:         John | Age:  35 | Subject: [HTML5]
Select target number [back:!b] : !b
************************************************************
[MAIN MENU] > [TEACHER]
   1. Registration
   2.       Modify
   3.   Regi-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 6
[MAIN MENU]
   1.      Teacher
   2.        Class
   3.      Student
   4.         Quit
select number >> 2
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 1
------------------------------------------------------------
[MAIN MENU] > [CLASS] > [REGISTRATION]
==> MSG: Register a class
SUBJECT (max 12) [back:!b] : REACTJS
TOTAL (Maximum numbers) [back:!b] : 15
START APPLY (ex> 20200522) [back:!b] : 20200602
END APPLY (ex> 20200522) [back:!b] : 20200625
START DAY (ex> 20200522) [back:!b] : 20200705
END DAY (ex> 20200522) [back:!b] : 20200915
TIME (0, 1, 2) [back:!b] : 0
OK!
Completed to register for database.
------------------------------------------------------------
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 4
------------------------------------------------------------
[MAIN MENU] > [CLASS] > [ALL LIST]
==> MSG: all class list
Sbuject:          JSP | Teacher:         Mark | Max:  1/30 | Apply: 20200510 ~ 20200520 | Period : 20200601 ~ 20200920
Sbuject:       ORACLE | Teacher:       Pororo | Max:  1/20 | Apply: 20200520 ~ 20200531 | Period : 20200605 ~ 20200630
Sbuject:        HTML5 | Teacher:         John | Max:  0/15 | Apply: 20200522 ~ 20200620 | Period : 20200630 ~ 20200820
Sbuject:   JAVASCRIPT | Teacher:        Barus | Max:  1/20 | Apply: 20200522 ~ 20200531 | Period : 20200621 ~ 20200930
Sbuject:         CSS3 | Teacher:       Pororo | Max:  7/20 | Apply: 20200522 ~ 20200531 | Period : 20200621 ~ 20200930
Sbuject:      REACTJS | Teacher:              | Max:  0/15 | Apply: 20200602 ~ 20200625 | Period : 20200705 ~ 20200915
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 3
------------------------------------------------------------
[MAIN MENU] > [CLASS] > [LIST]
==> MSG: class list
    <Classes you can apply>
Sbuject:        HTML5 | Teacher:         John | Max:  0/15 | Apply: 20200522 ~ 20200620 | Period : 20200630 ~ 20200820
Sbuject:      REACTJS | Teacher:              | Max:  0/15 | Apply: 20200602 ~ 20200625 | Period : 20200705 ~ 20200915
    <Classes schedule>
No List.
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 6
[MAIN MENU]
   1.      Teacher
   2.        Class
   3.      Student
   4.         Quit
select number >> 1
************************************************************
[MAIN MENU] > [TEACHER]
   1. Registration
   2.       Modify
   3.   Regi-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 3
------------------------------------------------------------
[MAIN MENU] > [TEACHER] > [REGISTER CLASS]
==> MSG: Teacher register class
    1. Name:         Mark | Age:  45 | Subject: [JSP]
    2. Name:       Pororo | Age:  39 | Subject: [ORACLE, CSS3]
    3. Name:        Barus | Age:  44 | Subject: [JAVASCRIPT]
    4. Name:          KJH | Age:  24 | Subject: []
    5. Name:         John | Age:  35 | Subject: [HTML5]
Select teacher [back:!b] : 4
    1. Sbuject:          JSP | Teacher:         Mark | Max:  1/30 | Apply: 20200510 ~ 20200520 | Period : 20200601 ~ 20200920
    2. Sbuject:       ORACLE | Teacher:       Pororo | Max:  1/20 | Apply: 20200520 ~ 20200531 | Period : 20200605 ~ 20200630
    3. Sbuject:        HTML5 | Teacher:         John | Max:  0/15 | Apply: 20200522 ~ 20200620 | Period : 20200630 ~ 20200820
    4. Sbuject:   JAVASCRIPT | Teacher:        Barus | Max:  1/20 | Apply: 20200522 ~ 20200531 | Period : 20200621 ~ 20200930
    5. Sbuject:         CSS3 | Teacher:       Pororo | Max:  7/20 | Apply: 20200522 ~ 20200531 | Period : 20200621 ~ 20200930
    6. Sbuject:      REACTJS | Teacher:              | Max:  0/15 | Apply: 20200602 ~ 20200625 | Period : 20200705 ~ 20200915
Select class [back:!b] : 6
OK!
Completed to register for database.
------------------------------------------------------------
************************************************************
[MAIN MENU] > [TEACHER]
   1. Registration
   2.       Modify
   3.   Regi-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 6
[MAIN MENU]
   1.      Teacher
   2.        Class
   3.      Student
   4.         Quit
select number >> 2
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 3
------------------------------------------------------------
[MAIN MENU] > [CLASS] > [LIST]
==> MSG: class list
    <Classes you can apply>
Sbuject:        HTML5 | Teacher:         John | Max:  0/15 | Apply: 20200522 ~ 20200620 | Period : 20200630 ~ 20200820
Sbuject:      REACTJS | Teacher:          KJH | Max:  0/15 | Apply: 20200602 ~ 20200625 | Period : 20200705 ~ 20200915
    <Classes schedule>
No List.
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 6
[MAIN MENU]
   1.      Teacher
   2.        Class
   3.      Student
   4.         Quit
select number >> 3
************************************************************
[MAIN MENU] > [STUDENT]
   1. Registration
   2.  Modify-Info
   3. Modify-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 4
------------------------------------------------------------
[MAIN MENU] > [STUDENT] > [LIST]
==> MSG: Student list
Name:  Kim Jeongho | Age:  31 | Subject:        JSP
Name:         Park | Age:  29 | Subject:       CSS3
Name:          Lee | Age:  31 | Subject:     ORACLE
Name:    Bruce Kim | Age:  25 | Subject:       CSS3
Name:       Totoro | Age:  33 | Subject: JAVASCRIPT
Name:         Sana | Age:  27 | Subject:       CSS3
Name:   Test Name2 | Age:  32 | Subject:       CSS3
Name:          Bob | Age:  32 | Subject:       CSS3
Name:         Momo | Age:  27 | Subject:       CSS3
Name:         Mina | Age:  26 | Subject:       CSS3
************************************************************
[MAIN MENU] > [STUDENT]
   1. Registration
   2.  Modify-Info
   3. Modify-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 1
------------------------------------------------------------
[MAIN MENU] > [STUDENT] > [REGISTRATION]
==> MSG: Registration of a student
NAME (max 12) [back:!b] : Park
AGE (numbers) [back:!b] : 24
    1. Sbuject:        HTML5 | Teacher:         John | Max:  0/15 | Apply: 20200522 ~ 20200620 | Period : 20200630 ~ 20200820
    2. Sbuject:      REACTJS | Teacher:          KJH | Max:  0/15 | Apply: 20200602 ~ 20200625 | Period : 20200705 ~ 20200915
Select class [back:!b, skip:0] : 1
OK!
Completed to register for database.
------------------------------------------------------------
************************************************************
[MAIN MENU] > [STUDENT]
   1. Registration
   2.  Modify-Info
   3. Modify-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 4
------------------------------------------------------------
[MAIN MENU] > [STUDENT] > [LIST]
==> MSG: Student list
Name:  Kim Jeongho | Age:  31 | Subject:        JSP
Name:         Park | Age:  29 | Subject:       CSS3
Name:          Lee | Age:  31 | Subject:     ORACLE
Name:    Bruce Kim | Age:  25 | Subject:       CSS3
Name:       Totoro | Age:  33 | Subject: JAVASCRIPT
Name:         Sana | Age:  27 | Subject:       CSS3
Name:   Test Name2 | Age:  32 | Subject:       CSS3
Name:          Bob | Age:  32 | Subject:       CSS3
Name:         Momo | Age:  27 | Subject:       CSS3
Name:         Mina | Age:  26 | Subject:       CSS3
Name:         Park | Age:  24 | Subject:      HTML5
************************************************************
[MAIN MENU] > [STUDENT]
   1. Registration
   2.  Modify-Info
   3. Modify-Class
   4.         List
   5.       Delete
   6.         Back
select number >> 6
[MAIN MENU]
   1.      Teacher
   2.        Class
   3.      Student
   4.         Quit
select number >> 2
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 3
------------------------------------------------------------
[MAIN MENU] > [CLASS] > [LIST]
==> MSG: class list
    <Classes you can apply>
Sbuject:        HTML5 | Teacher:         John | Max:  1/15 | Apply: 20200522 ~ 20200620 | Period : 20200630 ~ 20200820
Sbuject:      REACTJS | Teacher:          KJH | Max:  0/15 | Apply: 20200602 ~ 20200625 | Period : 20200705 ~ 20200915
    <Classes schedule>
No List.
************************************************************
[MAIN MENU] > [CLASS]
   1. Registration
   2.       Modify
   3.   Apply List
   4.     All List
   5.       Delete
   6.         Back
select number >> 6
[MAIN MENU]
   1.      Teacher
   2.        Class
   3.      Student
   4.         Quit
select number >> 4
Good bye~!
```