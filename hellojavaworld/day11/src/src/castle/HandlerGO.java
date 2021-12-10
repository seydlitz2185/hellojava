package src.castle;

public class HandlerGO extends Handler{
    public HandlerGO(Game game) {
        super(game);
    }
    public void doCmd(String word){
        game.goRoom(word);
    }
}
