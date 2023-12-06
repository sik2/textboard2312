package org.example;

import org.example.System.SystemController;
import org.example.wiseSaying.WiseSayingController;

import java.util.HashMap;
import java.util.Map;


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
            Request request = new Request(command);

            switch (request.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.create();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(request);
                    break;
                case "수정":
                    wiseSayingController.modify(request);
                    break;
            }
        }

    }
}
