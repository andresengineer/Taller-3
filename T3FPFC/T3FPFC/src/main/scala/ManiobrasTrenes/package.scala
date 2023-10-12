
/*
Taller #3

Wilson Andrés Mosquera Zapata <202182116>
Angie Natalia Córdoba Collazos <202124366>

12/10/2023

*/

package object ManiobrasTrenes {
  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)

  trait Movimiento

  case class Uno(n: Int) extends Movimiento

  case class Dos(n: Int) extends Movimiento

  type Maniobra = List[Movimiento]

  def aplicarMovimiento(e: Estado, m: Movimiento): Estado = m match {
    case Uno(n) if n > 0 =>
      val (take, remaining) = e._1.splitAt(e._1.length - n)
      ((take, e._2 ++ remaining, e._3))

    case Uno(n) if n < 0 =>
      val (take, remaining) = e._2.splitAt(n.abs)
      ((e._1 ++ take, remaining, e._3))

    case Dos(n) if n > 0 =>
      val (take, remaining) = e._1.splitAt(n)
      ((remaining, e._2, take ++ e._3))

    case Dos(n) if n < 0 =>
      val (take, remaining) = e._3.splitAt(n.abs)
      ((e._1 ++ take, e._2, remaining))

    case _ => e
  }


  def aplicarMovimientos(estadoInicial: Estado, movimientos: Maniobra): List[Estado] = {
    def generarListaEstados(estado: Estado, movimientosRestantes: Maniobra): List[Estado] = movimientosRestantes match {
      case Nil => Nil
      case movimiento :: rest =>
        val nuevoEstado = aplicarMovimiento(estado, movimiento)
        nuevoEstado :: generarListaEstados(nuevoEstado, rest)
    }

    estadoInicial :: generarListaEstados(estadoInicial, movimientos)
  }


  def definirManiobra(t1: Tren, t2: Tren): Maniobra = {
    // Creamos la maniobra para mover los vagones de t1 a t2 en el orden correspondiente
    t1.zip(t2).flatMap {
      case (vagonT1, vagonT2) =>
        if (vagonT1 == vagonT2) {
          // Si el vagon está en la posición correcta, no hacemos nada
          Nil
        } else {
          // Movemos el vagon a la posición correcta
          val movesToTarget = if (t2.indexOf(vagonT1) != -1) t2.indexOf(vagonT1) - t1.indexOf(vagonT1) else 0
          Uno(movesToTarget) :: Uno(-1) :: Nil
        }
    }
  }

}
