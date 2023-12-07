package org.example.wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int lastId = 1;

    public int create (String content, String author) {
        WiseSaying ws = new WiseSaying(lastId, content, author);

        wiseSayingList.add(ws);
        lastId++;

        return ws.getId();
    }

    public List<WiseSaying> findByAll() {
        return wiseSayingList;
    }

    public void delete (WiseSaying ws) {
        wiseSayingList.remove(ws);
    }
    public void modify (WiseSaying ws, String content, String author) {
        ws.setAuthor(author);
        ws.setContent(content);
    }

    public WiseSaying getFindById(int id) {
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == id) {
                return wiseSayingList.get(i);
            }
        }
        return null;
    }
}
