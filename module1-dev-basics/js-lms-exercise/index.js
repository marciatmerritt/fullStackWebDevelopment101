/** Filter quiz submissions by date 
 * @param {string} date: format 'mmddyyyy'  
 * @param {object[]} submissions: array of all quiz submission objects   
 * @returns {object[]} an array of all quiz objects submitted on the date that matches the input date. If the submission object is empty 
 *          or no matching submit dates are found, array will be empty * 
 */
const filterByDate = (date, submissions) => {
    const quizSubmForDateArray = [];

    if (submissions.length === 0){
        return quizSubmForDateArray;
    };

    for (const submission of submissions){
      if (date === submission.submissionDate){
          quizSubmForDateArray.push(submission);
      };
    };
    
    return quizSubmForDateArray;
};

/** Filter quiz submissions by student Id
 * 
 * @param {number} studentId: input studentId
 * @param {object[]} submissions: array of all quiz submission objects
 * @returns {object[]} an array of all quiz objects submitted by a student with the input studentId. If the submission object is empty
 *          or no matching studentId is found, array will be empty
 */
const filterByStudentId = (studentId, submissions) => {
    const quizSubmForStdntArray = [];

    if (submissions.length === 0){
        return quizSubmForStdntArray;
    };

    for (const submission of submissions){
      if (studentId === submission.studentId){
          quizSubmForStdntArray.push(submission);
      };
    };

    return quizSubmForStdntArray;
};

/**Checks for student name present in a list of quizzes
 * 
 * @param {string} studentName
 * @param {object[]} submissions: array of all quiz submission objects 
 * @returns {boolean} indicator of present of student name in list of submissions
 */
const hasSubmittedQuiz = (studentName, submissions) => {

    //loop through and see if student name is present, get out as soon as it is found
    for (const submission of submissions){
        if (studentName === submission.studentName){
            return true;
        };
    };

    //if code gets to this point, student name wasn't found in submissions
    return false;
};

/** Find list of students that have not submitted quiz on a specific date
 * 
 * @param {string} date: format 'mmddyyyy' 
 * @param {array} studentNames: list of student names
 * @param {object[]} submissions: array of all quiz submission objects
 * @returns {array} list of student names that haven't submitted a quiz on a particular date
 */
const findUnsubmitted = (date, studentNames, submissions) => {
    const studentWithUnsubmQuizArray = [];

    if ((studentNames.length === 0)){
        return studentWithUnsubmQuizArray;
    };
    
    if ((submissions.length === 0)){
        return studentNames;
    }

    //get list of quizzes submitted by date then loop through this list with each student name to see if it is there
    //if it is not found, add the name to the unsubm list
    let quizSubmByDateArray = filterByDate(date, submissions);

    for (const student of studentNames){
        if (hasSubmittedQuiz(student, quizSubmByDateArray) == false){
            studentWithUnsubmQuizArray.push(student);
        };
    };

    return studentWithUnsubmQuizArray;  
};

//how Tiana would have done it
//make a copy of names and remove the name from the list if it is present
//javascript Array indexOf
//except using copyOfNames isn't the best because of data integrity
//spread operator

//how to do this in a method
const findUnsubmitted = (date, studentNames, submissions) => {

	const copyOfNames = [...studentNames]; //these are technically taking up the same space in memory
	const filteredStudents = filterByDate(date, submissions);
	
	for (const name of studentNames){
		for(const submission of submissions){
			if(name === submission.studentName){
				copyOfNames.splice(copyOfNames.indexOf(name),1);
			};
		};
	};
	return copyOfNames;
};

/** Averages all of the quiz scores in the submissions list
 * 
 * @param {object[]} submissions: array of all quiz submission objects
 * @returns {number} an average of quiz scores to the nearest tenths place
 *                   If there are no scores to average, then returns 0
 */
const getAverageScore = (submissions) => {
    let quizCounter  = 0;
    let totQuizScore = 0;
    let avgQuizScore = 0;

    if (submissions.length === 0){
        return avgQuizScore;
    };
    
    for (let submission of submissions){
        totQuizScore += submission.quizScore;
        quizCounter ++;
    };

    avgQuizScore = totQuizScore/quizCounter;
    
    return avgQuizScore.toFixed(1); 
};