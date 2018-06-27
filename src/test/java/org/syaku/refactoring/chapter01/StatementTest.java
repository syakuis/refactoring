package org.syaku.refactoring.chapter01;

import org.junit.Test;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
public class StatementTest {
  @Test
  public void test() {
    Customer customer = new Customer("굿맨");
    System.out.println(customer.statement());
  }
}
