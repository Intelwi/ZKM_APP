CREATE TABLE Zarzad_Komunikacji_Miejskiej(
Nr_Zarzadu Integer NOT NULL,
Nazwa_Zarzadu Varchar2(100 ) NOT NULL,
Ulica Varchar2(50 ) NOT NULL,
Nr_Budynku Varchar2(5 ) NOT NULL,
Nr_Telefonu Varchar2(16 ) NOT NULL,
Email Varchar2(30 ) NOT NULL,
Nr_poczty Integer NOT NULL
);

CREATE INDEX IX_Zarzad_przynalezy_do ON Zarzad_Komunikacji_Miejskiej (Nr_poczty);

ALTER TABLE Zarzad_Komunikacji_Miejskiej ADD CONSTRAINT Nr_Zarzadu_PK PRIMARY KEY (Nr_Zarzadu);

CREATE TABLE Pracownicy(
Nr_Pracownika Integer NOT NULL,
Imie Varchar2(20 ) NOT NULL,
Nazwisko Varchar2(40 ) NOT NULL,
Miejscowosc Varchar2(30 ) NOT NULL,
Ulica Varchar2(50 ),
Nr_Budynku Varchar2(5 ) NOT NULL,
Nr_Lokalu Varchar2(5 ),
Nr_Telefonu Varchar2(16 ) NOT NULL,
Data_Urodzenia Date,
Data_Zatrudnienia Date NOT NULL,
Nr_Zarzadu Integer NOT NULL,
Nr_poczty Integer NOT NULL,
Nr_stanowiska Integer NOT NULL
);

CREATE INDEX IX_Zarzad_zatrudnia ON Pracownicy (Nr_Zarzadu);

CREATE INDEX IX_Pracownik_mieszka ON Pracownicy (Nr_poczty);

CREATE INDEX IX_Pracuje_na_stanowisku ON Pracownicy (Nr_stanowiska);

ALTER TABLE Pracownicy ADD CONSTRAINT Nr_Pacownika_PK PRIMARY KEY(Nr_Pracownika);

CREATE TABLE Wynagrodzenia(
Nr_Wynagrodzenia Integer NOT NULL,
Kwota_Podstawowa Number(8,2) NOT NULL,
Premia Number(8,2),
Data_Wynagrodzenia Date NOT NULL,
Nr_Pracownika Integer NOT NULL
);

CREATE INDEX IX_Pracownik_otrzymuje ON Wynagrodzenia (Nr_Pracownika);

ALTER TABLE Wynagrodzenia ADD CONSTRAINT Nr_Wynagrodzenia_PK PRIMARY KEY(Nr_Wynagrodzenia);

CREATE TABLE Pojazdy(
Nr_Pojazdu Integer NOT NULL,
Typ_pojazdu Varchar2(30 ) NOT NULL
CHECK (Typ_pojazdu IN ('AUTOBUS', 'TRAMWAJ')),
Data_Ostatniego_Przegladu Date NOT NULL,
Data_Zakupu Date NOT NULL,
Nr_Zarzadu Integer NOT NULL,
Nr_modelu Integer NOT NULL
);

CREATE INDEX IX_Zarzad_posiada_pojazdy ON Pojazdy (Nr_Zarzadu);

CREATE INDEX IX_Relationship2 ON Pojazdy (Nr_modelu);

ALTER TABLE Pojazdy ADD CONSTRAINT Nr_Pojazdu_PK PRIMARY KEY (Nr_Pojazdu);

CREATE TABLE Linie(
Nr_linii Integer NOT NULL,
Nazwa_linii Varchar2(30 ) NOT NULL,
Nr_Zarzadu Integer NOT NULL
);

CREATE INDEX IX_Zarzad_posiada_linie ON Linie (Nr_Zarzadu);

ALTER TABLE Linie ADD CONSTRAINT Nr_linii_PK PRIMARY KEY (Nr_linii);

CREATE TABLE Przystanki(
Nr_przystanku Integer NOT NULL,
Nazwa_przystanku Varchar2(50 ) NOT NULL,
Rodzaj_przystanku Varchar2(30 ) NOT NULL
CHECK (Rodzaj_przystanku IN ('ZWYKLY', 'NA_ZADANIE')),
Dla_niepelnosprawnych Char(1 ) NOT NULL,
Miejscowosc Varchar2(30 ) NOT NULL,
Ulica Varchar2(50 ),
Nr_Zarzadu Integer NOT NULL,
Nr_poczty Integer NOT NULL
);

CREATE INDEX IX_Zarzad_posiada_przystanek ON Przystanki (Nr_Zarzadu);

CREATE INDEX IX_Przystanek_przynalezy_do ON Przystanki (Nr_poczty);

ALTER TABLE Przystanki ADD CONSTRAINT Nr_przystanku_PK PRIMARY KEY(Nr_przystanku);

CREATE TABLE Punkty_srzedazy_biletow(
Nr_punktu Integer NOT NULL,
Nazwa_punktu Varchar2(100 ) NOT NULL,
Miejscowosc Varchar2(30 ) NOT NULL,
Ulica Varchar2(50 ),
Nr_Zarzadu Integer NOT NULL,
Nr_poczty Integer NOT NULL
);

CREATE INDEX IX_Zarzad_posiada_punkt ON Punkty_srzedazy_biletow (Nr_Zarzadu);

CREATE INDEX IX_Punkt_przynalezy_do ON Punkty_srzedazy_biletow (Nr_poczty);

ALTER TABLE Punkty_srzedazy_biletow ADD CONSTRAINT Nr_punktu_PK PRIMARY KEY(Nr_punktu);

CREATE TABLE Sklepy(
Nr_sklepu Integer NOT NULL,
Nazwa_sklepu Varchar2(100 ) NOT NULL,
Data_zawarcia_kontraktu Date NOT NULL,
Data_wygasniecia_kontraktu Date NOT NULL,
Nr_punktu Integer NOT NULL
);

CREATE INDEX IX_Punkt_jest_sklepem ON Sklepy (Nr_punktu);

ALTER TABLE Sklepy ADD CONSTRAINT Nr_sklepu_PK PRIMARY KEY (Nr_sklepu);

CREATE TABLE Automaty(
Nr_automatu Integer NOT NULL,
Nazwa_automatu Varchar2(30 ) NOT NULL,
Data_utworzenia Date NOT NULL,
Data_ostatniego_przegladu Date NOT NULL,
Data_nastepnego_przegladu Date NOT NULL,
Czynny Char(1 ) NOT NULL,
Nr_punktu Integer NOT NULL
);

CREATE INDEX IX_Punkt_jest_automatem ON Automaty (Nr_punktu);

ALTER TABLE Automaty ADD CONSTRAINT Nr_automatu_PK PRIMARY KEY (Nr_automatu);

CREATE TABLE Bilety(
Nr_biletu Integer NOT NULL,
Rodzaj_biletu Varchar2(30 ) NOT NULL
CHECK (Rodzaj_biletu IN ('30_MINUTOWY', '75_MINUTOWY', '1_DNIOWY',
'30_DNIOWY')),
Oblusgiwane_strefy Integer NOT NULL
CHECK (Oblusgiwane_strefy IN ('STREFA_1', 'STREFA_1_2')),
Cena_biletu Number(10,2) NOT NULL,
Data_sprzedazy Date,
Nr_Zarzadu Integer NOT NULL,
Nr_automatu Integer,
Nr_sklepu Integer
);

CREATE INDEX IX_Zarzad_oferuje_bilet ON Bilety (Nr_Zarzadu);

CREATE INDEX IX_Automat_sprzedaje ON Bilety (Nr_automatu);

CREATE INDEX IX_Sklep_sprzedaje ON Bilety (Nr_sklepu);

ALTER TABLE Bilety ADD CONSTRAINT Nr_biletu_PK PRIMARY KEY (Nr_biletu);

CREATE TABLE Linia_zawiera(
Nr_przystanku Integer NOT NULL,
Nr_linii Integer NOT NULL,
Nr_nastepnego_przystanku Integer NOT NULL
);

CREATE INDEX IX_Przystanek_ma_nastepnika ON Linia_zawiera (Nr_nastepnego_przystanku);

CREATE TABLE Kursy(
Nr_linii Integer NOT NULL,
Nr_Pojazdu Integer NOT NULL,
Nr_Pracownika Integer NOT NULL,
Data_kursu Timestamp(6) NOT NULL
);

CREATE TABLE Poczty(
Nr_poczty Integer NOT NULL,
Kod_pocztowy Varchar2(6 ) NOT NULL,
Poczta Varchar2(30 ) NOT NULL
);

ALTER TABLE Poczty ADD CONSTRAINT PK_Poczty PRIMARY KEY (Nr_poczty);

CREATE TABLE Stanowiska(
Nr_stanowiska Integer NOT NULL,
Nazwa_stanowiska Varchar2(30 ) NOT NULL,
Opis Varchar2(200 )
);

ALTER TABLE Stanowiska ADD CONSTRAINT PK_Stanowiska PRIMARY KEY (Nr_stanowiska);

CREATE TABLE Producenci(
Nr_producenta Integer NOT NULL,
Nazwa_producenta Varchar2(50 ) NOT NULL
);

ALTER TABLE Producenci ADD CONSTRAINT PK_Producenci PRIMARY KEY (Nr_producenta);

COMMENT ON COLUMN Producenci.Nr_producenta IS 'Unikalny numer producenta, klucz gÅ‚Ã³wny.';

COMMENT ON COLUMN Producenci.Nazwa_producenta IS 'Nazwa producenta.';

CREATE TABLE Modele(
Nr_modelu Integer NOT NULL,
Nazwa Varchar2(30 ) NOT NULL,
Opis Varchar2(800 ),
Nr_producenta Integer
);

CREATE INDEX IX_Relationship1 ON Modele (Nr_producenta);

ALTER TABLE Modele ADD CONSTRAINT PK_Modele PRIMARY KEY (Nr_modelu);

ALTER TABLE Modele ADD CONSTRAINT Nazwa UNIQUE (Nazwa);

ALTER TABLE Pracownicy ADD CONSTRAINT Zarzad_zatrudnia FOREIGN KEY (Nr_Zarzadu) REFERENCES Zarzad_Komunikacji_Miejskiej (Nr_Zarzadu);

ALTER TABLE Wynagrodzenia ADD CONSTRAINT Pracownik_otrzymuje FOREIGN KEY(Nr_Pracownika) REFERENCES Pracownicy (Nr_Pracownika);

ALTER TABLE Pojazdy ADD CONSTRAINT Zarzad_posiada_pojazdy FOREIGN KEY(Nr_Zarzadu) REFERENCES Zarzad_Komunikacji_Miejskiej (Nr_Zarzadu);

ALTER TABLE Linie ADD CONSTRAINT Zarzad_posiada_linie FOREIGN KEY (Nr_Zarzadu) REFERENCES Zarzad_Komunikacji_Miejskiej (Nr_Zarzadu);

ALTER TABLE Przystanki ADD CONSTRAINT Zarzad_posiada_przystanek FOREIGN KEY(Nr_Zarzadu) REFERENCES Zarzad_Komunikacji_Miejskiej (Nr_Zarzadu);

ALTER TABLE Punkty_srzedazy_biletow ADD CONSTRAINT Zarzad_posiada_punkt FOREIGN KEY (Nr_Zarzadu) REFERENCES Zarzad_Komunikacji_Miejskiej (Nr_Zarzadu);

ALTER TABLE Bilety ADD CONSTRAINT Zarzad_oferuje_bilet FOREIGN KEY (Nr_Zarzadu) REFERENCES Zarzad_Komunikacji_Miejskiej (Nr_Zarzadu);

ALTER TABLE Pracownicy ADD CONSTRAINT Pracownik_mieszka FOREIGN KEY (Nr_poczty) REFERENCES Poczty (Nr_poczty);

ALTER TABLE Punkty_srzedazy_biletow ADD CONSTRAINT Punkt_sprzedarzy_przynalezy_do

FOREIGN KEY (Nr_poczty) REFERENCES Poczty (Nr_poczty);

ALTER TABLE Przystanki ADD CONSTRAINT Przystanek_przynalezy_do FOREIGN KEY(Nr_poczty) REFERENCES Poczty (Nr_poczty);

ALTER TABLE Zarzad_Komunikacji_Miejskiej ADD CONSTRAINT Zarzad_przynalezy_do FOREIGN KEY (Nr_poczty) REFERENCES Poczty (Nr_poczty);

ALTER TABLE Pracownicy ADD CONSTRAINT Pracuje_na_stanowisku FOREIGN KEY(Nr_stanowiska) REFERENCES Stanowiska (Nr_stanowiska);

ALTER TABLE Linia_zawiera ADD CONSTRAINT Przystanek_ma_nastepnika FOREIGN KEY(Nr_nastepnego_przystanku) REFERENCES Przystanki (Nr_przystanku);

ALTER TABLE Kursy ADD CONSTRAINT Pracownik_kursuje FOREIGN KEY (Nr_Pracownika) REFERENCES Pracownicy (Nr_Pracownika);

ALTER TABLE Bilety ADD CONSTRAINT Automat_sprzedaje FOREIGN KEY (Nr_automatu) REFERENCES Automaty (Nr_automatu);

ALTER TABLE Bilety ADD CONSTRAINT Sklep_sprzedaje FOREIGN KEY (Nr_sklepu) REFERENCES Sklepy (Nr_sklepu);

ALTER TABLE Modele ADD CONSTRAINT Produkuje_modele FOREIGN KEY (Nr_producenta) REFERENCES Producenci (Nr_producenta);

ALTER TABLE Pojazdy ADD CONSTRAINT ma_model FOREIGN KEY (Nr_modelu) REFERENCES Modele (Nr_modelu);
















INSERT INTO Zarzad_komunikac(Nr_pojazdu, Typ_pojazdu, Data_ostatniego_przegladu, Data_zakupu, Nr_zarzadu, Nr_modelu) 
    Values(1, 'AUTOBUS', '2010-10-12', '1985-12-24', 1, 1);


INSERT INTO Pojazdy (Nr_pojazdu, Typ_pojazdu, Data_ostatniego_przegladu, Data_zakupu, Nr_zarzadu, Nr_modelu) 
    Values(2, 'AUTOBUS', '2010-10-12', '1985-12-24', 1, 1);

INSERT INTO Modele (Nr_modelu, Nazwa, Opis, Nr_producenta) 
    Values('3', 'A8', Null, Null);
    
INSERT INTO Poczty (Nr_poczty, Kod_pocztowy, Poczta) Values ('2', '01-223', 'Warszawa');

INSERT INTO Poczty (Nr_poczty, Kod_pocztowy, Poczta) Values ('3', '12-423', 'Krakow');

update poczty set poczta = 'Kraków'
where Poczta = 'Krakow';

INSERT INTO Zarzad_komunikacji_miejskiej (Nr_zarzadu, Nazwa_zarzadu, Ulica, Nr_budynku, Nr_telefonu, Email, Nr_poczty) 
    Values('1', 'ZKM', 'Rudnickiego', '5', '123456789', 'zkm@zkm.pl','1');
    
INSERT INTO Pracownicy (nr_pracownika, imiê, nazwisko, miejscowosc, ulica, nr_budynku, nr_lokalu, nr_telefonu, data_urodzenia, data_zatrudnienia, nr_zarzadu, nr_poczty, nr_stanowiska) 
    Values(1, 'Krzysztof', 'Nowak', 'Warszawa', 'Radosna', 22, 5, '223455782', '1985-10-22', '2007-05-12',1, 2, 2) ;
INSERT INTO Pracownicy (nr_pracownika, imiê, nazwisko, miejscowosc, ulica, nr_budynku, nr_lokalu, nr_telefonu, data_urodzenia, data_zatrudnienia, nr_zarzadu, nr_poczty, nr_stanowiska) 
    Values(2, 'Adam', 'Nowak', 'Warszawa', 'Smutna', 12, 20, '513453582', '1988-11-12', '2009-10-12',1, 2, 1) ;

INSERT INTO Pracownicy (nr_pracownika, imiê, nazwisko, miejscowosc, ulica, nr_budynku, nr_lokalu, nr_telefonu, data_urodzenia, data_zatrudnienia, nr_zarzadu, nr_poczty, nr_stanowiska) 
    Values(3, 'Krystyna', 'Krzeszowska', 'Kraków', 'Kapryœna', 52, 2, '113653512', '1985-06-25', '2014-02-17',1, 3, 3) ;
    
INSERT INTO Pracownicy (nr_pracownika, imiê, nazwisko, miejscowosc, ulica, nr_budynku, nr_lokalu, nr_telefonu, data_urodzenia, data_zatrudnienia, nr_zarzadu, nr_poczty, nr_stanowiska) 
    Values(4, 'Asia', 'Malanowska', 'Warszawa', 'Blondw³osa', 325, 12, '643453512', '1993-06-25', '2018-12-21',1, 2, 3) ;
    
INSERT INTO Pracownicy (nr_pracownika, imiê, nazwisko, miejscowosc, ulica, nr_budynku, nr_lokalu, nr_telefonu, data_urodzenia, data_zatrudnienia, nr_zarzadu, nr_poczty, nr_stanowiska) 
    Values(5, 'Wies³aw', 'Keras', 'Kielce', 'Osobliwa', 53, 93, '623457282', '1979-04-03', '2015-11-15',1, 1, 1) ;

INSERT INTO Stanowiska (Nr_stanowiska, nazwa_stanowiska, Opis) Values ('3', 'Ksiegowa', NULL);

select * from pracownicy

commit

















/* Wstawiane danych */
/*
INSERT INTO POCZTY VALUES (1,'03-769','Kielce');
INSERT INTO ZARZAD_KOMUNIKACJI_MIEJSKIEJ VALUES (1,'ZKM KIELCE','Barszczewska','12','123456789','zkmkielce@zkmkielce.pl','1');
*/

/* Pobieranie danych */
/*
SELECT Nr_poczty, Kod_pocztowy, Poczta FROM POCZTY;
SELECT Nr_zarzadu, Nazwa_zarzadu, Ulica, Nr_budynku, Nr_telefonu, Email, Nr_poczty FROM Zarzad_komunikacji_miejskiej;
*/

/* Kasowanie tabel */
/*
drop table "MSTOLARZ"."AUTOMATY" cascade constraints; 
drop table "MSTOLARZ"."BILETY" cascade constraints ;
drop table "MSTOLARZ"."KURSY" cascade constraints ;
drop table "MSTOLARZ"."LINIA_ZAWIERA" cascade constraints; 
drop table "MSTOLARZ"."LINIE" cascade constraints ;
drop table "MSTOLARZ"."MODELE" cascade constraints; 
drop table "MSTOLARZ"."NA_LINII_KURSUJE" cascade constraints ;
drop table "MSTOLARZ"."POCZTY" cascade constraints ;
drop table "MSTOLARZ"."POJAZDY" cascade constraints ;
drop table "MSTOLARZ"."PRODUCENCI" cascade constraints ;
drop table "MSTOLARZ"."PRZYSTANKI" cascade constraints ;
drop table "MSTOLARZ"."PUNKTY_SRZEDAZY_BILETOW" cascade constraints ;
drop table "MSTOLARZ"."SKLEPY" cascade constraints ;
drop table "MSTOLARZ"."STANOWISKA" cascade constraints ;
drop table "MSTOLARZ"."WYNAGRODZENIA" cascade constraints ;
drop table "MSTOLARZ"."ZARZAD_KOMUNIKACJI_MIEJSKIEJ" cascade constraints ;
drop table "MSTOLARZ"."PRACOWNICY" cascade constraints ;
*/