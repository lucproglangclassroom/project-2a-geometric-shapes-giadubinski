package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) | Ellipse(_, _) => 1
    case Location(_, _, shape) => 1 + apply(shape)
    case Group() => 1
    case Group(shapes @ _*) => 1 + shapes.map(apply).max

end height