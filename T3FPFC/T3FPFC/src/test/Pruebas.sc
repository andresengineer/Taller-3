/*
Taller #3

Wilson Andrés Mosquera Zapata <202182116>
Angie Natalia Córdoba Collazos <202124366>

12/10/2023

*/

import ManiobrasTrenes._

val e1 = (List('a','b', 'c', 'd'), Nil, Nil)
val e2= aplicarMovimiento (e1,Uno(2))
val e3 = aplicarMovimiento (e2,Dos(3))
val e4 = aplicarMovimiento (e3, Dos(-1))
val e5 = aplicarMovimiento (e4,Uno(-2))
val e6 = aplicarMovimiento (e5,Dos(-1))

val e = (List('a','b'),List('c'), List('d'))
val l1 = (List(1, 2, 3, 4, 5), Nil, Nil)

aplicarMovimientos(e, List(Uno(1), Dos(0), Uno(-4)))
aplicarMovimientos(l1, List(Uno(2), Dos(-4), Dos(2), Uno(-2), Dos(-1)))
aplicarMovimientos(l1, List(Uno(3), Uno(-3), Dos(6), Dos(-1), Uno(3)))
aplicarMovimientos(l1, List(Dos(4), Dos(-2), Uno(1), Uno(2), Dos(3)))

definirManiobra(List('a', 'b', 'c', 'd') , List('d', 'b', 'c', 'a'))
definirManiobra(List(1, 3, 5, 7, 9) , List(2, 4, 6, 8, 10))
definirManiobra(List(6, 5, 4, 3, 2) , List(2, 3, 4, 5, 6))

