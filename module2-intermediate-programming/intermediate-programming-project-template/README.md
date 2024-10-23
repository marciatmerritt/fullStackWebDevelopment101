# Intermediate Programming Project Template

Intermediate Programming Project Template is used to give trainees a base project for demonstrating logical thinking. 

## Description

### Average: 

<details>
<summary>This function calculates the averages of assessment scores.</summary>

 Input: Array of Integers that must all be positive. The array can be a single number or empty, but it can not have a negative integer.
Output: An average of the scores that is a double with precision to 2 decimal places. For an empty array, 0.00 will be returned.

If any number within the input array is negative, an exception is thrown with a message of "scores must be positive".
</details>
<details>
<summary>Test Cases</summary>

1. An Array with all positive integers
2. An Array with one positive integer
3. An Array with one positive integer of Zero
4. An Empty Array
5. An Array that has positive integers and a Negative Integer
</details>

### Last word length

<details>
<summary>This function gets the length of the last word in a string.</summary>

 Input: String with whitespace allowed but not an empty string
Output: The length (int) of the last word in the string. If the string is only whitespace, 0 is returned.

If the input string is empty, then an exception is thrown with a message of "input must not be an empty string".
</details>
<details>
<summary>Test Cases</summary>

1. A regular string with multiple words
2. A string with one letter and spaces after the letter
3. A string with only whitespace
4. An Empty string
</details>

### Distinct ladder paths
<details>
<summary>This function calculates the number of ladder paths there are to reach the top of a ladder with an n number of rungs.</summary>
 
When climbing the ladder, you have the choice of climbing either 1 or 2 rungs with each step.
e.g. (3) → 3:
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 Input: An int number of rungs. Must be a positive number and can be zero.
Output: A BigDecimal number to represent the number of distinct ladder paths found. If n=0 rungs, then 0 is returned. If n=100 rungs, then 573147844013817084101 is returned.

If the input is a negative integer, then an exception is thrown with a message of "ladders can't have negative rungs".
</details>
<details>
<summary>Test Cases</summary>

1. Positive integer of n = 3 rungs
2. Positive integer of n = 100 rungs
3. Integer of n = 0 rungs
4. Negative Integer of n = -1
</details>

### Group Strings
<details>
<summary>This function takes an array of strings and groups in groups with the same first and last letters</summary>

 Input: An array of strings that can be an empty array but cannot have an empty string.
Output: A list of list of strings grouped with the same first and last chars in the string. An input of empty list returns an empty list.

If the array has an empty string, then an exception is thrown with a message of "strings must not be empty".
</details>
<details>
<summary>Test Cases</summary>

1. An array of strings with just one word
2. An array of strings with two different words that should be in separate lists
3. An array of strings with multiple words that should make 2 groups
4. An array of strings that has a lot of words and multiple lists and groups returned
5. An empty array
6. An array with just an empty string
7. An array with words but has an empty string 
</details>


## Getting Started

### Dependencies

Must have IntelliJ IDEA 2023 installed [IDEA IntelliJ](https://www.jetbrains.com/idea/download)
Download or copy Google's IntelliJ Java style xml file (https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml)


## Installation

Fork the repository to your specified work directory, then clone it down

```bash
git clone <insert_url_here>
```

## Usage

All of the working solutions to the interface have been added to the LogicProblemsImpl file. 

### Linting with IntelliJ
```
Setting Java CodeStyle

	In IntelliJ: 
	1. Settings -> Editor -> Code Style -> Java (ctrl + alt + s)
	2. Import scheme by clicking on the gear icon beside Scheme dropdown
	3. Select downloaded Google's IntelliJ Java style xml file from file picker dialog
	4. Apply
```
```
To Lint code:

ctrl + alt + l - will automatically lint each file
or
right click on a package in the project tree and run Reformat Code -> then check code code cleanup
```

### Executing Testing

All test cases for each method in the LogicProblemsImpl are found in the LogicProblemsImplTest file.
* Go to test file
* The main test class is the LogicProblemsImplTest and from this point, you can execute all test cases for the project and their coverage by:
	* Find the main class ```public class LogicProblemsImplTest{ ```

	* Select the gutter icon next to the test class and choose **Run|Run... with coverage** 
	![Running a test using the gutter icon](https://resources.jetbrains.com/help/img/idea/2023.2/run-test.png)
	
	* or select the configuration from the list on the toolbar
	
	![Screenshot of an image of how to run with coverage in IntelliJ](https://resources.jetbrains.com/help/img/idea/2023.2/run-with-coverage.png)

* The **Run** also works on all of the individual methods if you want to test each individual method separately.

## Authors

Marcia Merritt

## Version History

* 0.1
    * Initial Release 15-11-2023


