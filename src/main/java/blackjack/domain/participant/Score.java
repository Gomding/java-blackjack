package blackjack.domain.participant;

import java.util.Objects;

public class Score {

    private static final int BLACKJACK = 21;
    private static final int TO_HARD_ACE = 10;
    private static final int DEALER_HIT_SCORE = 17;

    private final int value;

    public Score(final int value) {
        this.value = value;
    }

    public Score changeHardAce() {
        if (this.isBust()) {
            return new Score(this.value - TO_HARD_ACE);
        }
        return this;
    }

    public boolean compareTo(final Score score) {
        return this.value > score.value;
    }

    public boolean isBlackjack() {
        return this.value == BLACKJACK;
    }

    public boolean isBust() {
        return this.value > BLACKJACK;
    }

    public boolean isDealerStateStay() {
        return this.value >= DEALER_HIT_SCORE;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
