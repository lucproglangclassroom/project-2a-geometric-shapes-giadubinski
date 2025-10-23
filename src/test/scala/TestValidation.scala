package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestValidation extends AnyFunSuite:

  test("valid rectangle"):
    assert(validation.isValid(Rectangle(10, 20)))

  test("invalid rectangle - zero width"):
    assert(!validation.isValid(Rectangle(0, 20)))

  test("invalid rectangle - negative height"):
    assert(!validation.isValid(Rectangle(10, -5)))

  test("valid ellipse"):
    assert(validation.isValid(Ellipse(30, 40)))

  test("invalid ellipse - zero radius"):
    assert(!validation.isValid(Ellipse(0, 40)))

  test("invalid ellipse - negative radius"):
    assert(!validation.isValid(Ellipse(30, -10)))

  test("valid location"):
    assert(validation.isValid(simpleLocation))

  test("invalid location with invalid shape"):
    assert(!validation.isValid(Location(10, 20, Rectangle(-5, 10))))

  test("valid group"):
    assert(validation.isValid(basicGroup))

  test("invalid group with invalid shape"):
    assert(!validation.isValid(Group(Rectangle(10, 20), Ellipse(-5, 10))))

end TestValidation