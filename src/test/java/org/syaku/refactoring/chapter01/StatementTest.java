package org.syaku.refactoring.chapter01;

import org.junit.Test;

/**
 * 1. 맛보기예제
 * closed statement 메서드 분해와 기능 재분배
 * closed 대여료 계산 메서드 옮기기
 * closed 적립 포인트 계산을 메서드로 빼기
 * closed 임시변수 없애기
 * todo 가격 책정 부분의 조건을 재정의로 교체
 * todo 마지막 단계, 상속 구조 만들기
 *
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
