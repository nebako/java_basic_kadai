package kadai_024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Jyanken_Chapter24 {
  public Map<String, String> map;
  public List<String> choices;

  public Jyanken_Chapter24() {
    choices = new ArrayList<>();
    choices.add("r");
    choices.add("s");
    choices.add("p");
    map = new HashMap<>();
    map.put("r", "グー");
    map.put("s", "チョキ");
    map.put("p", "パー");
  }

  public String getMyChoice() {
    System.out.println("自分のじゃんけんの手を入力しましょう");
    System.out.println("グーはrockのrを入力しましょう");
    System.out.println("チョキはscissorsのsを入力しましょう");
    System.out.println("パーはpaperのpを入力しましょう");
    Scanner s = new Scanner(System.in);
    String myChoice = s.nextLine();
    if (!(myChoice.equals("r") || myChoice.equals("s") || myChoice.equals("p"))) {
      System.out.println("入力は不正です");
      myChoice = this.getMyChoice();
    }
    s.close();
    return myChoice;
  }

  public String getRandom() {
    int random = (int) Math.floor(Math.random() * 3);
    String choice = choices.get(random);
    return choice;
  }

  public void playGame(String myChoice, String choice) {
    System.out.println("自分の手は" + map.get(myChoice) + ",対戦相手の手は" + map.get(choice));
    if ((myChoice.equals("r") && choice.equals("s")) || (myChoice.equals("s") && choice.equals("p")) || (myChoice.equals("p") && choice.equals("r"))) {
      System.out.println("自分の勝ちです。");
    } else if ((myChoice.equals("r") && choice.equals("p")) || (myChoice.equals("s") && choice.equals("r")) || (myChoice.equals("p") && choice.equals("s"))) {
      System.out.println("自分の負けです");
    } else if ((myChoice.equals("r") && choice.equals("r")) || (myChoice.equals("s") && choice.equals("s")) || (myChoice.equals("p") && choice.equals("p"))) {
      System.out.println("あいこです");
    }

  }
}
