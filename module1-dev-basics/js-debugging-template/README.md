# JS Debugging Exercise
An elementary school hired you to build a word search generator for them. You built one that met the following requirements:
* User can specify the width and height of the grid
* User can add words to a word bank if they meet the following conditions:
    * Word is at least 3 characters long
    * Word includes only English letters
    * Word is unique
* User can remove individual words from the word bank by clicking the trash can icon for that word
* When user clicks "Create", a grid is generated
    * Grid has random letters
    * Grid has the width and height that were specified
    * Grid places all words from word bank or informs user that it couldn't

Unfortunately, someone edited the code and broke the generator. The school has asked us to give them a working copy again, but we already deleted the original. The school gave us the currently broken code. It's your job to find and correct the errors. The school would also like a record of all the changes that were made. You can put this into a `changelog` section in this README. They want to know the line of code that was changed, as well as a brief description of what was changed. For example:
* _Line 10_: change `with` to `width`
* _Line 2_: change `too` to `to`

_Take a look at the following resources for how to create a changelog using proper Markdown Syntax._

## What is a README

A README is a document designed to inform someone about your program. This can include installation, documentation, the most recent changes, etc. Modern READMEs are written in Markdown, which allows them to be formatted using simple [syntax](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet).

## Why Create a README

READMEs have become the standardized way of providing critical information about software to users. They allow you to document your work, give instructions and references, encourage interest, and facilitate understanding of your program.

## The Basic Structure of a README

The following is an example README structure:

- #### Title
- #### Description
- #### Installation Instructions
- #### Usage Instructions
- #### Credits
- #### License

However, it is important to keep in mind that every element in your README should provide pertinent and useful information. Some sections may not be relevant, so be sure to tailor your README to best serve the user. Your README should almost always include a title, a description, setup instructions, and contact information for issues.

## Moving Forward

Get into the habit of writing a README for every program you write. The more practice and feedback you get now the less of a headache writing READMEs will be in the future.

## Additional Resources
[How to Write a Good README](https://www.freecodecamp.org/news/how-to-write-a-good-readme-file/) - overview of what and why for a README

[makeareadme.com](https://www.makeareadme.com/) - information and resources on READMEs

[dillinger.io](https://dillinger.io/) - preview your README in browser

[Purdue OWL](https://owl.purdue.edu/owl/general_writing/academic_writing/conciseness/index.html) - tips and tricks for keeping your writing concise and impactful

# ChangeLog :see_no_evil: :hear_no_evil: :speak_no_evil:
### :bug: Fixes (2023-10-10)
* 3a937c8 index.js _line 45_ switch `width` and `height` parameters
* 9e8bf01 index.js _line 113_: change `remove` to `removeChild` to access the correct DOM element
* c36efc2 index.js _line 79_: change to `less than` to `greater than` 
* 36a5ae3 index.js _line 122_: change `child` to `childNodes`
* 6c5278c index.js _line 79_: change `less than` to `less than or equal to` the word length check b/c words must be 3 or more letters long
* f9ece47 index.js _line 19_: change `wordInput.innerText` to `wordInput.value` to be able to access the word put inside of the input box
* 1186759 index.js _line 92_: change `.class` to `.classList` for the trashbutton icon
* 3482748 index.js _line 21_: remove `!` to make `isValidWord` check evaluate to true since else covers if word is invalid
* 8e3e074 index.js _line 120_ to _line 130_: check `liElements` array to make sure it isn't empty before trying to access elements
        change the fxn to return the words array that is created in the fxn instead of the `liElements` array
* 717f73d index.js _line 134_: change `next-words` to `next-word-list` to match the element id
* 2c4b545 index.js _line 8_: change `getElementsByClassName` to `getElementById`
* d2728fb index.js _line 64_: add closing single quote after add-word
* ef73ad9 index.js _line 38_: change `word` to `words`
* 080cada index.js _line 88_: change `writeWrodList` to `writeWordToList`
* 2a8efdd index.js _line 27_: add closing curly bracket for the if statement checking for valid word. add in front of else
