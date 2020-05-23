Report

## Scacchi

### **1. Introduzione**
L'applicazione command line "Scacchi" è stata sviluppata come parte del progetto di Ingegneria del Sotware dell'anno accademico 2019/2020.
Il progetto è stato sviluppato simulando la metodologia Scrum.
Nell' applicazione sono state implementate le seguenti funzionalità:
movimento e cattura dei pezzi, cattura en passant per i pedoni, la possibilità di effettuare l'arrocco ( corto o lungo ) e di gestire  lo stato di scacco del proprio Re.

![scacchiera](/res/img/scacchiera.jpg)



### 3. Requisiti Specifici

####  **a. Requisiti Funzionali**

Come utente-giocatore voglio:

1. **mostrare elenco comandi**
in modo tale da visualizzare l'elenco dei comandi disponibili.

   
   
   **Criteri di accettazione**:
   
   > eseguendo il comando **help**:
    - il risultato è una lista di comandi disponibili, uno per riga, come da esempio successivo:
      
   > board
   >
   > quit
   
     


2. **iniziare una nuova partita**
in modo tale da avviare una nuova partita, anche mentre è in corso già una partita chiedendo un messaggio di conferma.

   **Criteri di accettazione**:
   
    > al comando **play**:
    - l'applicazione si predispone a ricevere la prima mossa di gioco,
    - l'applicazione è in grado di ricevere altri comandi (es. mostra scacchiera).
   
   


3. **chiudere il gioco**
in modo tale da terminare l'esecuzione della applicazione.

   **Criteri di accettazione**:
   
    > al comando **quit**:
    - l'applicazione chiede conferma
    - se la conferma è positiva, l'applicazione si chiude e compare il prompt del sistema operativo
   
   


4. **mostrare la scacchiera**
in modo tale da stampare a video la scacchiera.

   **Criteri di accettazione**:
   
    > al comando **board**:
    - l'applicazione mostra la posizione sulla scacchiera
    - sono mostrate le coordinate all'esterno della scacchiera come da figura nell'assegnazione del progetto
    - i pezzi sono mostrati in formato [Unicode](http://en.wikipedia.org/wiki/Chess_symbols_in_Unicode)
   
   


5. **muovere un pedone**
in modo tale da muovere un pedone rispettando le mosse valide.

   **Criteri di accettazione**
   
    - l'applicazione deve accettare mosse in [notazione algebrica abbreviata italiana](wikipedia.org/wiki/Notazione_algebrica)
    - la mossa deve rispettare le regole degli scacchi
    - il pedone può catturare pezzi
    - il pedone può catturare en passant
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di un mossa valida
   
   


6. **mostrare le mosse giocate**
in modo tale da visualizzare lo storico delle mosse giocate.

   **Criteri di accettazione**:
   
    > al comando **moves**:
    - l'applicazione mostra la storia delle mosse con una notazione algebrica abbreviata in italiano.
    - Esempio:
  > 1. e4 c6
  > 2. d4 d5
  > 3. Cc3 dxe4
  > 4. Cxe4 Cd7
  > 5. De2 Cgf6
   
   


7. **mostrare le catture**
in modo tale da visualizzare l'elenco delle catture effettuate.

   **Criteri di accettazione**:
   
    > Al comando **captures**:
   
    - l'applicazione mostra le catture del Bianco e del Nero con caratteri Unicode.
   
   


8. **muovere un Cavallo**
in modo tale da effettuare una mossa o una cattura rispettando le regole degli scacchi.

   **Criteri di accettazione**:
   
    - l'applicazione deve accettare le mosse in [notazione algebrica abbreviata in italiano](https://it.wikipedia.org/wiki/Notazione_algebrica)
    - la mossa deve rispettare le regole degli scacchi
    - il Cavallo può catturare pezzi
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di una mossa valida
   
   


9. **muovere un Alfiere**
in modo tale da effettuare una mossa o una cattura rispettando le regole degli scacchi.

   **Criteri di accettazione**:
   
    - l'applicazione deve accettare le mosse in [notazione algebrica abbreviata in italiano](https://it.wikipedia.org/wiki/Notazione_algebrica)
    - la mossa deve rispettare le regole degli scacchi
    - l'Alfiere può catturare pezzi
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di una mossa valida
   
   


10. **muovere una Torre**
in modo tale da effettuare una mossa o una cattura rispettando le regole degli scacchi.

    **Criteri di accettazione**:
    
    - l'applicazione deve accettare le mosse in [notazione algebrica abbreviata in italiano](https://it.wikipedia.org/wiki/Notazione_algebrica)
    - la mossa deve rispettare le regole degli scacchi
    - la Torre può catturare pezzi
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di una mossa valida
    
    


11. **muovere una Donna**
in modo tale da effettuare una mossa o una cattura rispettando le regole degli scacchi.

    **Criteri di accettazione**:
    
    - l'applicazione deve accettare le mosse in [notazione algebrica abbreviata in italiano](https://it.wikipedia.org/wiki/Notazione_algebrica)
    - la mossa deve rispettare le regole degli scacchi
    - la Donna può catturare pezzi
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di una mossa valida
    
    


12. **muovere il Re**
in modo tale da effettuare una mossa o una cattura rispettando le regole degli scacchi, impedendomi di portarlo sotto scacco.

    **Criteri di accettazione**:
    
    - l'applicazione deve accettare le mosse in notazione algebrica abbreviata in italiano
    https://it.wikipedia.org/wiki/Notazione_algebrica
    - la mossa deve rispettare le regole degli scacchi
    
      - il Re non può muoversi in case minacciate da pezzi avversari
    
      - il Re può catturare pezzi
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di una mossa valida
    
    


13. **arroccare corto**
in modo tale da poter effettuare l'arrocco corto rispettando le regole degli scacchi.

    **Criteri di accettazione**:

    - l'applicazione deve accettare le mosse in [notazione algebrica abbreviata in italiano](https://it.wikipedia.org/wiki/Notazione_algebrica)
    - la mossa deve rispettare le regole degli scacchi
      - Il giocatore non ha ancora mosso né il Re né la Torre coinvolta nell'arrocco;
      - Non ci devono essere pezzi (amici o avversari) fra il Re e la Torre utilizzata;
      - Né la casa di partenza del Re, né la casa che esso deve attraversare, né quella di arrivo devono essere minacciate da un pezzo avversario
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di una mossa valida
    
    


14. **arroccare lungo**

    in modo tale da poter effettuare l'arrocco lungo rispettando le regole degli scacchi.
    
    **Criteri di accettazione**:
    
    - l'applicazione deve accettare le mosse in [notazione algebrica abbreviata in italiano](https://it.wikipedia.org/wiki/Notazione_algebrica)
    - la mossa deve rispettare le regole degli scacchi
    
      - Il giocatore non ha ancora mosso né il Re né la Torre coinvolta nell'arrocco;
    
      - Non ci devono essere pezzi (amici o avversari) fra il Re e la Torre utilizzata;
    
      - Né la casa di partenza del Re, né la casa che esso deve attraversare, né quella di arrivo devono essere minacciate da un pezzo avversario
    - se si tenta una mossa non valida è mostrato il messaggio "mossa illegale" e l'applicazione rimane in attesa di una mossa valida



#### **b. Requisiti non funzionali**

- L'applicazione deve poter essere eseguita sul seguente elenco di terminali: 
  - Linux Terminal
  - Mac OS Terminal
  - Windows
    - Terminal del sottosistema Windows
    - Git Bash (in questo caso il comando Docker ha come prefisso `winpty`; es: `winpty docker -it ....`)


- L'applicazione deve supportare i caratteri in formato [Unicode](http://en.wikipedia.org/wiki/Chess_symbols_in_Unicode) per visualizzare i pezzi sulla scacchiera.
  



### 4. System Design

- Non sono stati utilizzati particolari stili architetturali.

- Tutti i componenti del programma si trovano in un unico package.



### **7. Manuale utente**
L'applicazione appena avviata mostra l'elenco dei comandi :
- *help* : mostra l'elenco dei comandi
- *play* : permette di iniziare una partita
- *quit* : permette di uscire dall'applicazione
- *moves* : mostra l'elenco delle mosse effettuate fino a quel momento
- *captures* : mostra i pezzi catturati dal giocatore Bianco e i pezzi catturati dal giocatore Nero
- *board* : visualizza a schermo la scacchiera e la posizione di tutti i pezzi presenti su di essa

**N.B.**
- Se si preme *play* durante una partita già avviata comparirà una richiesta di conferma, se si dà una risposta positiva si avvierà una nuova partita, altrimenti si tornerà alla partita in corso.
- Se si preme *quit* durante una partita già avviata comparirà una richiesta di conferma, se si dà una risposta positiva l'applicazione verrà chiusa, altrimenti si tornerà alla partita in corso.
- Se si preme il comando *moves* verrà visualizzata una lista di coppie di mosse effettuate durante la partita rispettivamente dal giocatore Bianco e dal giocatore Nero. La lista viene descritta nel seguente modo:

1. e4 e5
2. Cf3 Cc6
3. d4

Per descrivere le mosse è utilizzata la **notazione algebrica italiana abbreviata**.

La notazione utilizzata è descritta nel seguente [link](https://it.wikipedia.org/wiki/Notazione_algebrica). 

Per le mosse e le catture dei vari pezzi si può consultare il [regolamento FIDE](http://www.federscacchi.it/doc/reg/d20180517092319_fide.pdf). 

Per effettuare l'arrocco è possibile utilizzare sia la notazione algebrica italiana abbreviata che la notazione [Notazione Portable Game](https://it.wikipedia.org/wiki/Notazione_Portable_Game) in cui viene descritta con la O ( O-O oppure O-O-O).

### **8. Processo di sviluppo e organizzazione del lavoro**
Come metodologia per il processo di sviluppo dell'applicazione CLI "Scacchi" è stato adottato lo sviluppo agile. In 
particolare, è stata simulata la popolare metodologia **Scrum** che, essendo una versione dello sviluppo agile, prevede 
un progetto svolto da uno o più team di lavoro in uno stile di processo iterativo in cui ogni iterazione è chiamata 
Sprint.

Nel nostro caso, il **team 'hamming'** è composto da sette studenti e il progetto è stato organizzato in quattro Sprint 
dalla durata media di due settimane.
Il team è stato aiutato dal Dottor Luigi Quaranta e da altri Collaboratori i quali hanno messo a disposizione le loro 
conoscenze avanzate.

- In ciascuno Sprint, il **meeting di pianificazione** è stato diviso in due parti:

  - La **prima parte** prevedeva una riunione tra i vari team e il Docente Filippo Lanubile il quale in 
  qualità di Product Owner ha creato e gestito il Product Backlog iniziale e ha stabilito per ogni 
  Sprint con l'aiuto dei team una prima organizzazione dello Sprint Backlog in issue fondamentali da 
  portare a termine, lo Sprint goal, le priorità, i criteri di accettazione per ogni issue, la data di 
  consegna e quella di revisione.

  - La **seconda parte** prevedeva una riunione interna al team, effettuata anch'essa sulla piattaforma 
  Microsoft Teams, in particolare, su un canale creato appositamente.
  ![meeting di pianificazione con il team](/res/img/report/Microsoft_teams.png)

    Per quanto riguarda la parte organizzativa, nella riunione avveniva un'ulteriore riorganizzazione dello Sprint 
  Backlog corrente in cui gli issue ritenuti più complessi dal team sono stati scomposti in issue di difficoltà minore.
  
    Ogni Sprint è stato rappresentato come un Milestone con data di inizio, di fine e di feedback, 
  con una descrizione dello Sprint goal e con una "Definition of Done".
  Gli issue fondamentali sono stati etichettati con la label "user story" e i sotto issue sono stati 
  etichettati con label specifiche, talvolta create dal team; ogni issue è stato assegnato al rispettivo 
  Milestone.

    Per favorire l'organizzazione generale, il lavoro è stato suddiviso in due parti:

    gli issue fondamentali sono stati inseriti in una "General Board", specificando che si trattava della 
  board in cui venivano inseriti gli issue riguardanti le user story;
  gli issue fondamentali e la scomposizione di alcuni di essi in issue di difficoltà minore sono stati
  inseriti in una board specifica per ogni Sprint (es. "Sprint 1").

    Per velocizzare la suddivisione degli issue,il team ha designato un unico membro non solo per 
  creare la "General Board" e la board per lo Sprint corrente, ma anche per popolarle con i relativi 
  issue assegnati ai vari componenti del team.

    ![Prospetto Generale](/res/img/report/Prospetto_Generale.png)

    ![General Board](/res/img/report/General_Board.png)

    ![board Sprint1](/res/img/report/Sprint_1_Board.png)

    Per quanto riguarda parte di _design preliminare_, occorre fare una distinzione tra i vari Sprint:

    per lo Sprint 1, il team ha delineato un modello di dominio utilizzando UML come abbozzo 
  e prodotto dei diagrammi a prospettiva concettuale utilizzando principalmente l'applicazione "Visual 
  Paradigm".

    per lo Sprint 2, il team ha adattato ed arricchito il modello di dominio con i principi dell'_Object Oriented Design_ 
  e ha suddiviso le varie classi secondo la tassonomia _Entity-Control-Boundary_.

    Diagramma UML concettuale allo Sprint 1:

    ![diagramma Sprint1](/res/img/report/Diagramma_Sprint1.png)

    Diagramma UML concettuale allo Sprint 2:

    ![diagramma Sprint2](/res/img/report/Diagramma_Sprint2.png)

    per lo Sprint 0 e per lo Sprint 3, non essendo Sprint di sviluppo come gli Sprint 1 e 2, il meeting 
  di pianificazione si è concluso con l'assegnazione degli issue ai vari componenti del team.  

- Nei **meeting giornalieri**, ogni componente del team esponeva a turno ciò che aveva svolto il giorno 
precedente e ciò che doveva svolgere nel giorno corrente, talvolta chiedendo l'aiuto di altri membri nel caso 
avesse avuto particolari difficoltà.

  Il Docente in qualità di Scrum Master, ha messo a disposizione per lo Sprint 1 dei "Daily Meeting" con 
alcuni membri dei vari team. Durante questi confronti, è stato consigliato di seguire il design delle "Schede CRC" 
ed è stato chiarito il funzionamento del comando "play".

  Inoltre, è stato istituito il canale "assistenza" sulla piattaforma "Slack", il quale ha permesso 
al Docente e ai suoi Collaboratori di monitorare il lavoro dei team e di chiarire giornalmente eventuali 
dubbi, e ha reso possibile ai team la condivisione di conoscenze e di aiuti.

  Un'altra piattaforma utilizzata dal team è stata "Telegram": i membri del team hanno istituito sia un gruppo per stabilire l'orario dei meeting e discutere velocemente problematiche minori, sia un canale dove inserire materiale come foto di diagrammi e abbozzi UML, file di testo per la documentazione e 
messaggi-promemoria di correzione di eventuali bug o errori minori o incompletezze.  


- I **meeting di revisione** prevedevano un incontro tra il Docente in qualità di Product Owner 
e i team di sviluppo in cui veniva comunicato il feedback del Docente e venivano evidenziati e discussi 
gli errori commessi durante lo svolgimento di ogni Sprint.

  Gli errori erano di due tipologie: gli errori gravi e gli errori meno significativi "minor" i quali dovevano 
essere corretti nello Sprint successivo.

- **Osservazioni generali:**
  - Come richiesto dalla "Definition of Done", gli issue sono stati assegnati e svolti da uno o massimo 
  due membri del team e sono state istituite varie riunioni separate sempre utilizzando la piattaforma 
  Microsoft Teams per agevolare la comunicazione.
  
    Il carico di lavoro è stato distribuito equamente nel team e ciascun componente ha effettuato 
  mediamente lo stesso numero di commit.
  
  - Per gli Sprint 1 e 2, sono stati definiti durante i meeting giornalieri issue appositi per documentazione di codice o correzione di malfunzionamenti 
  o piccoli adattamenti necessari per il corretto funzionamento dell'applicazione.
  
  - Per ogni issue è stato rispettato il GitHub workflow con creazione di un branch parallelo al master e 
  di una pull request in cui c'è un riferimento al Milestone e un collegamento esplicito all'issue con 
  "Closes #n", dove n è il numero progressivo assegnato all'issue. Infine, ciascuna pull request 
  prevedeva un numero massimo di due revisori, ma era necessaria l'approvazione esplicita soltanto 
  di uno di essi.
  
  - L'applicazione delle patch, ad eccezione dello Sprint 0, prevedeva soltanto la creazione di un 
  branch parallelo e la creazione di una pull request etichettata con la label "patch".
  - Prima della chiusura del Milestone, gli errori "minor" sono stati corretti creando un issue apposito 
  e seguendo il GitHub workflow.
  
  - L'applicazione è stata eseguita su Docker prima di ogni consegna su tutti i terminali consigliati.
  
  - La documentazione del codice è stata effettuata dopo ogni Sprint di sviluppo.
  
  - Spesso gli issue sono stati assegnati a 2 studenti e sono stati svolti in modalità _pair programming_ 
  creando più riunioni sulla piattaforma Microsoft Teams. La coppia di studenti ha cercato il più 
  possibile di suddividere i commit in maniera equa, accordandosi anche sulla creazione della pull request 
  e sulla scelta dei revisori. 
  
### **9. Analisi retrospettiva**

  Il team ha deciso di riportare un'analisi retrospettiva generale poichè ritenuta più sintetica e rappresentativa dell'andamento dei quattro Sprint.

  In particolare, si è discusso sui tre punti proposti dal docente nel documento "Relazione tecnica finale":

- **Cosa vi ha fatto sentire soddisfatti e vi ha reso contenti?**
Anche se inizialmente  la maggior parte dei componenti del team non sapeva giocare a scacchi,
sviluppare l'applicazione "Scacchi" è stata una buona opportunità sia per imparare il gioco, sia per imparare la 
notazione algebrica abbreviata italiana che è quella più utilizzata per le gare ufficiali italiane.
Si è reputato che sviluppare il software ha permesso di consolidare e approfondire le conoscenze del linguaggio 
di programmazione Java.
  

  Il team ha apprezzato la simulazione di un processo di sviluppo (Scrum) usato nel mondo lavorativo, 
  con la possibilità di dividersi i compiti al fine di eseguirli  in maniera indipendente e parallela, come dei veri professionisti.
Lavorare in maniera agile ,sfruttando piattaforme come "Microsoft Teams" , "Telegram" o "Slack" ha permesso 
al team di lavorare agevolmente anche a distanza in una situazione avversa.

  Si è ritenuto che le tempistiche per svolgere il lavoro richiesto fossero adeguate e
  i membri del team hanno imparato a coordinarsi, a contare sull'aiuto reciproco e a risolvere tutti i problemi che 
gradualmente si presentavano durante lo sviluppo del codice o durante la gestione del workflow.

  In particolare, è stato ritenuto molto utile imparare a utilizzare alcuni strumenti come ad esempio "Git" 
  per il controllo di versione o il "GitHub workflow" oppure "Gradle", perché spesso usati in ambito lavorativo.

  Il team è rimasto soddisfatto, quando all'inizio dello Sprint 2 , ha applicato senza modifiche significative 
  alla logica del codice i principi della programmazione Object Oriented e la tassonomia ECB, e quando durante lo Sprint 3, 
ha dovuto correggere pochi warnings segnalati dallo strumento "SpotBugs".


- **Cosa vi ha fatto sentire insoddisfatti e vi ha deluso?**
Il team ha trovato difficoltà nello sviluppo di un'applicazione articolata come quella prevista dal progetto, 
poiché ha dovuto apprendere un paradigma di programmazione dalle fondamenta e non aveva un'esperienza sufficiente e approfondita per scrivere senza particolari problemi codice di qualità. 
In particolare, sebbene si è riusciti a svolgere tutte le assegnazioni entro le scadenze, 
non c'è stata la possibilità di arricchire l'applicazione con ad esempio una scacchiera colorata.
  
- **Cosa vi ha fatto «impazzire» e vi ha reso disperati?**
Il team ha trovato particolarmente impegnativo implementare mosse poco conosciute dai suoi membri, 
come la cattura en passant nello Sprint 1 e i vari tipi di arrocco nello Sprint 2.

  Inoltre,la correzione di eventuali bug prima della consegna , sempre durante gli Sprint di sviluppo, è stata particolarmente ardua, 
perché, sviluppando in maniera parallela il codice e non disponendo né di unità di test né di funzioni di stampa per la scacchiera, non è stato possibile testare le funzionalità volta per volta. 

  Infine,la correzione degli errori di stile che erano prevalentemente errori di formattazione ha richiesto più tempo del previsto.
