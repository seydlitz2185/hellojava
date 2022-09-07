package src.castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String,Handler> handlers = new HashMap<String,Handler>();
    public Game() 
    {
        //handlers.put("go",new HandlerGO());
        handlers.put("bye",new HandlerBye(this));
        handlers.put("help",new HandlerHelp(this));
        handlers.put("go",new HandlerGO(this));
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom,tower;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        tower = new Room("哨塔");
        //	初始化房间的出口,使用接口提高扩展性
        outside.SetExit("east",lobby);
        outside.SetExit("south",study);
        outside.SetExit("west",pub);
        outside.SetExit("up",tower);
        tower.SetExit("down",outside);
        lobby.SetExit("west",outside);
        lobby.SetExit("up",pub);
        pub.SetExit("east",outside);
        pub.SetExit("down",pub);
        study.SetExit("north",outside);
        study.SetExit("east",bedroom);
        bedroom.SetExit("west",study);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令

    /*private*/public void goRoom(String direction)
    {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
	public void showPrompt(){
        System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }

    public void play(){
        Scanner in = new Scanner(System.in);
        while ( true ) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            //split是正则表达式分隔符，使用" "对字符串进行分割，存入String[] words中
            Handler handler = handlers.get(words[0]);
            //不能直接使用words[1]，如果你输入的是bye就只有words[0]，
            // 加一个判断，当字符串数组有两个以上再赋值并调用
            //以下代码可重用
            String value = "";
            if(words.length > 1)
                value = words[1];
            if(handler != null){//说明handler是有效的
                handler.doCmd(value);
                if(handler.isBye())
                        break;
            }

//            if ( words[0].equals("help") ) {
//                game.printHelp();
//            } else if (words[0].equals("go") ) {
//                game.goRoom(words[1]);
//            } else if ( words[0].equals("bye") ) {
//                break;
//            }
        }
    }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.printWelcome();
        game.play();
        
        System.out.println("感谢您的光临。再见！");
        in.close();
	}

}
