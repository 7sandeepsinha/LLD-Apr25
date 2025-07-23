package Projects.TicTacToe.service.botPlayingStrategy;

import Projects.TicTacToe.model.constants.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        //TODO : create switch case based strategy object creation and return
        return new RandomBotPlayingStrategy();
    }
}
