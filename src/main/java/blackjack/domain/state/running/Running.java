package blackjack.domain.state.running;

import blackjack.domain.state.Started;
import blackjack.domain.state.hand.Hand;

public abstract class Running extends Started {

    protected Running(final Hand hand) {
        super(hand);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(final double money) {
        throw new UnsupportedOperationException();
    }

}
