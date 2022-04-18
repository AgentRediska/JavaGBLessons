package com.agentred.lessons.lesson8.competitions;

import com.agentred.lessons.lesson8.competitions.obstruction.Obstruction;
import com.agentred.lessons.lesson8.competitions.participant.action.TakingPart;

public class Main {

    private static final TakingPart[] participants = new TakingPart[4];
    private static final Obstruction[] obstructions = new Obstruction[3];

    public static void main(String[] args) {
        startAction();
    }

    private static void startAction() {
        for (Obstruction obstruction : obstructions) {
            for (TakingPart participant : participants) {
                obstruction.checkResult(participant);
            }
        }
    }
}
