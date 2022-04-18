package com.agentred.lessons.lesson8.competitions.obstruction;

import com.agentred.lessons.lesson8.competitions.participant.action.Running;
import com.agentred.lessons.lesson8.competitions.participant.action.TakingPart;

public class Track implements Obstruction {

    private final int size;

    private Track() {
        size = 0;
    }

    public Track(int size) {
        this.size = size;
    }

    @Override
    public boolean checkResult(TakingPart takingPart) {
        if(takingPart instanceof Running) {
            return size < ((Running) takingPart).getDistanceSize();
        } else return false;
    }
}
