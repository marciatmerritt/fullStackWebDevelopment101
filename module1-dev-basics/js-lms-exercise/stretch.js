/**Creates a list of all of the quiz module. Removes Duplicates
 * 
 * @param {object[]} submissions array of quiz submission objects
 * @returns {array} list of all quiz names found in the submissions list without duplicates
 */
const getListOfQuizModulesUnique = (submissions) => {
    const quizModuleArray = [];

    for (let submission of submissions){
        quizModuleArray.push(submission.quizModule);
    }
    //The below came from a compilation of research from 2 websites indicated below
    //https://www.geeksforgeeks.org/how-to-get-all-unique-values-remove-duplicates-in-a-javascript-array/
    // let quizModuleNoDupsArray = Array.from(new Set(quizModuleArray)); //keeping this here for notes
    //https://www.w3schools.com/js/js_object_sets.asp
    let quizModuleNoDupsArray = new Set(quizModuleArray);

    return quizModuleNoDupsArray;
};

/**Gets a list of all submissions for a Quiz Module
 * 
 * @param {string} quizModule
 * @param {object[]} submissions: array of quiz submission objects
 * @returns {array} a list of quizzes submitted only for the name of the module input as a parameter
 */
const filterByModule = (quizModule, submissions) => {
    const quizSubmForQuizModuleArray = [];

    if (submissions.length === 0){
        return quizSubmForQuizModuleArray;
    };

    for (const submission of submissions){
      if (quizModule === submission.quizModule){
          quizSubmForQuizModuleArray.push(submission);
      };
    };

    return quizSubmForQuizModuleArray;
};

/**get a list of the avg quiz scores for each module
 * 
 * @param {object[]} submissions: array of quiz subm objects
 * @returns {object[]} a list of average quiz scores for each module. Module name is the object key & avg score is the value
 */
const getAverageScoreByModule = (submissions) => {
    const avgQuizScoresByModuleObject = {};

    //get a list of quiz modules without duplicates
    let uniqueQuizModulesArray = getListOfQuizModulesUnique(submissions);

    for (let quiz of uniqueQuizModulesArray){

        let quizModuleSubmissionsArray = filterByModule(quiz, submissions);
        let avgQuizScoreForQuizModule  = getAverageScore(quizModuleSubmissionsArray);

        avgQuizScoresByModuleObject[quiz] = avgQuizScoreForQuizModule;
    }

    return avgQuizScoresByModuleObject;
};
