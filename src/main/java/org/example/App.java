package org.example;

import org.example.System.SystemController;
import org.example.wiseSaying.WiseSayingController;


public class App {
    SystemController systemController;
    WiseSayingController wiseSayingController;

    App () {
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController();
    }
    void run () {
        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령)");
            String command = Container.getSc().nextLine().trim();
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.create();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            }
        }

    }
}
