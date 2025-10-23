package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  def testScale(description: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(description):
      assert(scale(s, factor) == expected)

  testScale("simple rectangle x2", simpleRectangle, 2.0, Rectangle(160, 240))
  testScale("simple ellipse x2", simpleEllipse, 2.0, Ellipse(100, 60))
  testScale("simple location x2", simpleLocation, 2.0, Location(140, 60, Rectangle(160, 240)))
  testScale("basic group x2", basicGroup, 2.0, Group(Ellipse(100, 60), Rectangle(40, 80)))
  testScale("simple group x0.5", simpleGroup, 0.5, 
    Group(Location(100, 50, Ellipse(25, 15)), Location(200, 150, Rectangle(50, 25))))
  testScale("complex group x2", complexGroup, 2.0,
    Location(100, 200,
      Group(
        Ellipse(40, 80),
        Location(300, 100,
          Group(
            Rectangle(100, 60),
            Rectangle(600, 120),
            Location(200, 400, Ellipse(100, 60))
          )),
        Rectangle(200, 400)
      )))

end TestScale