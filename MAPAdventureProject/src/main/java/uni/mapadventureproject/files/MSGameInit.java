/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.files;

import javax.swing.ImageIcon;
import uni.mapadventureproject.Game;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.CommandType;
import uni.mapadventureproject.type.Inventory;
import uni.mapadventureproject.type.Item;
import uni.mapadventureproject.type.ItemContainer;
import uni.mapadventureproject.type.Room;
import uni.mapadventureproject.type.TriggeredRoom;

/**
 * Classe utilizzata per salvare i file di gioco di "nuova partita".
 */
public class MSGameInit {

    private Game g = new Game(); // Entità in cui caricare il gioco MetaStation

    public Game getGame() {
        return g;
    }

    /**
     * Popola il gioco con gli oggetti e stanze del "MetaStation" game
     */
    protected void init() {

        //Items dell'inventario
        Item taralli = new Item(50, "taralli", "Taralli in busta... Gli ottimi taralli del forno (che ti compra tua madre), ti viene l'acquolina in bocca solo a pensarci!");
        taralli.setAlias(new String[]{"tarallini"});
        ImageIcon img = new ImageIcon("resources//img//inventario//taralli.png");
        taralli.setItemImage(img);
        g.getInventory().add(taralli);
        Item notes = new Item(51, "quaderno", "Quaderno con gli appunti di MAP pieno di \"pippottoni\"");
        notes.setAlias(new String[]{"appunti", "riassunti", "block-notes", "fogli"});
        img = new ImageIcon("resources//img//inventario//appunti.png");
        notes.setItemImage(img);
        g.getInventory().add(notes);
        Item umbrella = new Item(52, "ombrello", "Fidato ombrello, ogni volta che ce l'hai con te non piove mai!");
        umbrella.setAlias(new String[]{"ombrellino"});
        img = new ImageIcon("resources//img//inventario//ombrello.png");
        umbrella.setItemImage(img);
        g.getInventory().add(umbrella);
        Item bottle = new Item(53, "borraccia", "La borraccia che hai aspettato tanto per avere dal DIB, forse facevi prima a scroccarla dal PoliBa...");
        bottle.setAlias(new String[]{"bottiglietta", "bottiglia"});
        img = new ImageIcon("resources//img//inventario//bottiglia.png");
        bottle.setItemImage(img);
        g.getInventory().add(bottle);
        Item pendrive = new Item(54, "pendrive", "La solita pen-drive che usi ormai da diversi anni.");
        pendrive.setAlias(new String[]{"chiavetta", "usb", "chiavetta usb", "pen-drive"});
        img = new ImageIcon("resources//img//inventario//chiavetta.png");
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
                + "1) Il lingotto dal portale nella direzione in cui sorge il sole,\n"
                + "2) l'Ixora Septrifolia dal portale più oscuro,\n"
                + "3) Il medaglione della regina Eve dal portale da cui sembra provenire una dolce musica.\n"
                + "Portali qui nell'atrio e riavrai il tuo bene prezioso.\"\n"
                + "\"Ah, bene!\" esclama il tuo amico \"Vuole che gli facciamo la spesa.\"");
        note.setAlias(new String[]{"biglietto", "fogliettino", "foglietto"});
        img = new ImageIcon("resources//img//inventario//biglietto.png");
        note.setItemImage(img);

        // Oggetti mondo pirata
        Item sword = new Item(57, "spada", "Una spada ben affilata,ogni pirata ne dovrebbe avere una così");
        img = new ImageIcon("resources//img//inventario//spada.png");
        sword.setItemImage(img);
        sword.setPickupable(true);
        sword.setConsumable((byte) 1);

        Item lamp = new Item(58, "lanterna", "Una vecchia lanterna ,potrebbe essere utile");
        lamp.setAlias(new String[]{"lampada", "lumino"});
        img = new ImageIcon("resources//img//inventario//lanterna.jpg");
        lamp.setItemImage(img);
        lamp.setPickupable(true);

        Item parchment = new Item(59, "pergamena", "Est, nord ed ancora est; nessun labirinto mi fermerà, "
                + "il tesoro sarà mio, stasera si festeggia domani riprendo la ricerca.");
        img = new ImageIcon("resources//img//inventario//pergamena.png");
        parchment.setItemImage(img);
        parchment.setPickupable(true);

        Inventory sacco = new Inventory();
        sacco.add(sword);
        sacco.add(lamp);
        sacco.add(parchment);
        ItemContainer sack = new ItemContainer(sacco, 60, "sacco", "Sacco del pirata,potrebbe contenere qualcosa di utile");
        Item key = new Item(61, "chiave pirata", "Chiave del capitano Kid");
        key.setItemImage(new ImageIcon("resources//img//inventario//chiave.png"));
        key.setPickupable(true);
        key.setConsumable((byte) 1);

        Item bullion = new Item(62, "lingotto", "Il tesoro di kid e uno degli oggetti per la tua salvezza!");
        bullion.setItemImage(new ImageIcon("resources//img//inventario//lingotto.jpg"));
        bullion.setPickupable(true);

        ItemContainer chest = new ItemContainer(new Inventory(), 63, "forziere", "Contiene il lingotto del capitano Kid");
        chest.setAlias(new String[]{"baule"});
        chest.add(bullion);
        chest.setLockedBy("chiave pirata");

        // Oggetti mondo spaziale
        Item window = new Item(64, "finestra", "La navicella sembra star orbitando attorno a un grande pianeta\n"
                + "rosso e, in fondo, vi è l'ombra di uno più piccolo e azzurro.\n"
                + "Che sia la Terra?");

        Item panel = new Item(65, "pannello", "Una pubblicità scorre in tanti linguaggi differenti:\n"
                + "\"Dolcezza assicurata dalle bacche di Xenon del quadrante 9231, "
                + "bevi anche tu una fresca VoidCoke Pop! Qualità assicurata sin dal "
                + "3043!\"");

        ItemContainer box = new ItemContainer(66, "scatola", "Contiene diverse ed interessanti cianfrusaglie.\n"
                + "Tra le varie cianfrusaglie noti uno strano cacciavite dalla "
                + "punta verde ed arrotondata, e una chiave dalla forma strana.");

        Item sonicScrewdriver = new Item(67, "cacciavite sonico", "Un cacciavite senza punta e con solo un bottone, emana una "
                + "strana luce verde. Ti sembra familiare.");
        sonicScrewdriver.setItemImage(new ImageIcon("resources//img//inventario//cacciaviteSonico.png"));
        sonicScrewdriver.setAlias(new String[]{"cacciavite"});
        sonicScrewdriver.setConsumable((byte) 2);
        sonicScrewdriver.setPickupable(true);
        box.add(sonicScrewdriver);

        Item cyberKey = new Item(68, "chiave strana", "Uno strano mix tra la tua tanto agognata usb e un giocattolo "
                + "per bambini. Magari un progetto scritto in un linguaggio alieno "
                + "potrebbe andare bene lo stesso...");
        cyberKey.setItemImage(new ImageIcon("resources//img//inventario//chiaveCyber.png"));
        cyberKey.setConsumable((byte) 1);
        cyberKey.setPickupable(true);
        box.add(cyberKey);

        Item elevatorButton = new Item(69, "bottone", "Bottone per l'ascensore.");
        elevatorButton.setPushable(true);
        elevatorButton.setAlias(new String[]{"pulsante"});

        Item table = new Item(70, "tavolo", "Guardando meglio vedi che c'è una tessera magnetica e un pacco di mentine.");
        table.setAlias(new String[]{"superficie"});

        Item keycard = new Item(71, "tessera magnetica", "Una tessera per il riconoscimento del personale, garantisce\n"
                + "un accesso di livello \"??\"");
        keycard.setItemImage(new ImageIcon("resources//img//inventario//tessera.png"));
        keycard.setAlias(new String[]{"tessera"});
        keycard.setPickupable(true);
        keycard.setConsumable((byte) 1);

        Item mints = new Item(72, "mentine", "Il pacco di mentine raffigura un piccolo alieno sorridente!");
        mints.setItemImage(new ImageIcon("resources//img//inventario//mentine.png"));
        mints.setAlias(new String[]{"menta", "mentos"});
        mints.setPickupable(true);
        mints.setConsumable((byte) 1);

        Item machine = new Item(73, "macchina", "Oltre allo schermo, la macchina presenta uno strano braccio "
                + "metallico e, sul retro, un pannello che appare essere fissato e non rimovibile a mano.");
        machine.setAlias(new String[]{"marchingegno", "teletrasporto", "teletrasportatore"});

        Item translatorBook = new Item(74, "libro traduttore", "Sfogliando il libro trovi diversi vocaboli: "
                + "\"essere = rffrer | mangiare = znatvner | crescere = perfprer | "
                + "casa = pnfn | in = va | deserto = qrfregb | fiore = svber \"");

        Item book = new Item(75, "libro particolare", "\"Ixora Septrifolia r' ha svber pur perfpr va mbar qrfregvpur.\"\n"
                + "Meglio confrontarlo con il traduttore per capire cosa dice...");

        ItemContainer vendingMachine = new ItemContainer(76, "distributore", "Uno schermo raffigurante un occhio si muove e vi fissa, "
                + "come se volesse indurvi a comprare qualcosa. \n"
                + "Sul lato della macchinetta vi è un pannello. ");
        vendingMachine.setAlias(new String[]{"macchinetta"});
        vendingMachine.setLockedBy("cacciavite sonico");

        Item vmPanel = new Item(77, "pannello", "Un pannello fissato al lato della macchinetta, molto simile "
                + "a quello della stanza del teletrasporto... Forse lo stesso strumento potrebbe servire per"
                + "aprire il distributore.");

        Item vmButton = new Item(78, "bottone", "Questo bottone azionerà qualcosa della macchinetta.");
        vmButton.setPushable(true);
        vmButton.setAlias(new String[]{"pulsante"});

        Item voidCoke = new Item(77, "voidcoke pop", "La bottiglia sembra molto simile a quella di qualunque "
                + "bibita gassata presente anche nei vostri tempi!");
        voidCoke.setItemImage(new ImageIcon("resources//img//inventario//voidcoke.png"));
        voidCoke.setAlias(new String[]{"bevanda", "cocacola"});
        voidCoke.setPickupable(true);
        vendingMachine.add(voidCoke);

        Item alienFlower = new Item(78, "ixora septrifolia", "E' il fiore che vi permetterà di riavere la vostra chiavetta!");
        alienFlower.setItemImage(new ImageIcon("resources//img//inventario//FioreAlieno.png"));
        alienFlower.setAlias(new String[]{"fiore"});
        alienFlower.setPickupable(true);

        //Oggetti mondo medievale
        Item stick = new Item(79, "bastone", "Un bastone di legno con una specie di fiamma luminosa all'estremo superiore. \n"
                + "Su di esso sono intagliati simboli strani e una scritta:\"Astor\"\n "
                + "Questa parola non ti è nuova...");
        stick.setItemImage(new ImageIcon("resources//img//inventario//druidStick.png"));
        stick.setAlias(new String[]{"mazza", "legno", "asta"});
        stick.setPickupable(true);
        stick.setConsumable((byte) 1);

        Item greenKey = new Item(82, "chiave verde", "Una chiave verde con dei richiami argentati");
        greenKey.setPickupable(true);
        greenKey.setItemImage(new ImageIcon("resources//img//inventario//greenKey.png"));
        greenKey.setConsumable((byte) 1);

        Item redKey = new Item(83, "chiave rossa", "Una chiave rossa con dei richiami argentati");
        redKey.setPickupable(true);
        redKey.setItemImage(new ImageIcon("resources//img//inventario//redKey.png"));
        redKey.setConsumable((byte) 1);

        Item blueKey = new Item(84, "chiave blu", "Una chiave blu con dei richiami argentati");
        blueKey.setPickupable(true);
        blueKey.setItemImage(new ImageIcon("resources//img//inventario//blueKey.png"));
        blueKey.setConsumable((byte) 1);

        Item scroll = new Item(85, "pergamena antimaledizioni", "La pergamena che stavi cercando per salvare il tuo amico.");
        scroll.setPickupable(true);
        scroll.setItemImage(new ImageIcon("resources//img//inventario//scroll.png"));
        scroll.setConsumable((byte) 1);

        Item mapNote = new Item(87, "mappa", "La mappa per raggiungere il castello. C'è un sentiero, poi un ruscello, una cascata, una valle e infine il castello. Sembra semplice");
        mapNote.setAlias(new String[]{"percorso", "strada"});
        mapNote.setPickupable(true);
        mapNote.setItemImage(new ImageIcon("resources//img//inventario//mapCastle.png"));

        ItemContainer wardrobe = new ItemContainer(80, "mobile", "Il mobile è chiuso a chiave. "
                + "La serratura è argentata con dei simboli verdi");
        wardrobe.setAlias(new String[]{"guardaroba", "armadio"});
        wardrobe.add(scroll);
        wardrobe.setLockedBy(greenKey.getName());

        Item medallion = new Item(86, "medaglione", "E' il prezioso medaglione che, con gli altri due oggetti, vi permetterà di rientrare in possesso della vostra chiavetta!");
        medallion.setAlias(new String[]{"collana", "pendente", "gioiello"});
        medallion.setPickupable(true);
        medallion.setItemImage(new ImageIcon("resources//img//inventario//medallion.png"));
        
        //Stanze intro
        Room station = new Room(0, "Stazione ferroviaria", "Una voce metallica gracchia dall'altoparlante:"
                + "\n\"Il treno regionale delle ore 9:00 diretto a Bari Centrale è in partenza dal binario 9 con un ritardo di 10 minuti!\""
                + "\nSenti il fischio assordante del capotreno che ti sollecita a salire.");
        station.setRoomImage(new ImageIcon("resources//img//stanze//station.png"));

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
        wagon.setRoomImage(new ImageIcon("resources//img//stanze//wagon.png"));

        Room metaStation = new Room(2, "Metastazione", "Come sempre scendi dal treno stretto come una sardina in mezzo ad altri poveri pendolari.\n"
                + "Noti che il treno si è fermato a un binario diverso dal solito, alzi lo sguardo e leggi \"Binario 0\".\n"
                + "Strano, non ti ricordavi esistesse quel binario\n"
                + "Aspetta, questa non sembra la stazione di Bari.\n"
                + "Ti guardi intorno spaesato.\n"
                + "Un strano uomo con delle orecchie a punta si avvicina al capotreno:\n"
                + "\"Scusi, mi può dire la strada per il portale che conduce a PaleoliticCity?\"\n"
                + "Guardi il tuo amico con gli occhi strabuzzati e lui scrolla le spalle \n"
                + "\"Cerchiamo di capire dove cavolo siamo finiti!\" e inizia a guardarsi intorno.");
        metaStation.setRoomImage(new ImageIcon("resources//img//stanze//metaStation.png"));

        Room metaStationLobby = new Room(3, "Atrio della Metastazione", "Uscendo dalla stazione ti rendi conto di avere lo zaino aperto.\n"
                + "Chiedi al tuo amico di controllare che ci sia tutto e, gentilmente, di chiuderti lo zaino.\n"
                + "Il tuo amico, non gentilmente, esclama \"Oh no! Come dannazione hai fatto?! La chiavetta con su il progetto è scomparsa!\"\n"
                + "Gli premi di controllare meglio e comincia ad elencare il contenuto dello zaino.\n"
                + "\"Borraccia, i tuoi immancabili taralli, ombrello, quaderno e un fogliettino sparso. Cos'è vuoi copiare all'esame?\"\n"
                + "(Non avevi un bigliettino prima!)");
        metaStationLobby.setRoomImage(new ImageIcon("resources//img//stanze//metaStationLobby.png"));

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
                + "quello alla tua destra brilla di giallo,\n quello di fronte a te è scuro con tante luci lontane e \n"
                + "infine, quello alla tua sinistra è verde e il suono che proviene da lì ti affascina.");
        metaStationLobby.setSouth(metaStation);
        metaStationLobby.addItem(note);

        //Stanze mondo pirata
        Room ship = new Room(4, "Nave pirata", "Sbuchi dal portale e ti ritrovi su una nave enorme,"
                + "in cima sventola una bandiera nera raffigurante un teschio bianco,sei su una nave pirata! \n"
                + "La nave è ormeggiata vicino ad un'isola, da cui si nota una foresta e sulla spiaggia un piccolo falò. Potrebbe esserci qualcuno.\n"
                + "Il tuo amico trova un biglietto attaccato sull'albero maestro e lo legge: \n"
                + "\"Su quest'isola troverai il tesoro del capitano kid, un lingotto d'oro che mai nessuno è riuscito a trovare, trovalo e rispetta il nostro patto.\n"
                + "Ah dimenticavo,dovrai raggiungere la caverna dopo aver attraversato la foresta; nella tenda vicino al falò troverai qualcosa per te.\"");
        ship.setRoomImage(new ImageIcon("resources//img//stanze//ship.png"));
        metaStationLobby.setEast(ship);

        Room campFire = new Room(5, "Falo'", "Tu e il tuo amico vi siete divisi per avere più probabilità di trovare il tesoro e setacciare meglio l'isola.\n"
                + "Vai avanti e trovi un piccolo falò che illumina a stento l area circostante circondato da tante bottiglie vuote.\n"
                + "Sulla sabbia ci sono delle impronte che vanno verso est, impronte strane... un piede umano e un impronta circolare, ma dove sei finito?");
        campFire.setRoomImage(new ImageIcon("resources//img//stanze//campFire.png"));

        Room tent = new TriggeredRoom(6, "Tenda", "Che puzza di alcol! Un tizio con una benda sull'occhio sinistro e una gamba di legno è  spaparanzato per terra tutto UBRIACO!"
                + "Ecco di chi erano quelle bottiglie.\n"
                + "\"Per mille balene...\" farfuglia il pirata  nel sonno.\n"
                + "Dovresti trovare qualcosa di utile qui dentro, ma attento a non svegliarlo.");
        ((TriggeredRoom) tent).addTriggerer("prendi spada");
        ((TriggeredRoom) tent).addTriggerDesc("Ora hai la spada, spero non ti serva.");

        ((TriggeredRoom) tent).addTriggerer("prendi lanterna");
        ((TriggeredRoom) tent).addTriggerDesc("Puoi usarla per andare in luoghi bui.");

        ((TriggeredRoom) tent).addTriggerer("prendi pergamena");
        ((TriggeredRoom) tent).addTriggerDesc("Sembra la soluzione di qualcosa...");

        ((TriggeredRoom) tent).addTriggerer("usa lanterna");
        ((TriggeredRoom) tent).addTriggerDesc("Ora puoi andare nella foresta.");

        tent.setRoomImage(new ImageIcon("resources//img//stanze//tent.jpg"));

        Room forest = new Room(7, "Foresta", "E' notte inoltrata e sei in una fitta foresta, solo la luce emessa dalla lanterna ti fa vedere qualcosa, ma non più di tanto.\n");
        forest.setRoomImage(new ImageIcon("resources//img//stanze//forest.jpg"));

        Room waterfall = new Room(8, "Cascata", "Una cascata blocca il passaggio. Non c'è modo di passar da qui.");
        waterfall.setRoomImage(new ImageIcon("resources//img//stanze//waterfall.gif"));

        Room cliff = new Room(9, "Precipizio", "Sei fuori dalla foresta, ma davanti a te c'è un precipizio, non vorrai farla finita vero?");
        cliff.setRoomImage(new ImageIcon("resources//img//stanze//cliff.jpg"));

        Room cave = new Room(10, "Caverna", "Sei arrivato alla caverna, ma l'entrata è bloccata. E ora?");
        cave.setRoomImage(new ImageIcon("resources//img//stanze//cave.jpg"));

        Room cave1 = new Room(11, "Caverna", "Finalmente sei nella caverna, e appena sceso vieni attaccato da uno stormo di pipistelli!!\n"
                + "AHAHAH scherzo volevo spaventarti!\n"
                + "La caverna si dirama in piu vie, ed è piena di scheletri umani, chissà quante persone ci hanno provato prima di te.\n"
                + "Come fare per trovare un'uscita?");
        cave1.setRoomImage(new ImageIcon("resources//img//stanze//cave.jpg"));

        Room cave2 = new Room(12, "Caverna", "Bene, ora un'altro bivio");
        cave2.setRoomImage(new ImageIcon("resources//img//stanze//cave.jpg"));

        Room cave3 = new Room(13, "Caverna", "Da qui non si può proseguire.");
        cave3.setRoomImage(new ImageIcon("resources//img//stanze//vicolo_cieco.png"));

        Room cave4 = new Room(14, "Caverna", "Da qui non si può proseguire.");
        cave4.setRoomImage(new ImageIcon("resources//img//stanze//vicolo_cieco.png"));

        Room cave5 = new Room(15, "Caverna", "Oh no! Ora devi scegliere tra tre direzioni!");
        cave5.setRoomImage(new ImageIcon("resources/img//stanze//cave.jpg"));

        Room cave6 = new Room(16, "Caverna", "Da qui non si può proseguire.");
        cave6.setRoomImage(new ImageIcon("resources//img//stanze//vicolo_cieco.png"));

        Room cave7 = new Room(17, "Caverna", "Da qui non si può proseguire.");
        cave7.setRoomImage(new ImageIcon("resources//img//stanze//vicolo_cieco.png"));

        Room sunrise = new TriggeredRoom(18, "Alba", "Finalmente sei riuscito ad uscire da quella maledetta caverna. Ormai è l' alba e la luce non ti aiuterà a prendere il tesoro inosservato."
                + "Davanti a te trovi uno scheletro con un cappello da pirata e una pistola a canna focaia accanto ad esso. Provi a raccoglierlo ma mentre ci provi fai scattare una trappola.\n"
                + "Lo scheletro si alza e se ne va ridendo, oltre al danno pure la beffa.\n"
                + " Sei appeso come un salame in una fune. Questa giornata non poteva andare peggio di così...");
        ((TriggeredRoom) sunrise).addTriggerer("usa spada");
        ((TriggeredRoom) sunrise).addTriggerDesc("Ti sei liberato, puoi andare giù in acqua alla ricerca del tesoro ora.");
        sunrise.setRoomImage(new ImageIcon("resources/img//stanze//sunrise.jpg"));

        Room sea = new Room(19, "A mollo", "Ti sei immerso, ci sono tanti pesci e  alghe ma la via per la nave è sgombra");
        sea.setRoomImage(new ImageIcon("resources//img//stanze//sea.png"));

        Room adventureGalley = new Room(20, "Adventure Galley", "Davanti a te si trova la nave affondata del capitano Kid");
        adventureGalley.setRoomImage(new ImageIcon("resources//img//stanze//adventureGalley.png"));

        Room treasure = new Room(21, "Stanza del tesoro", "La nave è semi distrutta, ma non si può non notare un gran forziere e tanti oggetti luccicanti, il forziere è chiuso ovviamente.\n"
                + "Ad ovest si trova la stanza del capitano.");
        treasure.setRoomImage(new ImageIcon("resources//img//stanze//treasure.png"));

        Room captainRoom = new Room(22, "Stanza del capitano", "La stanza non è molto grande e vicino ad un tavolo giace il corpo di un pirata con una 'chiave pirata' attacata alla sua cintura.\n"
                + "E' il corpo del leggendario capitano kid uno dei pirati più ricercati\n"
                + "che si suicidò perchè esausto di fuggire dalla condonna a morte del governo inglese nei suoi confronti.\n"
                + "Questo non farà scattare una trappola  come per  lo scheletro di prima,si spera.");
        captainRoom.setRoomImage(new ImageIcon("resources//img//stanze//captainRoom.png"));

        Room boat = new Room(23, "Barchetta", "Finalmente aria. Trovi una barchetta e ci sali sopra.");
        boat.setRoomImage(new ImageIcon("resources//img//stanze//boat.png"));

        Room shipPortal = new Room(21, "Il ritorno", "Accanto alla nave c'è una corda per poter salire e attraversare il portale. \n"
                + "Senti degli spari e delle esplosioni e vedi un tizio che corre verso il portale.\n"
                + "E' il tuo amico che ha esagerato un po' con il distarre i pirati fantasma che ora vi stanno cercando, "
                + "forse è meglio muoversi e tornare nella stanza dei portali con il nuovo tesoro!!\n"
                + "Chissà che fine farà il pirata ubriacone che non troverà più il tesoro.\n"
                + "Chi dorme non piglia pesci dice un detto!");
        shipPortal.setRoomImage(new ImageIcon("resources//img//stanze//shipPortal.png"));

        ship.setLook("A nord cè il falò,alle tue spalle  il portale dal quale sei arrivato,nelle altre direzioni c'è solo il mare.");
        ship.setWest(metaStationLobby);
        ship.setNorth(campFire);

        campFire.setLook("Le impronte portano ad una tenda,è quella a cui faceva riferimento il biglietto trovato sulla nave?");
        campFire.setEast(tent);
        campFire.setSouth(ship);

        tent.setLook("Per andare nella foresta ci vorrà una fonte luminosa per farti strada. \n"
                + "C'è un sacco e puoi aprirlo, prendi tutto quello che trovi al suo interno, tanto è gratis!");
        tent.addItem(sack);
        tent.setNorth(forest);

        forest.setLook(" Si sentono versi strani e ti senti osservato eppure non c'è nessuno, o almeno speri...tutto questo ti mette i brividi!");
        forest.setEast(waterfall);
        forest.setWest(cliff);
        forest.setNorth(cave);
        forest.setLockedBy("lanterna");

        waterfall.setLook("Tutto molto bello, lo terrai in mente per le prossime vacanze, ma di qui non si può avanzare.");
        waterfall.setWest(forest);

        cliff.setLook("La vista è stupenda, il riflesso della luna sul mare lo fa brillare in alcuni punti, ma dovresti muoverti invece di guardare la luna,"
                + " il pirata potrebbe riprendersi da un momento all'altro.");
        cliff.setEast(forest);

        cave.setLook("Scusami non te l'ho detto??\n"
                + "Accanto alla caverna c'è un foro e una corda per poter scendere.\n"
                + "Volevo vedere se fossi attento...");
        cave.setDown(cave1);

        cave1.setLook("Questa caverna sembra una specie di labirinto, ci sarà un modo per uscirne. \n"
                + "C'è una via ad est e una a ovest.");
        cave1.setEast(cave2);
        cave1.setWest(cave3);

        cave2.setLook("Ora le vie sono una verso nord e una verso sud.");
        cave2.setNorth(cave5);
        cave2.setSouth(cave4);
        cave2.setWest(cave1);

        cave3.setLook("Dovresti tornare indietro e riprovare.");
        cave3.setEast(cave1);

        cave4.setLook("Dovresti tornare indietro e riprovare.");
        cave4.setNorth(cave2);

        cave5.setLook("Ora le vie sono una verso nord, una verso est, una verso ovest, a sud torni indietro.");
        cave5.setNorth(cave7);
        cave5.setSouth(cave2);
        cave5.setWest(cave6);
        cave5.setEast(sunrise);

        cave6.setLook("Dovresti tornare indietro e riprovare.");
        cave6.setEast(cave5);

        cave7.setLook("Dovresti tornare indietro e riprovare.");
        cave7.setSouth(cave5);

        sunrise.setLook("La corda che ti intrappola non sembra molto robusta, potresti usare qualcosa per tagliarla.");
        sunrise.setDown(sea);

        sea.setLook("Ad est si trova l' Adventure Galley!");
        sea.setEast(adventureGalley);
        sea.setLockedBy("spada");

        adventureGalley.setLook("Noti un foro nel fianco della nave, a sud, puoi entrarci.");
        adventureGalley.setSouth(treasure);
        adventureGalley.setWest(sea);

        treasure.setLook("Ad ovest c'è una stanza, invece sopra di te c'è una via per tornare a galla. \n"
                + "Ricordati di prendere ciò per cui hai passato tutto questo, il LINGOTTO, prima di tornare a galla.");
        treasure.setWest(captainRoom);
        treasure.setNorth(adventureGalley);
        treasure.setUp(boat);
        treasure.addItem(chest);

        captainRoom.setLook("Quella potrebbe essere la 'chiave pirata' del forziere.");
        captainRoom.setEast(treasure);
        captainRoom.addItem(key);

        boat.setLook("A nord si trova la nave con il portale, dai ci sei quasi!");
        boat.setNorth(shipPortal);

        shipPortal.setLook("Sali così potrai attraversare il portale e tornare alla metastazione!");
        shipPortal.setUp(metaStationLobby);

        // Stanze del mondo spaziale
        Room broomCloset = new TriggeredRoom(22, "Sgabuzzino",
                "Sbuchi dal portale e ti ritrovi in un freddo ed oscuro abisso. \n"
                + "E se il portale vi avesse rigettato nello spazio siderale?\n"
                + "E se in questo momento un buco nero vi stesse spaghettificando?\n"
                + "Dannazione, finirai come il tuo codice!");
        ((TriggeredRoom) broomCloset).addTriggerer("guarda");
        ((TriggeredRoom) broomCloset).addTriggerDesc("Senti il tuo amico muoversi accanto a te e colpire qualcosa, "
                + "un forte rumore metallico invade le vostre orecchie seguito "
                + "dal tonfo di diversi oggetti.");

        Room hallway = new Room(23, "Corridoio", "Trovata la maniglia del \"buco nero\" ti rendi conto che era "
                + "solamente uno sgabuzzino pieno di secchi e strane scope.\n"
                + "Wow! Anche per questa volta siete salvi...");
        hallway.setRoomImage(new ImageIcon("resources//img//stanze//corridoio1.png"));

        Room eastHallway = new Room(24, "Corridoio Est", "Il corridoio si ferma e non va oltre. Accanto a voi si trovano "
                + "una porta ed alcuni pannelli con schermi e bottoni.\n"
                + "\"E questo sarebbe il futuro?! Non c'è nemmeno il touch-screen!\" commenta il tuo amico, deluso.");
        eastHallway.setRoomImage(new ImageIcon("resources//img//stanze//corridoio1.png"));

        Room controlRoom = new Room(25, "Stanza di Controllo", "Una moltitudine di pannelli di controllo fanno flashare "
                + "differenti video ed immagini, alcuni anche dello strano "
                + "codice che sembra azionare autonomamente leve e pulsanti.");
        controlRoom.setRoomImage(new ImageIcon("resources//img//stanze//ControlRoom.png"));

        Room westHallway = new Room(26, "Corridoio Ovest", "Il corridoio prosegue e trovi quelli che puoi solo immaginare "
                + "siano alieni intenti a parlare in uno strano linguaggio e\n"
                + "bere un liquido fumante verde smeraldo. Meglio non farsi domande.");
        westHallway.setRoomImage(new ImageIcon("resources//img//stanze//corriodio ovest.png"));

        Room canteen = new Room(27, "Mensa", "Vi ritrovate in una sala affollata inondata dal chiasso di posate, "
                + "chiacchiere in linguaggi strani e pubblicità olografiche proiettate "
                + "da alcuni pannelli sul pavimento.\nDiverse persone vi adocchiano "
                + "in maniera strana, forse per il vostro vestiario un po' \"vintage\"...");
        canteen.setRoomImage(new ImageIcon("resources//img//stanze//mensa.png"));

        Room upperHallway = new Room(28, "Corridoio Superiore", "Arrivi in un lungo corridoio le cui pareti di vetro si affacciano"
                + " sull'area di attracco di diverse navicelle spaziali.\nIn fondo"
                + " al corridoio noti delle figure che sembrano guardie, meglio "
                + "non spingersi oltre. \n"
                + "L'unica stanza raggiungibile sembra essere verso sud.");
        upperHallway.setRoomImage(new ImageIcon("resources//img//stanze//corridoio superiore.png"));

        Room teleporterRoom = new TriggeredRoom(29, "Stanza del Teletrasporto", "Appena entri vedi uno strano alieno colpire la macchina posta al "
                + "centro della stanza con uno dei suoi tentacoli. Emettendo un suono "
                + "di dissenso e cambiando vorticosamente colori delle squame, vi "
                + "lascia da soli.");
        teleporterRoom.setRoomImage(new ImageIcon("resources//img//stanze//teletrasporto.png"));

        ((TriggeredRoom) teleporterRoom).addTriggerer("usa cacciavite sonico");
        ((TriggeredRoom) teleporterRoom).addTriggerDesc("Ha funzionato! Il pannello viene via con un \"pop\" e rivela "
                + "una serie di chip e transistor. Al lato vi è una fessura "
                + "in cui sembra possibile inserire qualcosa.");

        ((TriggeredRoom) teleporterRoom).addTriggerer("usa chiave strana");
        ((TriggeredRoom) teleporterRoom).addTriggerDesc(
                "La macchina comincia ad emettere un ronzio e il braccio meccanico sembra aver ripreso vita. E' arrivata l'ora "
                + "di usare il teletrasporto e scoprire dove vi vorrà scaraventare questa volta.\n"
                + "\"Basta viaggi interdimensionali... soffro di mal di teletrasporto!\" il tuo amico sembra sconsolato.");

        Room cityStreet1 = new Room(30, "Strada Aliena", "Come prima esperienza con il teletrasporto sembra essere andato "
                + "tutto a posto: hai ancora tutti gli arti nei posti giusti e non "
                + "sembri esserti fuso in maniera strana con il tuo amico il quale, "
                + "a proposito, sembra un po' verdino...\n\n"
                + "Siete sbucati su una larga via movimentata dal via vai di diverse "
                + "specie aliene. Meglio esplorare un po'.");
        cityStreet1.setRoomImage(new ImageIcon("resources//img//stanze//city1.png"));

        Room bookshop = new TriggeredRoom(31, "Libreria", "Entrate nella moderna e pulita libreria, il cassiere vi saluta "
                + "scuotendo le sue antenne.");
        bookshop.setRoomImage(new ImageIcon("resources//img//stanze//libreria.png"));

        ((TriggeredRoom) bookshop).addTriggerer("guarda");
        ((TriggeredRoom) bookshop).addTriggerDesc("Il tuo amico ti chiama, sembra aver trovato un libro per le "
                + "traduzioni da Astraeusiano, la lingua universale aliena, "
                + "a quanto pare, ad Italiano! Faresti meglio a dare un'occhiata a questo \"libro traduttore\".");

        ((TriggeredRoom) bookshop).addTriggerer("guarda libro traduttore");
        ((TriggeredRoom) bookshop).addTriggerDesc("Conoscendo un po' meglio la lingua aliena, vi mettete a ricercare "
                + "libri che vi possano dare informazioni sull'oggetto da trovare.\n\n"
                + "Dopo esserti fatto prendere la mano ed aver perso un po' di tempo "
                + "con un libro di freddure aliene insieme al tuo amico vedete un \"libro particolare\" che potrebbe tornarvi utile. ");

        ((TriggeredRoom) bookshop).addTriggerer("prendi libro particolare");
        ((TriggeredRoom) bookshop).addTriggerDesc("Non avendo soldi alieni e per evitare di diventare dei ricercati "
                + "intergalattici, decidete di lasciare i libri lì.");

        Room cityStreet2 = new TriggeredRoom(32, "Strada Aliena Coperta", "Ora la strada è coperta da alcune infrastrutture e da diverse\n"
                + "grate sul pavimento sembra uscire del fumo! ");
        cityStreet2.setRoomImage(new ImageIcon("resources//img//stanze//city2.png"));

        ((TriggeredRoom) cityStreet2).addTriggerer("premi bottone");
        ((TriggeredRoom) cityStreet2).addTriggerDesc("Senti un tonfo provenire dal distributore e noti che "
                + "ha erogato un bevanda chiamata \"VoidCoke Pop\".");

        Room alleyway = new TriggeredRoom(33, "Vicolo", "La strada si interrompe verso sud, tuttavia sembra proseguire "
                + "verso la tua destra. Quando provi ad avvicinarti, un robot dal fare minaccioso ti sbarra la via!");
        alleyway.setRoomImage(new ImageIcon("resources//img//stanze//cityalley.png"));

        ((TriggeredRoom) alleyway).addTriggerer("usa voidcoke pop");
        ((TriggeredRoom) alleyway).addTriggerDesc("Tiri fuori la frizzante bevanda e la poggi sull'asfalto.\n"
                + "\"Sarebbe il caso di fare un bel gavettone a quel robot\" "
                + "commenta il tuo amico. Se solo la bevanda fosse più "
                + "effervescente...");

        ((TriggeredRoom) alleyway).addTriggerer("usa mentine");
        ((TriggeredRoom) alleyway).addTriggerDesc("Butti la mentos aliena nella VoidCoke Pop e ti allontani, "
                + "nascondendoti dietro ad una colonna insieme al tuo amico.\n La bevanda comincia ad eruttare fuori dalla bottiglia e "
                + "colpisce il robot! \nEmettendo scintille questo, scappa via.");

        Room market = new Room(34, "Mercato", "Nella angusta via tanti mercanti espongono la loro merce.\n"
                + "Spostandovi tra le bancarelle e tirando via il tuo amico "
                + "da un mini pterodattilo in vendita ti fai strada tra gli acquirenti.");
        market.setRoomImage(new ImageIcon("resources//img//stanze//mercato.png"));

        Room icyWorld = new Room(35, "Mondo Ghiacciato", "Dalla piattaforma del mercato vi ritrovate in un "
                + "mondo freddo, composto solo da ghiaccio e geyser.\n\"T-t-t-torniamo indietro\" implora il tuo amico.");
        icyWorld.setRoomImage(new ImageIcon("resources//img//stanze//MondoGhiacciato.png"));

        Room volcanicWorld = new Room(36, "Mondo Vulcanico", "Appena saliti sulla piattaforma, siete stati teletrasportati "
                + "in un mondo pieno di lava e detriti! Respirare è reso "
                + "difficile da tutto il fumo emesso dai vulcani.\n"
                + "Meglio tornare indietro prima di diventare sculture umane\n"
                + "composte da lapilli!");
        volcanicWorld.setRoomImage(new ImageIcon("resources//img//stanze//MondoVulcanico.png"));

        Room desertPlanet = new Room(37, "Mondo Desertico", "Davanti a voi si estende una landa desertica e desolata.\n"
                + "L'unica fonte di vita in vista è un negozio verso sud e niente di più...");
        desertPlanet.setRoomImage(new ImageIcon("resources//img//stanze//deserto.png"));

        Room desert1 = new Room(38, "Deserto a Est", "Dopo aver camminato per un bel po' e sperando di non esservi persi "
                + "incrociate una navicella spaziale schiantata contro il terreno sabbioso.");
        desert1.setRoomImage(new ImageIcon("resources//img//stanze//deserto2.png"));

        Room desert2 = new TriggeredRoom(39, "Deserto ancora più a Est", "Guarda! Ecco l'astronauta a cui appartiene quella navicella "
                + "che hai visto! E sembra ci sia anche il mostro che ha emesso il liquido strano... \n"
                + "\"Ottimo\" commenta sarcasticamente il tuo amico \"Dici che è il caso di aiutare quel poveretto?\"");
        desert2.setRoomImage(new ImageIcon("resources//img//stanze//deserto3.png"));

        ((TriggeredRoom) desert2).addTriggerer("usa taralli");
        ((TriggeredRoom) desert2).addTriggerDesc("Centro! Il mostro comincia a sgranocchiare i taralli che gli hai "
                + "lanciato e sembra placarsi. Con lo stomaco pieno trotterella via per il deserto, lasciandoti libera la via.\n"
                + "\nL'astronauta vi abbraccia in segno di gratitudine e scappa via ancora terrorizzato dall'avvenimento.");

        Room floweryDesert = new Room(40, "Deserto Fiorito", "Oltrepassato il campo di battaglia, ti ritrovi in una zona "
                + "piena di fiori che sembrano spuntare dritti dalla sabbia.");
        floweryDesert.setRoomImage(new ImageIcon("resources//img//stanze//deserto4.png"));

        metaStationLobby.setNorth(broomCloset);
        broomCloset.setSouth(hallway);
        broomCloset.setLook("Non vedi nulla!");

        hallway.setLook("Lo sgabuzzino sfocia su un grande corridoio dall'aspetto "
                + "moderno e pulito. Il corridoio si dirama verso est e verso ovest.\n "
                + "Una imponente finestra rivela un panorama mozzafiato.");
        hallway.setNorth(broomCloset);
        hallway.setEast(eastHallway);
        hallway.setWest(westHallway);
        hallway.addItem(window);

        eastHallway.setLook("Accanto alla porta vi è uno slot in cui sembra possibile\n"
                + "inserire una tessera.");
        eastHallway.setWest(hallway);
        eastHallway.setNorth(controlRoom);
        eastHallway.addItem(panel);

        controlRoom.setLook("Su una superficie alla tua sinistra vi è una scatola in cui\n"
                + "sono disposti diversi gadget metallici ed oggetti. \n"
                + "Che sia il caso di dare un'occhiata?");
        controlRoom.setLockedBy("tessera magnetica");
        controlRoom.setSouth(eastHallway);
        controlRoom.addItem(box);

        westHallway.setLook("Dietro l'interessante combriccola vi è quello che speri\n"
                + "sia un ascensore e non una navicella di salvataggio che vi espellerà "
                + "nello spazio siderale.\nChe sia il caso di premere il bottone?");
        westHallway.addItem(elevatorButton);
        westHallway.setUp(canteen);
        westHallway.setEast(hallway);

        canteen.setLook("Guardi meglio il cibo servito sui diversi vassoi e pensi che, dopotutto,"
                + "forse la mensa universitaria non era tanto male!\n"
                + "Noti nella stanza un unico tavolo libero con qualcosa sopra.");
        canteen.setDown(westHallway);
        canteen.setWest(upperHallway);
        canteen.setLockedBy("bottone");
        canteen.addItem(table);
        canteen.addItem(keycard);
        canteen.addItem(mints);

        upperHallway.setLook("Astronavi di innumerevoli colori e forme costellano il panorama "
                + "insieme ad alcuni meccanici fluttuanti grazie all'assenza di gravità.\n"
                + "\"Guarda quella sembra il Bebop! E quell'altra il Millenium Falcon!\""
                + "esclama il tuo amico con il naso appiccicato al vetro.");
        upperHallway.setEast(canteen);
        upperHallway.setSouth(teleporterRoom);

        teleporterRoom.setLook("E' pieno di marchingegni strani tra cui spicca uno al centro, "
                + "a cui tutti gli altri sembrano essere collegati.\n"
                + "Sullo schermo della macchina riesci a selezionare la lingua "
                + "Inglese e leggi: \"Teletrasporto per il quadrante 127.0.0.1\"\n"
                + "\"Quell'alieno sembrava abbastanza incavolato, probabilmente "
                + "non funziona\" commenta il tuo amico.");
        teleporterRoom.setNorth(upperHallway);
        teleporterRoom.setSouth(cityStreet1);
        teleporterRoom.addItem(machine);

        cityStreet1.setLook("La strada prosegue verso sud, mentre alla tua sinistra sembra "
                + "esserci una libreria.\n\"Hey, forse possiamo trovare qualche informazione su quel "
                + "coso strano che dobbiamo trovare... l'Ixora Sep...qualcosa!\" "
                + "suggerisce il tuo amico.");
        cityStreet1.setLockedBy("chiave strana");
        cityStreet1.setWest(bookshop);
        cityStreet1.setSouth(cityStreet2);

        bookshop.setLook("Libri variopinti e con alfabeti sconosciuti popolano i grandi scaffali della libreria.");
        bookshop.setEast(cityStreet1);
        bookshop.addItem(translatorBook);
        bookshop.addItem(book);

        cityStreet2.setLook("La strada continua verso sud. L'unico oggetto che sembra "
                + "essere più interessante è un distributore di bevande. Ti avvicini e cominci ad ispezionarlo.");
        cityStreet2.setNorth(cityStreet1);
        cityStreet2.setSouth(alleyway);
        cityStreet2.addItem(vmPanel);
        cityStreet2.addItem(vmButton);
        cityStreet2.addItem(vendingMachine);

        alleyway.setLook("Sembra che il robot stia facendo da guardia all'entrata di quella via laterale! \n"
                + "I suoi grandi artigli e affilate zampe bioniche ti fanno pensare che sia meglio non affrontarlo "
                + "direttamente, si potrebbe, però, provocare una distrazione...");
        alleyway.setNorth(cityStreet2);
        alleyway.setEast(market);

        market.setLook("Alla fine del mercato noti un mercante, questa volta umano, "
                + "distratto a giocare su una strana console portatile.\n"
                + "La sua merce è composta da tre piattaforme marcate come \"Teletrasportatori\". Magari è il caso di provarli.");
        market.setLockedBy("mentine");
        market.setWest(alleyway);
        market.setNorth(desertPlanet);
        market.setEast(volcanicWorld);
        market.setSouth(icyWorld);

        volcanicWorld.setLook("Non ci pensi nemmeno a continuare su questo pianeta!");
        volcanicWorld.setWest(market);

        icyWorld.setLook("Di sicuro non è qui che troverai il fiore desertico!");

        icyWorld.setNorth(market);

        desertPlanet.setLook("Guardando meglio il negozio, sembra un gift shop turistico "
                + "per chi si ritrova su questo strano pianeta! Dici che i tuoi amici apprezzerebbero una cartolina da \"Arj Ynf Irtnf\"?\n"
                + "\nDietro il negozio, andando verso sud, noti un portale molto simile a quello usato per entrare in questo universo bizzarro.\n"
                + "Dovrebbe essere la via per tornare alla MetaStazione!\n"
                + "Ad est il deserto sembra percorribile...");
        desertPlanet.setSouth(metaStationLobby);
        desertPlanet.setEast(desert1);

        desert1.setLook("Vi avvicinate alla navicella, ma sembra essere vuota. L'unica "
                + "sostanza presente vicino ad essa è uno strano liquido denso e verde.\n"
                + "Speri vivamente di non incontrare l'essere che l'abbia prodotto.Puoi continuare ad andare verso est..");
        desert1.setWest(desertPlanet);
        desert1.setEast(desert2);

        desert2.setLook("Quell'essere alieno ha definitivamente troppe zampe e denti "
                + "per essere legale. La sua bocca si estende come una voragine "
                + "piena di spuntoni aguzzi che ti fanno impallidire...\n"
                + "\n\"Forse gli puoi lanciare qualcosa!\" ti esorta il tuo amico.\n"
                + "Quale luogo più appropriato per tirare fuori il tuo allenamento alla Space Jam di un pianeta sperduto nel cosmo?!");
        desert2.setWest(desert1);
        desert2.setNorth(floweryDesert);

        floweryDesert.setLook("Avvicinandoti meglio a uno di essi lo riconosci dalla foto "
                + "trovata sul libro: è l'oggetto che vi serve per poter riavere la vostra preziosa chiavetta!");
        floweryDesert.setLockedBy("taralli");
        floweryDesert.setSouth(desert2);
        floweryDesert.addItem(alienFlower);

        //Stanze del mondo medievale
        Room glade = new Room(41, "Radura", "Sbuchi dal portale e ti ritrovi in mezzo a un bosco. \n"
                + "C’è anche il tuo amico con te che esclama: “Ma dove siamo finiti??"); //Comandi
        glade.setRoomImage(new ImageIcon("resources//img//stanze//glade.png"));

        Room woodsWest = new Room(42, "Foresta", "Qui la foresta è molto fitta...");
        woodsWest.setRoomImage(new ImageIcon("resources//img//stanze//woodsWest.png"));

        Room woodsEast = new Room(43, "Foresta", "Senti dei versi di qualche strano animale... Potrebbe essere un orso?\n Il tuo amico, terrorizzato, ti prega di tornare indietro.");
        woodsEast.setRoomImage(new ImageIcon("resources//img//stanze//woodsEast.png"));

        Room pathway = new TriggeredRoom(44, "Sentiero", "Vi incamminate verso il sentiero.\n"
                + "Ad un tratto, incontrate un uomo seduto su di un masso, intento a suonare un liuto. "
                + "E' molto basso, ha delle orecchie a punta e uno strano vestito. "
                + "In effetti, non sembra un uomo... Sarà un elfo? Un halfling?\n"
                + "La dolce melodia che proviene dallo strumento è la stessa che avevi sentito nella stazione dei portali.\n"
                + "Il tuo amico esclama: \"Moo bella questa canzonee! "
                + "Sembra una di quelle che ascoltiamo quando facciamo sessione di D&D!\n"
                + "Forse dovremmo parlargli e chiedergli se sa qualcosa dell'oggetto. Com'è che si chiamava?"
                + "Non mi ricordo, forse dovremmo dare un'occhiata al bigliettino…\"");
        pathway.setRoomImage(new ImageIcon("resources//img//stanze//pathway.jpg"));
        ((TriggeredRoom) pathway).addTriggerer("guarda bigliettino");
        ((TriggeredRoom) pathway).addTriggerDesc("Giusto! Il medaglione della regina Eve!\n"
                + "Vi fermate a parlare con il musicista e chiedete informazioni per trovarlo. \n"
                + "Lui, con uno strano accento, vi racconta:\n"
                + "\"Ahimé, messeri, la vostra è un'ardua impresa:\n "
                + "il medaglione si trova nel vecchio castello della regina, "
                + "adesso abitato da un drago, che si è appropriato di tutti i tesori. "
                + "Se volete quell'oggetto, dovrete raggiungere quel posto e affrontare il mostro.\n"
                + "La strada è la seguente: prendete il sentiero verso est, "
                + "poi proseguite controcorrente rispetto al ruscello, "
                + "attraversate la piccola cascata e vi ritroverete in una valle, nei pressi del vecchio castello.\n"
                + "Secondo la leggenda, il drago non vi lascerà passare facilmente: "
                + "si dice che sia gelosissimo del castello e non permetta a nessuno di entrare.\"\n"
                + "Ringraziate il musicista. \nIl tuo amico porge 50 centesimi... "
                + "Lui, tutto euforico, inizia a saltellare di gioia, "
                + "convinto di avere avuto una moneta d'oro e di essere diventato ricco...\n"
                + "Povero illuso... Lo salutate e se ne va. "
                + "Il tuo amico scrive una piccola mappa e te la porge dicendo: "
                + "\"In questo modo, non ci dimenticheremo il tragitto da percorrere!\"");
        ((TriggeredRoom) pathway).addTriggerer("prendi mappa");
        ((TriggeredRoom) pathway).addTriggerDesc("Siete sul sentiero dove avete incontrato il musicista. Adesso è deserto...");

        Room pathwayUp = new Room(45, "Sentiero in salita", "Superati degli stretti scalini di legno, il sentiero torna lineare. "
                + "Accanto ad esso, scorre un ruscello. ");
        pathwayUp.setRoomImage(new ImageIcon("resources//img//stanze//pathwayUp.png"));

        Room pathwayDown = new Room(46, "Sentiero in discesa", "Percorri un tratto ripidissimo, inciampi e rischi di cadere, ma,"
                + "per fortuna, c'è il tuo amico che riesce a salvarti in tempo!");
        pathwayDown.setRoomImage(new ImageIcon("resources//img//stanze//pathwayDown.png"));

        Room pathWaterfall = new TriggeredRoom(47, "Una cascata",
                "Il sentiero conduce davanti a una cascata e termina…\n"
                + "Il tuo amico esclama: "
                + "\"Dovremmo attraversarla davvero?! Ma, ma... Pensavo che stesse scherzando... \n"
                + "No, no e no! Non se ne parla! "
                + "Mi si bagnerà il computer nello zaino... "
                + "Mi è costato tutta la borsa di studio dell’anno scorso!"
                + "Non fa niente, torno indietro, rifaccio il progetto da solo e lo do al prossimo appello!\"\n\n"
                + "Cerchi di convincere il tuo amico, ma non ne vuole sapere di bagnare il suo prezioso computer per attraversare la cascata...\n"
                + "Chissà se puoi trovare una soluzione...");
        pathWaterfall.setRoomImage(new ImageIcon("resources//img//stanze//pathWaterfall.png"));
        ((TriggeredRoom) pathWaterfall).addTriggerer("usa ombrello");
        ((TriggeredRoom) pathWaterfall).addTriggerDesc("Usando l'ombrello, "
                + "riuscirete a passare sotto alla cascata senza bagnarvi "
                + "e il tuo amico ne sarà molto contento!");

        Room valley = new Room(48, "Una vasta valle", "Grazie all'ombrello, non vi siete bagnati. Siete nella valle. Il paesaggio qui è magnifico!");
        valley.setRoomImage(new ImageIcon("resources//img//stanze//valley.png"));
        valley.setLockedBy("ombrello");

        Room castle = new TriggeredRoom(49, "Un vecchio castello", "Siete finalmente giunti al castello. "
                + "Sara' quello di cui ha parlato il musicista? "
                + "Vedi l'aquila di prima che si avvicina e diventa sempre più grande...\n"
                + "Aspetta, ma è... \n"
                + "\"U-u-u-un d-d-dddrago?!” esclama il tuo amico, visibilmente spaventato.\n"
                + "Atterra sulle mura del castello e, con un tono infuriato, vi chiede: "
                + "\"Come osate avvicinarvi al mio castello? Non è aperto a visite.\"\n"
                + "Prende il tuo amico fra le zampe e si alza in volo.\n"
                + "\"AAAAH AIUTOOOOO SOFFRO DI VERTIGINII! METTIMI GIUUUUUU'\"\n"
                + "Mentre il tuo amico continua a urlare e a cercare di dimenarsi, il drago ti dice: \n"
                + "\"Libererò il tuo compagno solo se mi porterai "
                + "la pergamena antimaledizioni del druido Astor. "
                + "È lì, verso la montagna.\" Ti guardi intorno per vedere dove si trova la montagna. ");
        castle.setRoomImage(new ImageIcon("resources//img//stanze//castle.png"));
        ((TriggeredRoom) castle).addTriggerer("guarda");
        ((TriggeredRoom) castle).addTriggerDesc("Il castello è in mezzo alla valle. Sarebbe bello visitarlo, ma forse non è il momento giusto... ");
        ((TriggeredRoom) castle).addTriggerer("sud");
        ((TriggeredRoom) castle).addTriggerDesc("Tornato dal drago, vedi lui e il tuo amico sdraiati sull'erba fuori dal castello "
                + "che chiacchierano e ridacchiano. \nIl tuo amico ti viene incontro, "
                + "dicendo che il drago gli ha raccontato la sua storia: "
                + "per una maledizione di Astor, è rimasto vincolato al castello negli ultimi 500 anni."
                + "Adesso, usando la pergamena, si potrà rompere la maledizione.");
        ((TriggeredRoom) castle).addTriggerer("usa pergamena");
        ((TriggeredRoom) castle).addTriggerDesc("Dopo aver pronunciato le parole magiche scritte sulla pergamena, questa si autodistrugge;\n"
                + "il drago è finalmente libero e potrà tornare a volare in giro per il mondo.\n"
                + "\"Simpatico 'sto tizio! Abbiamo giocato a degli indovinelli, ne conosce di interessanti! "
                + "E mi ha raccontato diverse cose, adesso ho tante nuove idee per la prossima sessione di D&D...\" "
                + "esclama il tuo amico, che ti si avvicina, porgendoti un ciondolo e aggiungendo:\n"
                + "\"Guarda quii, è il medaglione di Eve! Parlando con il drago, gli ho raccontato la nostra storia e me l'ha dato!"
                + "E' meglio che lo prenda tu! \n"
                + "Attenzione a non farti rubare anche questo, eh!\"\n"
                + "Dentro di te, sai che farai molta attenzione a questo oggetto...");
        ((TriggeredRoom) castle).addTriggerer("prendi medaglione");
        ((TriggeredRoom) castle).addTriggerDesc("Il drago ti ringrazia e decide di riaccompagnarvi al portale volando.\n"
                + "Il tuo amico non ne è molto contento, avendo le vertigini, ma sale comunque sul suo dorso e aspetta che lo faccia anche tu. ");

        Room mountain = new TriggeredRoom(50, "Verso la montagna", "Proseguendo verso la montagna,"
                + "senti qualcuno a ovest, che, disperato, urla:\n"
                + "\"Il mio bastone è andato perduto!!! Sono rovinato!\"\n"
                + "Fai spallucce e continui a camminare. "
                + "A un tratto, inciampi in un sassolino e cadi per terra. Stavolta non c'è il tuo amico ad aiutarti! \n"
                + "Mentre ti rialzi, noti accanto a te uno strano bastone incustodito. Sembra magico... "
                + "Forse potrebbe tornare utile?");
        mountain.setRoomImage(new ImageIcon("resources//img//stanze//mountain.png"));
        ((TriggeredRoom) mountain).addTriggerer("prendi bastone");
        ((TriggeredRoom) mountain).addTriggerDesc("Continui a camminare. Strada facendo, "
                + "incontri un uomo alquanto strano che si sta disperando. \n"
                + "\"Come farò, come farò??? Il mio bastone è scomparso! Chissà dove sarà!!!\" "
                + "Poi alza lo sguardo e incrocia il tuo. \"Ehi tu, hai per caso visto il mio bastone???\" ti chiede. \n"
                + "Starà forse parlando di quel bastone magico che hai appena preso?"
                + "Glielo mostri e lui ti dice che è proprio quello!\n"
                + "\"Hai trovato il mio bastone!! Sono salvo! Grazie, straniero, grazie! "
                + "Permettimi di sdebitarmi offrendoti il pranzo!\"\n"
                + "Il vecchio esclama \"Ah, che maleducato... Non mi sono presentato! Io sono Astor il druido!\n"
                + "Grazie ancora per aver ritrovato il mio bastone!"
                + "A proposito, una volta arrivati, "
                + "potresti usarlo al posto mio per aprire la porta di casa? Ho le mani occupate...\""
                + "e solleva un cesto pieno di funghi. \nPrima che tu risponda, "
                + "Astor si incammina verso il sentiero, aspettandosi che lo segua.");
        ((TriggeredRoom) mountain).addTriggerer("guarda");
        ((TriggeredRoom) mountain).addTriggerDesc("Alzando lo sguardo, vedi un paesaggio stupendo davanti a te... \n"
                + "Vorresti fare una foto per postarla su Instagram quando tornerai a casa, "
                + "ma ti ricordi che il cellulare è scarico... ");

        Room druidGarden = new TriggeredRoom(51, "Giardino della casa di Astor il druido", "Arrivi davanti a una casetta. "
                + "La porta è chiusa. ");
        druidGarden.setRoomImage(new ImageIcon("resources//img//stanze//druidHouseOutside.png"));
        ((TriggeredRoom) druidGarden).addTriggerer("usa bastone");
        ((TriggeredRoom) druidGarden).addTriggerDesc("Agitando il bastone, "
                + "l'estremità si illumina di verde e riesci ad aprire la porta. \n"
                + "Il vecchio entra, poggia il cesto sul tavolo, prende il bastone dalle tue mani e ti invita in casa sua. ");
        ((TriggeredRoom) druidGarden).addTriggerer("guarda");
        ((TriggeredRoom) druidGarden).addTriggerDesc("Per entrare nella casa del druido, ti basta salire gli scalini.");
        ((TriggeredRoom) druidGarden).addTriggerer("giu");
        ((TriggeredRoom) druidGarden).addTriggerDesc("Sei pronto ad andare a salvare il tuo amico e recuperare il medaglione?\n"
                + "Ti ricordi la strada per il castello? Basta tornare indietro, verso est!");

        Room crossroad = new Room(52, "Un bivio", "Siete ad un bivio: una strada prosegue verso la salita e l'altra verso la discesa. ");
        crossroad.setRoomImage(new ImageIcon("resources//img//stanze//pathway1.jpg"));

        Room druidHouse = new TriggeredRoom(53, "Casa di Astor il druido", "Osservi meglio il druido: "
                + "sarà alto sì e no un metro, ha una barba lunghissima e una veste verde scuro "
                + "con un cappuccio che gli copre la testa  (riesci ad intravedere delle orecchie a punta) .\n "
                + "Sembra un incrocio tra Gandalf e Bilbo Baggins. \n"
                + "Astor prepara il pranzo e vi mettete a mangiare. "
                + "Inizi a raccontargli la tua storia, del tuo amico e gli chiedi della pergamena. "
                + "Lui sbianca in viso e ti risponde \"Pergamena antimaledizioni?!? No, non ne ho mai sentito parlare...\" "
                + "e cambia subito discorso: \"Ahh, dimenticavo... Vorrei farti provare la mia erba pipa... "
                + "Torno subito!\" ed esce in giardino.\n"
                + "\nSei rimasto solo… Potrebbe essere una buona occasione per guardarti intorno... "
                + "In fondo, quel vecchio non sembrava sincero riguardo la pergamena…");
        druidHouse.setRoomImage(new ImageIcon("resources//img//stanze//druidHouseInside.png"));
        druidHouse.setLockedBy("bastone");
        ((TriggeredRoom) druidHouse).addTriggerer("prendi chiave verde");
        ((TriggeredRoom) druidHouse).addTriggerDesc("Mentre cerchi la pergamena, senti Astor che canticchia nel giardino; "
                + "la sua voce è sempre più vicina... \nDovresti muoverti o verrai scoperto!!"); //a prendere la pergamena e chiudere tutto!
        ((TriggeredRoom) druidHouse).addTriggerer("prendi pergamena");
        ((TriggeredRoom) druidHouse).addTriggerDesc("Senti Astor che sta per rientrare. \n"
                + "Riesci a rimettere tutto a posto e a sederti giusto in tempo. \n"
                + "\"Scusa per l'attesa!! Ecco qui\"\n "
                + "Ti offre  un po' della sua erba pipa e tu accetti. \n"
                + "Dopo qualche minuto, ti senti un po' intontito, ma sembra davvero buona! "
                + "Terminato il pranzo, il druido ti congeda dicendo: "
                + "\"Giovanotto, ho una certa eta' e ora ho bisogno di riposare..."
                + "Torna ancora a trovarmi! "
                + "La porta di casa è aperta, ti basta scendere gli scalini.\n"
                + "Buona fortuna per la tua avventura!\"");

        Room shortcutPortal = new Room(54, "In groppa al drago",
                "Dall'alto è tutto così piccolo! Vedi il castello, la casa di Astor, la cascata, i sentieri... \n"
                + "Arrivate al portale e salutate il drago per l'ultima volta.");
        shortcutPortal.setRoomImage(new ImageIcon("resources//img//stanze//dragon.png"));
        shortcutPortal.setLockedBy("pergamena");

        Room castleDoor = new Room(55, "Portone del castello", "Hai superato il ponte e sei arrivato davanti al portone del castello, ma è chiuso!");
        castleDoor.setRoomImage(new ImageIcon("resources//img//stanze//castleDoor.png"));

        metaStationLobby.setWest(glade);

        glade.setLook("Dietro di te c’è il portale da cui sei arrivato; "
                + "a est e ovest la foresta diventa più fitta... "
                + "A sud, invece, vedi un lungo sentiero… ");
        glade.setSouth(pathway);
        glade.setEast(woodsEast);
        glade.setWest(woodsWest);
        glade.setUp(metaStationLobby);

        woodsWest.setLook("A est c'è la radura con il portale, mentre, nelle altre direzioni, gli alberi sembrano tutti uguali... "
                + "  Forse sarebbe meglio tornare indietro o rischierete di perdervi... ");
        woodsWest.setEast(glade);

        woodsEast.setLook("A ovest c'è la radura con il portale, mentre nelle altre direzioni la foresta si infittisce. "
                + " I versi sembrano sempre più vicini e a te iniziano a tremare le gambe per la paura... "
                + " Forse è il caso di tornare alla radura!");
        woodsEast.setWest(glade);

        pathway.setLook("La strada continua verso est. A nord, invece, c'è la radura del portale. ");
        pathway.setNorth(glade);
        pathway.setEast(crossroad);
        pathway.addItem(mapNote);

        crossroad.setLook("Facendo più attenzione, verso l'alto senti il rumore di un ruscello. "
                + "A nord vedi la radura del portale da cui sei sbucato con il tuo amico. ");
        crossroad.setWest(pathway);
        crossroad.setUp(pathwayUp);
        crossroad.setDown(pathwayDown);

        pathwayUp.setLook("Il ruscello scorre verso nord.\n"
                + "\"Il musicista aveva detto di andare nella direzione opposta "
                + "rispetto a quella del ruscello, no?\" riflette il tuo amico.");
        pathwayUp.setDown(crossroad);
        pathwayUp.setSouth(pathWaterfall);

        pathwayDown.setLook("\"Il sentiero è interrotto da un grosso tronco e non  riuscite a proseguire. "
                + " L'unica strada percorribile è la salita che vi fa tornare al bivio. ");
        pathwayDown.setUp(crossroad);

        pathWaterfall.setLook("Sembra che il sentiero venga interrotto dalla cascata... Forse bisogna passarci sotto?");
        pathWaterfall.setNorth(pathwayUp);
        pathWaterfall.setDown(valley);

        valley.setLook("Di fronte a te una immensa distesa di verde... "
                + "Dietro di te, passando sotto alla cascata, torneresti indietro. "
                + "Guardando meglio, a ovest, c'è un castello con un'aquila che vola intorno. ");
        valley.setDown(pathWaterfall);
        valley.setWest(castle);

        castle.setLook("Davanti a te, a sud, c’è il portone per entrare nel castello, ma è chiuso. "
                + "Prendendo la strada a est, torneresti indietro, nella valle verso la cascata. "
                + "A nord, invece, riesci a vedere la montagna. ");
        castle.setEast(valley);
        castle.setNorth(mountain);
        castle.setUp(shortcutPortal);
        castle.addItem(medallion);

        mountain.setLook("Verso sud riesci a scorgere il castello. A ovest c'è il sentiero. ");
        mountain.setSouth(castle);
        mountain.setWest(druidGarden);
        mountain.addItem(stick);

        druidGarden.setLook("La casa è piccolissima; fuori c'è un piccolo orto, con delle strane erbe coltivate. "
                + "Salendo gli scalini, puoi entrare in casa. "
                + "A est vedi la strada del ritorno, mentre a nord c'è un piccolo fiume. ");
        druidGarden.setUp(druidHouse);
        druidGarden.setEast(mountain);

        druidHouse.setLook("La casa è abbastanza disordinata: un camino, spento da poco, un calderone, "
                + "il tavolo su cui state pranzando, il letto di Astor, cianfrusaglie varie e un mobile "
                + "(che potrebbe contenere qualcosa di utile, chissà!)... "
                + "Guardandoti intorno, non puoi fare a meno di notare "
                + "tre chiavi di diverso colore (una verde, una rossa e una blu ) sul comodino.\n"
                + "Dietro di te invece, c’è la porta d’ingresso con gli scalini per scendere e uscire. ");
        druidHouse.setDown(druidGarden);
        druidHouse.addItem(wardrobe);
        druidHouse.addItem(greenKey);
        druidHouse.addItem(redKey);
        druidHouse.addItem(blueKey);

        shortcutPortal.setLook("Ora che siete scesi dal suo dorso, non vi basta che entrare nel portale andando su per una collina!");
        shortcutPortal.setUp(metaStationLobby);
        shortcutPortal.setDown(glade);

        castleDoor.setLook("Davanti a te, a sud, c'è il portone del castello. \n"
                + "Andando a nord, puoi tornare alla valle dove il tuo amico è stato preso in ostaggio dal drago.\n"
                + "A est e ovest, invece, vedi il fossato. Ci sono creature strane là dentro, non conviene buttarsi...");
        castle.setSouth(castleDoor);
        castleDoor.setNorth(castle);

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
        down.setAlias(new String[]{"sotto", "giù", "giu"});
        g.getCommands().add(down);
        Command escape = new Command("scappa", CommandType.RUN);
        escape.setAlias(new String[]{"fuggi", "muori", "crepa"});
        g.getCommands().add(escape);
        Command wake = new Command("sveglia", CommandType.WAKE_UP);
        wake.setAlias(new String[]{"svegliati"});
        g.getCommands().add(wake);
        Command help = new Command("aiuto", CommandType.HELP);
        help.setAlias(new String[]{"guida", "hint"});
        g.getCommands().add(help);

        g.setCurrentRoom(station);

    }

    /**
     * Rende eseguibile la classe, in modo da ricreare i file di gioco.
     *
     * @param args
     */
    public static void main(String[] args) {

        FileSaver fs = new FileSaver();
        MSGameInit mInit = new MSGameInit();

        // Inizializza il gioco
        mInit.init();

        try {
            
            // Scrive il file di "nuova partita" con il gioco creato
            fs.saveFile("NewGame//Intro.dat", mInit.getGame());
            
        } catch (Exception e) {
            
            System.out.println("Eccezione: " + e.getMessage());
            
        }
    }

}
