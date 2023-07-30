-- inserimento del proprietario
INSERT INTO `negozio`.`proprietari` (`nome`, `cognome`, `email`, `password`, `num_telefono`, `data_nascita`)
VALUES ("Gianluca", "Filippi", "g.filippi@mail.com", "01928374", "1234567890", "1990-01-01");

-- inserimento dei dipendenti
INSERT INTO `negozio`.`dipendenti` (`nome`, `cognome`, `email`, `password`, `num_telefono`, `data_nascita`, `stipendio`)
VALUES
  ("Marco", "Bianchi", "marco.bianchi@example.com", "password123", "1234567890", "1990-01-01", 2500),
  ("Anna", "Verdi", "anna.verdi@example.com", "password456", "9876543210", "1985-05-10", 2800),
  ("Giulia", "Neri", "giulia.neri@example.com", "password654", "9999999999", "1991-03-25", 2900);

-- inserimento dei clienti
INSERT INTO clienti (nome, cognome, email, password, num_telefono, data_nascita, genere)
VALUES
    ("Mario", "Rossi", "mario.rossi@example.com", "password123", "1234567890", "1990-01-01", "MASCHIO"),
    ("Giulia", "Bianchi", "giulia.bianchi@example.com", "password456", "9876543210", "1995-05-15", "FEMMINA"),
    ("Luca", "Verdi", "luca.verdi@example.com", "password789", "5555555555", "1988-12-10", "MASCHIO"),
    ("Anna", "Gialli", "anna.gialli@example.com", "passwordabc", "7777777777", "1992-07-20", "FEMMINA"),
    ("Marco", "Neri", "marco.neri@example.com", "passworddef", "4444444444", "1985-09-30", "MASCHIO"),
    ("Laura", "Rosa", "laura.rosa@example.com", "passwordghi", "6666666666", "1998-03-25", "FEMMINA"),
    ("Alessio", "Marroni", "alessio.marroni@example.com", "passwordjkl", "2222222222", "1993-11-05", "ALTRO");

-- inserimento dei prodotti
INSERT INTO prodotti (id, nome, prezzo, descrizione)
VALUES
    (1, "Maglietta", 20, "Una comoda maglietta di cotone perfetta per le giornate estive. Disponibile in diversi colori e taglie, adatta ad ogni occasione."),
    (2, "Pantaloni", 40, "Pantaloni lunghi realizzati con materiali di alta qualità. Ideali per un look casual o formale, a seconda dell'occasione."),
    (3, "Scarpe", 60, "Scarpe sportive di ultima generazione con suola ammortizzante e traspirante. Disponibili in diverse misure per un comfort ottimale durante l'attività fisica."),
    (4, "Camicia", 30, "Una camicia elegante e raffinata, perfetta per le occasioni speciali. Realizzata con tessuti pregiati per garantire un look impeccabile."),
    (5, "Jeans", 50, "Jeans casual dal taglio moderno e comodo. Un capo indispensabile per un look casual-chic adatto a diverse situazioni.");

-- popolamento dell'inventario
INSERT INTO inventario (id_prodotto, stato, quantita)
VALUES
    (1, "DISPONIBILE", 10),
    (1, "NON_DISPONIBILE", 2),
    (1, "IN_PROMOZIONE", 3),
    (1, "VENDUTO", 24),
    (2, "DISPONIBILE", 5),
    (2, "NON_DISPONIBILE", 16),
    (2, "IN_PROMOZIONE", 7),
    (2, "VENDUTO", 8),
    (3, "DISPONIBILE", 50),
    (3, "NON_DISPONIBILE", 22),
    (3, "IN_PROMOZIONE", 47),
    (3, "VENDUTO", 17),
    (4, "DISPONIBILE", 31),
    (4, "NON_DISPONIBILE", 20),
    (4, "IN_PROMOZIONE", 7),
    (4, "VENDUTO", 72),
    (5, "DISPONIBILE", 31),
    (5, "NON_DISPONIBILE", 2),
    (5, "IN_PROMOZIONE", 67),
    (5, "VENDUTO", 7);


-- popolamento delle transazioni
INSERT INTO transazioni (id, data, id_cliente, tipo, prezzo_totale, info)
VALUES
    (1, "2023-05-10", 1, "acquisto prodotto", 310, "primo acquiso da parte di un cliente"),
    (3, "2023-05-11", null, "spese varie", -200, "Queste spese sono state necessarie"),
    (4, "2023-06-10", 4, "acquisto prodotto", 350, "ennesimo acquiso da parte di un cliente"),
    (5, "2023-07-02", null, "spese varie", -290, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ex gravida, pulvinar dui sed, sodales tellus."),
    (2, "2023-05-11", 2, "acquisto prodotto", 220, "secondo acquiso da parte di un cliente");


-- popolamento delle vendite
INSERT INTO vendite (id_transazione, id_prodotto, quantita)
VALUES
    (1, 2, 3),
    (1, 1, 2),
    (1, 4, 5),
    (2, 2, 1),
    (2, 3, 3),
    (4, 5, 7);

-- popolamento del carrello
INSERT INTO carrello (quantita, id_prodotto, id_cliente)
VALUES
    (3, 5, 1),
    (2, 1, 1),
    (5, 4, 1),
    (1, 2, 2),
    (3, 3, 2),
    (7, 1, 3);


-- popolamento dei commenti
INSERT INTO recensioni (data_pubblicazione, valutazione, commento, id_prodotto, id_cliente)
VALUES 
    ('2023-07-30', 5, "Ottimo prodotto!", 1, 1),
    ('2023-07-29', 4, "Buon rapporto qualita'-prezzo.", 2, 2),
    ('2023-07-28', 3, "Prodotto discreto.", 1, 3),
    ('2023-07-27', 5, "Consigliatissimo!", 3, 4),
    ('2023-07-26', 2, "Non mi e' piaciuto.", 2, 5);