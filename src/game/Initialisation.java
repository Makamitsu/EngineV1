package game;

import com.engine.core.components.ObjectManager;
import com.engine.core.fx.Image;
import com.engine.core.fx.ImageTile;
import game.core.Exit;
import game.core.Item;
import game.core.NPC;
import game.core.Room;
import game.dialog.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class creates and initialises all the objects in our game.
 * All the object are declared then all the items, then all the room
 * then all the NPC and exits
 * After all the elements(item/npc/exits) are added to their room
 *
 * At the end there is a getter for each initialised room.
 */
public class Initialisation {

    private Room tower,courtyard,kitchen,banquetHall,stock,throneHall,vestibule,stables;
    private Exit towerExit1,
            courtyardExit1,courtyardExit2,courtyardExit3,courtyardExit4,
            kitchenExit1,
            banquetHallExit1,banquetHallExit2,banquetHallExit3,
            stockExit1,
            throneHallExit1,
            vestibuleExit1,vestibuleExit2;
    private NPC unicorn,
            otis,
            villager1,villager2,villager3,villager4,
            chest1,chest2,chest3,chest4,
            commis,chief,saucier,
            guard1, guard2,
            council,queen, guardThr1, guardThr2,
            thief;
    private Item pass,
            key,
            flour,
            egg,
            milk,
            raspberry,
            blueberry,
            raspMuffin,
            blueMuffin;

    public Initialisation(){
        //The Rooms creation
        stables = new Room(new Image("/sprite/stables/back.png"));
        banquetHall = new Room(new Image("/sprite/banquetHall/back.png"));
        kitchen = new Room(new Image("/sprite/kitchen/back.png"));
        stock = new Room(new Image("/sprite/stock/back.png"));
        throneHall = new Room(new Image("/sprite/throneHall/back.png"));
        vestibule = new Room(new Image("/sprite/vestibule/back.png"));
        courtyard = new Room(new Image("/sprite/courtyard/back.png"));
        tower = new Room(new Image("/sprite/tower/back.png"));

        //The items initialisation
        pass = new Item(0,0,30,30,new ImageTile("/sprite/pass.png",30,30),"Pass",false,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a pass!"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a pass!"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a pass!"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a pass!"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a pass!"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a pass!"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a pass!"));
                            }}
                    );
                }}
        );

        key = new Item(0,0,30,30,new ImageTile("/sprite/key.png",30,30),"Key",false,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a key!"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a key!"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a key!"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a key!"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a key!"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a key!"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You found a key!"));
                            }}
                    );
                }}
        );
        flour = new Item(116,39,30,30,new ImageTile("/sprite/flour.png",30,30),"Flour",true,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a flour bag"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a flour bag"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a flour bag"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a flour bag"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageGiveObject("You found a flour bag:",flour));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a flour bag"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a flour bag"));
                            }}
                    );
                }}
                );

        flour.getDialog(GameState.FINDMUFFIN).get(0).setItem(flour);

        milk = new Item(107,180,30,30,new ImageTile("/sprite/milk.png",30,30),"Milk",true,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a milk bottle"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a milk bottle"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a milk bottle"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a milk bottle"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageGiveObject("You found a bottle of milk:",milk));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a milk bottle"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a milk bottle"));
                            }}
                    );
                }}
        );

        milk.getDialog(GameState.FINDMUFFIN).get(0).setItem(milk);

        egg = new Item(0,0,30,30,new ImageTile("/sprite/egg.png",30,30),"Egg",false,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is an egg"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is an egg"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is an egg"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is an egg"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is an egg"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is an egg"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a flour bag"));
                            }}
                    );
                }}
        );
        raspberry = new Item(0,0,30,30,new ImageTile("/sprite/raspberry.png",30,30),"Raspberries",false,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some raspberries"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some raspberries"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some raspberries"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some raspberries"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some raspberries"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some raspberries"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some raspberries"));
                            }}
                    );
                }}
        );
        blueberry = new Item(0,0,30,30,new ImageTile("/sprite/blueberry.png",30,30),"Blueberries",false,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some blueberries"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some blueberries"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some blueberries"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some blueberries"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some blueberries"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some blueberries"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This are some blueberries"));
                            }}
                    );
                }}
        );
        raspMuffin = new Item(0,0,30,30,new ImageTile("/sprite/rmuffin.png",30,30),"Raspberry muffin",false,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a raspberry muffin"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a raspberry muffin"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a raspberry muffin"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a raspberry muffin"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a raspberry muffin"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a raspberry muffin"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a raspberry muffin"));
                            }}
                    );
                }}
        );
        blueMuffin = new Item(0,0,30,30,new ImageTile("/sprite/bmuffin.png",30,30),"Blueberry muffin",false,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a blueberry muffin"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a blueberry muffin"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a blueberry muffin"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a blueberry muffin"));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a blueberry muffin"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a blueberry muffin"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is a blueberry muffin"));
                            }}
                    );
                }}
        );

        //Elements from the TOWER room
        towerExit1 = new Exit(85,63,35,58,new ImageTile("/sprite/tower/exit1.png",35,58),courtyard,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You must speak to the unicorn before."));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("to the courtyard",courtyard));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("to the courtyard",courtyard));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("to the courtyard",courtyard));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("to the courtyard",courtyard));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("to the courtyard",courtyard));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("to the courtyard",courtyard));
                            }}
                    );
                }});
        unicorn = new NPC(187,84,80,80,new ImageTile("/sprite/unicorn.png",80,80),"Rocco the Unicorn",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Please! I need someone! My distress is total.",2000));
                                add(new DialogStage("The kingdom will collapse, all magic will disappear    " +
                                        "from the world ...",2000));
                                add(new DialogStage("A thief just stole my magical horn",2000));
                                add(new DialogStage("Please, you!                                           " +
                                        "Please listen, you are the only one able to bring my   " +
                                        "horn back!                                             " +
                                        "Find this thief!",2000));
                                add(new DialogStage("Why are you still here!?                               " +
                                        "Find this thief and bring my horn back!",2000,true));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("What are you doing here again?!",1000));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("What! You still do not have my horn!?",1000));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("What! You still do not have my horn!?",1000));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The world we know today will collapse                  " +
                                        "if you do nothing!",1000));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Please find this thief...",1000));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("",1000));
                            }}
                    );
                }}
                );

        //Elements from the COURTYARD room
        courtyardExit1 = new Exit(255,13,35,57,new ImageTile("/sprite/courtyard/exit1.png",35,57),tower,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",tower));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",tower));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",tower));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",tower));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",tower));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",tower));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",tower));
                            }}
                    );
                }}
        );
        courtyardExit2 = new Exit(369,145,30,60,new ImageTile("/sprite/courtyard/exit2.png",30,60),banquetHall,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                }}
        );
        courtyardExit3 = new Exit(129,237,69,39,new ImageTile("/sprite/courtyard/exit3.png",69,39),stock,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It must be the pantry."));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It must be the pantry."));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It must be the pantry."));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It must be the pantry."));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",stock));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",stock));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",stock));
                            }}
                    );
                }}
        );
        courtyardExit4 = new Exit(104,67,25,39,new ImageTile("/sprite/courtyard/exit4.png",25,39),stables,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The door is locked. I need a key."));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The door is locked. I need a key."));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The door is locked. I need a key."));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The door is locked. I need a key."));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The door is locked. I need a key."));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The door is locked but the Queen gave me the key!",1000));
                                add(new DialogStageChangeRoom("",stables));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The door is locked but the Queen gave me the key!",1000));
                                add(new DialogStageChangeRoom("",stables));
                            }}
                    );
                }}
        );
        otis = new NPC(39,186,34,46,new ImageTile("/sprite/otis.png",34,46),"OTIS the peasant",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("But you know I do not think there are good or bad      " +
                                        "situations... If I had to summarize my life today, with" +
                                        "you, I would say that it is primarily encounters,      " +
                                        "people who stretched out my hand",8000));
                                add(new DialogStage("Perhaps at a time when I could not, where I was alone  " +
                                        "at home. And it is curious enough to say that chance,  " +
                                        "encounters forge a destiny because when one has the    " +
                                        "taste for the thing well done, the beautiful gesture.",8000));
                                add(new DialogStage("Sometimes one does not find l The person opposite,     " +
                                        "I would say, the mirror that helps you move forward.   " +
                                        "So it is not my case as I said there since I on the    " +
                                        "contrary I could and I say thank you to life.",8000));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("But you know I do not think there are good or bad      " +
                                        "situations... If I had to summarize my life today, with" +
                                        "you, I would say that it is primarily encounters,      " +
                                        "people who stretched out my hand",8000));
                                add(new DialogStage("Perhaps at a time when I could not, where I was alone  " +
                                        "at home. And it is curious enough to say that chance,  " +
                                        "encounters forge a destiny because when one has the    " +
                                        "taste for the thing well done, the beautiful gesture.",8000));
                                add(new DialogStage("Sometimes one does not find l The person opposite,     " +
                                        "I would say, the mirror that helps you move forward.   " +
                                        "So it is not my case as I said there since I on the    " +
                                        "contrary I could and I say thank you to life.",8000));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("But you know I do not think there are good or bad      " +
                                        "situations... If I had to summarize my life today, with" +
                                        "you, I would say that it is primarily encounters,      " +
                                        "people who stretched out my hand",8000));
                                add(new DialogStage("Perhaps at a time when I could not, where I was alone  " +
                                        "at home. And it is curious enough to say that chance,  " +
                                        "encounters forge a destiny because when one has the    " +
                                        "taste for the thing well done, the beautiful gesture.",8000));
                                add(new DialogStage("Sometimes one does not find l The person opposite,     " +
                                        "I would say, the mirror that helps you move forward.   " +
                                        "So it is not my case as I said there since I on the    " +
                                        "contrary I could and I say thank you to life.",8000));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("But you know I do not think there are good or bad      " +
                                        "situations... If I had to summarize my life today, with" +
                                        "you, I would say that it is primarily encounters,      " +
                                        "people who stretched out my hand",8000));
                                add(new DialogStage("Perhaps at a time when I could not, where I was alone  " +
                                        "at home. And it is curious enough to say that chance,  " +
                                        "encounters forge a destiny because when one has the    " +
                                        "taste for the thing well done, the beautiful gesture.",8000));
                                add(new DialogStage("Sometimes one does not find l The person opposite,     " +
                                        "I would say, the mirror that helps you move forward.   " +
                                        "So it is not my case as I said there since I on the    " +
                                        "contrary I could and I say thank you to life.",8000));                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("But you know I do not think there are good or bad      " +
                                        "situations... If I had to summarize my life today, with" +
                                        "you, I would say that it is primarily encounters,      " +
                                        "people who stretched out my hand",8000));
                                add(new DialogStage("Perhaps at a time when I could not, where I was alone  " +
                                        "at home. And it is curious enough to say that chance,  " +
                                        "encounters forge a destiny because when one has the    " +
                                        "taste for the thing well done, the beautiful gesture.",8000));
                                add(new DialogStage("Sometimes one does not find l The person opposite,     " +
                                        "I would say, the mirror that helps you move forward.   " +
                                        "So it is not my case as I said there since I on the    " +
                                        "contrary I could and I say thank you to life.",8000));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("But you know I do not think there are good or bad      " +
                                        "situations... If I had to summarize my life today, with" +
                                        "you, I would say that it is primarily encounters,      " +
                                        "people who stretched out my hand",8000));
                                add(new DialogStage("Perhaps at a time when I could not, where I was alone  " +
                                        "at home. And it is curious enough to say that chance,  " +
                                        "encounters forge a destiny because when one has the    " +
                                        "taste for the thing well done, the beautiful gesture.",8000));
                                add(new DialogStage("Sometimes one does not find l The person opposite,     " +
                                        "I would say, the mirror that helps you move forward.   " +
                                        "So it is not my case as I said there since I on the    " +
                                        "contrary I could and I say thank you to life.",8000));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("But you know I do not think there are good or bad      " +
                                        "situations... If I had to summarize my life today, with" +
                                        "you, I would say that it is primarily encounters,      " +
                                        "people who stretched out my hand",8000));
                                add(new DialogStage("Perhaps at a time when I could not, where I was alone  " +
                                        "at home. And it is curious enough to say that chance,  " +
                                        "encounters forge a destiny because when one has the    " +
                                        "taste for the thing well done, the beautiful gesture.",8000));
                                add(new DialogStage("Sometimes one does not find l The person opposite,     " +
                                        "I would say, the mirror that helps you move forward.   " +
                                        "So it is not my case as I said there since I on the    " +
                                        "contrary I could and I say thank you to life.",8000));
                            }}
                    );
                }}
        );

        //Elements from the BANQUETHALL room
        banquetHallExit1 = new Exit(51,255,60,30,new ImageTile("/sprite/banquetHall/exit1.png",60,30),courtyard,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                }}
        );
        banquetHallExit2 = new Exit(276,255,60,30,new ImageTile("/sprite/banquetHall/exit2.png",60,30),kitchen,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",kitchen));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",kitchen));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",kitchen));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",kitchen));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",kitchen));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",kitchen));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",kitchen));
                            }}
                    );
                }}
        );
        banquetHallExit3 = new Exit(241,41,50,40,new ImageTile("/sprite/banquetHall/exit3.png",50,40),vestibule,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                }}
        );
        villager1 = new NPC(31,113,30,49,new ImageTile("/sprite/villager1.png",30,49),"Simple woman",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I like banquets at the castle."));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("To go and see the queen, it is the great door          " +
                                        "surrounded by these guards.",1000));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I like banquets at the castle.",1000));
                                add(new DialogStage("It really is a great atmosphere.",1000));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I like banquets at the castle.",1000));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I have fun like crazy.",1000));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("What do you mean? A thief?!",1000));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("",1000));
                            }}
                    );
                }}
        );
        villager2 = new NPC(287,185,30,48,new ImageTile("/sprite/villager2.png",30,48),"Bored man",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Those banquets are always the same...                  " +
                                        "and the food isn't really good.",1000));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Those banquets are always the same...                  " +
                                        "and the food isn't really good. I should complain to   " +
                                        "the cooks, the kitchen is right there...",1000));
                                add(new DialogStageGiveObject("If you want I can give you my pass for this pathetic   " +
                                        "banquet",1000,pass));
                                add(new DialogStage("Please leave me alone now.",true));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Please leave me alone now, you should have something   " +
                                        "better to do..."));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Please leave me alone now, you should have something   " +
                                        "better to do..."));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("If you see the chief say him that his muffins are      " +
                                        "really bad..."));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Please leave me alone now, you should have something   " +
                                        "better to do..."));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("",1000));
                            }}
                    );
                }}
        );
        villager3 = new NPC(140,168,30,45,new ImageTile("/sprite/villager3.png",30,45),"Pensive girl",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is so magnificent. I always wanted to be a   " +
                                        "princess...",1000));
                                add(new DialogStage("Maybe I'll marry a rich heir and then I could be a     " +
                                        "princess. Maybe I should talk to this man with a       " +
                                        "mustache.",1000));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is so magnificent. I always wanted to be a   " +
                                        "princess...",1000));
                                add(new DialogStage("Maybe I'll marry a rich heir and then I could be a     " +
                                        "princess. Maybe I should talk to this man with a       " +
                                        "mustache.",1000));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is so magnificent. I always wanted to be a   " +
                                        "princess...",1000));
                                add(new DialogStage("Maybe I'll marry a rich heir and then I could be a     " +
                                        "princess. Maybe I should talk to this man with a       " +
                                        "mustache.",1000));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I'm sure he is a gentleman. Maybe he also has a castle " +
                                        "and he is single.",1000));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I'm sure he is a gentleman. Maybe he also has a castle " +
                                        "and he is single.",1000));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("After all, this man is disgusting. He just...          " +
                                        "all over the floor!",1000));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("",1000));
                            }}
                    );
                }}
        );
        villager4 = new NPC(293,135,30,48,new ImageTile("/sprite/villager4.png",30,48),"Hungry man",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Yum yum yum!...",1000));
                                add(new DialogStage("These buffets, what a blessing!",1000));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Yum yum yum!...",1000));
                                add(new DialogStage("These buffets, what a blessing!",1000));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Yum yum yum!...",1000));
                                add(new DialogStage("These buffets, what a blessing!",1000));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Yum yum yum!...",1000));
                                add(new DialogStage("These buffets, what a blessing!",1000));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Humf... I think I ate too much.",1000));
                                add(new DialogStage("I do not feel good... at all...",1000));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("+burp+"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("",1000));
                            }}
                    );
                }}
        );

        //Elements from the KITCHEN room
        kitchenExit1 = new Exit(10,200,30,60,new ImageTile("/sprite/kitchen/exit1.png",30,60),banquetHall,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                }}
        );
        commis = new NPC(186,127,43,62,new ImageTile("/sprite/commis.png",43,62),"Commis",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is not a place for the guests!"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is not a place for the guests!"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is not a place for the guests!"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Oh the queen is asking you some muffins I see..."));
                                add(new DialogStage("You should speak to my colleagues, both have good      " +
                                        "muffin recipes!",1000));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("You can find all the ingredients in the pantry outside."));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It is not because you have a pass that you are all     " +
                                        "allowed! I keep an eye on you ..."));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It is not because you have a pass that you are all     " +
                                        "allowed! I keep an eye on you ..."));
                            }}
                    );
                }}
        );
        chief = new NPC(304,176,29,62,new ImageTile("/sprite/chief.png",29,62),"Chief",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is not a place for the guests!"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is not a place for the guests! Get out!"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("This is not a place for the guests! Get out!"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Oh you want a muffin for the queen? I can cook you a   " +
                                        "muffin if you bring me some ingredients.",1000));
                                add(new DialogStage("I already have sugar, but i'll need flour, a egg, some " +
                                        "milk and why not fruit if you have.                   " +
                                        "You should try to find those ingredients in the pantry.",1000,true));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Do you all the ingredients? I can't make muffin without" +
                                        "flour,egg, milk...                                     " +
                                        "And some raspberry could be nice."));
                                add(new DialogStageNeedObject("Give me some of your flour",flour));
                                add(new DialogStageNeedObject("Give me an eggs",egg));
                                add(new DialogStageNeedObject("Give me your milk",milk));
                                add(new DialogStageNeedObject("Give me your raspberries",raspberry));
                                add(new DialogStage("Oh! You bring me all the ingredients!"));
                                add(new DialogStage("Please wait a bit, I'm doing your muffin...",5000));
                                add(new DialogStageGiveObject("Here you are your raspberry muffin !",raspMuffin));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Their is no thief here!..."));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );
        saucier = new NPC(96,163,48,80,new ImageTile("/sprite/saucier.png",48,80),"Saucier",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("We are busy get out!"));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("We are busy get out!"));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("We are busy get out!"));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I'm not good in pastry, but i can try to cook you a    " +
                                        "muffin if you bring me some ingredient",1000));
                                add(new DialogStage("I already have sugar, but i'll need flour, a egg, some " +
                                        "milk and why not fruit if you have.                    " +
                                        "You should try to find those ingredients in the pantry.",1000,true));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Do you all the ingredients? I can't make muffin without" +
                                        "flour,egg, milk...                                     " +
                                        "And some raspberry could be nice."));
                                add(new DialogStageNeedObject("Give me some of your flour",flour));
                                add(new DialogStageNeedObject("Give me an eggs",egg));
                                add(new DialogStageNeedObject("Give me your milk",milk));
                                add(new DialogStageNeedObject("Give me your raspberries",blueberry));
                                add(new DialogStage("Oh! You bring me all the ingredients!"));
                                add(new DialogStage("Please wait a bit, I'm doing your muffin...",5000));
                                add(new DialogStageGiveObject("Here you are your raspberry muffin !",blueMuffin));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Their is no thief here!..."));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );

        //Elements from the VESTIBULE room
        vestibuleExit1 = new Exit(10,158,30,60,new ImageTile("/sprite/vestibule/exit1.png",30,60),banquetHall,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",banquetHall));
                            }}
                    );
                }}
        );
        vestibuleExit2 = new Exit(365,158,30,60,new ImageTile("/sprite/vestibule/exit2.png",30,60),throneHall,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Hey you! You don't have the pass!",3000));
                                add(new DialogStage("What are you doing here? I don't want to know anything!" +
                                        "Get out!",2000));
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Hey you! You don't have the pass!",3000));
                                add(new DialogStage("What are you doing here? I don't want to know anything!" +
                                        "Get out!",2000));
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",throneHall));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",throneHall));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",throneHall));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",throneHall));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",throneHall));
                            }}
                    );
                }}
        );
        guard1 = new NPC(316,127,30,48,new ImageTile("/sprite/guard1.png",30,48),"Guard",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Hey you! You don't have the pass!",3000));
                                add(new DialogStage("What are you doing here? I don't want to know anything!" +
                                        "Get out!",2000));
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Hey you! You don't have the pass!",3000));
                                add(new DialogStage("What are you doing here? I don't want to know anything!" +
                                        "Get out!",2000));
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It is not because you have a pass that you are all     " +
                                        "allowed! I keep an eye on you ..."));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It is not because you have a pass that you are all     " +
                                        "allowed! I keep an eye on you ..."));                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It is not because you have a pass that you are all     " +
                                        "allowed! I keep an eye on you ..."));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It is not because you have a pass that you are all     " +
                                        "allowed! I keep an eye on you ..."));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("It is not because you have a pass that you are all     " +
                                        "allowed! I keep an eye on you ..."));
                            }}
                    );
                }}
        );
        guard2 = new NPC(316,180,30,48,new ImageTile("/sprite/guard2.png",30,48),"Guard",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I protect the queen.. Hey?! You don't have the pass!",3000));
                                add(new DialogStage("What are you doing here? I don't want to know anything!" +
                                        "Get out!",2000));
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I protect the queen.. Hey?! You don't have the pass!",3000));
                                add(new DialogStage("What are you doing here? I don't want to know anything!" +
                                        "Get out!",2000));
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is just behind this door."));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is just behind this door."));
                         }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is just behind this door."));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is just behind this door."));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );

        //Elements from the THRONEHALL room
        throneHallExit1 = new Exit(170,269,60,30,new ImageTile("/sprite/throneHall/exit1.png",60,30),vestibule,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                }}
        );
        guardThr1 = new NPC(98,145,31,47,new ImageTile("/sprite/guardThr1.png",31,47),"Guard",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I've been protecting the Queen for 40 years..."));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I've been protecting the Queen for 40 years..."));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I've been protecting the Queen for 40 years..."));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I've been protecting the Queen for 40 years..."));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I'm tired of the queen's whims, why does not she like  " +
                                        "blueberries"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Oh, a thief, run to the stables!"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );
        guardThr2 = new NPC(280,145,31,48,new ImageTile("/sprite/guardThr2.png",31,48),"Guard",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I am new. I am fortunate to have been assigned to the  " +
                                        "guard of the queen."));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I am new. I am fortunate to have been assigned to the  " +
                                        "guard of the queen."));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I am new. I am fortunate to have been assigned to the  " +
                                        "guard of the queen."));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I am new. I am fortunate to have been assigned to the  " +
                                        "guard of the queen."));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("I do not know if it's really good to be assigned to the" +
                                        "royal guard. The Queen is..."));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("ZZZzzzzzZZZZzzzzz..."));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );
        council = new NPC(139,96,30,45,new ImageTile("/sprite/council.png",30,45),"Council",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("The queen is very hungry she will not talk so much     " +
                                        "without her favorite muffin."));
                                add(new DialogStage("This queen tires me...",true));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("If you want to speak with the queen, you should        " +
                                        "consider an offering. A muffin could be good."));
                                add(new DialogStage("You should ask the cooks."));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Muffins aren't good for her diabetes..."));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Please use this key to find the thief!"));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );
        queen = new NPC(185,75,30,45,new ImageTile("/sprite/queen.png",30,45),"Queen Raspberry",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("HAAAAAHaaaa!! How dare you talk to me! Get out!"));
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("HAAAAAHaaaa!! I'am so hungry I want a muffin! Get out!"));
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Oh?! Did you bring me a muffin?"));
                                add(new DialogStageNeedObject("I hope this is a raspberry muffin!",raspMuffin));
                                add(new DialogStage("Thanks you! you are so cute!"));
                                add(new DialogStage("Yum Yum Yum...",5000));
                                add(new DialogStageGiveObject("Take this key to find your thief",key));
                                add(new DialogStage("Now leave me!!!!",true));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Now go and fin the thief! And get out!"));
                                add(new DialogStageChangeRoom("",vestibule));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );

        //Elements from the STOCK room
        stockExit1 = new Exit(280,8,60,30,new ImageTile("/sprite/stock/exit1.png",60,30),courtyard,
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageChangeRoom("",courtyard));
                            }}
                    );
                }}
        );
        chest1 = new NPC(70,36,33,37,new ImageTile("/sprite/coffre1.png",33,37),"Wooden chest",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageTypeAnswer("If you want my content, answer this enigma:            " +
                                        "As soon as I am called, I do not exist anymore.        Who am I ?",
                                        new ArrayList<Answer>(){{add(new Answer("SILENCE"));add(new Answer("MUTISM"));}}));
                                add(new DialogStage("Congratulation you found the solution!"));
                                add(new DialogStageGiveObject("You find inside the chest:",raspberry));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
                );
        chest2 = new NPC(246,110,37,38,new ImageTile("/sprite/coffre2.png",37,38),"Blue chest",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageMultipleAnswers("I have an enigma for you:" +
                                        "What is this thing that lengthens in the hands,when it " +
                                        "is passed between the breasts and when it is inserted  " +
                                        "into a slot?",
                                        new ArrayList<Answer>(){{add(new Answer(false,"magical wand"));
                                            add(new Answer(true,"security belt"));
                                            add(new Answer(false,"hum... what do you mean?"));}}));
                                add(new DialogStage("Congratulation you found the solution!"));
                                add(new DialogStageGiveObject("You find inside the chest:",blueberry));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
                );
        chest3 = new NPC(72,210,37,38,new ImageTile("/sprite/coffre3.png",37,38),"Red chest",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageTypeAnswer("I have an enigma for you:                              " +
                                        "It is better than god, it is worst than devil          " +
                                        "Poor people have it, rich people needs it              " +
                                        "If we eat it, we die.It is faster than the light",
                                        new ArrayList<Answer>(){{
                                            add(new Answer("NOTHING"));
                                            add(new Answer("VOID"));
                                }}));
                                add(new DialogStage("Congratulation you found the solution! But their is    ...Nothing!"));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
                );
        chest4 = new NPC(270,36,29,26,new ImageTile("/sprite/coffre4.png",29,26),"Little chest",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStageMultipleAnswers("I have an enigma for you:                              " +
                                        "The bigger I am, the less you see me. Who am I ?",
                                        new ArrayList<Answer>(){{
                                            add(new Answer(true,"darkness"));
                                            add(new Answer(false,"universe"));
                                            add(new Answer(false,"hum... i'm not sure..."));
                                        }}));
                                add(new DialogStage("Congratulation you found the solution!"));
                                add(new DialogStageGiveObject("You find eggs inside the chest.",egg));

                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );

        //Elements from the STABLES room
        thief = new NPC(33,105,47,73,new ImageTile("/sprite/thief.png",47,73),"Thief",
                new HashMap<GameState,ArrayList<DialogStage>>()
                {{
                    put(GameState.INIT,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.START,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.GETPASS,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.SPEACKADVISER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.FINDMUFFIN,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                    put(GameState.FINDTHIEF,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage("Oh damn... it seems you caught me red-handed...        "+
                                        "But it isn't what you think!",1000));
                                add(new DialogStage("Oh well... never mind. I'm sick of all the people in   " +
                                        "this bloody castel. Do you really think this unicorn   " +
                                        "brings magic over the world?                           " +
                                        "And this queen... I'm tired, I'm out of here!",1000));
                                add(new DialogStageMultipleAnswers("You know what, you should go with me.",
                                        new ArrayList<Answer>(){{
                                            add(new Answer(true,"Hum... I'm not sure"));
                                            add(new Answer(true,"Really? I don't think..."));
                                        }}));
                                add(new DialogStageMultipleAnswers("You and me, we could make lot of money with this horn  " +
                                        "and have a long life of pleasure and happiness.",
                                        new ArrayList<Answer>(){{
                                            add(new Answer(true,"But the unicorn said me..."));
                                        }}));
                                add(new DialogStage("Tsss! Do you want to go with me?",1000));
                                add(new DialogStageMultipleAnswers("Tsss! Do you want to go with me?",
                                        new ArrayList<Answer>(){{
                                            add(new Answer(true,"Yes!"));
                                            add(new Answer(true,"Yes!"));
                                        }}));
                                add(new DialogStage("Let's go!",true));
                            }}
                    );
                    put(GameState.GAMEOVER,new ArrayList<DialogStage>()
                            {{
                                add(new DialogStage(""));
                            }}
                    );
                }}
        );

        //Adding Elements to their own room
        tower.setRoomContent(new ObjectManager(){{
            addObject(towerExit1);
            addObject(unicorn);
        }});
        courtyard.setRoomContent(new ObjectManager() {{
            addObject(courtyardExit1);
            addObject(courtyardExit2);
            addObject(courtyardExit3);
            addObject(courtyardExit4);
            addObject(otis);
        }});
        banquetHall.setRoomContent(new ObjectManager(){{
            addObject(banquetHallExit1);
            addObject(banquetHallExit2);
            addObject(banquetHallExit3);
            addObject(villager1);
            addObject(villager2);
            addObject(villager3);
            addObject(villager4);
        }});
        kitchen.setRoomContent(new ObjectManager(){{
            addObject(kitchenExit1);
            addObject(commis);
            addObject(chief);
            addObject(saucier);
        }});
        vestibule.setRoomContent(new ObjectManager(){{
            addObject(vestibuleExit1);
            addObject(vestibuleExit2);
            addObject(guard1);
            addObject(guard2);
        }});
        throneHall.setRoomContent(new ObjectManager(){{
            addObject(throneHallExit1);
            addObject(guardThr1);
            addObject(guardThr2);
            addObject(council);
            addObject(queen);
        }});
        stock.setRoomContent(new ObjectManager(){{
            addObject(stockExit1);
            addObject(flour);
            addObject(milk);
            addObject(chest1);
            addObject(chest2);
            addObject(chest3);
            addObject(chest4);
        }});
        stables.setRoomContent(new ObjectManager(){{
            addObject(thief);
        }});
    }


    /**
     *
     * @return the initialised tower room
     */
    public Room getTower() {
        return tower;
    }
    /**
     *
     * @return the initialised courtyard room
     */
    public Room getCourtyard() {
        return courtyard;
    }
    /**
     *
     * @return the initialised kitchen room
     */
    public Room getKitchen() {
        return kitchen;
    }
    /**
     *
     * @return the initialised banquetHall room
     */
    public Room getBanquetHall() {
        return banquetHall;
    }
    /**
     *
     * @return the initialised stock room
     */
    public Room getStock() {
        return stock;
    }
    /**
     *
     * @return the initialised throneHall room
     */
    public Room getThroneHall() {
        return throneHall;
    }
    /**
     *
     * @return the initialised vestibule room
     */
    public Room getVestibule() {
        return vestibule;
    }
    /**
     *
     * @return the initialised stables room
     */
    public Room getStables() {
        return stables;
    }
}
