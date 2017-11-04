package rk.algos.codewars;

import org.junit.Test;

import rk.AlgoTestingBase;

import static org.junit.Assert.assertEquals;

public class TestAlphabetWars extends AlgoTestingBase {

    @Test
    public void SampleTests() {
        assertEquals("Right side wins!",   AlphabetWars.woLoLoooooo("z"));
        assertEquals("Left side wins!",    AlphabetWars.woLoLoooooo("tz"));
        assertEquals("Let's fight again!", AlphabetWars.woLoLoooooo("jbdt"));
        assertEquals("Right side wins!",   AlphabetWars.woLoLoooooo("jz"));
        assertEquals("Left side wins!",    AlphabetWars.woLoLoooooo("zt"));
        assertEquals("Right side wins!",   AlphabetWars.woLoLoooooo("sj"));
        assertEquals("Left side wins!",    AlphabetWars.woLoLoooooo("azt"));
        assertEquals("Right side wins!",   AlphabetWars.woLoLoooooo("tzj"));
        assertEquals("Left side wins!",    AlphabetWars.woLoLoooooo("wololooooo"));
        assertEquals("Let's fight again!", AlphabetWars.woLoLoooooo("zdqmwpbs"));
        assertEquals("Left side wins!",    AlphabetWars.woLoLoooooo("ztztztzs"));
    }
}
