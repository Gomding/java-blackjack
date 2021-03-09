package blackjack.domain;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Players;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class BlackjackManager {

    private static final int DEFAULT_COUNT = 0;
    private static final int DEFAULT_RECEIVE_COUNT = 2;

    private BlackjackManager() {
    }

    public static void initGame(Players players, Dealer dealer) {
        dealer.initDealerHand(DEFAULT_RECEIVE_COUNT);
        players.initHandByDealer(dealer, DEFAULT_RECEIVE_COUNT);
    }

    public static GameResultDto getGameResult(Dealer dealer, Players players) {
        Map<String, GameResult> playerResult = getPlayersResult(dealer, players);
        return new GameResultDto(playerResult, getDealerResult(playerResult));
    }

    private static Map<String, GameResult> getPlayersResult(Dealer dealer, Players players) {
        Map<String, GameResult> playersResult = new HashMap<>();
        players.toList()
                .forEach(player -> playersResult.put(player.getName(), GameResult.judgeHand(
                        dealer.getTotalScore(), player.getTotalScore())));
        return playersResult;
    }

    private static Map<GameResult, Integer> getDealerResult(Map<String, GameResult> playerResult) {
        Map<GameResult, Integer> dealerResult = new EnumMap<>(GameResult.class);
        Arrays.asList(GameResult.values()).forEach(value -> dealerResult.put(value, DEFAULT_COUNT));
        playerResult.values()
                .forEach(result -> dealerResult.computeIfPresent(GameResult.reverseResult(result),
                        ((gameResult, count) -> ++count)));
        return dealerResult;
    }
}
