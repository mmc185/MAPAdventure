package uni.mapadventureproject.files;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import javax.swing.ImageIcon;
import uni.mapadventureproject.Game;
import uni.mapadventureproject.GameTimeTask;
import uni.mapadventureproject.type.*;

public class FileSaver {

    Game g;

    public Game getG() {
        return g;
    }

    public void init() {

        g = new Game();

        //Items dell'inventario
        Item taralli = new Item(50, "taralli", "Taralli in busta... Gli ottimi taralli del forno (che ti compra tua madre), ti viene l'acquolina in bocca solo a pensarci!");
        taralli.setAlias(new String[]{"tarallini"});
        ImageIcon img = new ImageIcon("img//inventario//taralli.png");
        taralli.setItemImage(img);
        g.getInventory().add(taralli);
        Item notes = new Item(51, "quaderno", "Quaderno con gli appunti di MAP pieno di \"pippottoni\"");
        notes.setAlias(new String[]{"appunti", "riassunti", "block-notes", "fogli"});
        img = new ImageIcon("img//inventario//appunti.png");
        notes.setItemImage(img);
        g.getInventory().add(notes);
        Item umbrella = new Item(52, "ombrello", "Fidato ombrello, ogni volta che ce l'hai con te non piove mai!");
        umbrella.setAlias(new String[]{"ombrellino"});
        img = new ImageIcon("img//inventario//ombrello.png");
        umbrella.setItemImage(img);
        g.getInventory().add(umbrella);
        Item bottle = new Item(53, "borraccia", "La borraccia che hai aspettato tanto per avere dal DIB, forse facevi prima a scroccarla dal PoliBa...");
        bottle.setAlias(new String[]{"bottiglietta", "bottiglia"});
        img = new ImageIcon("img//inventario//bottiglia.png");
        bottle.setItemImage(img);
        g.getInventory().add(bottle);
        Item pendrive = new Item(54, "pendrive", "La solita pen-drive che usi ormai da diversi anni.");
        pendrive.setAlias(new String[]{"chiavetta", "usb", "chiavetta usb", "pen-drive"});
        img = new ImageIcon("img//inventario//chiavetta.png");
        pendrive.setItemImage(img);
        g.getInventory().add(pendrive);

        //Oggetti non inventario
        Item buttonTrain = new Item(55, "bottone", "Bottone per far aprire le porte del treno");
        buttonTrain.setAlias(new String[]{"pulsante"});
        buttonTrain.setPushable(true);
        buttonTrain.setConsumable((byte) 1);
        
        Item poster = new Item(55, "poster", "\"L'Agenzia di viaggi Artskjid ti dà il benvenuto alla Metastazione Centrale! \n"
                + "Luogo da cui puoi raggiungere ogni dimensione immaginabile. \nPer informazioni, chiedere al personale in divisa.\"");
        poster.setAlias(new String[]{"cartello", "cartellone", "manifesto", "affisso", "locandina"});

        Item note = new Item(56, "bigliettino", "\"Ho preso un oggetto per te importante, se vuoi averlo indietro devi portarmi degli oggetti altrettanto importanti per me:\n"
                + "1) OggettoX dal portale nella direzione in cui sorge il sole,\n"
                + "2) OggettoY dal portale più oscuro,\n"
                + "3) OggettoZ dal portale da cui sembra provenire una dolce musica.\n"
                + "Portali qui nell'atrio e riavrai il tuo bene prezioso.\"\n"
                + "\"Ah, bene!\" esclama il tuo amico \"Vuole che gli facciamo la spesa.\"");
        note.setAlias(new String[]{"biglietto", "fogliettino", "foglietto"});
        img = new ImageIcon("img//inventario//biglietto.png");
        note.setItemImage(img);
        
        Item sword=new Item(57,"spada","Una spada ben affilata,ogni pirata ne dovrebbe avere una così");
        img =new ImageIcon("img//inventario//spada.png");
        sword.setItemImage(img);
        sword.setPickupable(true);
        
        Item lamp=new Item(58,"lanterna","Una vecchia lanterna ,potrebbe essere utile");
        lamp.setAlias(new String[]{"lampada", "lumino"});
        img =new ImageIcon("img//inventario//lanterna.jpg");
        lamp.setItemImage(img);
        lamp.setPickupable(true);
        
        Item parchment=new Item(59,"pergamena","Est ,nord ed ancora est;nessun labirinto mi fermerà,"
                              +"il tesoro sarà mio,stasera si festeggia domani riprendo la ricerca.");
        img =new ImageIcon("img//inventario//pergamena.png");
        parchment.setItemImage(img);
        parchment.setPickupable(true);
        
        
        //da verificare se introdurre o meno (non si apre il sacco)
        Inventory sacco=new Inventory();
        sacco.add(sword);
        sacco.add(lamp);
        sacco.add(parchment);
        ItemContainer sack=new ItemContainer(sacco,60,"sacco","Sacco del pirata,potrebbe contenere qualcosa di utile");
        sack.setItemImage(new ImageIcon("img//inventario//sacco.jpg"));
        //sack.setOpenable(true); 
        
        Item key=new Item(61,"chiave","Chiave del capitano Kid");
        key.setItemImage(new ImageIcon("img//inventario//chiave.png"));
        key.setPickupable(true);
        
        Item bullion=new Item(62,"lingotto","Il tesoro di kid e uno degli oggetti per la tua salvezza!");
        bullion.setItemImage(new ImageIcon("img//inventario//lingotto.jpg"));
        bullion.setPickupable(true);
        
        ItemContainer chest=new ItemContainer(new Inventory(),63,"forziere","Contiene il lingotto del capitano Kid");
        chest.setAlias(new String[]{"baule"});
        chest.add(bullion);
       // chest.setOpenable(true);
        chest.setLockedBy("chiave");
        

//Stanze
        Room station = new Room(0, "Stazione ferroviaria", "Una voce metallica gracchia dall'altoparlante:"
                + "\n\"Il treno regionale delle ore 9:00 diretto a Bari Centrale è in partenza dal binario 9 con un ritardo di 10 minuti!\""
                + "\nSenti il fischio assordante del capotreno che ti sollecita a salire.");
        station.setRoomImage(new ImageIcon("img//stanze//station.png"));

        Room wagon = new TriggeredRoom(1, "Vagone del treno", "Dopo esserti fatto strada tra l'assembramento di persone sui vagoni, trovi il tuo amico nonché compagno di progetto.\n"
                + "Che fortuna, ti ha preso il posto! (stonks) Ti siedi.\n"
                + "\"Beh, ti senti preparato per l'esame di oggi? Spero che il prof sia clemente...\" ti chiede il tuo amico.\n\n"
                + "\"Io ricordavo che il prof si chiamasse Pierpaolo\" rispondi. \nIl tuo amico ti defenestra. GAME OVER\n\n"
                + "Scherzo, riprendiamo.\n\n"
                + "\"Hey, hai con te la pen-drive, vero?! Non ripetiamo l'incidente di laboratorio...\" ti chiede il tuo amico.\n"
                + "Apri lo zaino e gliela mostri, non perderesti mai qualcosa di così importante... vero? ");

        ((TriggeredRoom) wagon).addTriggerer("guarda");
        ((TriggeredRoom) wagon).addTriggerDesc("Fuori dal finestrino si estende una distesa immensa di ulivi.\n"
                + "\"Speriamo che il treno recuperi il ritardo\" senti il tuo amico che riflette ad alta voce.\n"
                + "Tira fuori i suoi appunti e comincia a ripetere per conto suo, dovresti farlo anche tu!");

        ((TriggeredRoom) wagon).addTriggerer("guarda quaderno");
        ((TriggeredRoom) wagon).addTriggerDesc("Cominci a rileggere gli appunti, ma le palpebre si fanno pesanti e crolli in un sonno profondo...\n"
                + "...\n"
                + "\"Il treno è in arrivo a destinazione con un ANTICIPO di 1 minuto.\"\n"
                + "Ti svegli di sobbalzo, 1 minuto di anticipo? C'è qualcosa che non quadra, qui i treni non arrivano neanche in orario...\n"
                + "Senti il fischio dei freni e il treno si arresta completamente sui binari.\n"
                + "Il tuo amico è già vicino alle porte e sollecita \"Dai, sbrigati, premi il bottone per aprirle le porte "
                + "o arriveremo in ritardo.\"\n");
        // trigger o locked per la metastation?
        wagon.setRoomImage(new ImageIcon("img//stanze//wagon.png"));

        Room metaStation = new Room(2, "Metastazione", "Come sempre scendi dal treno stretto come una sardina in mezzo ad altri poveri pendolari.\n"
                + "Noti che il treno si è fermato a un binario diverso dal solito, alzi lo sguardo e leggi \"Binario 0\".\n"
                + "Strano, non ti ricordavi esistesse quel binario\n"
                + "Aspetta, questa non sembra la stazione di Bari.\n"
                + "Ti guardi intorno spaesato.\n"
                + "Un strano uomo con delle orecchie a punta si avvicina al capotreno:\n"
                + "\"Scusi, mi può dire la strada per il portale che conduce a PaleoliticCity?\"\n"
                + "Guardi il tuo amico con gli occhi strabuzzati e lui scrolla le spalle \n"
                + "\"Cerchiamo di capire dove cavolo siamo finiti!\" e inizia a guardarsi intorno.");
        metaStation.setRoomImage(new ImageIcon("img//stanze//metaStation.png"));

        Room metaStationLobby = new Room(3, "Atrio della Metastazione", "Uscendo dalla stazione ti rendi conto di avere lo zaino aperto.\n"
                + "Chiedi al tuo amico di controllare che ci sia tutto e, gentilmente, di chiuderti lo zaino.\n"
                + "Il tuo amico, non gentilmente, esclama \"Oh no! Come dannazione hai fatto?! La chiavetta con su il progetto è scomparsa!\"\n"
                + "Gli premi di controllare meglio e comincia ad elencare il contenuto dello zaino.\n"
                + "\"Borraccia, i tuoi immancabili taralli, ombrello, quaderno e un fogliettino sparso. Cos'è vuoi copiare all'esame?\"\n"
                + "(Non avevi un bigliettino prima!)");
        metaStationLobby.setRoomImage(new ImageIcon("img//stanze//metaStationLobby.png"));
        
         //Stanze mondo pirata
         
        Room ship=new Room(4,"Nave pirata","Sbuchi dal portale e ti ritrovi su nave enorme ,"
                +"in cima sventola una bandiera nera raffigurante un teschio bianco,sei su una nave pirata! \n"
                +"La nave è ormeggiata vicino ad un isola,da cui si nota una foresta e sulla spiaggia un piccolo falò.Potrebbe esserci qualcuno.\n" 
                +"Il tuo amico trova un biglietto attaccato sull'albero maestro e lo legge: \n"
                + "Su quest'isola troverai il tesoro del capitano kid,un lingotto d'oro che mai nessuno è riuscito a trovare,trovalo e rispetta il nostro patto.\n"
                +"Ah dimenticavo,dovrai raggiungere la caverna dopo aver attraversato la foresta,nella tenda vicino al falò troverai qualcosa per te.");
        ship.setRoomImage(new ImageIcon("img//stanze//ship.png"));
        
        Room campFire=new Room(5,"Falo'","Tu e il tuo amico vi siete divisi per avere più probabilità di trovare il tesoro e setacciare meglio l'isola.\n"
                +"vai avanti e trovi un piccolo falo che illumina a stento l area circostante circondato da tante bottiglie vuote.\n" 
                +"Sulla sabbia ci sono delle impronte che vanno verso est,impronte strane... un piede umano e un impronta circolare,ma dove sei finito?");
        campFire.setRoomImage(new ImageIcon("img//stanze//campFire.png"));
        
        Room tent=new TriggeredRoom(6,"Tenda","Che puzza di alcol!Un tizio con una  benda sull'occhio sinistro e una gamba di legno è  spaparanzato per terra tutto UBRIACO!"
                +"Ecco di chi erano quelle bottiglie.\n"
                +"\"per mille balene...\" farfuglia il pirata  nel sonno.\n" 
                +"Dovresti trovare qualcosa di utile qui dentro, ma attento a non svegliarlo.");
        ((TriggeredRoom)tent).addTriggerer("prendi spada");
        ((TriggeredRoom)tent).addTriggerDesc("Ora hai la spada,spero non ti serva");
        ((TriggeredRoom)tent).addTriggerer("prendi lanterna");
        ((TriggeredRoom)tent).addTriggerDesc("Puoi usarla per andare in luoghi bui");
        ((TriggeredRoom)tent).addTriggerer("prendi pergamena");
        ((TriggeredRoom)tent).addTriggerDesc("Sembra la soluzione di qualcosa...");
        
        tent.setRoomImage(new ImageIcon("img//stanze//tent.jpg"));
        
        Room forest=new Room(7,"Foresta","è notte inoltrata e sei in una fitta foresta,solo la luce emessa dalla lanterna ti fa vedere qualcosa,ma non più di tanto.\n");
        forest.setRoomImage(new ImageIcon("img//stanze//forest.jpg"));
        
        Room waterfall=new Room(8,"Cascata","Una cascata blocca il passaggio.Non c'e modo di passar da qui");
        waterfall.setRoomImage(new ImageIcon("img//stanze//waterfall.gif"));
        
        Room cliff=new Room(9,"Precipizio","Sei fuori dalla foresta  ma davanti a te c'è un precipizio,non vorrai farla finita vero?");
        cliff.setRoomImage(new ImageIcon("img//stanze//cliff.jpg"));
        
        Room cave=new Room(10,"Caverna","Sei arrivato alla caverna,ma l'entrata è bloccata.E ora?");
        cave.setRoomImage(new ImageIcon("img//stanze//cave.jpg"));
        
        Room cave1=new Room(11,"Caverna","Finalmente sei nella caverna,e appena sceso vieni attaccato da un branco di pipistelli!!\n"
                          +"AHAHAH scherzo volevo spaventarti!\n"
                          +"La caverna si dirama in piu vie,ed è piena di scheletri umani ,chissà quante persone ci hanno provato prima di te.\n"
                          +"Come fare per trovare un'uscita?");
        cave1.setRoomImage(new ImageIcon("img//stanze//cave.jpg"));
        
        Room cave2=new Room(12,"Caverna","Bene,ora un'altro bivio");
        cave2.setRoomImage(new ImageIcon("img//stanze//cave.jpg"));
        
        Room cave3=new Room(13,"Caverna","Da qui non si può proseguire");
        cave3.setRoomImage(new ImageIcon("img//stanze//vicolo_cieco.png"));
        
        Room cave4=new Room(14,"Caverna","Da qui non si può proseguire");
        cave4.setRoomImage(new ImageIcon("img//stanze//vicolo_cieco.png"));
        
        Room cave5=new Room(15,"Caverna","Oh no ora devi scegliere tra tre direzioni");
        cave5.setRoomImage(new ImageIcon("img//stanze//cave.jpg"));
        
        Room cave6=new Room(16,"Caverna","Da qui non si può proseguire");
        cave6.setRoomImage(new ImageIcon("img//stanze//vicolo_cieco.png"));
        
        Room cave7=new Room(17,"Caverna","Da qui non si può proseguire");
        cave7.setRoomImage(new ImageIcon("img//stanze//vicolo_cieco.png"));
        
        Room sunrise=new TriggeredRoom(18,"Alba","Finalmente sei riuscito ad uscire da quella maledetta caverna.Ormai è l alba e la luce non ti aiuterà a prendere il tesoro inosservato."
                +"Davanti a te trovi uno scheletro con un cappello da pirata e una pistola a canna focaia accanto ad esso.Provi a raccoglierlo ma mentre ci provi fai scattare una trappola.\n"
                +"Lo scheletro si alza e se ne va ridendo,oltre al danno pure la beffa.\n"
                +" Sei appeso come un salame in una fune.Questa giornata non poteva andare peggio di così...");
        ((TriggeredRoom)sunrise).addTriggerer("usa spada");
        ((TriggeredRoom)sunrise).addTriggerDesc("Ti sei liberato,puoi scendere in acqua alla ricerca del tesoro ora");
        sunrise.setRoomImage(new ImageIcon("img//stanze//sunrise.jpg"));
        
        Room sea=new Room(19,"A mollo","Ti sei immerso, ci sono tanti pesci e  alghe ma la via per la nave è sgombra");
        sea.setRoomImage(new ImageIcon("img//stanze//sea.png"));
        
        Room adventureGalley=new Room(20,"Adventure Galley","Davanti a te si trova la nave affondata del capitano Kid");
        adventureGalley.setRoomImage(new ImageIcon("img//stanze//adventureGalley.png"));
        
        Room treasure=new Room(21,"Stanza del tesoro","La nave è semi distrutta,ma non si può non notare un gran forziere e tanti oggetti luccicanti,il forziere è chiuso ovviamente.ad est si trova la stanza del capitano");
        treasure.setRoomImage(new ImageIcon("img//stanze//treasure.png"));
        
        Room captainRoom=new Room(22,"Stanza del capitano","La stanza non è molto grande  e vicino ad un tavolo giace il corpo di un pirata,con una chiave attacata alla sua cintura./n"
                + "E' il corpo del leggendario capitano kid uno dei pirati più ricercati\n" 
                +"che si suicidò perchè esausto di fuggire dalla condonna a morte del governo inglese nei suoi confronti.\n"
                +"Questo non farà scattare una trappola  come per  lo scheletro di prima,si spera.");
        captainRoom.setRoomImage(new ImageIcon("img//stanze//captainRoom.png"));
        
        Room boat=new Room(23,"Barchetta","Finalmente aria.Trovi una barchetta e ci sali sopra.");
        boat.setRoomImage(new ImageIcon("img//stanze//boat.png"));
        
        Room shipPortal=new Room(21,"Il ritorno","Accanto alla nave cè una corda per poter salire e attraversare il portale /n"
                 +"Senti degli spari e delle esplosioni e vedi un tizio che corre verso il portale.\n"
                 +"E' il tuo amico che ha esagerato un po' con il distarre i pirati fantasma che ora vi stanno cercando,forse è meglio muoversi e tornare nella stanza dei portali con il nuovo tesoro!!\n"
                 +"Chissà che fine farà il pirata ubriacone che non troverà più il tesoro.\n"
                 +"Chi dorme non piglia pesci dice un detto!");
        shipPortal.setRoomImage(new ImageIcon("img//stanze//shipPortal.png"));
        
        station.setUp(wagon);
        station.setLook("Ti trovi di fronte alle porte del treno. Dovresti muoverti prima che si chiudano!");

        wagon.setDown(metaStation);
        wagon.setLook("Il vagone è strapieno come sempre! ");
        wagon.addItem(buttonTrain);
        
        metaStation.setLook("Sul muro della stazione è affisso un grande poster con grandi scritte colorate e vicino al cancello di uscita\n"
                + "c'è una strana creatura simile a un polpo che suona i tamburi con i suoi diversi tentacoli.");
        metaStation.addItem(poster);
        metaStation.setNorth(metaStationLobby);
        metaStation.setLockedBy("bottone");

        metaStationLobby.setLook("Il grande atrio è costellato da portali variopinti, la tua attenzione viene catturata da tre portali:\n"
                + "quello alla tua destra brilla di giallo,\n quello di fronte a te è scuro con tante luci lontane e\n"
                + "infine, quello alla tua sinistra è verde e il suono che proviene da lì ti affascina.");
        metaStationLobby.setSouth(metaStation);
        metaStationLobby.setEast(ship);
        metaStationLobby.addItem(note);
        
        ship.setLook("A nord cè il falò,alle tue spalle  il portale dal quale sei arrivato,nelle altre direzioni cè solo il mare.");
        ship.setWest(metaStationLobby);
        ship.setNorth(campFire);
        
        campFire.setLook("Le impronte portano ad una tenda,è quella a cui faceva riferimento il biglietto trovato sulla nave?");
        campFire.setEast(tent);
        campFire.setSouth(ship);
        
        tent.setLook("Per andare nella foresta ci vorrà una fonte luminosa per farti strada \n"
        +"Predi tutto quello che trovi!");
        tent.addItem(sack);
        tent.setNorth(forest);
        
        forest.setLook(" Si sentono versi strani e ti senti osservato eppure non c'è nessuno,o almeno speri...tutto questo ti mette i brividi");
        forest.setEast(waterfall);
        forest.setWest(cliff);
        forest.setNorth(cave);
        forest.setLockedBy("lanterna");
        
        waterfall.setLook("Tutto molto bello,lo terrai in mente per le prossime vacanze,ma di qui non si può avanzare");
        waterfall.setWest(forest);
        
        cliff.setLook("La vista è stupenda ,il riflesso della luna sul mare lo fa brillare in alcuni punti, ma dovresti muoverti invece di  guardare la luna,"
                +"il pirata potrebbe rimprendersi da un momento all'altro e ");
        cliff.setEast(forest);
        
        cave.setLook("Scusami non te l'ho detto??\n"
          +"Accanto alla caverna c'è un foro e una corda per poter scendere.\n"
          +"Volevo vedere se fossi attento...");
        cave.setDown(cave1);
        
        cave1.setLook("Questa caverna sembra una specie di labirinto,ci sarà un modo per uscirne"
                + "C'è una via ad est e una a ovest");
        cave1.setEast(cave2);
        cave1.setWest(cave3);
        
        cave2.setLook("Ora le vie sono una verso nord e una verso sud");
        cave2.setNorth(cave5);
        cave2.setSouth(cave4);
        cave2.setWest(cave1);
        
        cave3.setLook("Dovresti tornare indietro e riprovare");
        cave3.setEast(cave1);
                
        cave4.setLook("Dovresti tornare indietro e riprovare");
        cave4.setNorth(cave2);   
        
        cave5.setLook("Ora le vie sono una verso nord,una verso est,una verso ovest,a sud torni indietro");
        cave5.setNorth(cave7);
        cave5.setSouth(cave2);
        cave5.setWest(cave6);
        cave5.setEast(sunrise);
        
        cave6.setLook("Dovresti tornare indietro e riprovare");
        cave6.setEast(cave5);
        
        cave7.setLook("Dovresti tornare indietro e riprovare");
        cave7.setSouth(cave5);
        
        sunrise.setLook("La corda che ti intrappola non sembra molto robusta,potresti usare qualcosa per tagliarla");
        sunrise.setDown(sea);
        
        sea.setLook("Ad est si trova l' adventure Galley");
        sea.setEast(adventureGalley);
        sea.setLockedBy("spada");
        
        adventureGalley.setLook("Noti un foro nel fianco della nave ,a sud ,puoi entrarci");
        adventureGalley.setSouth(treasure);
        adventureGalley.setWest(sea);
        
        treasure.setLook("Ad ovest c'è una stanza,invece sopra di te c'e una via per tornare a galla");
        treasure.setWest(captainRoom);
        treasure.setNorth(adventureGalley);
        treasure.setUp(boat);
        treasure.addItem(chest);
        
        captainRoom.setLook("Quella potrebbe essere la chiave del forziere");
        captainRoom.setEast(treasure);
        captainRoom.addItem(key);
        
        boat.setLook("A nord si trova la nave con il portale,dai ci sei quasi!");
        boat.setNorth(shipPortal);
        boat.setLockedBy("lingotto");
        
        shipPortal.setLook("Sali così potrai attraversare il portale e tornare alla metastazione");
        shipPortal.setUp(metaStationLobby);
        

        //Comandi
        Command north = new Command("nord", CommandType.MOVE_N);
        g.getCommands().add(north);
        Command south = new Command("sud", CommandType.MOVE_S);
        g.getCommands().add(south);
        Command west = new Command("ovest", CommandType.MOVE_W);
        g.getCommands().add(west);
        Command east = new Command("est", CommandType.MOVE_E);
        g.getCommands().add(east);
        Command inv = new Command("inventario", CommandType.INV);
        inv.setAlias(new String[]{"inv", "zaino", "borsa"});
        g.getCommands().add(inv);
        Command look = new Command("guarda", CommandType.LOOK);
        look.setAlias(new String[]{"osserva", "vedi", "trova", "cerca", "descrivi", "controlla"});
        g.getCommands().add(look);
        Command pickup = new Command("prendi", CommandType.PICK_UP);
        pickup.setAlias(new String[]{"raccogli"});
        g.getCommands().add(pickup);
        Command open = new Command("apri", CommandType.OPEN);
        g.getCommands().add(open);
        Command use = new Command("usa", CommandType.USE);
        g.getCommands().add(use);
        Command push = new Command("premi", CommandType.PUSH);
        push.setAlias(new String[]{"spingi", "attiva"});
        g.getCommands().add(push);

        Command up = new Command("sali", CommandType.MOVE_U);
        up.setAlias(new String[]{"sopra", "su"});
        g.getCommands().add(up);
        Command down = new Command("scendi", CommandType.MOVE_D);
        down.setAlias(new String[]{"sotto", "giu"});
        g.getCommands().add(down);
        Command escape = new Command("scappa", CommandType.RUN);
        escape.setAlias(new String[]{"fuggi", "muori", "crepa"});
        g.getCommands().add(escape);
        Command wake = new Command("sveglia", CommandType.WAKE_UP);
        wake.setAlias(new String[]{"svegliati"});
        g.getCommands().add(wake);

        //Comando buttati?
        //TODO Serve anche un comando per uscire dal gioco?
        g.setCurrentRoom(station);

        g.setPlayer("Patatine");

        //GameTimeThread gTime = new GameTimeThread();
        //g.setGameTime(gTime);
    }

    public void saveFile(String path, Game g) throws FileNotFoundException, IOException {

        FileOutputStream fOut = new FileOutputStream(path + "/Intro.dat");
        ObjectOutputStream objOut = new ObjectOutputStream(fOut);

        objOut.writeObject(g.getCommands());

        objOut.writeObject(g.getInventory());

        objOut.writeObject(g.getCurrentRoom());

        objOut.writeUTF(g.getPlayer());

        objOut.writeInt(g.getGameTime().getSecondPassed());

        objOut.close();
        fOut.close();

    }

    public void readFile(String path, Game g) throws IOException, ClassNotFoundException {
        FileInputStream fIn = new FileInputStream(path);

        ObjectInputStream objIn = new ObjectInputStream(fIn);

        g.setCommands((HashSet<Command>) objIn.readObject());
        g.setInventory((Inventory) objIn.readObject());
        g.setCurrentRoom((Room) objIn.readObject());
        g.setPlayer((String) objIn.readUTF());
        g.getGameTime().setSecondPassed((int) objIn.readInt());

        objIn.close();
        fIn.close();

    }

    public static void main(String[] args) {

        FileSaver fs = new FileSaver();
        //fs.g = new Game(s, null, null);
        fs.init();

        try {
            fs.saveFile("NewGame", fs.getG());
            /*fs.readFile("NewGame//Intro.dat");
            for (Command c : fs.g.getCommands()) {
                System.out.println(c.getName());
            }
           System.out.println("==========================");
            for (Item i : fs.g.getInventory().getInventoryList() ) {
                System.out.println(i.getName() + ": " + i.getDesc() );
            }
            System.out.println("==========================");
            System.out.println("Nome: " + fs.g.getCurrentRoom().getName() +
                    "\nDesc: " + fs.g.getCurrentRoom().getDesc()+ 
                    "\nLook: " + fs.g.getCurrentRoom().getLook());
             
        } catch (IOException exc) {
            System.out.println("1" + exc.getMessage());*/
        } catch (Exception e) {
            System.out.println("2" + e.getMessage());
            e.printStackTrace();
        }
    }

}
