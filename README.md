# OOP_Ryhmatoo
Autorid: Norman Tolmats, Marten Mathias Jaani

Projekti põhjalik kirjeldus: Programm võimaldab kasutajal valida kahe juhusliku pokkerikäe vahel. Kui see on tehtud, siis väljastab programm ühiskaardid ja ütleb, kas sinu valitud käsi sai tugevama seisu kui teine käsi. Võimalus on ka viiki jääda. Seejärel kasutaja saab otsustada, kas mängib veel ehk saad valida kahe uue käe vahel ja seejärel laotakse uued ühiskaardid. Lisaks hoiab programm skoori meeles. Näiteks kui kasutaja valitud käed võitsid 4 korda ja kaotasid 2 korda, siis väljastatakse “Mängu seis: mängija 4 - 2 arvuti”.


Klassid(eesmärk ja olulisemad meetodid): 
Kaart - Selle klassi abil saab luua kaarte
Selle klassi kõige olulisem meetod on compareTo meetod, mis lubab kaarte omavahel võrrelda ja Kaart tüüpi liste sorteerida.

Pakk - See klass loob paki.
Olulisemad meetodid on võtaKaart, mille abil toimub kaartide võtmine, ja sega, mille abil kaardipakk segatakse.

Mäng - Selle klassi abil saab mängu mängida.
Meetod mäng paneb mängu käima.

SeisuKontroll - See klass leiab kõik võimalikud seisud.
Selles klassis on palju olulisi meetodeid.

Projekti tegemise protsessi kirjeldus:
Esimesena olid valmis klassid Kaart ja Pakk. Järgmisena valmis SeisuKontroll klass. Selle protsessi jooksul täiendati klassi Kaart vajalike meetoditega. Kontrollisime klassi SeisuKontrolli tööd erinevate etteantud kaartidega. Kui see klass oli töökorras, siis valmis klassis Mäng meetodis mäng erinevad tingimuslaused, mille abil sai leida tugevama käe. Viimaseks valmis tsükkel ja erinevad sisendid, mille abil saab kasutaja mängu mängida.

Rühmaliikmete panus:
Marten: klass SeisuKontroll ja klassi Mäng meetodi mäng tingimused, mis kontrollivad kumb käsi on tugevam. Kokku umbes 10 tundi.
Norman: klassid Kaart, Pakk ja klassi Mäng meetodi mäng ülejäänud osad. Kokku umbes 10 tundi.

Tegemise mured: Võrdsete käte kontrollimine osutus oodatust keerulisemaks. Lisaks oli algselt programmis mitmeid vigu (näiteks väljastati viik, kui viiki polnud). Lisaks tagantjärele tundub, et mitmemõõtmelise listi asemel oleks Hashmap vast mõistlikum olnud.

Hinnang töö lõpptulemusele: Oleme lõpptulemusega rahul.

Testimine: Kontrollisime eraldi seisude leidmise klassi. Kui see klass sai valmis, siis kontrollisime, kas võrdsete tugevustega käte korral suudab programm leida tugevama käe (nt kui on kaks maja 7,7,7,3,3  ja 6,6,6,A,A  siis peab programm aru saama, et esimene maja on tugevam (suurem kolmik)).
