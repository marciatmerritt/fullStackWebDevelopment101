package io.catalyte.training;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Contains multiple common logic exercises.
 */
public class LogicExercise {

  /**
   * Takes a BigDecimal for the unit price and an int for number of units sold and returns a
   * discounted sales total based on the quantity sold:
   *
   * if more than 99 units are sold,
   *        apply a 15% discount to the total price;
   * if more than 49 units are sold,
   *        apply a 10% discount 10% to the total price;
   * if less than 50 units are sold,
   *        do not apply a discount to the price.
   *
   * For example, if the unit price was 1.00 and the quantity sold was 100, the method should return 85.00 for
   * the total sales amount.
   */
  /**
   * Given an amount purchased & price per unit, apply a discount when applicable
   * @param unitPrice {BigDecimal} price per unit
   * @param unitAmount {Integer} amount of units purchased
   * @return {BigDecimal} total price of purchase with discount when applicable
   */
  public BigDecimal getDiscount(BigDecimal unitPrice, int unitAmount) {

    BigDecimal total;
    BigDecimal percentOff;
    BigDecimal totalWithDiscount;
    BigDecimal percentage15 = new BigDecimal("0.15");
    BigDecimal percentage10 = new BigDecimal("0.10");

    MathContext m = new MathContext(4);

    total = unitPrice.multiply(BigDecimal.valueOf(unitAmount));

    //no discount when buy less than 50 units
    if (unitAmount < 50){
      return total;
    }

    //if more than 99 units sold -> give 15% off
    if (unitAmount > 99){
      percentOff = total.multiply(percentage15, m);
      totalWithDiscount = total.subtract(percentOff);
      return totalWithDiscount;
    }

    //when you buy 50 to 99 units -> give 10% off
    percentOff = total.multiply(percentage10, m);
    totalWithDiscount = total.subtract(percentOff);
    return totalWithDiscount;
  }

  /**
   * This method takes an int representing a percentile score and should return the appropriate
   * letter grade.
   * If the score is above 90, return 'A';
   * if the score is between 80 and 89, return 'B';
   * if the score is between 70 and 79, return 'C';
   * if the score is between 60 and 69, return 'D';
   * if the score is below 60, return 'F'.
   */
  /**
   * Given a student's score, return a letter grade
   * @param score {Integer}
   * @return {Char} a letter grade
   */
  public char getGrade(int score) {

    if (score < 60){
      return 'F';
    }
    if (score <= 69){
      return 'D';
    }
    if (score <= 79){
      return  'C';
    }
    if (score <= 89){
      return 'B';
    }
    return 'A';
  }

  /**
   * This method should take an ArrayList of strings,
   * remove all the elements in the array containing an even number of letters,
   * and then return the result.
   *
   * For example, if given an array of "Cat", "Dog", "Bird", the method should return an array containing only "Cat" and
   * "Dog".
   */
  /**
   * Given an array of words, remove all words that have an even number of letters
   * @param a {ArrayList} an array of random words
   * @return {ArrayList} an array of strings that have an odd number of letters
   */
  public ArrayList<String> removeEvenLength(ArrayList<String> a) {

    ArrayList<String> newArray = new ArrayList<String>();  //create new array to keep words
    int aLength = a.size() - 1;   //length of array

    for (int i=0; i <= aLength; i++){
      if ((a.get(i).length() % 2) != 0){
        newArray.add(a.get(i));
      }
    }

    return newArray;
  }


  /**
   * This method should take an double array, a, and return a new array containing the square of
   * each element in a.
   */
  /**
   * Given an array of numbers, return a new array with the square of each number
   * @param a {Double[]}
   * @return {Double[]} the square of each number in the given array
   */
  public double[] powerArray(double[] a) {

    double[] newA = new double[a.length];
    double holdNum;

    for (int i=0; i < a.length; i++){
      holdNum = Math.pow(a[i], 2);
      newA[i] = Double.parseDouble(String.format("%.2f", holdNum));
    }

    return newA;
  }

  /**
   * This method should take an int array, a, and return the index of the element with the greatest
   * value.
   */
  /**
   * Given an array of numbers, return the Number of the index that has the greatest value
   * @param a {Array} an array of numbers
   * @return {Integer} number indicating the location of the greatest number, returns -1 for empty array
   */
  public int indexOfMax(int[] a) {

    int index = -1;

    if (a.length == 0){
      return index;
    }

    int[] b = a.clone();
    Arrays.sort(b);
    int max = b[(b.length -1)];

    for (int i = 0; i < a.length; i++){
      if (a[i] == max){
        index = i;
      }
    }
    return index;
  }

  /**
   * This method should take an ArrayList of Integers, a, and returns true if all elements in the
   * array are divisible by the given int, i.
   */
  /**
   * Given an arrayList of numbers & a divisor, see if all the numbers in the list are divisible
   * @param a {ArrayList} an array of numbers
   * @param i {Integer} a number that is the divisor
   * @return {Boolean} true if all of the numbers in arrayList are divisible by divisor
   */
  public boolean isDivisibleBy(ArrayList<Integer> a, int i) {

    int divisor = i;
    int n = a.size() - 1;

    for (i = 0; i <= n; i++){
      if ((a.get(i) % divisor) != 0){
        return false;
      }
    }
    return true;
  }

  /**
   * A word is "abecedarian" if its letters appear in alphabetical order--the word 'biopsy' for
   * example. This method should take String s and return true if it is abecedarian.
   */
  /**
   * Given a string, check each letter and see they appear in ABC order
   * @param s {String}
   * @return {Boolean} true if letters are in abc order
   */
  public boolean isAbecedarian(String s) {

    char[] newS = s.toLowerCase().toCharArray();
    char[] sCharArray = s.toLowerCase().toCharArray();
    Arrays.sort(newS);

    if (Arrays.equals(newS,sCharArray)){
      return true;
    }
    return false;
  }

  /**
   * This method should take 2 strings and return true if they are anagrams of each other. For
   * example, "stop" is an anagram for "pots".
   */
  /**
   * Given two strings, check to see that the words are anagrams which means that they have the same number of letters and occurrences
   * @param s1 {String}
   * @param s2 {String}
   * @return {Boolean} true if the words contain the same letters and occurrences
   */
  public boolean areAnagrams(String s1, String s2) {

    if (s1.length() != s2.length()){
      return false;
    }

    char[] s1CharArray = s1.toLowerCase().toCharArray();
    char[] s2CharArray = s2.toLowerCase().toCharArray();
    Arrays.sort(s1CharArray);
    Arrays.sort(s2CharArray);

    if (Arrays.equals(s1CharArray,s2CharArray)){
      return true;
    }

    return false;
  }

  /**
   * This method should take a String and return the number of unique characters.
   * For example, if the method is given "noon", it should return a value of 2.
   */
  /**
   * Given a string, return count of unique letters in the string
   * @param s {String}
   * @return {Integer} count of unique letters in the string
   */
  public int countUniqueCharacters(String s) {

    char[] charArray = s.toCharArray();  //convert the string toCharArray

    char holdChar = '\0'; //init hold char to blank
    int uniqueCharCount = 0;

    Arrays.sort(charArray); //sort the array

    for (char c : charArray) {
      if (c != holdChar) {
        uniqueCharCount++;
        holdChar = c;
      }
    }
    return uniqueCharCount;
  }

  /**
   * This method should take a string and return true if it is a palindrome, i.e. it is spelled the
   * same forwards and backwards. For example, the words "racecar" and "madam" are palindromes.
   */
  /**
   * Given a string, test to see if it is a palindrome
   * @param s {String}
   * @return {Boolean} true if the word is the same word forwards & backwards
   */
  public boolean isPalindrome(String s) {

    int startChar = 0;
    int endChar = s.length() - 1;

    while (startChar < endChar){

      if (s.charAt(startChar) != s.charAt(endChar)){
        return false;
      }

      startChar++;
      endChar--;
    }

    return true;
  }

  /**
   * This method should take a string
   * and return a HashMap which is a map of characters to a list of their indices in a string
   * (i.e., which characters occur where in a string).
   * For example for the string "Hello World", the map would look something like: r=[7], d=[9], e=[1], W=[5], H=[0],
   * l=[2, 3, 8], o=[4, 6].
   */
  /**
   * Given a string, return a map of each letter with each having a list of all of their indices in the string
   * @param s {String}
   * @return {HashMap<String, ArrayList<Integer>} map of unique chars as key and a list of indices as value
   */
  public HashMap<String, ArrayList<Integer>> concordanceForString(String s) {

    HashMap<String, ArrayList<Integer>> sHashMap = new HashMap<>();
    s = s.replaceAll("\\s", ""); // remove all whitespace characters
    String sString;

    for (int i = 0; i < s.length(); i++) {

      sString = s.substring(i, i+1);
      if(sHashMap.get(sString) == null){
        sHashMap.put(sString, new ArrayList<>(i));
      }
      sHashMap.get(sString).add(i);
    }
    return sHashMap;
  }

}