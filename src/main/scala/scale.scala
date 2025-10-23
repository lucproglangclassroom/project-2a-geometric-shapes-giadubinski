package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale:
  def apply(s: Shape, factor: Double): Shape = s match
    case Rectangle(w, h) =>
      Rectangle(Math.round(w * factor).toInt, Math.round(h * factor).toInt)

    case Ellipse(rx, ry) =>
      Ellipse(Math.round(rx * factor).toInt, Math.round(ry * factor).toInt)

    case Location(x, y, shape) =>
      Location(Math.round(x * factor).toInt, Math.round(y * factor).toInt, apply(shape, factor))

    case Group(shapes @ _*) =>
      Group(shapes.map(apply(_, factor)): _*)

end scale