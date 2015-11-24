package com.siemens.icvro.dhm

import com.siemens.icvro.dhm.geometry.Polygon
import org.scalatest.FunSuite

class ContourBuilderTest extends FunSuite{
  test("polygon from string") {
    val maybePolygon = Polygon.fromString("(0,0);(1,0);(0,3)")
    val polygon = maybePolygon.get

    assert(polygon.contour.size == 3)
    assert(polygon.contour(0) == Tuple2(0,0))
    assert(polygon.contour(1) == Tuple2(1,0))
    assert(polygon.contour(2) == Tuple2(0,3))

    val maybePolygon2 = Polygon.fromString("(0,2);(1,0);(0,3)")
    val polygon2 = maybePolygon2.get

    assert(polygon2.contour.size == 3)
    assert(polygon2.contour(0) == Tuple2(0,2))
    assert(polygon2.contour(1) == Tuple2(1,0))
    assert(polygon2.contour(2) == Tuple2(0,3))
  }
}
