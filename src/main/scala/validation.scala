package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object validation:
  /** Validates that a shape has positive dimensions */
  def isValid(s: Shape): Boolean = s match
    case Rectangle(w, h) => w > 0 && h > 0
    case Ellipse(rx, ry) => rx > 0 && ry > 0
    case Location(_, _, shape) => isValid(shape)
    case Group(shapes*) => shapes.forall(isValid)

end validation