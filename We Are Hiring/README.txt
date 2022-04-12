SCHIBINSCHI ARTIOM, 321CC

Gradul de dificultate : dificila
Timpul alocat rezolvarii : 25-30 de ore

Observatii :
	Am efectuat doar Cerinta1 (Implementarea integrala a claselor propuse)
	si Cerinta3 (fara design pattern Builder).

Modul de implementare: (Ma voi referi doar la metode mai complexe)

getRecruiter(User user) din clasa Company :
	Parcurg lista de recruiteri si il selectez pe cel mai indepartat folosindu-ma
	de metoda getDegreeInFriendship( User, user), in caz ca sunt egal departati
	aleg dupa rating.
getDegreeInFriendship(User user) din clasa Consumer:
	Privind obiectul clasei Consumer ca radacina a unui arbore multicai,
	implementarea a constat in traversarea BFS a acestui "arbore" pe parcursul 
	careea am numarat prin cati prieteni am trecut pentru a ajunge la user-ul 
	transmis ca parametru (gradu-ul de prietenie). In caz ca user-ul transmis ca 
	parametru nu avea o relatie de prietenie cu user-ul curent atunci returnam 
	valoarea -1.
compareDates(String date1, String Date2) din clasa Education si Experience :
	Metoda pe care am adaugat-o eu si care imi compara cei 2 parametri din punct 
	de vedere cronologic. Am folosit metoda substring(index b, index e) din 
	clasa String pentru a compara pe zile, luni, ani.
getTotalSalaryBudget() din clasa Finance :
	Am parcurs fiecare angajat si am verifica vechimea sa folosind metoda 
	parseInt(String s) din clasa Integer pentru a calcula vechimea. Apoi am 
	aplicat taxele grupurilor necesare de angajati si am calculat bugetul.
apply(User user) din clasa Job :
	Am cautat compania necesara parcurgand lista de companii din clasa Application.
	Apoi am ales recruiterul potrivit (cel mai indepartat in retea sociala si cu
	rating-ul cel mai mare). Dupa am apelat functia evaluate() pentru recruiter-ul
	gasit.
process(Job job) din clasa Manager :
	Am iterat prin colectia de cereri verificand daca cererea corespunde
	parametrului metodei. In caz ca cererea corespunde job-ului verificam daca
	candidatul nu a fost adaugat (verificand-ui existenta in lista cu utilizatori
	din clasa Application), in caz ca acesta era prezent in lista , il eliminam
	din lista, cautam compania si departamentul pentru acest candidat si il angajam.
getTotalScore() din clasa User :
	Pentru a calcula numarul anilor de experienta m-am folosit de metodele
	claselor Integer (parseInt) si String (substring).

Mai multe detalii despre implementarea metodelor/claselor le-am lasat in
comentariile din surse.

Multumesc!