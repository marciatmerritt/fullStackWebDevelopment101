/*
SQL Queries Exercise v1
Type: Independent
Associates will complete this exercise on their own and deliver the code in their own GitLab repository.
Exercise Duration: ½ day
Exercise Instructions:
You have been provided with a dump file which contains data for college students and classes. The college has tasked you with writing the queries to perform a set of operations on the data. Create a new database and restore the dump file then answer the following questions using SQL statements.
*/
--Requirements:
/*
1. A new student has been accepted into the college, add his information to the students table: Dan Zanes.
*/
INSERT INTO STUDENTS
  (
	ID
   ,FIRST_NAME
   ,LAST_NAME
   ,USERNAME
   ,EMAIL
  ) 
VALUES 
  (
    5
   ,'DAN'
   ,'ZANES'
   ,'DZANES'
   ,'DZANES@COLLEGE.EDU'
  );
	
--Check data with
  SELECT * 
    FROM STUDENTS
ORDER BY ID;
/*
2. Josie’s email was inputted incorrectly. Modify her email to be “jblair21@college.edu”.
*/
UPDATE STUDENTS
   SET EMAIL = 'JBLAIR21@COLLEGE.EDU'
 WHERE ID = 1;

--Check data with
  SELECT * 
    FROM STUDENTS
ORDER BY ID;

/*
3. The college is creating a directory of all student names and emails. To help, generate a list of all students in the format: <Last name, First name> <Email> with a heading of “Name” for the full name and “Email” for the email. Order the list alphabetically by last name.
*/
  SELECT LAST_NAME || ', ' || FIRST_NAME AS "Name",
         EMAIL AS "Email"
    FROM STUDENTS
ORDER BY LAST_NAME;

/*
4. Abe wants to see all of his recorded class grades. Create a list for him with the name of the class and the grade he received.
*/

SELECT CLASSES.NAME
	  ,GRADES.GRADE
  FROM CLASSES
	  ,GRADES
 WHERE GRADES.STUDENT_ID = 3
   AND CLASSES.ID = GRADES.CLASS_ID;

/*
5. Joe Barnes has graduated and his information has been recorded in an alumni table. Delete his record from the students table.
*/
    ALTER TABLE GRADES 
DROP CONSTRAINT GRADES_STUDENT_ID_FKEY;

DELETE 
  FROM STUDENTS 
 WHERE ID = 4;

DELETE 
  FROM GRADES
 WHERE STUDENT_ID 
NOT IN(SELECT STUDENTS.ID 
	     FROM STUDENTS);

   ALTER TABLE GRADES 
ADD CONSTRAINT GRADES_STUDENT_ID_FKEY 
   FOREIGN KEY (STUDENT_ID) 
    REFERENCES STUDENTS(ID);
	

--NOTE: In real world situation, you DON'T just drop the constraint without adding it back. Of course, that is not valid in this situation unless you delete from the grades table. 
--But then, you don't even need to drop the constraint because you can just delete from the grades table and then delete from the students table. 


/*
6. The teacher of Introduction to Computer Science wants to see a list of all the grades in the class. Create a list with the full name of the student and the grade received in Introduction to Computer Science.
*/
  SELECT STUDENTS.LAST_NAME || ', ' || STUDENTS.FIRST_NAME AS "Name"
        ,GRADES.GRADE AS "Grade"
    FROM STUDENTS
		,GRADES
		,CLASSES
   WHERE CLASSES.ID = 1
     AND CLASSES.ID = GRADES.CLASS_ID 
     AND GRADES.STUDENT_ID = STUDENTS.ID
ORDER BY LAST_NAME;

/*
Stretch Requirements (These are optional requirements for additional practice):

1. An administrator would like to see a list of all grades in all classes for all students. Create a list which shows all of the grades, the class name, and the student’s full name
*/

  SELECT STUDENTS.LAST_NAME || ', ' || STUDENTS.FIRST_NAME AS "Name"
	    ,CLASSES.NAME AS "Class Name"
	    ,CLASSES.CODE AS "Class Code"
	    ,GRADES.GRADE AS "Grade"
    FROM CLASSES
        ,GRADES
        ,STUDENTS
   WHERE STUDENTS.ID = GRADES.STUDENT_ID
     AND CLASSES.ID = GRADES.CLASS_ID
ORDER BY STUDENTS.ID;




