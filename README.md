## ThreadClienthandler

Palvelin, joka käsittelee ja vastaa useiden asiakkaiden viesteihin samanaikaisesti käyttämällä useita säikeitä asiakkaita varten.

`Server` luokka kuvaa palvelinta, joka tarkkailee tiettyä porttia loputtomasti ja luo `Clienthandler`-säikeitä käsittelemään siihen yhdistäviä asiakkaita samanaikaisesti.

`Client` luokka on tehty demonstroimaan asiakasta, joka yhdistää palvelimeen, lähettää muutaman viestin ja tämän jälkeen lähettää palvelimelle käskyn sulkea yhteys.


## Käyttöohje

Aloita suorittamalla `Server`-luokka, joka käytännössä vain käynnistää palvelimen ja aloittaa valitun portin tarkkailun.

Tämän jälkeen voit suorittaa `Client`-luokan.

`Server`- luokka tulostaa terminaaliin asiakkaalta vastaanottamansa viestit ja lopuksi ilmoittaa, kun sulkee yhteyden asiakaaseen.

`Client`- luokka tulostaa terminaaliin päivityksiä palvelimelta vastaanottamistaan viesteistä.