/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.seong.pms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int SIZE = 5;

    boolean company = true;
    int turn = 0; // 배열인덱스
    int employeeNo = 0; // 사번
    int userChoice = 0;

    int[] id = new int[SIZE]; // 직원번호
    String[] name = new String[SIZE]; // 직원이름
    int[] age = new int[SIZE]; // 직원나이
    String[] department = new String[SIZE]; // 부서
    Date[] joinDate = new Date[SIZE]; // 입사날짜
    String[] holiday = new String[SIZE]; // 휴가종류
    Date[] startDate = new Date[SIZE]; // 휴가시작날짜
    Date[] endDate = new Date[SIZE]; // 휴가끝나는날짜
    String[] holidayReason = new String[SIZE]; // 휴가사유
    String[] holidayApproval = new String[SIZE]; // 휴가승인여부
    Date[] outDate = new Date[SIZE]; // 퇴사날짜
    String[] outReason = new String[SIZE]; // 퇴사사유
    String[] outApproval = new String[SIZE]; // 퇴사승인여부

    for (int i = 0; i < SIZE; i++)
    {
      holidayApproval[i] = "미승인";
      outApproval[i] = "미승인";
    }


    while (company)
    {
      System.out.println("[문서관리 시스템]");

      System.out.println("1. 서류작성");
      System.out.println("2. 서류목록");
      System.out.println("99. 종료");
      System.out.print("> ");
      int menu = scanner.nextInt();

      if (menu == 1)
      {
        // 서류작성
        boolean write = true;

        while (write)
        {
          System.out.println();
          System.out.println("=> 서류작성 메뉴입니다. <=");
          System.out.println("1. 직원정보");
          System.out.println("2. 휴가신청서");
          System.out.println("3. 사직서");
          System.out.println("0. 뒤로가기");
          System.out.println("99. 종료");
          System.out.print("> ");
          menu = scanner.nextInt();
          scanner.nextLine();

          if (menu == 1)
          {
            // 회사원 정보 입력
            if (turn == SIZE)
            {
              System.out.println("입력란이 없어 더이상 추가입력이 불가능합니다.");
              continue;
            }

            id[turn] = ++employeeNo;

            System.out.print("이름> ");
            name[turn] = scanner.nextLine();

            System.out.print("나이> ");
            age[turn] = scanner.nextInt();
            scanner.nextLine();

            System.out.print("입사날짜(yyyy-MM-dd)> ");
            joinDate[turn] = Date.valueOf(scanner.nextLine());

            while (true)
            {
              System.out.print("부서(1. 개발팀 2. 디자인팀 3. 마케팅팀)> ");
              userChoice = scanner.nextInt();

              switch(userChoice)
              {
                case 1 :
                  department[turn] = "개발팀";
                  break;
                case 2 :
                  department[turn] = "디자인팀";
                  break;
                case 3 :
                  department[turn] = "마케팅팀";
                  break;
                default :
                  System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
                  System.out.println();
              } // switch

              if (1 <= menu && menu <= 3)
              {
                break;
              }

            } // while

            System.out.printf("%s직원의 정보가 입력되었습니다.\n", name[turn]);

            turn++;
          } else if (menu == 2 || menu == 3)
          {
            // 휴가신청서, 사직서
            while (true)
            {
              if (name[0] == null)
              {
                System.out.println("저장된 직원이 없습니다. 직원의 정보를 먼저 입력해주세요.");
                break;
              }

              System.out.println();
              System.out.println("문서를 작성할 직원의 사번 또는 이름을 입력해주세요.");
              for (int i = 0; i < turn; i++)
              {
                // 입력된 직원 보여주기
                System.out.printf("%d. %s\n", id[i], name[i]);
              }
              System.out.println("0. 뒤로가기");
              System.out.println("99. 종료");
              System.out.print("> ");
              String valuse = scanner.nextLine();

              if (valuse.equals("0"))
              {
                // 뒤로가기
                System.out.println("뒤로갑니다.");
                break;
              } else if (valuse.equals("99"))
              {
                // 종료
                System.out.println("시스템을 종료합니다.");
                write = false; // 서류작성 while 종료
                company = false; // 시스템 while 종료
                break;
              } // if

              // 사용자가 입력한 직원의 존재여부 확인을 위한 변수(있으면 1, 없으면 0)
              int check = 0;

              for (int i = 0; i < turn; i++)
              {
                // 해당 직원이 있는지 검사
                if (valuse.equalsIgnoreCase(name[i]) || valuse.equals((i+1) + ""))
                {
                  // 해당 직원이 있을 때
                  if (menu == 2)
                  {
                    // 휴가신청서 
                    System.out.println();
                    System.out.print("휴가종류(1. 연차 2. 반차 3. 병가 4. 경조)> ");
                    userChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (userChoice)
                    {
                      case 1 :
                        holiday[i] = "연차";
                        break;
                      case 2 :
                        holiday[i] = "반차";
                        break;
                      case 3 :
                        holiday[i] = "병가";
                        break;
                      case 4 :
                        holiday[i] = "경조";
                        break;
                      default :
                        System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
                        System.out.println();
                        i--;
                        continue;
                    } // switch

                    System.out.print("휴가 시작 날짜(yyyy-MM-dd)> ");
                    startDate[i] = Date.valueOf(scanner.nextLine());

                    System.out.print("휴가 마지막 날짜(yyyy-MM-dd)> ");
                    endDate[i] = Date.valueOf(scanner.nextLine());

                    System.out.print("사유> ");
                    holidayReason[i] = scanner.nextLine();

                    holidayApproval[i] = "미승인";

                    System.out.printf("%s직원의 휴가신청서가 작성되었습니다.\n", name[i]);

                  } else 
                  {
                    // 사직서
                    System.out.println();
                    System.out.print("퇴사날짜(yyyy-MM-dd)> ");
                    outDate[i] = Date.valueOf(scanner.nextLine());

                    System.out.print("퇴사사유> ");
                    outReason[i] = scanner.nextLine();

                    outApproval[i] = "미승인";

                    System.out.printf("%s직원의 사직서가 작성되었습니다.\n", name[i]);

                  }

                  check = 1;
                  break;
                } // if
              } // for

              if (check == 0)
              {
                System.out.println("없는 직원입니다. 다시 입력해주세요.");
                continue; // 현재 while 문을 반복하기 위해 아래 break를 건너뜀
              } // if

              break;
            } // while

          } else if (menu == 0)
          {
            // 뒤로가기
            System.out.println("뒤로갑니다.");
            break;
          } else if (menu == 99)
          {
            // 종료
            System.out.println("시스템을 종료합니다.");
            company = false; // 시스템 while 종료
            break;
          } else
          {
            System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
          } // if
        } // while
      } else if (menu == 2)
      {
        // 서류목록
        if (name[0] == null)
        {
          System.out.println("작성된 문서가 없습니다.");
          System.out.println();
          continue;
        }

        while(true)
        {
          System.out.println();
          System.out.println("=> 서류목록 메뉴입니다. <=");
          System.out.println("1. 모든 문서 List");
          System.out.println("2. 승인 된 문서 List");
          System.out.println("3. 미승인 문서 List");
          System.out.println("0. 뒤로가기");
          System.out.println("99. 종료");
          System.out.print("> ");
          menu = scanner.nextInt();
          scanner.nextLine();

          if (menu == 1)
          {
            // 모든 문서 리스트
            System.out.println();
            System.out.println("= 모든 문서 List =");

            for (int i = 0; i < turn; i++)
            {
              if (name[i] != null)
              {
                System.out.printf("- %s(%d)직원의 정보\n", name[i], id[i]);

                if (holidayReason[i] != null)
                {
                  System.out.printf("- %s(%d)직원의 휴가신청서\n", name[i], id[i]);
                } // if

                if (outReason[i] != null)
                {
                  System.out.printf("- %s(%d)직원의 사직서\n", name[i], id[i]);
                } // if
              } // if
            } // for
          } else if (menu == 2)
          {
            // 승인 된 문서 리스트
            int check = 0;

            for (int i = 0; i < turn; i++)
            {
              if (holidayApproval[i].equals("미승인") && outApproval[i].equals("미승인"))
              {
                // 휴가신청서와 사직서의 승인여부가 '미승인'일때
                check++;
              } // if

            } // for

            if (check == turn)
            {
              System.out.println("승인된 문서가 없습니다.");
              continue;
            }

            System.out.println();
            System.out.println("= 승인 된 문서 List =");

            for (int i = 0; i < turn; i++)
            {
              if (holidayApproval[i].equals("승인"))
              {
                System.out.printf("- %s(%d)직원의 휴가신청서\n", name[i], id[i]);
              } // if

              if (outApproval[i].equals("승인"))
              {
                System.out.printf("- %s(%d)직원의 사직서\n", name[i], id[i]);
              } // if
            } // for

          } else if (menu == 3)
          {
            // 미승인 문서 리스트
            int check = 0;

            for (int i = 0; i < turn; i++)
            {
              if (holidayReason[i] == null && holidayApproval[i].equals("미승인")
                  && outReason[i] == null && outApproval[i].equals("미승인"))
              {
                check++;
              }

              if (holidayReason[i] != null && holidayApproval[i].equals("승인")
                  && outReason[i] != null && outApproval[i].equals("승인"))
              {
                check++;
              }

            } // for

            if (check >= turn)
            {
              System.out.println("승인할 문서가 없습니다.");
              continue;
            }

            while(true)
            {
              System.out.println();
              System.out.println("= 미승인 문서 List =");

              for (int i = 0; i < turn; i++)
              {
                if (holidayReason[i] != null && holidayApproval[i].equals("미승인"))
                {
                  System.out.printf("- %s(%d)직원의 휴가신청서\n", name[i], id[i]);
                } // if

                if (outReason[i] != null &&  outApproval[i].equals("미승인"))
                {
                  System.out.printf("- %s(%d)직원의 사직서\n", name[i], id[i]);
                } // if
              } // for

              System.out.print("승인할 문서의 작성자 사번 또는 이름을 입력하세요.> ");
              String valuse = scanner.nextLine();

              int holidayCheck = 0;
              int outCheck = 0;
              int index = 0;

              System.out.println();

              for (int i = 0; i < turn; i++)
              {
                // 해당 직원이 있는지 검사
                if ((valuse.equalsIgnoreCase(name[i]) && holidayReason[i] != null && holidayApproval[i].equals("미승인"))
                    || (valuse.equals((i+1) + "") && holidayReason[i] != null && holidayApproval[i].equals("미승인")))
                {
                  // 해당 직원이 있고, 미승인된 휴가신청서가 있을 때
                  System.out.println(name[i] + "직원이 입력한 [휴가신청서]가 있습니다.");

                  check++;
                  holidayCheck++;
                  index = i;
                } // if

                if ((valuse.equalsIgnoreCase(name[i]) && outReason[i] != null && outApproval[i].equals("미승인"))
                    || (valuse.equals((i+1) + "") && outReason[i] != null && outApproval[i].equals("미승인")))
                {
                  // 해당 직원이 있고, 미승인된 사직서가 있을 때
                  System.out.println(name[i] + "직원이 입력한 [사직서]가 있습니다.");

                  check++;
                  outCheck++;
                  index = i;
                } // if
              } // for

              if (check == 0)
              {
                System.out.println("없는 결과입니다. 다시 입력해주세요.");
                continue;
              } // if

              while(true)
              {
                if (holidayCheck > 0 && outCheck > 0)
                {
                  // 휴가신청서와 사직서 모두 있는 경우
                  System.out.print("확인 할 문서를 선택하세요.(1. 휴가신청서 2. 사직서)> ");
                  userChoice = scanner.nextInt();
                  scanner.nextLine();

                  if (userChoice == 1)
                  {
                    // 휴가신청서 승인 할 때
                    System.out.println("--------------------------------------------------------");
                    System.out.println("[휴가신서]");
                    System.out.printf("사번 : %d\n", id[index]);
                    System.out.printf("서명 : %s\n", name[index]);
                    System.out.printf("부서 : %s\n", department[index]);
                    System.out.printf("휴가종류 : %s\n", holiday[index]);
                    System.out.printf("휴가날짜 : %s ~ %s\n", startDate[index], endDate[index]);
                    System.out.printf("상기 %s(본인)은 %s로 인하여 휴가신청서를 제출하오니\n"
                        + "허락하여 주시기 바랍니다.\n", name[index], holidayReason[index]);
                    System.out.printf("[승인여부] : %s\n", holidayApproval[index]);
                    System.out.println("--------------------------------------------------------");
                    System.out.print("휴가신청을 승인하시겠습니까? (y/N)> ");
                    String answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("y"))
                    {
                      System.out.println("승인하셨습니다.");
                      holidayApproval[index] = "승인";
                    } else
                    {
                      System.out.println("미승인하셨습니다.");
                    }


                  } else if (userChoice == 2)
                  {
                    // 사직서 신청할 떄
                    System.out.println("--------------------------------------------------------");
                    System.out.println("[사직서]");
                    System.out.printf("사번 : %d\n", id[index]);
                    System.out.printf("서명 : %s\n", name[index]);
                    System.out.printf("부서 : %s\n", department[index]);
                    System.out.printf("입사날짜 : %s\n", joinDate[index]);
                    System.out.printf("퇴사날짜 : %s\n", outDate[index]);
                    System.out.printf("상기 %s(본인)은 %s로 인하여 사직서를 제출하오니\n"
                        + "허락하여 주시기 바랍니다.\n", name[index], outReason[index]);
                    System.out.printf("[승인여부] : %s\n", outApproval[index]);
                    System.out.println("--------------------------------------------------------");
                    System.out.print("사직서를 승인하시겠습니까? (y/N)> ");
                    String answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("y"))
                    {
                      System.out.println("승인하셨습니다.");
                      outApproval[index] = "승인";
                    } else
                    {
                      System.out.println("미승인하셨습니다.");
                    }


                  } else
                  {
                    System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
                  }

                } else if (holidayCheck > 0)
                {
                  // 휴가신청서만 있을 경우
                  System.out.print("[휴가신청서]를 확인하시겠습니까? (y/N)> ");
                  String answer = scanner.nextLine();

                  if (answer.equalsIgnoreCase("y"))
                  {
                    // 휴가신청서 승인 할 때
                    System.out.println("--------------------------------------------------------");
                    System.out.println("[휴가신청서]");
                    System.out.printf("사번 : %d\n", id[index]);
                    System.out.printf("서명 : %s\n", name[index]);
                    System.out.printf("부서 : %s\n", department[index]);
                    System.out.printf("휴가종류 : %s\n", holiday[index]);
                    System.out.printf("휴가날짜 : %s ~ %s\n", startDate[index], endDate[index]);
                    System.out.printf("상기 %s(본인)은 %s로 인하여 휴가신청서를 제출하오니\n"
                        + "허락하여 주시기 바랍니다.\n", name[index], holidayReason[index]);
                    System.out.printf("[승인여부] : %s\n", holidayApproval[index]);
                    System.out.println("--------------------------------------------------------");
                    System.out.print("휴가신청을 승인하시겠습니까? (y/N)> ");
                    answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("y"))
                    {
                      System.out.println("승인하셨습니다.");
                      holidayApproval[index] = "승인";
                    } else
                    {
                      System.out.println("미승인하셨습니다.");
                    }
                  } else
                  {
                    System.out.println("휴가신청서를 확인하지 않습니다.");
                  }

                } else if (outCheck > 0)
                {
                  // 사직서만 있을 경우
                  System.out.print("[사직서]를 확인하시겠습니까? (y/N)> ");
                  String answer = scanner.nextLine();

                  if (answer.equalsIgnoreCase("y"))
                  {
                    // 사직서 승인 할 때
                    System.out.println("--------------------------------------------------------");
                    System.out.println("[사직서]");
                    System.out.printf("사번 : %d\n", id[index]);
                    System.out.printf("서명 : %s\n", name[index]);
                    System.out.printf("부서 : %s\n", department[index]);
                    System.out.printf("입사날짜 : %s\n", joinDate[index]);
                    System.out.printf("퇴사날짜 : %s\n", outDate[index]);
                    System.out.printf("상기 %s(본인)은 %s로 인하여 사직서를 제출하오니\n"
                        + "허락하여 주시기 바랍니다.\n", name[index], outReason[index]);
                    System.out.printf("[승인여부] : %s\n", outApproval[index]);
                    System.out.println("--------------------------------------------------------");
                    System.out.print("사직서를 승인하시겠습니까? (y/N)> ");
                    answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("y"))
                    {
                      System.out.println("승인하셨습니다.");
                      outApproval[index] = "승인";
                    } else
                    {
                      System.out.println("미승인하셨습니다.");
                    }
                  } else
                  {
                    System.out.println("사직서를 확인하지 않습니다.");
                  }

                } // if

                break;
              } // while

              break;

            } // while

          } else if (menu == 0)
          {
            System.out.println("뒤로갑니다.");
            break;
          } else if (menu == 99)
          {
            System.out.println("시스템을 종료합니다.");
            company = false;
            break;
          } else
          {
            System.out.println("없는 메뉴 입니다. 다시 입력해주세요."); 
          }
        } // while

      } else if (menu == 99)
      {
        // 종료
        System.out.println("시스템을 종료합니다.");
        break;
      } else
      {
        System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
      } // if

      System.out.println();
    } // while



    scanner.close();
  } // main
}
