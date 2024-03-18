
Clasa `Attraction` reprezintă o atracție turistică de bază și servește drept clasă părinte pentru alte tipuri de atracții. Aceasta conține un simplu câmp pentru numele atracției și implementă interfața `Comparable` pentru a permite sortarea după nume.

Clasa `Church` este o subclasă a clasei `Attraction` și reprezintă o biserică ca atracție turistică. Aceasta conține un orar de vizitare pentru diferitele zile și ore.


Clasa `Concert` este o subclasă a clasei `Attraction` și reprezintă un concert ca atracție turistică. Aceasta conține un orar de desfășurare a concertului și prețul unui bilet de intrare.


Clasa `Pair` reprezintă o pereche de obiecte de tipuri diferite. Este folosită în diverse locuri din proiect, cum ar fi reprezentarea intervalului de timp.


Clasa `TimeInterval` este o subclasă a clasei `Pair` și reprezintă un interval de timp, având o oră de început și o oră de sfârșit.


Interfața `Payable` specifică că o atracție turistică poate fi plătibilă, având o metodă pentru a obține prețul biletului.


Interfața `Visitable` specifică că o atracție turistică poate fi vizitată, având o metodă pentru a obține orarul de vizitare și o metodă implicită pentru a obține ora de deschidere pentru o anumită dată.


Clasa `TravelPlan` reprezintă un plan de călătorie care conține o mapare între atracții și datele în care acestea sunt planificate pentru vizitare.


Clasa `Trip` reprezintă o călătorie într-un anumit oraș și conține detalii precum numele orașului, perioada de timp a călătoriei și lista atracțiilor planificate pentru călătorie. De asemenea, conține metode pentru adăugarea unei atracții și afișarea locațiilor vizitabile și non-plătibile.
