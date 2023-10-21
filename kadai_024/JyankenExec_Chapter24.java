package kadai_024;

public class JyankenExec_Chapter24 {
  public static void main(String[] args) {
    Jyanken_Chapter24 game = new Jyanken_Chapter24();
    String myChoice = game.getMyChoice();
    String choice = game.getRandom();
    
    game.playGame(myChoice, choice);
  }
}
