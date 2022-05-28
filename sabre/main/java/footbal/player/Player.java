/* Copyright 2021 Sabre Holdings */
package footbal.player;

public class Player
{
    private final String name;
    private final PitchPosition pitchPosition;
    private final int distanceCovered;

    public Player(String name, PitchPosition pitchPosition, int distanceCovered)
    {
        this.name = name;
        this.pitchPosition = pitchPosition;
        this.distanceCovered = distanceCovered;
    }

    public String getName()
    {
        return name;
    }

    public PitchPosition getPitchPosition()
    {
        return pitchPosition;
    }

    public int getDistanceCovered()
    {
        return distanceCovered;
    }
}
