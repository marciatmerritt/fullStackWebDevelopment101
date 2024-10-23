package io.catalyte.training;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogicProblemsImpl implements LogicProblems {

  /**
   * A V E R A G E: Given an array of integers (scores), return a double (average) to the nearest 2
   * decimal places. Return 0.00 for an empty array. All scores must be positive numbers.
   *
   * @param scores {Integer[]} an input of positive integer scores
   * @return {Double} returns the average scores rounded to 2 decimal places.
   **/
  @Override
  public Double average(int[] scores) {
    double total = 0.00;
    double result;
    if (scores.length == 0) {
      result = total;
    } else {
      double average;
      for (int score : scores) {
        if (score < 0) {
          throw new IllegalArgumentException("scores must be positive");
        } else {
          total += score;
        }
      }
      average = total / scores.length;
      result = Math.round(average * 100.0) / 100.0;
    }

    return result;
  }

  /**
   * L A S T  W O R D  L E N G T H: Given a string, return an integer to indicate the length of the
   * last word found in the string. Return 0 if the incoming string is just spaces. String cannot be
   * empty.
   *
   * @param text {String} an input of text
   * @return {Integer} integer indicating the length of the last word in the text
   **/
  @Override
  public int lastWordLength(String text) {
    int result = 0;

    if (text.isEmpty()) {
      throw new IllegalArgumentException("input must not be an empty string");
    }
    if (!text.equals(" ")) {//remove leading & trailing spaces in the phrase & find the last word
      String str = text.trim();
      str = str.substring(str.lastIndexOf(" ") + 1);
      result = str.length();
    }

    return result;
  }

  /**
   * D I S T I N C T  L A D D E R  P A T H S: Given an integer of ladder rungs, return a BigDecimal
   * number to indicate the number of distinct paths there are to reach the top of the ladder. If
   * there are 0 rungs, then return 0, does not allow for any negative integers to be entered.
   *
   * @param rungs {Integer} number of ladder rungs
   * @return {BigDecimal} number of distinct paths to reach top of ladder
   **/
  @Override
  public BigDecimal distinctLadderPaths(int rungs) {
    BigDecimal result;

    if (rungs < 0) {
      throw new IllegalArgumentException("ladders can't have negative rungs");
    }
    if (rungs <= 3) {
      result = new BigDecimal(rungs);
    } else {
      BigDecimal[] paths = new BigDecimal[rungs + 1];
      paths[0] = BigDecimal.valueOf(1);
      paths[1] = BigDecimal.valueOf(1);
      for (int i = 2; i <= rungs; i++) {
        paths[i] = paths[i - 1].add(paths[i - 2]);
      }
      result = paths[rungs];
    }

    return result;
  }

  /**
   * G R O U P  S T R I N G S: Given an array of strings, return a list of lists with each word
   * grouped together that start and end with the same letter. An empty array will just return an
   * empty array but there cannot be an empty string in the list.
   *
   * @param strs {String[]} an input array of strings
   * @return {List<List<String>>} a list of grouped strings with same 1st & last letters
   **/
  @Override
  public List<List<String>> groupStrings(String[] strs) {
    List<List<String>> result;

    List<List<String>> groupStrings = new ArrayList<>();
    if (strs != null && strs.length != 0) {
      HashMap<String, List<String>> firstLastLetterMap = new HashMap<>();
      char firstLetter, lastLetter;
      for (String string : strs) {

        if (string.isEmpty()) {
          throw new IllegalArgumentException("strings must not be empty");
        }

        string = string.toLowerCase().trim();
        firstLetter = string.charAt(0);
        lastLetter = string.charAt(string.length() - 1);
        String firstLastKey = String.valueOf(firstLetter + lastLetter); //key to the Hashmap

        List<String> firstLastValue;
        if (firstLastLetterMap.containsKey(firstLastKey)) {
          firstLastValue = firstLastLetterMap.get(firstLastKey);
        } else {
          firstLastValue = new ArrayList<>();
        }
        firstLastValue.add(string); //add word to the inner list
        firstLastLetterMap.put(firstLastKey, firstLastValue);
      }
      groupStrings.addAll(firstLastLetterMap.values());
    }
    result = groupStrings;

    return result;
  }
}