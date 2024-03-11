Clasa Client reprezintă un client în sistem. Un client are un nume, un interval de timp pentru vizitare și un tip (regular sau premium). Această clasă este utilizată pentru a defini informațiile despre fiecare client.

Clasa Depot reprezintă un depou. Un depou are un nume și o listă de vehicule asociate. Această clasă este utilizată pentru a defini informațiile despre fiecare depou și pentru a gestiona vehiculele asociate acestuia.

Clasa abstractă Vehicle reprezintă un vehicul. Această clasă are un nume, un depou asociat și o listă de clienți asociați. Clasa Truck și clasa Drone extind clasa Vehicle și adaugă proprietăți specifice (capacitate pentru camion și durată maximă de zbor pentru dronă).

Clasa Greedy implementează un algoritm greedy pentru a aloca clienții la vehicule. Acest algoritm sortează clienții în funcție de timpul de început al vizitei și îi alocă la vehicule în funcție de distanța minimă.

Clasa Problem reprezintă întreaga problemă. Aceasta gestionează depourile și vehiculele asociate, permițând adăugarea de noi depouri și vehicule.