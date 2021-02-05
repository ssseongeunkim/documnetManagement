/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.seong.pms;

import com.seong.pms.handler.ListMenuHandler;
import com.seong.pms.handler.WriteMenuHandler;
import com.seong.util.Prompt;

public class App {

  public static boolean company = true;

  public static void main(String[] args) {
    //    MemberHandler memberHandler = new MemberHandler();

    WriteMenuHandler writeHandler = new WriteMenuHandler();
    ListMenuHandler listHandler = new ListMenuHandler(writeHandler.memberHandler, writeHandler.paperHandler);
    //    UpdateHandler updateHandler = new UpdateHandler(writeHandler.memberHandler);


    while (company)
    {
      String menu = Prompt.inputString("[문서관리 시스템]\n1. 서류작성\n2. 서류목록\n3. 서류수정\n99. 종료\n> ");

      if (menu.equals("1"))
      {
        // 서류작성메뉴
        writeHandler.writeMenu();
      } else if (menu.equals("2")) 
      {
        // 서류목록
        if (writeHandler.paperHandler.paperList.exist())
        {
          Prompt.println("작성된 문서가 없습니다.");
          Prompt.println("");
          continue;
        }

        //        System.out.println("준비중입니다.");
        //        continue;
        listHandler.paperMenu();

      } else if (menu.equals("3"))
      {
        //        if (MemberHandler.members[0] == null)
        //        {
        //          Prompt.println("수정할 서류가 없습니다.");
        //          Prompt.println("");
        //          continue;
        //        }

        System.out.println("준비중입니다.");
        continue;
        //        updateHandler.service();

      } else if (menu.equals("99"))
      {
        // 종료
        Prompt.println("시스템을 종료합니다.");
        break;
      } else if (Prompt.inputCheck(menu))
      {
        Prompt.println("입력형식이 맞지 않습니다. 숫자만 입력해 주세요.");
      } else
      {
        Prompt.println("없는 메뉴 입니다. 다시 입력해주세요.");
      } // if

      Prompt.println("");
    } // while



    Prompt.close();
  } // main
}
