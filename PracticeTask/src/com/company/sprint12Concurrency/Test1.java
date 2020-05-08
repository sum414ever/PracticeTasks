package com.company.sprint12Concurrency;

import java.util.Objects;
import java.util.function.BinaryOperator;

//Implement class ParallelCalculator that will be able to execute an operation in parallel thread.
//    Use the implementation of Runnable for this.
//    Constructor of ParallelCalculator should take 3 parameters:
//    BinaryOperator<Integer> to define an operation that will be executed,
//    int operand1 and int operand2.
//    ParallelCalculator class should have not private int result field where the result of the operation will be written when it's executed
public class Test1 {


  public static void main(String[] args) {
    ParallelCalculator parallelCalculator = new ParallelCalculator((x1, x2) -> x1 + x2, 5,8);
    Thread th = new Thread(parallelCalculator);
    th.start();
    System.out.println(parallelCalculator.result);
  }
}

class ParallelCalculator implements Runnable{

  public int result;
  private BinaryOperator<Integer> bp;
  private int operand1;
  private int operand2;

  public ParallelCalculator(BinaryOperator<Integer> bp, int operand1, int operand2) {
    this.bp = bp;
    this.operand1 = operand1;
    this.operand2 = operand2;
  }

  @Override
  public void run() {
    result = bp.apply(operand1,operand2);
  }
}

