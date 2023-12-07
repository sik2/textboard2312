package org.example.wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    WiseSayingService () {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public int create (String content, String author) {
        return this.wiseSayingRepository.create(content, author);
    }

    public List<WiseSaying> findByAll() {
        return this.wiseSayingRepository.findByAll();
    }

    public void delete (WiseSaying ws) {
        this.wiseSayingRepository.delete(ws);
    }
    public void modify (WiseSaying ws, String content, String author) {
        this.wiseSayingRepository.modify(ws, content, author);
    }

    public WiseSaying getFindById(int id) {
        return this.wiseSayingRepository.getFindById(id);
    }
}
