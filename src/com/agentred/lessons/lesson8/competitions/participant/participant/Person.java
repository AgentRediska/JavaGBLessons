package com.agentred.lessons.lesson8.competitions.participant.participant;

import com.agentred.lessons.lesson8.competitions.participant.action.Jumping;
import com.agentred.lessons.lesson8.competitions.participant.action.Running;
import com.agentred.lessons.lesson8.competitions.participant.action.TakingPart;

public class Person implements TakingPart, Jumping, Running {

    final private int number;

    public Person(int number) {
        this.number = number;
    }

    @Override
    public int getJumpSize() {
        return 40;
    }

    @Override
    public int getDistanceSize() {
        return 100;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
