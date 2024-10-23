package io.catalyte.training;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogicProblemsImplTest {

  LogicProblemsImpl exercise;

  @BeforeEach
  public void init() {

    exercise = new LogicProblemsImpl();

  }

  @Test
  @DisplayName("Test average() when array contains all positive integers")
  public void getAverageHandlesPositiveArray() {

    int[] scores = {1, 4, 2};
    double result = exercise.average(scores);
    double expected = 2.33;

    assertEquals(expected, result,
        () -> "Wrong score was given. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test average() when array has only one integer")
  public void getAverageHandlesSingletonArray() {

    int[] scores = {10};
    double result = exercise.average(scores);
    double expected = 10.00;

    assertEquals(expected, result,
        () -> "Wrong score was given. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test average() when array has only one integer that equals zero")
  public void getAverageHandlesSingletonArrayOfZero() {

    int[] scores = {0};
    double result = exercise.average(scores);
    double expected = 0.00;

    assertEquals(expected, result,
        () -> "Wrong score was given. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test average() when array is empty")
  public void getAverageHandlesEmptyArray() {

    int[] scores = {};
    double result = exercise.average(scores);
    double expected = 0.00;

    assertEquals(expected, result,
        () -> "Wrong score was given. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test for Exception Message when average() input has negative integer")
  public void getAverageHandlesNegativeArrayByThrowingException() {

    int[] scores = {10, -1, 2};
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> exercise.average(scores));

    String expectedMessage = "scores must be positive";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }


  @Test
  @DisplayName("Test lastWordLength() with valid entry")
  public void getLastWordLength() {

    String str = "test this string";
    int expected = 6;
    int result = exercise.lastWordLength(str);

    assertEquals(expected, result,
        () -> "Wrong string length found. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test lastWordLength() with only ONE word")
  public void getLastWordLengthWithOneWord() {

    String str = "H ";
    int expected = 1;
    int result = exercise.lastWordLength(str);

    assertEquals(expected, result,
        () -> "Wrong string length found. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test lastWordLength() with only WHITE Space")
  public void getLastWordLengthWithOnlyWhiteSpace() {

    String str = " ";
    int expected = 0;
    int result = exercise.lastWordLength(str);

    assertEquals(expected, result,
        () -> "Wrong number of unique characters found. Expected: " + expected + ". Got: "
            + result);
  }

  @Test
  @DisplayName("Test lastWordLength() with only an EMPTY String")
  public void getLastWordLengthWithEmptyString() {

    String str = "";
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> exercise.lastWordLength(str));

    String expectedMessage = "input must not be an empty string";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  @DisplayName("Test distinctLadderPaths() with small integer")
  public void getDistinctLadderPathsSmallInteger() {

    int rungs = 3;
    BigDecimal expected = new BigDecimal(3);
    BigDecimal result = exercise.distinctLadderPaths(rungs);

    assertEquals(expected, result,
        () -> "Wrong number of paths found. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test distinctLadderPaths() with large integer")
  public void getDistinctLadderPathsWith100Rungs() {

    int rungs = 100;
    BigDecimal expected = new BigDecimal("573147844013817084101");
    BigDecimal result = exercise.distinctLadderPaths(rungs);

    assertEquals(expected, result,
        () -> "Wrong number of paths found. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test distinctLadderPaths() with Zero")
  public void getDistinctLadderPathsWithZeroRungs() {

    int rungs = 0;
    BigDecimal expected = new BigDecimal(0);
    BigDecimal result = exercise.distinctLadderPaths(rungs);

    assertEquals(expected, result,
        () -> "Wrong number of paths found. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test distinctLadderPaths() with Negative integer")
  public void getDistinctLadderPathsWithNegativeInt() {

    int rungs = -1;
    assertThrows(IllegalArgumentException.class, () -> exercise.distinctLadderPaths(rungs),
        "IllegalArgumentException was expected");
  }

  @Test
  @DisplayName("Test groupStrings() with Empty Array")
  public void getGroupStringsWithSingletonArray() {

    String[] str = {"Freedom"};
    List<List<String>> result = exercise.groupStrings(str);
    List<List<String>> expected = new ArrayList<>();
    expected.add(new ArrayList<>(List.of("freedom")));

    assertIterableEquals(expected, result,
        "The group strings list does not match. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test groupStrings() with Empty Array")
  public void getGroupStringsWithTwoWordArray() {

    String[] str = {"Free", "Palestine"};
    List<List<String>> result = exercise.groupStrings(str);
    List<List<String>> expected = new ArrayList<>();
    expected.add(new ArrayList<>(List.of("free")));
    expected.add(new ArrayList<>(List.of("palestine")));

    assertAll("The group strings list does not match",
        () -> assertEquals(expected.size(), result.size(),
            "Expected size: " + expected.size() + ". Got size: " + result.size()),
        () -> assertTrue(expected.containsAll(result),
            "Expected list: " + expected + ". Got list: " + result)
    );
  }

  @Test
  @DisplayName("Test groupStrings() with short valid group of strings")
  public void getGroupStringsValidation() {

    String[] str = {"arrange", "ace", "assert", "act"};
    List<List<String>> result = exercise.groupStrings(str);
    List<List<String>> expected = new ArrayList<>();
    expected.add(new ArrayList<>(Arrays.asList("assert", "act")));
    expected.add(new ArrayList<>(Arrays.asList("arrange", "ace")));

    assertAll("The group strings list does not match",
        () -> assertEquals(expected.size(), result.size(),
            "Expected size: " + expected.size() + ". Got size: " + result.size()),
        () -> assertTrue(expected.containsAll(result),
            "Expected list: " + expected + ". Got list: " + result)
    );
  }

  @Test
  @DisplayName("Test groupStrings() with long valid group of strings")
  public void getGroupStringsWithLongGroupStrings() {

    String[] str = {" Free", "ene ", " huh ", "NAN", "POP", "cease", "aba", "alga", "edge", "hash",
        "neon",
        "peep", "pimp", "noon", "fire"};
    List<List<String>> result = exercise.groupStrings(str);
    List<List<String>> expected = new ArrayList<>();
    expected.add(new ArrayList<>(List.of("cease")));
    expected.add(new ArrayList<>(Arrays.asList("free", "fire")));
    expected.add(new ArrayList<>(Arrays.asList("aba", "alga")));
    expected.add(new ArrayList<>(Arrays.asList("huh", "hash")));
    expected.add(new ArrayList<>(Arrays.asList("ene", "edge")));
    expected.add(new ArrayList<>(Arrays.asList("nan", "neon", "noon")));
    expected.add(new ArrayList<>(Arrays.asList("pop", "peep", "pimp")));

    assertAll("The group strings list does not match",
        () -> assertEquals(expected.size(), result.size(),
            "Expected size: " + expected.size() + ". Got size: " + result.size()),
        () -> assertTrue(expected.containsAll(result),
            "Expected list: " + expected + ". Got list: " + result)
    );
  }

  @Test
  @DisplayName("Test groupStrings() with Empty Array")
  public void getGroupStringsWithEmptyArray() {

    String[] str = {};
    List<List<String>> result = exercise.groupStrings(str);
    List<List<String>> expected = new ArrayList<>();

    assertIterableEquals(expected, result,
        "The group strings list does not match. Expected: " + expected + ". Got: " + result);
  }

  @Test
  @DisplayName("Test groupStrings() with array of Empty String Only")
  public void getGroupStringsWithOnlyEmptyString() {

    String[] str = {""};
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> exercise.groupStrings(str));

    String expectedMessage = "strings must not be empty";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  @DisplayName("Test groupStrings() with an array that contains an Empty String")
  public void getGroupStringsContainsEmptyString() {

    String[] str = {"act", "apt", "cat", "", "cot", "cut"};
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> exercise.groupStrings(str));

    String expectedMessage = "strings must not be empty";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

}
