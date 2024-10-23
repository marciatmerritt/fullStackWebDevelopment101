package com.catalyte.training.monkeytesting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonkeyTest {

  MonkeyTrouble exercise;

  @BeforeEach
  public void init() {

    exercise = new MonkeyTrouble();

  }
  //When both monkeys are smiling, return true
  @Test
  public void getBothMonkeysAreSmiling() {

    boolean aSmile = true;
    boolean bSmile = true;

    boolean result = exercise.monkeyTrouble(aSmile, bSmile);

    assertTrue(result, () -> "Wrong result was given. Got: " + result);

  }
  //When both monkeys are not smiling, return true
  @Test
  public void getBothMonkeysAreNOTSmiling() {

    boolean aSmile = false;
    boolean bSmile = false;

    boolean result = exercise.monkeyTrouble(aSmile, bSmile);

    assertTrue(result, () -> "Wrong result was given. Got: " + result);

  }
  //when only 1 monkey is smiling and 1 is not smiling, return false
  @Test
  public void getMonkeyAIsSmiling() {

    boolean aSmile = true;
    boolean bSmile = false;

    boolean result = exercise.monkeyTrouble(aSmile, bSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }

  @Test
  public void getMonkeyBIsSmiling() {

    boolean aSmile = false;
    boolean bSmile = true;

    boolean result = exercise.monkeyTrouble(aSmile, bSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getThreeMonkeysAreSmiling() {

    boolean aSmile = true;
    boolean bSmile = true;
    boolean cSmile = true;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertTrue(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getThreeMonkeysAreNOTSmiling() {

    boolean aSmile = false;
    boolean bSmile = false;
    boolean cSmile = false;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertTrue(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getOnlyMonkeyAIsSmiling() {

    boolean aSmile = true;
    boolean bSmile = false;
    boolean cSmile = false;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getOnlyMonkeyBIsSmiling() {

    boolean aSmile = false;
    boolean bSmile = true;
    boolean cSmile = false;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getOnlyMonkeyCIsSmiling() {

    boolean aSmile = false;
    boolean bSmile = false;
    boolean cSmile = true;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getMonkeyABAreSmiling() {

    boolean aSmile = true;
    boolean bSmile = true;
    boolean cSmile = false;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getMonkeyACAreSmiling() {

    boolean aSmile = true;
    boolean bSmile = false;
    boolean cSmile = true;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }
  @Test
  public void getMonkeyBCAreSmiling() {

    boolean aSmile = false;
    boolean bSmile = true;
    boolean cSmile = true;

    boolean result = exercise.monkeyTroubleThree(aSmile, bSmile, cSmile);

    assertFalse(result, () -> "Wrong result was given. Got: " + result);

  }
}