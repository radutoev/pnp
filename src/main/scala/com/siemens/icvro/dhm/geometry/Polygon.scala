package com.siemens.icvro.dhm.geometry

case class Polygon(contour: Seq[(Int, Int)]){
  // Based on: https://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html
  def hasPoint(point: (Int, Int)):Boolean = {
    val nvert = contour.size
    var inPolygon = false
    var jVertex = contour.last
    var j = nvert - 1
    for(i <- 0 until nvert) {
      val xVertex = contour(i)
      jVertex = contour(j)
      if(((xVertex._2 > point._2) != (jVertex._2 > point._2)) &&
        (point._1 < (jVertex._1 - xVertex._1) * (point._2 - xVertex._2) / (jVertex._2 - xVertex._2) + xVertex._1))
        inPolygon = !inPolygon
      j = i
    }
    inPolygon
  }
}

object Polygon {
  def fromString(str: String): Option[Polygon] = {
    val pointArr = str.split(";")
    val contour = for(strPoint <- pointArr) yield strPoint.split(",") match {
      case Array(x:String, y:String) => (x.drop(1).toInt, y.dropRight(1).toInt)
      case _ => throw new PolygonException("Invalid contour vertex")
    }
    Option(Polygon(contour))
  }
}

class PolygonException(message: String) extends RuntimeException(message: String)
