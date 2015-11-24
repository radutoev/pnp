package com.siemens.icvro.dhm

import com.siemens.icvro.dhm.geometry.Polygon
import org.scalatest.FunSuite

class PnPolyTest extends FunSuite{
  test("Point in square") {
    assert(Polygon(Seq(Tuple2(0,0), Tuple2(2,0), Tuple2(2,2), Tuple2(0,2))) hasPoint Tuple2(1,1))
    assert(Polygon(Seq(Tuple2(0,2), Tuple2(2,2), Tuple2(2,0), Tuple2(0,0))) hasPoint Tuple2(1,1))
  }

  test("Point in triangle") {
    assert(Polygon(Seq(Tuple2(0,0), Tuple2(4,0), Tuple2(2,4))) hasPoint Tuple2(2,2))
  }

  test("Point on edge") {
    //algorithm considers edge points outside of the polygon
    assert(!(Polygon(Seq(Tuple2(0,0), Tuple2(2,0), Tuple2(2,2), Tuple2(0,2))) hasPoint Tuple2(2,1)))
  }
}
