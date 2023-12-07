package org.example.wiseSaying;

import org.example.Container;
import org.example.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    WiseSayingService wiseSayingService;

    public WiseSayingController () {
        this.wiseSayingService = new WiseSayingService();
    }

    public void create () {
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine().trim();

        int id = this.wiseSayingService.create(content, author);

        System.out.println(id + "번 명언이 등록 되었습니다.");
    }

    public void list () {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayingList = this.wiseSayingService.findByAll();

        for (WiseSaying ws : wiseSayingList) {
            System.out.println(ws.getId() + " / " + ws.getContent() + " / " + ws.getAuthor());
        }
    }

    public void delete(Request request) {

        int id = _getIntParam(request.getParams("id"));

        if (id == -1) {
            return;
        }

        WiseSaying ws = this.wiseSayingService.getFindById(id);

        if (ws == null) {
            System.out.println(id+"번 명언은 존재하지 않습니다.");
            return;
        }

        this.wiseSayingService.delete(ws);


        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    private int _getIntParam (String id) {
        int defaultValue = -1;
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("id는 정수만 입력이 가능합니다.");
            return defaultValue;
        }
    }

    public void modify(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if (id == -1) {
            return;
        }

        WiseSaying ws = this.wiseSayingService.getFindById(id);

        if (ws == null) {
            System.out.println(id+"번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("기존명언:" + ws.getContent());
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine();

        System.out.println("기존작가:" + ws.getAuthor());
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine();

        this.wiseSayingService.modify(ws, content, author);

        System.out.println(id + "번 명언이 수정 되었습니다.");

    }
}
