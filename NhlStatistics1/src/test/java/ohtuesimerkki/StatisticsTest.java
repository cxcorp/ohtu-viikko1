package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StatisticsTest {

    private Reader readerStub = () -> {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri",   "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));

        return players;
    };

    private Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchFindsPlayerWithExactName() {
        Player player = stats.search("Semenko");
        assertEquals("Semenko", player.getName());
        assertEquals("EDM", player.getTeam());
    }

    @Test
    public void searchFindsPlayerWithPartialName() {
        Player player = stats.search("Yzer");
        assertEquals("Yzerman", player.getName());
    }

    @Test
    public void searchDoesNotFindBogusPlayer() {
        Player player = stats.search("Luukkainen");
        assertNull(player);
    }

    @Test
    public void teamFindsMultiplePlayers() {
        List<Player> players = stats.team("EDM");

        assertEquals(3, players.size());
    }

    @Test
    public void teamFindsSinglePlayer() {
        List<Player> players = stats.team("PIT");

        assertEquals(1, players.size());
    }

    @Test
    public void teamFindsCorrectTeamPlayers() {
        List<Player> players = stats.team("EDM");

        for (Player player : players) {
            assertEquals("EDM", player.getTeam());
        }
    }

    @Test
    public void teamFindsNoPlayersOfBogusTeam() {
        List<Player> players = stats.team("LUKE");

        assertEquals(0, players.size());
    }

    @Test
    public void topScorersReturnsSinglePlayerCorrectly() {
        List<Player> players = stats.topScorers(1);

        assertEquals(1, players.size());
    }

    @Test
    public void topScorersReturnsAllPlayersCorrectly() {
        List<Player> players = stats.topScorers(5);

        assertEquals(5, players.size());
    }

    @Test
    public void topScorersReturnsNothingCorrectly() {
        List<Player> players = stats.topScorers(0);

        assertEquals(0, players.size());
    }

    @Test
    public void topScorersReturnsCorrectTopPlayer() {
        List<Player> players = stats.topScorers(1);

        assertEquals("Gretzky", players.get(0).getName());
    }

    @Test
    public void topScorersReturnsCorrectTopThree() {
        List<Player> players = stats.topScorers(3);

        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
        assertEquals("Yzerman", players.get(2).getName());
    }

    @Test(expected = NoSuchElementException.class)
    public void topScorersThrowsWhenAskingForMorePlayersThanProvided() {
        stats.topScorers(9001);
    }
}