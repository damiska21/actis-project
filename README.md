ZÁZNAM ČLOVĚKA
name - jméno - string (limit 30 charů)
surname - příjmení - string (limit 30 charů)
age - věk - int
birthday - datum narození - date (yyyy-mm-dd)
gender - pohlaví - bool (true je muž, false žena, zbytek má smůlu :D)

STRÁNKY
/database - vypisuje všechny záznamy v databázi lidí
/database/add - přidává člověka
    příklad použití - /database/add?name=Jan&&surname=Zeleny&age=26&birthday=1998-18-12&gender=true
/api/test/{jakékoliv číslo} - test funkčnosti webu
/   - jednoduchý úvod
/error - by měl být error stránka, fungoval, ale teď záhadně ne.



Požadavky v bodech:

1. Intellij IDEA - https://www.jetbrains.com/idea/ - studentská licence 
2. Git - projekt uložit do git repozitáře (např. gitlab nebo github)
3. SpringBoot - https://spring.io/projects/spring-boot (verze 3)
4. Postgres - https://www.postgresql.org - tabulka s libovolnými záznamy (více atributů různých 
datových typů, minimálně — text, číslo, boolean, datum)
5. Automaticky při startu vložit záznamy do db.
6. REST API endpoint - vypsat seznam záznamů z bodu 5. (stačí JSON)
7. Sepsat stručný návod a dokumentaci

Nepovinné požadavky:

8. Rozšířit API - načítání konkrétních záznamů, vkládání záznamů,

9. Frontend - Angular JS