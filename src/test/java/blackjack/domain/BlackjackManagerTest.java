package blackjack.domain;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackManagerTest {

    private Players players;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        players = new Players(Arrays.asList("pobi", "jason"));
        dealer = new Dealer();
    }

    @Test
    @DisplayName("각 플레이어가 초기 2장씩 소지한다.")
    void testAllPlayersGetTwoCards() {
        BlackjackManager.initGame(players, dealer);

        assertThat(players.toList()
                .stream()
                .filter(player -> player.toHandList().size() == 2)
                .count())
                .isEqualTo(2);
    }
}
